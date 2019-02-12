var $ = require('jquery');
$("#verifyCode").click(function(){
    $(this).attr("src", 'getVerifyCode?' + Math.random());
});

