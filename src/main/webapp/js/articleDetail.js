$(function () {
    var id = GetUrlParam("id");
    // console.log(id);
    $.ajax("/admin/getArticleDetail", {
        method: "POST",
        data: {
            id: id
        },
        success: function (res) {
            console.log(res);
            insertArticleTags(res.tag);
            insertArticleCategories(res.category);
        },
        error: function (error) {
            console.log(error);
        }

    })
});

/**
 * 文章页中插入所有标签,选中文章的标签
 */
function insertArticleTags(tags) {
    console.log(tags);
    for(var i = 0, l = tags.length; i< l; i++){
        var content = "<div class=\"form-check\">\n" +
            "  <input class=\"form-check-input\" type=\"checkbox\" value=\"" +
            tags[i].id +
            "\" id=\"" +
            "" +
            "tag-" + tags[i].id +
            "" +
            "\">\n" +
            "  <label class=\"form-check-label\" for=\"" +
            "tag-" + tags[i].id +
            "\">\n" +
            tags[i].name +
            "  </label>\n" +
            "</div>";
        $("#articleTag").append(content);
    }
}

/**
 * 文章页中插入所有分类,选中文章的分类
 */
function insertArticleCategories(categories) {
    console.log(categories);
    for (var i = 0, l = categories.length;i< l;i++){
        var content = "<div class=\"form-check\">\n" +
            "  <input class=\"form-check-input\" type=\"radio\" name=\"exampleRadios\" id=\"exampleRadios1\" value=\"option1\" checked>\n" +
            "  <label class=\"form-check-label\" for=\"exampleRadios1\">\n" +
            categories[i].name+
                "  </label>\n" +
            "</div>";
        $("#articleCategory").append(content);

    }
}

//paraName 等找参数的名称
function GetUrlParam(paraName) {
    var url = document.location.toString();
    var arrObj = url.split("?");

    if (arrObj.length > 1) {
        var arrPara = arrObj[1].split("&");
        var arr;

        for (var i = 0; i < arrPara.length; i++) {
            arr = arrPara[i].split("=");

            if (arr != null && arr[0] == paraName) {
                return arr[1];
            }
        }
        return "";
    }
    else {
        return "";
    }
}

var editor = editormd("editormd", {
    path : "/editor.md-1.5.0/lib/", // Autoload modules mode, codemirror, marked... dependents libs path,
    width: "100%",
    //autoHeight: true,
    height: "640",
    toolbarAutoFixed: true,
    codeFold : true,
    //searchReplace : true,
    //saveHTMLToTextarea : true,                // 保存HTML到Textarea
    htmlDecode : "style,script,iframe",       // 开启HTML标签解析，为了安全性，默认不开启
    emoji : true,
    taskList : true,
    tex : true,
    tocm : true,         // Using [TOCM]
    //autoLoadModules : false,
    previewCodeHighlight : true,
    flowChart : true,
    sequenceDiagram : true
});
