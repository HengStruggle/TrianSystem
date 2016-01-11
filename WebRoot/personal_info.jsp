<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="Content-Type;charset=UTF-8" />
	<title>帅气上档次 | 余票查询</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/personal.css">
	<script type="text/javascript" src="js/jquery.js"></script>
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
					<a id="first_page" href="index.jsp"><li class="items">首&nbsp;&nbsp;&nbsp;&nbsp;页</li></a>
					<a id="check_page" href="check_ticket.jsp"><li class="items">余票查询</li></a>
					<a id="user_page" href="personal_info.jsp"><li class="items curr_item">个人信息</li></a>
				</ul>
			</div>
		</div>
	</div>
	<div id="main" class="center">
		<!-- <div id="search_input" class="slim_border">
			<form >			
				<ul>
					<li class="sitem">
						<span>出发地</span>
						<select class="ipwin" id="departure" name="departure"></select>
					</li>	
					<li class="sitem">
						<img src="images/ex.png" id="ex_icon" />
					</li>
					<li class="sitem">
						<span>目的地</span>
						<select class="ipwin" id="terminal" name="terminal"></select>
					</li>
					<li class="sitem">
						<span>车次</span>
						<input type="text" class="ipwin" id="station" />
					</li>
					<li class="sitem">
						<span>乘车日期</span>
						<select class="ipdate" id="start_year" name="year">
							<option value=""></option>
							<option value="2016">2016</option>
							<option value="2017">2017</option>
							<option value="2018">2018</option>
						</select>年
						<select class="ipdate" id="start_month" name="month">
							<option value=""></option>
						</select>月
						<select class="ipdate" id="start_day" name="day">
							<option value=""></option>
						</select>日
					</li>
					<li class="sitem">
						<input type="button" value="查询" class="submit_button" id="check_btn" />
					</li>
				</ul>
			</form>
		</div>-->
		<div id="user_info" class="slim_border"></div>
		<div id="train_list">
			<div id="list_bar" class="blue_bar"></div>
			<table id="list"  border="0" cellspacing="0" cellpadding="0" >
				<tr id="thead">
					<th>车次</th>
					<th>始发站</th>
					<th>终点站</th>
					<th>发车日期</th>
					<th>发车时间</th>
					<th>到达时间</th>
					<th>座位等级</th>
					<th>座位号</th>
					<th>票价</th>
				</tr>
				<!--<tr>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div></div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
				</tr>
				<tr>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div></div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
					<td><div>ddd</div></td>
				</tr>-->
			</table>

		</div>
	</div>
	<div id="buyTicket" class="common_border">
		<div class="blue_bar">
			选择座位等级
		</div>
		<div class="main_area">
			座位等级&nbsp;&nbsp;
			<form >
				<select id="seatlevel" name="seatlevel" class="rank" >
					<option value='0'>商务座</option>
					<option value='1'>一等座</option>
					<option value='2'>二等座</option>
				</select>
				<input type="button" id="chooselevel" value="提交订单" />
				<input type="button" id="cancel" value="取消" />
			</form>
		</div>
	</div>
	<div class="clear"></div>
	<!--底部-->
	<hr class="bottomline" />
	<div id="bottom">
		Copyright © 2016. All rights reserved.<br/>Handsome boy~
	</div>
</body>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/user.js"></script>
</html>