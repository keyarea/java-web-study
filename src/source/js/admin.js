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

function editUser(id, name, nickname, password){
    console.log(id, name, nickname, password);
};

window.deleteUser = deleteUser;
window.editUser = editUser;