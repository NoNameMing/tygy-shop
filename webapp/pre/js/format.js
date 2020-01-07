function YZname() {
    var name = document.getElementById("name").value;
    var relName = "^[a-zA-Z$_][a-zA-Z0-9]{7,15}$";
    if (name != "") {
        if (name.match(relName)) {
            document.getElementById("name_span").innerText = "格式正确";
        } else {
            document.getElementById("name_span").innerText = "首字母必须以下划线_、$、英文开头，不能以数字开头，位数为8-16位，可以是大小写、数字和字母组合";
        }
    } else {
        document.getElementById("name_span").innerText = "请输入用户名!";
    }

};

function YanZ() {
    var pwd = document.getElementById("password").value;
    var rpwd = document.getElementById("confirmPassword").value;
    var relPwd = "^[A-Z][a-zA-Z0-9_]{7,15}$";
    if (pwd.match(relPwd)) {
        document.getElementById("password_span").innerText = "格式正确";
        // var rpwd = document.getElementById("confirmPassword").value;
        if (pwd.toString() == rpwd.toString()) {
            document.getElementById("confirmPassword_span").innerText = "√";
        } else {
            document.getElementById("confirmPassword_span").innerText = "两次密码输入不一致";
        }
    } else {
        document.getElementById("password_span").innerText = "首字母必须是大写字母，8-16位";
    }
};

function YZPhone() {
    var phone = document.getElementById("phone").value;
    if(!(/^1[3456789]\d{9}$/.test(phone))){
        document.getElementById("phone_span").innerText = "手机号格式有误，请重新填写";
        return false;
    } else {
        document.getElementById("phone_span").innerText = "格式正确";
        return true;
    }
};