var username = '';
var domainName = "http://localhost:8080/myDBDesign";

function userInfo(){
	this.username;
	this.train_no;
	this.departure;
	this.terminal;
	this.startdate;
	this.starttime;
	this.arrivaltime;
	this.seat_no;
	this.seatlevel;
	this.ticketprice;
}

var users = new Array();

function getParam(paramName) {
	    var lot = location.search;
	    var reg = new RegExp(".*" + "userid" + "\\s*=([^=&#]*)(?=&|#|).*","g");
	    console.log(decodeURIComponent(lot.replace(reg, "$1")));
	    return decodeURIComponent(lot.replace(reg, "$1"));
}

function init(){
	username  = getParam('userid');
	if(username == '') {
		alert("尚未登录");
		window.location.href="../myDBDesign/index.jsp";
	}
	else {
		alert(username)
		showUsername();
		getUserTicket();
	}
}

function showUsername(){
	$("#user_info").html("<div id='detail'>用户名：" + username + "以下是您的订票信息</div>");
}

function getUserTicket(){
	
	$.post(
			domainName + "/servlet/GuestInfoServlet",
			{
				username:username
			},
			function (data){
				data = eval('(' + data + ')');
				if(data.status == 'error') return ;
				var re = data.result;
				for (var i = 0; i < re.length; i++) {
					userInfo[i] = new userInfo();
					userInfo[i].train_no = re[i].train_no;
					userInfo[i].departure = re[i].departure;
					userInfo[i].terminal = re[i].terminal;
					userInfo[i].startdate = re[i].startdate;
					userInfo[i].starttime = re[i].starttime;
					userInfo[i].arrivaltime = re[i].arrivaltime;
					userInfo[i].seat_no = re[i].seat_no;
					userInfo[i].seatlevel = re[i].seatlevel;
					userInfo[i].ticketprice = re[i].ticketprice;
					var newLine = '<tr id="' + re[i].train_no  + "'" + ')"><td class="train_no"><div>' + re[i].train_no + '</div></td><td class="dep"><div>' + userInfo[i].departure + '</div></td><td class="ter"><div>' + userInfo[i].terminal + '</div></td><td class="startdate><div>"' + userInfo[i].startdate + '</div></td><td class="stattTime"><div>' + re[i].starttime + '</div></td><td class="arrivalTime"><div>' + re[i].arrivaltime + '</div></td><td class="business_sum"><div>' + re[i].seat_no + '</div></td><td class="first_sum"><div>' + re[i].seatlevel + '</div></td><td class="second_sum"><div>' + re[i].ticketprice + '</div></td></tr>';
					$('table#list').append(newLine);
				}
				
			}
	)
}



onload = init;