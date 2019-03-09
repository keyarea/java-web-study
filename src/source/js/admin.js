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
    $.ajax("/admin/getUser",{
        method: "post",
        data: {id: userID},
        success: function(data){
            console.log(data);
       },
        error: function (error) {
            console.log(error);
        }
    });
    var modal = $(this);
});




window.deleteUser = deleteUser;
