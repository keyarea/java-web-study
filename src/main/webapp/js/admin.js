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
    $.ajax("/admin/addUser", {
        method: "post",
        data: {
            "name": name,
            "nickname": nickname,
            "password": password
        },
        success: function(data){
            if(data !== null && data.result !== null && data.message !== null){
                if(data.result){
                    alert(data.message);
                    window.location.reload();
                }else{
                    alert(data.message);
                }

            }
        },
        erroe: function (error) {
            alert(JSON.stringify(error));
        }
    })
}

/**
 * 修改一个用户
 * @param id 用户的id
 */
function updateUser(id, nickname, password){
    console.log(id, nickname, password);
    $.ajax("/admin/updateUser", {
        method: "post",
        data: {
            "id": id,
            "nickname": nickname,
            "password": password
        },
        success: function(data){
            console.log(data);
            if(data !== null && data.result !== null){
                if(data.result){
                    alert("用户更新成功");
                    window.location.reload();
                }else{
                    alert("用户更新失败");
                }
            }
        },
        error: function (error) {
            console.log(error);
        }
    })
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
        var name = modal.find("#user-name").val();
        var password = modal.find("#password-text").val();
        var verifyPassword = modal.find("#verify-password").val();
        var nickname = modal.find("#nickname-text").val();
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
            if(name === ""){
                alert("用户名不能为空");
                return;
            }
            addUser(name, nickname, password);
        }else{ // userID有则表示为修改用户
            updateUser(userID, nickname, password);
        }
    });

    if(userID === ""){
        return;
    }
    modal.find("#user-name").attr('disabled',true);
    $.ajax("/admin/getUser",{
        method: "post",
        data: {id: userID},
        success: function(data){
            modal.find('#user-name').val(data.name);
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

    // 重置用户名的属性
    modal.find("#user-name").attr("disabled", false);
    // 重置输入的数据为空
    modal.find("#user-name").val("");
    modal.find("#nickname-text").val("");
    modal.find("#password-text").val("");
    modal.find("#verify-password").val("");
    // 取消绑定点击事件，防止绑定多个点击事件
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
                $("#deleteUserModal").modal('hide');
                alert("删除用户失败！");
            }
        })
    });
});


/**
 * 删除分类的确认莫泰框，模态框显现的时候所触发的事件
 */
$("#deleteCategoryModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget);
    var categoryID = button.data("id");
    var modal = $(this);
    modal.find("#deleteCategoryModalBody").text("您是否删除id为" + categoryID + "的分类？")
    $("#deleteCategory").click(function (e) {
        $.ajax("/admin/deleteCategory",{
            method: "post",
            data: {id: categoryID},
            success: function (data) {
                $("#deleteUserModal").modal('hide');
                alert("成功删除分类！");
                window.location.reload();
            },
            error: function (error) {
                $("#deleteUserModal").modal('hide');
                alert("删除分类失败！");
            }
        })
    });
});

/**
 * 管理分类
 */
$("#editCategoryModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget);
    var categoryID = button.data("id");
    var modal = $(this);

    // 添加保存事件
    $("#saveCategory").click(function() {
        var title = modal.find("#category-name").val();
        if(categoryID === ""){
            addCategory(title);
        }else{
            updateCategory(categoryID, title);
        }
    });

    if(categoryID === ""){
        return;
    }

    $.ajax("/admin/getCategory", {
        method: 'POST',
        data: {
            id: categoryID
        },
        success: function (result) {
            modal.find("#category-name").val(result.name);
        },
        error: function(error) {
            alert(error);
        }
    })
});

/**
 * 管理用户模态框消失时，该做的事情
 */
$("#editCategoryModal").on("hidden.bs.modal", function(){
    var modal = $(this);
    // 重置输入框中的数据
    modal.find("#category-name").val("");
    // 解绑绑定的点击事件
    $("#saveCategory").unbind('click');
});

/**
 * 修改一个用户
 * @param id
 * @param title
 */
