var $ = require("jquery");

/**
 * 注销按钮单击所触发的事件
 */
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

/**
 * 添加一个用户
 */
function addUser(name, nickname, password){
    console.log(name, nickname, password);
    /*$.ajax("/admin/addUser", {
        method: "post",
        data: {
            "name": name,
            "nickname": nickname,
            "password": password
        },
        success: function(data){
            console.log(data);
        },
        erroe: function (error) {
            console.log(error);
        }
    })*/
}

/**
 * 修改一个用户
 * @param id 用户的id
 */
function updateUser(id, name, nickname, password){
    console.log(id, name, nickname, password);
    /*$.ajax("/admin/updateUser", {
        method: "post",
        data: {
            "id": id,
            "name": name,
            "nickname": nickname,
            "password": password
        },
        success: function(data){
            console.log(data);
        },
        erroe: function (error) {
            console.log(error);
        }
    })*/
}


/**
 * 用户编辑模态框显示的时候所触发的事件
 */
$("#editUserModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget); // Button that triggered the modal
    var userID = button.data('id'); // Extract info from data-* attributes
    var modal = $(this);
    // 添加保存事件
    $("#saveUser").click(function () {
        var password = modal.find("#password-text").val();
        var verifyPassword = modal.find("#verify-password").val();
        var name = modal.find("#user-name").val();
        var nickname = modal.find("#nickname-text").val();
        if(name === ""){
            alert("用户名不能为空！");
            return;
        }
        if(nickname === ""){
            alert("昵称不能为空！");
            return;
        }
        if(password === ""){
            alert("密码不能为空！");
            return;
        }
        if(verifyPassword === ""){
            alert("重复密码不能为空！");
            return;
        }
        if(password !== verifyPassword){
            alert("两次输入的密码不一致！");
            return;
        }

       if(userID === ""){ // userID为空代表为添加用户
           addUser(name, nickname, password);
       }else{ // userID有则表示为修改用户
           updateUser(userID, name, nickname, password);
       }
    });

    if(userID === ""){
        return;
    }
    var modal = $(this);
    $.ajax("/admin/getUser",{
        method: "post",
        data: {id: userID},
        success: function(data){
            modal.find("#user-name").val(data.name);
            modal.find("#nickname-text").val(data.nickname);
            modal.find("#password-text").val(data.password);
            modal.find("#verify-password").val(data.password);
       },
        error: function (error) {
            alert(error);
        }
    });

});


/**
 * 用户编辑模态框取消的时候所触发的事件
 */
$("#editUserModal").on("hidden.bs.modal", function(e){
    var modal = $(this);
    modal.find("#user-name").val("");
    modal.find("#nickname-text").val("");
    modal.find("#password-text").val("");
    modal.find("#verify-password").val("");
    $("#saveUser").unbind("click");
});

/**
 * 删除用户的确认莫泰框，模态框显现的时候所触发的事件
 */
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
                window.location.reload();
            },
            error: function (error) {
                alert(JSON.parse(error));
            }
        })
    });
});




