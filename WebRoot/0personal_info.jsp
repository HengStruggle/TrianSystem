<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="Content-Type;charset=UTF-8" />
	<title>帅气上档次订票系统 | 首页</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/style_index.css">
	<link rel="stylesheet" type="text/css" href="css/personal.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
</head>
<body>
<!--导航-->
	<div id="nav">
		<div id="nav_center" class="center">		
			<div id="nav_left" class="divleft">
				<h2>车票订票系统 | 数据库课程设计</h2>
				<h5 style="margin-top: -16px;">计算机13(1)&nbsp;&nbsp;蔡岳衡&nbsp;&nbsp;3113005717</h5>
			</div>
			<div id="nav_right" class="divright">
				<div id="tip">
					您好！欢迎来到<strong>帅到没朋友</strong>订票中心！
				</div>
				<ul id="nav_items">
				<a href="index.jsp"><li class="items">首&nbsp;&nbsp;&nbsp;&nbsp;页</li></a>
					<a href="check_ticket.jsp"><li class="items">余票查询</li></a>
					<a href="personal_info.jsp"><li class="items curr_item">个人信息</li></a>
				</ul>
			</div>
		</div>
	</div>
	<div id="main" class="center">
		<div id="input_info" class="divleft common_border info_win">
			<!--登录窗口-->
			<div id="top_bar" class="blue_bar">账号信息</div>
			<hr class="baseline" />
			<div class="main_area">
				<div class="essential_info" id="name">
					姓名：
				</div>
				<div class="essential_info" id="pass">
					密码:
				</div>
			</div>
		</div>
		<!--展示信息区域-->
		<div id="show_info" class="divright info_win common_border">
			<div class="blue_bar">已订票信息</div>
			<hr class="baseline" />
			<div class="main_area">

			</div>
		</div>
	</div>
	<div class="clear"></div>
	<!--底部-->
	<hr class="bottomline" />
	<div id="bottom">
		Copyright © 2016. All rights reserved.<br/>Handsome boy~
	</div>
</body>
</html>