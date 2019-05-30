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
    return articleDom;
}
