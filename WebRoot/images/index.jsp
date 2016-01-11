<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="Content-Type;charset=UTF-8" />
	<title>帅气上档次订票系统 | 首页</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/style_index.css">
	<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<!--导航-->
	<div id="nav">
		<div id="nav_center" class="center">		
			<div id="nav_left" class="divleft">
				<h2>车票订票系统 | 数据库课程设计</h2>
				<h5 style="margin-top: -16px;">计算机13(8)&nbsp;&nbsp;谢泳&nbsp;&nbsp;3113006148</h5>
			</div>
			<div id="nav_right" class="divright">
				<div id="tip">
					您好！欢迎来到<strong>帅到没朋友</strong>订票中心！
				</div>
				<ul id="nav_items">
					<a href="index.jsp"><li class="items">首&nbsp;&nbsp;&nbsp;&nbsp;页</li></a>
					<a href="check_ticket.jsp"><li class="items curr_item">余票查询</li></a>
					<a href="order_ticket.jsp"><li class="items">车票预订</li></a>
					<a href="personal_info.jsp"><li class="items">个人信息</li></a>
				</ul>
			</div>
		</div>
	</div>
	<div id="main" class="center">
		<div id="input_info" class="divleft common_border info_win">
			<!--登录窗口-->
			<div class="blue_bar">登录</div>
			<hr class="baseline" />
			<div class="main_area">
				<form name="login_info" >
					<input type="radio" name="role" value="admin" /> 管理员
					<input type="radio" checked="checked" name="role" value="guest" /> 普通用户
					<hr class="bottomline" style="height: 1px;" />
					用户名&nbsp;&nbsp;<input type="text" name="userid" class="ipwin" />
					密&nbsp;&nbsp;码&nbsp;&nbsp;<input type="password" name="password" class="ipwin" />
					<input type="submit" id="login" class="submit_button" value="登录"/>
					<input type="submit" id="register" class="submit_button" value="没有账号？注册一个"/>
				</form>
			</div>
		</div>
		<!--展示信息区域-->
		<div id="show_info" class="divright info_win common_border">
			<style type="text/css">
				div#show_info{
					background-image: url('images/bg_mainarea.png');
					background-size: 97%;
				}
			</style>
			<div class="blue_bar">说明</div>
			<hr class="baseline" />
			<div class="main_area">
				<ol>
					<li>注册账户；</li>
					<li>登录到本订票系统；</li>
					<li>查询余票</li>
					<li>预订车票</li>
				</ol>
			</div>
		</div>
	</div>
	<div class="clear"></div>
	<!--底部-->
	<div id="bottom">
	<hr class="bottomline" />
		Copyright © 2016. All rights reserved.<br/>Handsome boy~
	</div>
</body>
<script type="text/javascript" src="js/login.js"></script>
</html>