function updateCategory(id, title){
    $.ajax("/admin/updateCategory", {
        method: "POST",
        data: {
            id: id,
            name: title
        },
        success: function(result){
            if(result){
                alert("更新分类成功");
                window.location.reload();
            }else{
                alert("更新分类失败");
                window.location.reload();
            }
        },
        error: function(error){
            alert(error);
            window.location.reload();
        }

    })
}

/**
 * 添加一个用户
 * @param title
 */
function addCategory(title){
    $.ajax("/admin/addCategory",{
        method: "POST",
        data: {
            name: title
        },
        success: function(result){
            if(result){
                alert("添加分类成功");
                window.location.reload();
            }else{
                alert("添加分类失败");
                window.location.reload();
            }
        },
        error: function() {
            alert(error);
            window.location.reload();
        }
    })
}


/**
 * 删除标签的确认莫泰框，模态框显现的时候所触发的事件
 */
$("#deleteTagModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget);
    var tagID = button.data("id");
    var modal = $(this);
    modal.find("#deleteTagModalBody").text("您是否删除id为" + tagID + "的标签？");
    $("#deleteTag").click(function (e) {
        $.ajax("/admin/deleteTag",{
            method: "post",
            data: {id: tagID},
            success: function (data) {
                $("#deleteTagModal").modal('hide');
                alert("成功删除标签！");
                window.location.reload();
            },
            error: function (error) {
                $("#deleteTagModal").modal('hide');
                alert("删除标签失败！")
            }
        })
    });
});

$("#deleteTagModal").on("hidden.bs.modal", function (event) {
    $("#deleteTag").unbind("click");
});


/**
 * 管理标签
 */
$("#editTagModal").on("show.bs.modal", function (event) {
    var button = $(event.relatedTarget);
    var tagID = button.data("id");
    var modal = $(this);

    // 添加保存事件
    $("#saveTag").click(function() {
        var title = modal.find("#tag-name").val();
        if(tagID === ""){
            addTag(title);
        }else{
            updateTag(tagID, title);
        }
    });

    if(tagID === ""){
        return;
    }

    $.ajax("/admin/getTag", {
        method: 'POST',
        data: {
            id: tagID
        },
        success: function (result) {
            modal.find("#tag-name").val(result.name);
        },
        error: function(error) {
            alert(error);
        }
    })
});

/**
 * 管理用户模态框消失时，该做的事情
 */
$("#editTagModal").on("hidden.bs.modal", function(){
    var modal = $(this);
    // 重置输入框中的数据
    modal.find("#tag-name").val("");
    // 解绑绑定的点击事件
    $("#saveTag").unbind('click');
});

function addTag(title) {
    $.ajax("/admin/addTag",{
        method: "POST",
        data: {
            name: title
        },
        success: function(result){
            if(result.result){
                alert(result.message);
                window.location.reload();
            }else{
                alert(result.message);
                window.location.reload();
            }
        },
        error: function() {
            alert(error);
            window.location.reload();
        }
    })
}

function updateTag(tagID, title) {
    $.ajax("/admin/updateTag", {
        method: "POST",
        data: {
            id: tagID,
            name: title
        },
        success: function(result){
            if(result.result){
                alert(result.message);
                window.location.reload();
            }else{
                alert(result.message);
                window.location.reload();
            }
        },
        error: function(error){
            alert(error);
            window.location.reload();
        }

    })


}

$("#deleteArticleModal").on("show.bs.modal", function(event) {
    var button = $(event.relatedTarget);
    var articleID = button.data("id");
    var modal = $(this);
    modal.find("#deleteArticleModalBody").text("您是否删除id为" + articleID + "的文章？");
    $("#deleteArticle").click(function (e) {
        $.ajax("/admin/deleteArticle",{
            method: "post",
            data: {id: articleID},
            success: function (data) {
                $("#deleteArticleModal").modal('hide');
                alert("成功删除文章！");
                window.location.reload();
            },
            error: function (error) {
                $("#deleteArticleModal").modal('hide');
                alert("删除文章失败！");
            }
        })
    });

});

$("#deleteArticleModal").on("hidden.bs.modal", function (event) {
    $("#deleteArticle").unbind("click");
});

$("#saveArticle").click(function (event) {
    console.log(editor.getMarkdown());
});
