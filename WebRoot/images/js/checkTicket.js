function g(id){
	return document.getElementById(id);
}

var dep, ter, sta;
var year, month, day;

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
		if (sta != '') {
			$("#search_info").html("以下为车次 <span style='color: blue;'>" + sta + "</span> 的信息：");
			//post
		}
		else if (dep != '' && ter != '') {
			$("#search_info").html("以下为 <span style='color: blue;'>" + dep + "</span> 到 <span style='color: blue;'>" + ter + "</span> 的车次信息：");
			//post
		}
		else {alert('温馨提示：请输入查询条件！');}
	}
	else alert("温馨提示：请输入乘车日期！")
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

function createDate(){
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

onload = createDate;
$("#check_btn").click(submitInfo);
$('select#start_year').change(createOpt);
$('select#start_month').change(createOpt);