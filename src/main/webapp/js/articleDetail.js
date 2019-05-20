$(function () {
    var id = GetUrlParam("id");
    //console.log(id);
    //用jquery标记本身文章的分类和标签

    if(id){
        $.ajax("/admin/getArticleDetail", {
            method: "POST",
            data: {
                id: id
            },
            success: function (res) {
                console.log(res);
                if(res.tag){
                    checkedArticleTags(res.tag);
                }
                if(res.category){
                    checkedArticleCategory(res.category);
                }
            },
            error: function (error) {
                console.log(error);
            }
        })
    }
});

/**
 * 保存按钮触发的事件
 */
$("#saveArticle").click(function (e) {
    var id = GetUrlParam("id");
    var title = $("input[name='title']").val();
    var content = editor.getMarkdown();
    var category = $("input[name='category']:checked").val();
    var tags = [];
    $("input[name='tag']:checked").each(function () {
        tags.push($(this).val()); // 向数组中添加元素
    });

    if(id){
        updateArticle(id, title, content, category, tags);
    }else{
        insertArticle(title, content, category, tags);
    }
});

/**
 * 发起ajax请求,保存该数据到服务器.
 * @param title
 * @param content
 * @param category
 * @param tags
 */
function insertArticle(title, content, category, tags){
    $.ajax("/admin/insertArticle", {
        method: "POST",
        traditional: true,
        data: {
            title: title,
            content: content,
            category: category,
            tags: tags
        },
        success: function(res){
            console.log(res);
        },
        error: function(error){
            console.log(error);
        }
    })
}

/**
 * 发起ajax请求,更新文章.
 * @param id
 * @param title
 * @param content
 * @param category
 * @param tags
 */
function updateArticle(id, title, content, category, tags){

}

/**
 * 文章页中插入所有标签,选中文章的标签
 */
function checkedArticleTags(tags) {
    //console.log(tags);
    for(var i = 0, l = tags.length;i < l;i++){
        var id = tags[i];
        $("#tag-" + id).attr("checked", "checkde");
    }
}

/**
 * 文章页中插入所有分类,选中文章的分类
 */
function checkedArticleCategory(category) {
    //console.log(category);
    $("#category-" + category).attr("checked", "checked");
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
