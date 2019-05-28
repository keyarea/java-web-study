$(function () {
    //showLoading();
    setTitle("最近的文章", "")
});

/**
 * 清空内容
 */
function clear(){
    $(".card-body").empty();
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
 *
 */
function setTitle(title, text){
    clear();
    $(".card-body").append("<h5 class='card-title'> " + title + " </h5>");
    $(".card-body").append("<p class=\"card-text\">" + text + "</p>");
}
