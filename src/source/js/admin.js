var $ = require("jquery");
$("#logout-btn").click(function () {
    $.ajax("/logout", {
        method: "post",
        success: function (data) {
            window.location.href="/";
        },
        error: function (jqXHR, textStatus, error) {
            console.log('error' + jqXHR + textStatus + error);
        }
    });
});

function deleteUser(id){
    console.log(id);
};

$("#editUserModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var userID = button.data('id'); // Extract info from data-* attributes
    var modal = $(this);
    $.ajax("/admin/getUser",{
        method: "post",
        data: {id: userID},
        success: function(data){
            modal.find("#user-name").val(data.name);
            modal.find("#nickname-text").val(data.nickname);
            modal.find("#password-text").val(data.password);
       },
        error: function (error) {
            alert(error);
        }
    });

});

$("#deleteUserModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget);
    var userID = button.data("id");
    var modal = $(this);
    modal.find("#deleteUserModalBody").text("您是否删除id为" + userID + "的用户？")
    $("#deleteUser").click(function (e) {
        $.ajax("/admin/deleteUser",{
            method: "post",
            data: {id: userID},
            success: function (data) {
                $("#deleteUserModal").modal('hide');
                alert("成功删除用户！");
                usersRefresh();
            },
            error: function (error) {
                alert(JSON.parse(error));
            }
        })
    });
});

function usersRefresh(){
    var skip = getQueryString("skip");
    var limit = getQueryString("limit");
    console.log(skip, limit);
}

/**
 * 获取URL参数
 * @param name 参数名
 * @returns 参数值
 */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
}

window.usersRefresh = usersRefresh;

