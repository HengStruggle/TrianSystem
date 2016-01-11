var domainName = "http://localhost:8080/myDBDesign";
var username = '';

function g(id){
	return document.getElementById(id);
}

var dep;
var ter;
var sta;
var year;
var month;
var day;

function trainInfo(){
	this.dep;
	this.ter;;
	this.year;
	this.month;
	this.day;
	this.train_no;
	this.departure;
	this.terminal;
	this.startDate;
	this.startTime;
	this.arrivalTime;
	this.business_sum;
	this.business_price;
	this.first_sum;
	this.first_price;
	this.second_sum;
	this.second_price;
}

var train_info = new Array();


$("#ex_icon").click(function (){
	dep = g('departure').value;
	ter = g("terminal").value;
	g('departure').value = ter;
	g('terminal').value = dep;
	ter = dep;
	dep = g('departure').value;
});

function submitInfo(){
	dep = g('departure').value;
	ter = g("terminal").value;
	sta = g('station').value;
	year = $("select#start_year").val();
	month = $("select#start_month").val();
	day = $("select#start_day").val();
	if (year != '' && month != '' && day != '') {			
		if (dep != '' && ter != '') {
			$("#search_info").html("以下为 <span style='color: blue;'>" + dep + "</span> 到 <span style='color: blue;'>" + ter + "</span> 的车次信息：");
			postToCheck();

		}
		else {alert('温馨提示：请输入查询条件！');}
	}
	else alert("温馨提示：请输入乘车日期！");
}

function postToCheck(){
	$.ajaxSetup({ xhrFields: { withCredentials: true }, crossDomain: true });
	$.post(domainName + "/servlet/CheckTicketServlet",	///modify
		{
			departure: dep,
			terminal: ter,
			year: year,
			month: month,
			day:day
		},
		function (data) {
			data = eval('(' + data + ')');
			if (data.status === "error") {
				alert("error,没有相关线路的数据。");
			}
			else {
				//alert("success");
				var re = data.result;
				for (var i = 0; i < re.length; i++) {
					train_info[i] = new trainInfo();
					train_info[i].dep = dep;
					train_info[i].ter = ter;
					train_info[i].year = year;
					train_info[i].month = month;
					train_info[i].day = day;
					train_info[i].train_no = re[i].train_no;
					train_info[i].departure = re[i].departure;
					train_info[i].terminal = re[i].terminal;
					train_info[i].startDate = re[i].startDate;
					train_info[i].startTime = re[i].startTime;
					train_info[i].arrivalTime = re[i].arrivalTime;
					train_info[i].business_sum = re[i].business_sum;
					train_info[i].business_price = re[i].business_price;
					train_info[i].first_sum = re[i].first_sum;
					train_info[i].first_price = re[i].first_price;
					train_info[i].second_sum = re[i].second_sum;
					train_info[i].second_price = re[i].second_price;

					var newLine = '<tr id="' + re[i].train_no  + "'" + ')"><td class="train_no"><div>' + re[i].train_no + '</div></td><td class="dep"><div>' + dep + '</div></td><td class="ter"><div>' + ter + '</div></td><td class="stattTime"><div>' + re[i].startTime + '</div></td><td class="arrivalTime"><div>' + re[i].arrivalTime + '</div></td><td class="business_sum"><div>' + re[i].business_sum + '<Br/>￥' + re[i].business_price + '</div></td><td class="first_sum"><div>' + re[i].first_sum+ '<Br/>￥' + re[i].first_price  + '</div></td><td class="second_sum"><div>' + re[i].second_sum+ '<Br/>￥' + re[i].second_price  + '</div></td><td class="buyBtn"><div>' + '<input type="button" id="' + i + '" value="预订" class="submitToBuy" onclick="showWin(' + "'" + i + "'" + ')" />' + '</div></td></tr>';
					//var newNext = '<tr id="' + re[i].train_no +  '" onClick="' +   ')"><td class="train_no"><div>' + re[i].train_no + '</div></td><td class="dep"><div>' + dep + '</div></td><td class="ter"><div>' + ter + '</div></td><td class="stattTime"><div>' + re[i].startTime + '</div></td><td class="arrivalTime"><div>' + re[i].arrivalTime + '</div></td><td class="business_sum"><div>' + re[i].business_price + '</div></td><td class="first_sum"><div>' + re[i].first_price + '</div></td><td class="second_sum"><div>' + re[i].second_price + '</div></td><td class="buyBtn"><div>' + '<input type="button" id="submitToBuy" />' + '</div></td></tr>';
					$('table#list').append(newLine);
					//$('table#list').append(newNext);
				};	
				BtnIsAble();
			}
			
		}
	)
	
}

function BtnIsAble(){
	if(username == '' || username == 'undefined') {
		$('input.submitToBuy').each(function (){
			$(this).attr("disabled","disabled");
		})
	}
}

