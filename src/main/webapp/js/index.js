$(function () {
    // 添加事件
    addEvent();
    // 显示loading
    showLoading();
    // 显示文章
    listNewArticle();
});

/**
 * 清空文章内容
 */
function clear(){
    $("#articleList").empty();
}


/**
 * 隐藏loading
 */
function hideLoading(){
    $(".loading").hide();
}

/**
 * 显示loading
 */
function showLoading(){
    $(".loading").show();
}

/**
 * 各个元素绑定事件
 */
function addEvent() {
    newArticleAddClick();
}


/**
 * 点击最近文章触发的事件
 */
function newArticleAddClick(){
    $("#newArticle").click(function(e){
        // 先清空文章列表
        clear();
        // 显示loading
        showLoading();

    });
}

/**
 * 请求最近文章数据
 * @param page number 页数
 */
function listNewArticle(page) {
    $.ajax("/listNewArticle", {
        data: {page: page},
        method: "POST",
        success: function(listArticle) {
            // 隐藏loading
            hideLoading();
            // 解析返回的json数据
            parseListArticle(listArticle);
        },
        error: function(error) {
            alert(error);
        }
    })
}

/**
 * 解析返回的文章数组
 */
function parseListArticle(listArticle) {
    // 遍历数据
    for(var i = 0, l = listArticle.length;i < l;i++){
        var article = createDomByArticle(listArticle[i]);
        $("#articleList").append(article);
    }
}

/**
 * 根据单个文章数据生成单个Dom
 */
function createDomByArticle(article) {
    var articleDom = document.createElement("a");
    articleDom.href = "/article/" + article.id;
    articleDom.className = "list-group-item list-group-item-action flex-column align-items-start";

    var divDom = document.createElement("div");
    divDom.className = "d-flex w-100 justify-content-between";

    var titleDom = document.createElement("h5");
    titleDom.className = "mb-1";
    titleDom.innerText = article.title;
    divDom.appendChild(titleDom);

    var smallDom = document.createElement("small");
    smallDom.innerText = article.createTime;
    divDom.appendChild(smallDom);

    articleDom.appendChild(divDom);

    var articleContentDom = document.createElement("p");
    articleContentDom.className = "mb-1";
    articleContentDom.innerText = article.content.substring(0, 100);

    articleDom.appendChild(articleContentDom);

    var tagDom = document.createElement("small");
    tagDom.innerText = "标签:";
    for(var i = 0,l = article.tags.length;i<l;i++){
        var tagItemDom = document.createElement("span");
        tagItemDom.className = "badge badge-info m-1";
        tagItemDom.innerText = article.tags[i].name;
        tagDom.appendChild(tagItemDom);
    }
    articleDom.appendChild(tagDom);

    return articleDom;
}
