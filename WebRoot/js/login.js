var domainName = "http://localhost:8080/myDBDesign";

var role;
var userid,password;
var noError = '0',errUidEmpty = '1',errPwEmpty = '2',errTooLong = '3';//错误类型
//提示信息
var tip = "温馨提示：";
var mUidNotEmpty = "用户名不能为空！";
var mPassNotEmpty = "密码不能为空！";
var mUidShorter = "用户名长度不能超过20！";
var mPassShorter = "密码长度不能超过20！";

function submitLoginInfo(){
	checkInfo();
	postToLogin();	
}

function submitRegInfo(){
	checkInfo();
	postToRegister();
}

function checkInfo(){
	role = $("input[name='role']:checked").val();
	userid = $("input[name='userid']").val();
	password = $("input[name='password']").val();
	if (userid == '') {
		alert(tip + mUidNotEmpty);
		return errUidEmpty;
	}
	else if (userid.length > 20) {
		alert(tip + mUidShorter);
		return errTooLong;
	};
	if (password == '') {
		alert(tip + mPassNotEmpty);
		return errPwEmpty;
	}
	else if (password.length > 20) {
		alert(tip + mPassShorter);
		return errTooLong;
	};
	return noError;
}

//与后台交互
function postToLogin(){
	$.ajaxSetup({ xhrFields: { withCredentials: true }, crossDomain: true });
	$.post(domainName + "/servlet/LoginServlet",	///modify
		{
			username: userid,
			password: password,
			role: role
		},
		function (data) {
			data = eval('(' + data + ')');
			if (data.statue === "error") {

				console.log("error");
			}
			else {

				alert("登录成功！");
				console.log("success");
				window.location.href="../myDBDesign/check_ticket.jsp?userid=" + userid;
			}
		}
	)
}

function postToRegister(){
	$.ajaxSetup({ xhrFields: { withCredentials: true }, crossDomain: true });
	$.post(domainName + "/servlet/RegisterServlet",	///modify
		{
			username: userid,
			password: password,
			role:role
		},
		function (data) {
			data = eval('(' + data + ')');
			if (data.status == "error") {
				alert("用户名已存在，请重新输入");
				console.log("error");
			}
			else {
				//do when successfully register
				alert("注册成功！\n请登录");
				console.log("success");
			}
		}
	)
}

$('#login').click(submitLoginInfo);
$('#register').click(submitRegInfo);