function createOpt(){
	var year = $("select#start_year").val();
	var month = $("select#start_month").val();
	var len = 0;
	if (month == '' || year == '') {len = 0}
	else if (month == '1' || month == '3' || month == '5' ||month == '7' || month == '8' 
		|| month == '10' ||month == '12') {len = 31}
	else if (month == '2') {
		year = parseInt(year);
		if (year % 100 == 0) {year /= 100}
		if (year % 4 == 0) {len = 29}
		else len = 28;
	}
	else len = 30;
	if ($('select#start_day').children().lnegth != len + 1) {
		$('select#start_day').empty();
		$('select#start_day').append("<option value=''></option>");
		for (var i = 1; i < len + 1; i++) {
			var day = "<option value='" + i + "'>" + i + "</option>";
			$('select#start_day').append(day);
		};
	};
}

function getParam(paramName) {
   /*   paramValue = "";
  isFound = false;
    if (this.location.search.indexOf("?") == 0 && this.location.search.indexOf("=") > 1) {
        arrSource = unescape(this.location.search).substring(1, this.location.search.length).split("&");
        i = 0;
        while (i < arrSource.length && !isFound) {
            if (arrSource[i].indexOf("=") > 0) {
                if (arrSource[i].split("=")[0].toLowerCase() == paramName.toLowerCase()) {
                    paramValue = arrSource[i].split("=")[1];
                    isFound = true;
                }
            }
            i++;
        }
    }*/
    var lot = location.search;
    var reg = new RegExp(".*" + "userid" + "\\s*=([^=&#]*)(?=&|#|).*","g");
    console.log(decodeURIComponent(lot.replace(reg, "$1")));
    return decodeURIComponent(lot.replace(reg, "$1"));
}

function init(){
	createlist('departure');
	createlist('terminal');
	username  = getParam('userid');
	alert(username);
	$('a#user_page').attr('href',"../myDBDesign/personal_info.jsp?userid=" + username);
	//alert($('a#user_page').attr('href'));
	console.log(username);

	var date = new Date();
	var ty = date.getFullYear();
	var tm = date.getMonth();
	var td = date.getDate();
	var sy = $("select#start_year");
	var sm = $("select#start_month");
	var sd = $("select#start_day");
	for (var i = 1; i < 13; i++) {
		var month = "<option value='" + i + "'>" + i + "</option>"
		sm.append(month);
	};
	sy.children().eq(ty - 2015).attr("selected","selected");
	sm.children().eq(tm + 1).attr("selected","selected");
	createOpt();
	sd.children().eq(td).attr("selected","selected");
}

var departureArr = new Array(
	'惠州南',
	'普宁',
	'汕尾',
	'深圳北',
	'潮汕',
	'潮阳',
	'广州南',
	'虎门',
	'光明城',
	'葵潭',
	'陆丰',
	'常平',
	'深圳坪山'
);

var terminalArr = new Array(
	'深圳北',
	'汕尾',
	'惠州南',
	'广州南',
	'潮阳',
	'普宁',
	'虎门',
	'潮汕',
	'陆丰',
	'光明城',
	'葵潭',
	'广州东',
	'深圳坪山',
	'常平'
);

function createlist(str){
	if (str == "departure") {temp = departureArr}
	else temp = terminalArr;
	for (var i = 0; i < temp.length; i++) {
		var opt = '<option value="' + temp[i] + '">' + temp[i] + '</option>';
		$('#' + str).append(opt);
	};
}

var num;
//***********订票*/
function showWin(id){
	num = parseInt(id);
	$('#buyTicket').show();
}

function order(){
	var t=train_info[num];
	var train_no = t.train_no;
	var year = t.year;
	var month = t.month;
	var day = t.day;
	var starttime = t.startTime;
	var seatlevel = $('#seatlevel option:selected').val();
	var price;
	if (seatlevel == '0') {price = t.business_price}
	else if (seatlevel == '1') {price = t.first_price}
	else price = t.second_price;

	$.post(domainName + '/servlet/OrderTicketServlet',
		{
			train_no:train_no,
			year: year,
			month:month,
			day:day,
			username:username,
			starttime:starttime,
			seatlevel:seatlevel,
			ticket_price:price
		},
		function (data){
			data = eval('(' + data + ')');
			if (data.status == "error") {alert('已订该车次车票，不可再次订票')}
			else if(data.status == "success") {
				alert('订票成功');
			}
		}
	)
	$('#buyTicket').hide();
}


onload = init;
$("#check_btn").click(submitInfo);
$('select#start_year').change(createOpt);
$('select#start_month').change(createOpt);
//$(".submitToBuy").click(showWin);
$('#chooselevel').click(order);
$('#cancel').click(function (){$('#buyTicket').hide();})