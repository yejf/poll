//页面跳转函数
function ReDirect(Url){
	window.location = Url;
}

//
function PopWindow(Url,H,W,Scroll){
	window.open(Url,null,
				"height=" + H +",width=" + W + ",scrollbars=" + Scroll +
				",status=no,toolbar=no,menubar=no,location=no,resizable=no");
}


//数据验证函数
//==============================================================
//检查表单输入项,如果是""或是NULL返回false
function isEmpty(element1){
        var element2 = eval(element1);
        if( element2 == null || element2.value == ""){
			return false;
			element1.focus();
        }
        return true;
}
//检查表单输入项,如果是""或是NULL弹出"errMsg"提示,并且返回false
function isEmpty(pObj,errMsg){

        var obj = eval(pObj);
        if( obj == null || obj.value == ""){
                if (errMsg == null || errMsg =="")
                        alert("输入为空!");
                else
                        alert(errMsg);
                obj.focus();

                return false;
        }
        return true;
}

//检查表单输入项元素pObj是否为数值,否则弹出"errMsg"提示,并且返回false
function isDecimal(pObj,errMsg){
	var obj = eval(pObj);
	if(!isEmpty(pObj,errMsg))return false;
	if (isNaN(obj.value)) {
		if (errMsg == null || errMsg =="")
			alert("输入不为数值!");
		else
			alert(errMsg);
		obj.focus();
		return false;
	}
	return true;
}

//检查表单输入项,如果是""或是NULL弹出"errMsg"提示,并且返回false(长度要小于)
function isEmpty(pObj,num,errMsg){
        var obj = eval(pObj);
        if( obj == null || obj.value == ""){
                if (errMsg == null || errMsg =="")
                        alert("输入为空!");
                else
                        alert(errMsg);
                obj.focus();

                return false;
        }else{
          if(obj.value.length>num){
		alert(errMsg);
		obj.focus();
		return false;
            }
             return true;
        }
}
//检查表单输入项,如果是""或是NULL弹出"errMsg"提示,并且返回false(长度要小于)
function isEmpty(pObj,num1,num2,errMsg){
        var obj = eval(pObj);
        if( obj == null || obj.value == ""){
                if (errMsg == null || errMsg ==""){
                        alert("输入为空!");
                } else {
                        alert(errMsg);
                }
                obj.focus();
                return false;
        }else{
          if(obj.value.length<num1||obj.value.length>num2){
				alert(errMsg);
				obj.focus();
				return false;
            }
             return true;
        }
}

//检查表单输入项元素element1中,如果含有非法字符char1,返回false
function checkInvalid(element1,char1,errMsg){

        var obj = eval(element1);
        if( obj != null && obj.value !=""){
			for (i=0;i<obj.value.length;i++) {
				tempChar= obj.value.substring(i,i+1);
                if(!(char1.indexOf(tempChar,0)==-1)) {
                        alert(errMsg)
                        return false;
                }
			}
        }
    	return true;
}

//检查表单输入项元素pObj中,不能含有中文,且不能为空
function checkNoch(pObj,errMsg){
	var obj = eval(pObj);
	strRef = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_";
	if(!isEmpty(pObj,errMsg))return false;
	for (i=0;i<obj.value.length;i++) {
		tempChar= obj.value.substring(i,i+1);
		if (strRef.indexOf(tempChar,0)==-1) {
			if (errMsg == null || errMsg =="")
				alert("数据不符合要求,请检查");
			else
				alert(errMsg);
			if(obj.type=="text")
				obj.focus();
			return false;
		}
	}
	return true;
}

//日期格式检测
function checkDate(pObj,errMsg){
	var obj = eval(pObj);
	strRef = "0123456789-";
	if(!isEmpty(pObj,10,10,errMsg)) return false;
	if(!checkNoch(pObj,strRef,errMsg))return false;
	for (i=0;i<obj.value.length;i++) {
		tempChar= obj.value.substring(i,i+1);
		
		if (i==4){
			if(tempChar!="-"){
				alert(errMsg);
				return false;
			}
		} else if (i==7){
			if(tempChar!="-"){
				alert(errMsg);
				return false;
			}
		} 
	}
	return true;
}

//检查表单输入项元素pObj中,不能含有中文,且不能为空
function checkNoch(pObj,strRef,errMsg){

	var obj = eval(pObj);
	if(strRef==null||strRef==""){
        checkNoch(pObj,errMsg)
	}else{
		if(!isEmpty(pObj,errMsg))return false;
		for (i=0;i<obj.value.length;i++) {
			tempChar= obj.value.substring(i,i+1);
			if (strRef.indexOf(tempChar,0)==-1) {
				if (errMsg == null || errMsg =="")
					alert("数据不符合要求,请检查");
				else
					alert(errMsg);
				if(obj.type=="text")
					obj.focus();
				return false;
			}
		}
		return true;
	}
}

//检查表单输入项元素pObj中,长度是否大于num,
function checkLength(pObj,num,errMsg){

	var obj = eval(pObj);
	if(!isEmpty(pObj,errMsg))return false;
                if (obj.value.length<num){
                        alert(errMsg);
                        return false;
                }
	return true;
}
//检查表单输入项元素pObj是否为数字,否则弹出"errMsg"提示,并且返回false(不能为空)
function isNumber(pObj,errMsg){
	var obj = eval(pObj);
	strRef = "1234567890";
	if(!isEmpty(pObj,errMsg))return false;
	for (i=0;i<obj.value.length;i++) {
		tempChar= obj.value.substring(i,i+1);
		if (strRef.indexOf(tempChar,0)==-1) {
			if (errMsg == null || errMsg =="")
				alert("数据不符合要求,请检查");
			else
				alert(errMsg);
			if(obj.type=="text")
				obj.focus();
			return false;
		}
	}
	return true;
}

//检查表单输入项元素pObj是否为数字,但是数字可以为负数,否则弹出"errMsg"提示,并且返回false
function isNegative(pObj,errMsg){
	var obj = eval(pObj);
	strRef = "1234567890-";
	if(!isEmpty(pObj,errMsg))return false;
	for (i=0;i<obj.value.length;i++) {
		tempChar= obj.value.substring(i,i+1);
		if (strRef.indexOf(tempChar,0)==-1) {
			if (errMsg == null || errMsg =="")
				alert("数据不符合要求,请检查");
			else
				alert(errMsg);
			if(obj.type=="text")
				obj.focus();
			return false;
		}else{
			if(i>0){
				if(obj.value.substring(i,i+1)=="-"){
					if (errMsg == null || errMsg =="")
						alert("数据不符合要求,请检查");
					else
						alert(errMsg);
					if(obj.type=="text")
					obj.focus();
					return false;
				}
			}
		}
	}
	return true;
}


//检查表单输入项元素pObj是否大于零,否则弹出"errMsg"提示,并且返回false
function isPlus(pObj,errMsg){
        var obj = eval(pObj);
        if (obj.value<=0) {
                if (errMsg == null || errMsg =="")
                        alert("输入必须大于零!");
                else
                        alert(errMsg);
                obj.focus();
                return false;
        }
        return true;
}


//检查表单输入项元素pObj是否为email,否则弹出"errMsg"提示,并且返回false
function isEmail(pObj,errMsg){
	var obj = eval(pObj);
	if (obj.value=="")
		return true;
	if(obj.value.indexOf("@") == -1 || obj.value.indexOf(".") == -1){
		if (errMsg == null || errMsg =="")
			alert("输入不为email!");
		else
			alert(errMsg);
		obj.focus();
		return false;
	}
	return true;
}

//检查导入的文件类型,pObj表单名称,filetype指定文件类型,errMsg消息提示,并且返回false
function isFileType(pObj,filetype,errMsg){
	var obj = eval(pObj);
	if (obj.value!=""){
		if(obj.value.lastIndexOf(".") != -1){
			var filetype1 = obj.value.substring(obj.value.lastIndexOf("."), obj.value.length);
			if (filetype1!=filetype){
			        alert(errMsg);
				return false;
			}
		}
	}
	return true;
}


function passwordvalidate(pObj1,pObj2,errMsg){
  var obj1 = eval(pObj1);
  var obj2 = eval(pObj2);
  if(obj1.value!=obj2.value){
                      alert(errMsg);
                      obj1.focus(); obj2.focus();
                      return false;
  }else{
                       obj1.focus(); obj2.focus();
                      return true;
    }

}
//得到当前日期的月份
function getToday(){
	var thisDate = new Date();
	var months = new makeArray("January", "February", "March",
								"April", "May", "June",
								"July", "August", "September",
								"October", "November", "December");
	return getDay(thisDate) + " <font face=Helvetica>&#149;</font> " +
	months[thisDate.getMonth()] + " " +	thisDate.getDate() + ", " + getFullYear(thisDate);
}
//得到当前日期的星期
function getDay(date){
	var days = new makeArray("星期日", "星期一","星期二", "星期三", "星期四", "星期五","星期六");
	return days[date.getDay()];
}
//得到当前日期的年
function getFullYear(date){
	year = date.getYear();
	if (year < 1000)
		year += 1900;
	return year;
}

//内部方法
function makeArray(){
	var args = makeArray.arguments;
	for (var i = 0; i < args.length; i++)
		this[i] = args[i];
	this.length = args.length;
}
//==============================================================

//表单验证和表单操作函数
//==============================================================
//验证是否重复提交,"errMsg"重复提交后返回的错误信息
var submitFlag=false;
function isReSubmit(errMsg) {
        if (submitFlag) {
                if (errMsg == null || errMsg =="")
                        alert("正在提交,请稍候!");
                else
                        alert(errMsg);
                return false;
        }
        submitFlag = true;
        return true;
}

//判断是否选择一个选项条目
function isSelectItem(theform,etName,msg){
        cnum=0;
        for(i=0;i<theform.elements.length;i++) {
                et=theform.elements[i];
                if((et.name==etName)&&(et.checked))
                        cnum++;
        }
        if(cnum==0) {
                alert(msg);
                return false;
        }
        return true;
}

//使form中的checkbox被全部选中
function checkall(form){
     for (var i=0;i<document.form.elements.length;i++){
               document.form.elements[i].checked = true;
     }
}
//使form中checkbox被全部取消
function checkno(form){
     for (var i=0;i<document.form.elements.length;i++){
               document.form.elements[i].checked = false;
     }
}

//用于在文本框中只能输入汉字
function checkchinese(str){  
    var   reg   =   /[^\u4E00-\u9FA5]/g;
     if (reg.test(str.value)){
	str.value="";
	      return false;
   }
   return true;
}
//email 检查
function checkInfo(s) {
if(checkMail(s.value)==false){
	alert("输入的E-Mail不是合法的格式!"); 
	s.focus(); 
	s.value="";
	return false;
}

}
function checkMail(s) 
{ 
var pattern=/\w+@\w+\.[a-z]+/; 
if(pattern.test(s)||s.length==0) 
{ 
return true; 
} 
else 
{ 
return false; 
} 
}
//poll项目中增加班级表单验证
function checkClassAdd(info)
{
	if(info.classType.value=="-1"){
		alert("请选择班级类型");
		info.focus();
		return false;
	}
	if(info.className.value==""||info.className.value==null){
		alert("请输入班级");
		info.focus();
		return false;
	}
	if(info.classIP.value==""||info.classIP.value==null){
		alert("请输入IP");
		info.focus();
		return false;
	}
	if(checkIP(info.classIP.value)==false){
		alert("你输入的IP不是合法的。");
		info.focus();
		return false;
	}
	if(info.remark.value==""||info.remark.value==null){
		alert("请输入备注信息");
		info.focus();
		return false;
	}
}
//IP 检查
function checkIP(ip){
	var pattern = /^((2[0-4]\d|25[0-5]|[01]?\d\d?)\.){2}(2[0-4]\d|25[0-5]|[01]?\d\d?)$/;
	if(pattern.test(ip)||ip.length==0){
		return true;
	}else{
		return false;
	}
}
//poll项目中增加调查表单的验证
function checkClassAndPm(info){
	if(info.className.value=="-1"){
		alert("请选择班级");
		info.focus();
		return false;
	}
	if(info.realName.value=="-1"){
		alert("请选择项目经理");
		info.focus();
		return false;
	}
}
//poll项目中修改密码表单的验证
function checkPasswordV(info){
	if(info.oldPassword.value==""||info.oldPassword.value==null){
		alert("请输入原密码！");
		info.focus();
		return false;
	}
	if(info.newPassword.value==""||info.newPassword.value==null){
		alert("请输入新密码！");
		info.focus();
		return false;
	}
	if(info.newPasswordConfim.value==""||info.newPasswordConfim.value==null){
		alert("请输入确认密码！");
		info.focus();
		return false;
	}
	if(info.newPassword.value!=info.newPasswordConfim.value){
		alert("密码输入不一致！");
		info.newPassword.value="";
		info.newPasswordConfim.value="";
		info.newPassword.focus();
		return false;
	}
	if(info.oldPassword.value.length > 18||info.newPasswordConfim.value.length > 18||info.newPasswordConfim.value.length > 18){
		alert("密码长度不能大于18个字符");
		info.focus();
		return false;
	}
}
//只能输入数字
function checkchinese(str){  
    var   reg   =   /[^\u4E00-\u9FA5]/g;
     if (reg.test(str.value)){
	str.value="";
	      return false;
   }
   return true;
}

//用于在文本框中只能输入汉字
function onlychinese(){
	if((window.event.keyCode >= 32) && (window.event.keyCode <= 126)){
		window.event.keyCode = 0;
		alert("请输入汉字");
		return false;
	}
 }

//检查users_ad.jsp表单输入项,如果是""或是NULL返回false
function notnull_user_add(){
        if(!isEmpty(document.getElementById("user_name_id"))){
        	alert("员工NO不能为空");
        	return false;
        }
       	if(!isEmpty(document.getElementById("passwd_id"))){
        	alert("密码不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("real_name_id"))){
        	alert("姓名不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("join_date_id"))){
        	alert("入职时间不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("email_id"))){
        	alert("邮箱不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("phone_id"))){
        	alert("电话不能为空");
        	return false;
        }
        return true;
}

//检查deptment_add.jsp表单输入项,如果是""或是NULL返回false
function notnull_deptment_add(){
        if(!isEmpty(document.getElementById("group_name_id"))){
        	alert("部门不能为空");
        	return false;
        }
       	if(!isEmpty(document.getElementById("real_name_id"))){
        	alert("部门名不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("descrption_id"))){
        	alert("部门简介不能为空");
        	return false;
        }
        return true;
}

//检查module_add.jsp表单输入项,如果是""或是NULL返回false
function notnull_module_add(){
        if(!isEmpty(document.getElementById("module_name_id"))){
        	alert("功能名不能为空");
        	return false;
        }
       	if(!isEmpty(document.getElementById("real_name_id"))){
        	alert("功能全称不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("description_id"))){
        	alert("备注不能为空");
        	return false;
        }
        return true;
}

//检查class_add.jsp表单输入项,如果是""或是NULL返回false
function notnull_class_add(){
        if(!isEmpty(document.getElementById("class_name_id"))){
        	alert("名称不能为空");
        	return false;
        }
       	if(!isEmpty(document.getElementById("room_local_id"))){
        	alert("教室不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("start_date_id"))){
        	alert("日期不能为空");
        	return false;
        }
        if(!isEmpty(document.getElementById("descrption_id"))){
        	alert("备注不能为空");
        	return false;
        }
        return true;
}
//只能输入数字
function onlynumber(){ 
    if (event.keyCode < 48 || event.keyCode > 57){
      event.returnValue = false;
      alert("请输入数字");
      return false;
      }
}

//条件选择器
//==============================================================
//实现"省-市"条件选择器
function showProvinceCity(province){
		
				var ah_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"合肥市\">合肥市</option>" +
							"		<option value=\"宿州市\">宿州市</option>" +
							"		<option value=\"淮北市\">淮北市</option>" +
							"		<option value=\"毫州市\">毫州市</option>" +
							"		<option value=\"阜阳市\">阜阳市</option>" +
							"		<option value=\"蚌埠市\">蚌埠市</option>" +
							"		<option value=\"淮南市\">淮南市</option>" +
							"		<option value=\"滁州市\">滁州市</option>" +
							"		<option value=\"马鞍山市\">马鞍山市</option>" +
							"		<option value=\"芜湖市\">芜湖市</option>" +
							"		<option value=\"铜陵市\">铜陵市</option>" +
							"		<option value=\"安庆市\">安庆市</option>" +
							"		<option value=\"黄山市\">黄山市</option>" +
							"		<option value=\"六安市\">六安市</option>" +
							"		<option value=\"巢湖市\">巢湖市</option>" +
							"		<option value=\"池州市\">池州市</option>" +
							"		<option value=\"宣城市\">宣城市</option>" +
							"	</select>"
			var am_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"澳门\">澳门</option>" +
							"	</select>"

				var bj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"北京市\">北京市</option>" +
							"	</select>"

				var cq_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"重庆市\">重庆市</option>" +
							"	</select>"
				var fj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"福州市\">福州市</option>" +
							"		<option value=\"南平市\">南平市</option>" +
							"		<option value=\"莆田市\">莆田市</option>" +
							"		<option value=\"三明市\">三明市</option>" +
							"		<option value=\"泉州市\">泉州市</option>" +
							"		<option value=\"厦门市\">厦门市</option>" +
							"		<option value=\"漳州市\">漳州市</option>" +
							"		<option value=\"龙岩市\">龙岩市</option>" +
							"		<option value=\"宁德市\">宁德市</option>" +
							"	</select>"
				var gd_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"广州市\">广州市</option>" +
							"		<option value=\"清远市\">清远市</option>" +
							"		<option value=\"韶关市\">韶关市</option>" +
							"		<option value=\"河源市\">河源市</option>" +
							"		<option value=\"梅州市\">梅州市</option>" +
							"		<option value=\"潮州市\">潮州市</option>" +
							"		<option value=\"汕头市\">汕头市</option>" +
							"		<option value=\"揭阳市\">揭阳市</option>" +
							"		<option value=\"汕尾市\">汕尾市</option>" +
							"		<option value=\"惠州市\">惠州市</option>" +
							"		<option value=\"东莞市\">东莞市</option>" +
							"		<option value=\"深圳市\">深圳市</option>" +
							"		<option value=\"珠海市\">珠海市</option>" +
							"		<option value=\"中山市\">中山市</option>" +
							"		<option value=\"江门市\">江门市</option>" +
							"		<option value=\"佛山市\">佛山市</option>" +
							"		<option value=\"肇庆市\">肇庆市</option>" +
							"		<option value=\"云浮市\">云浮市</option>" +
							"		<option value=\"阳江市\">阳江市</option>" +
							"		<option value=\"茂名市\">茂名市</option>" +
							"		<option value=\"湛江市\">湛江市</option>" +
							"	</select>"
				var gs_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"兰州市\">兰州市</option>" +
							"		<option value=\"嘉峪关市\">嘉峪关市</option>" +
							"		<option value=\"金昌市\">金昌市</option>" +
							"		<option value=\"白银市\">白银市</option>" +
							"		<option value=\"天水市\">天水市</option>" +
							"		<option value=\"武威市\">武威市</option>" +
							"		<option value=\"酒泉市\">酒泉市</option>" +
							"		<option value=\"张掖市\">张掖市</option>" +
							"		<option value=\"庆阳市\">庆阳市</option>" +
							"		<option value=\"平凉市\">平凉市</option>" +
							"		<option value=\"定西市\">定西市</option>" +
							"		<option value=\"陇南市\">陇南市</option>" +
							"		<option value=\"临下市\">临下市</option>" +
							"		<option value=\"甘南市\">甘南市</option>" +
							"	</select>"
			

				
				
				var gx_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"南宁市\">南宁市</option>" +
							"		<option value=\"桂林市\">桂林市</option>" +
							"		<option value=\"柳州市\">柳州市</option>" +
							"		<option value=\"梧州市\">梧州市</option>" +
							"		<option value=\"贵港市\">贵港市</option>" +
							"		<option value=\"玉林市\">玉林市</option>" +
							"		<option value=\"钦州市\">钦州市</option>" +
							"		<option value=\"北海市\">北海市</option>" +
							"		<option value=\"防城港市\">防城港市</option>" +
							"		<option value=\"崇左市\">崇左市</option>" +
							"		<option value=\"百色市\">百色市</option>" +
							"		<option value=\"河池市\">河池市</option>" +
							"		<option value=\"来宾市\">来宾市</option>" +
							"		<option value=\"贺州市\">贺州市</option>" +
							"	</select>"

				var gz_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"贵州市\">贵州市</option>" +
							"		<option value=\"六盘水市\">六盘水市</option>" +
							"		<option value=\"遵义市\">遵义市</option>" +
							"		<option value=\"安顺市\">安顺市</option>" +
							"		<option value=\"毕节地区\">毕节地区</option>" +
							"		<option value=\"铜仁地区\">铜仁地区</option>" +
							"		<option value=\"黔东南苗族侗族自治州\">黔东南苗族侗族自治州</option>" +
							"		<option value=\"黔南布依族苗族自治州\">黔南布依族苗族自治州</option>" +
							"		<option value=\"黔西南布依族苗族自治州\">黔西南布依族苗族自治州</option>" +
							"	</select>"

				var hn_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"郑州市\">郑州市</option>" +
							"		<option value=\"三门峡市\">三门峡市</option>" +
							"		<option value=\"洛阳市\">洛阳市</option>" +
							"		<option value=\"焦作市\">焦作市</option>" +
							"		<option value=\"新乡市\">新乡市</option>" +
							"		<option value=\"鹤壁市\">鹤壁市</option>" +
							"		<option value=\"安阳市\">安阳市</option>" +
							"		<option value=\"濮阳市\">濮阳市</option>" +
							"		<option value=\"开封市\">开封市</option>" +
							"		<option value=\"南丘市\">南丘市</option>" +
							"		<option value=\"许昌市\">许昌市</option>" +
							"		<option value=\"漯河市\">漯河市</option>" +
							"		<option value=\"平顶山市\">平顶山市</option>" +
							"		<option value=\"南阳市\">南阳市</option>" +
							"		<option value=\"信阳市\">信阳市</option>" +
							"		<option value=\"周口市\">周口市</option>" +
							"		<option value=\"驻马店市\">驻马店市</option>" +
							"	</select>"
				var hb_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"武汉市\">武汉市</option>" +
							"		<option value=\"十堰市\">十堰市</option>" +
							"		<option value=\"襄樊市\">襄樊市</option>" +
							"		<option value=\"荆门市\">荆门市</option>" +
							"		<option value=\"孝感市\">孝感市</option>" +
							"		<option value=\"黄冈市\">黄冈市</option>" +
							"		<option value=\"鄂州市\">鄂州市</option>" +
							"		<option value=\"黄石市\">黄石市</option>" +
							"		<option value=\"咸宁市\">咸宁市</option>" +
							"		<option value=\"荆州市\">荆州市</option>" +
							"		<option value=\"宜昌市\">宜昌市</option>" +
							"		<option value=\"随州市\">随州市</option>" +
							"		<option value=\"恩施土家族苗族自治州\">恩施土家族苗族自治州</option>" +
							"	</select>"
				var heb_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"石家庄市\">石家庄市</option>" +
							"		<option value=\"张家口市\">张家口市</option>" +
							"		<option value=\"承德市\">承德市</option>" +
							"		<option value=\"秦皇岛市\">秦皇岛市</option>" +
							"		<option value=\"唐山市\">唐山市</option>" +
							"		<option value=\"廊坊市\">廊坊市</option>" +
							"		<option value=\"衡水市\">衡水市</option>" +
							"		<option value=\"沧州市\">沧州市</option>" +
							"		<option value=\"邢台市\">邢台市</option>" +
							"		<option value=\"邯郸市\">邯郸市</option>" +
							"		<option value=\"保定市\">保定市</option>" +
							"	</select>"
				var hain_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"海口市\">海口市</option>" +
							"		<option value=\"三亚市\">三亚市</option>" +
							"	</select>"

				var hlj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"哈尔滨市\">哈尔滨市</option>" +
							"		<option value=\"七台河市\">七台河市</option>" +
							"		<option value=\"黑河市\">黑河市</option>" +
							"		<option value=\"大庆市\">大庆</option>" +
							"		<option value=\"齐齐哈尔市\">齐齐哈尔市</option>" +
							"		<option value=\"伊春市\">伊春市</option>" +
							"		<option value=\"佳木斯市\">佳木斯市</option>" +
							"		<option value=\"双鸭山市\">双鸭山市</option>" +
							"		<option value=\"鸡西市\">鸡西市</option>" +
							"		<option value=\"大兴安岭地区\">大兴安岭地区</option>" +
							"		<option value=\"牡丹江市\">牡丹江市</option>" +
							"		<option value=\"鹤岗市\">鹤岗市</option>" +
							"		<option value=\"绥化市\">绥化市</option>" +
							"	</select>"
				var hun_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"长沙市\">长沙市</option>" +
							"		<option value=\"张家界市\">张家界市</option>" +
							"		<option value=\"常德市\">常德市</option>" +
							"		<option value=\"益阳市\">益阳市</option>" +
							"		<option value=\"岳阳市\">岳阳市</option>" +
							"		<option value=\"株洲市\">株洲市</option>" +
							"		<option value=\"湘潭市\">湘潭市</option>" +
							"		<option value=\"衡阳市\">衡阳市</option>" +
							"		<option value=\"郴州市\">郴州市</option>" +
							"		<option value=\"永州市\">永州市</option>" +
							"		<option value=\"邵阳市\">邵阳</option>" +
							"		<option value=\"怀化市\">怀化市</option>" +
							"		<option value=\"娄底市\">娄底市</option>" +
							"		<option value=\"湘西土家族苗族自治州\">湘西土家族苗族自治州</option>" +
							"	</select>"

				var jl_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"吉林市\">吉林市</option>" +
							"		<option value=\"长春市\">长春市</option>" +
							"		<option value=\"白城市\">白城市</option>" +
							"		<option value=\"松原市\">松原市</option>" +
							"		<option value=\"四平市\">四平市</option>" +
							"		<option value=\"辽源市\">辽源市</option>" +
							"		<option value=\"通化市\">通化市</option>" +
							"		<option value=\"白山市\">白山市</option>" +
							"		<option value=\"延边朝鲜族自治州\">延边朝鲜族自治州</option>" +
							"	</select>"
				var js_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"南京市\">南京市</option>" +
							"		<option value=\"徐州市\">徐州市</option>" +
							"		<option value=\"连云港市\">连云港市</option>" +
							"		<option value=\"宿迁市\">宿迁市</option>" +
							"		<option value=\"淮安市\">淮安市</option>" +
							"		<option value=\"盐城市\">盐城市</option>" +
							"		<option value=\"扬州市\">扬州市</option>" +
							"		<option value=\"泰州市\">泰州市</option>" +
							"		<option value=\"南通市\">南通市</option>" +
							"		<option value=\"镇江市\">镇江市</option>" +
							"		<option value=\"常州市\">常州市</option>" +
							"		<option value=\"无锡市\">无锡市</option>" +
							"		<option value=\"苏州市\">苏州市</option>" +
							"	</select>"
				var jx_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"南昌市\">南昌市</option>" +
							"		<option value=\"九江市\">九江市</option>" +
							"		<option value=\"景德镇市\">景德镇市</option>" +
							"		<option value=\"鹰潭市\">鹰潭市</option>" +
							"		<option value=\"新余市\">新余市</option>" +
							"		<option value=\"萍乡市\">萍乡市</option>" +
							"		<option value=\"赣州市\">赣州市</option>" +
							"		<option value=\"上饶市\">上饶市</option>" +
							"		<option value=\"抚州市\">抚州市</option>" +
							"		<option value=\"宜春市\">宜春市</option>" +
							"		<option value=\"吉安市\">吉安市</option>" +
							"	</select>"
				var ln_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"沈阳市\">沈阳市</option>" +
							"		<option value=\"朝阳市\">朝阳市</option>" +
							"		<option value=\"阜新市\">阜新市</option>" +
							"		<option value=\"铁岭市\">铁岭市</option>" +
							"		<option value=\"抚顺市\">抚顺市</option>" +
							"		<option value=\"丹东市\">丹东市</option>" +
							"		<option value=\"本溪市\">本溪市</option>" +
							"		<option value=\"辽阳市\">辽阳市</option>" +
							"		<option value=\"鞍山市\">鞍山市</option>" +
							"		<option value=\"大连市\">大连市</option>" +
							"		<option value=\"营口市\">营口市</option>" +
							"		<option value=\"盘锦市\">盘锦市</option>" +
							"		<option value=\"锦州市\">锦州市</option>" +
							"		<option value=\"葫芦岛市\">葫芦岛市</option>" +

							"	</select>"
				var nmg_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"呼和浩特市\">呼和浩特市</option>" +
							"		<option value=\"包头市\">包头市</option>" +
							"		<option value=\"乌海市\">乌海市</option>" +
							"		<option value=\"赤峰市\">赤峰市</option>" +
							"		<option value=\"通辽市\">通辽市</option>" +
							"		<option value=\"呼伦贝尔市\">呼伦贝尔市</option>" +
							"		<option value=\"鄂尔多斯市\">鄂尔多斯市</option>" +
							"		<option value=\"乌兰察布市\">乌兰察布市</option>" +
							"		<option value=\"巴彦淖尔市\">巴彦淖尔市</option>" +
							"		<option value=\"兴安盟\">兴安盟</option>" +
							"		<option value=\"阿拉善盟\">阿拉善盟</option>" +
							"		<option value=\"锡林郭勒盟\">锡林郭勒盟</option>" +
							"	</select>"
				var nx_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"银川市\">银川市</option>" +
							"		<option value=\"石嘴山市\">石嘴山市</option>" +
							"		<option value=\"吴忠市\">吴忠市</option>" +
							"		<option value=\"固原市\">固原市</option>" +
							"		<option value=\"中卫市\">中卫市</option>" +
							"	</select>"
				var qh_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"西宁市\">西宁市</option>" +
							"		<option value=\"海东地区\">海东地区</option>" +
							"		<option value=\"海北藏族自治州\">海北藏族自治州</option>" +
							"		<option value=\"黄南藏族自治州\">黄南藏族自治州</option>" +
							"		<option value=\"玉树藏族自治州\">玉树藏族自治州</option>" +
							"		<option value=\"海南藏族自治州\">海南藏族自治州</option>" +
							"		<option value=\"果洛藏族自治州\">果洛藏族自治州</option>" +
							"		<option value=\"海西蒙古族自治州\">海西蒙古族自治州</option>" +
							"	</select>"
				var sc_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"成都市\">成都市</option>" +
							"		<option value=\"广元市\">广元市</option>" +
							"		<option value=\"绵阳市\">绵阳市</option>" +
							"		<option value=\"德阳市\">德阳市</option>" +
							"		<option value=\"南充市\">南充市</option>" +
							"		<option value=\"广安市\">广安市</option>" +
							"		<option value=\"遂宁市\">遂宁市</option>" +
							"		<option value=\"内江市\">内江市</option>" +
							"		<option value=\"乐山市\">乐山市</option>" +
							"		<option value=\"自贡市\">自贡市</option>" +
							"		<option value=\"泸州市\">泸州市</option>" +
							"		<option value=\"宜宾市\">宜宾市</option>" +
							"		<option value=\"攀枝花市\">攀枝花市</option>" +
							"		<option value=\"巴中市\">巴中市</option>" +
							"		<option value=\"资阳市\">资阳市</option>" +
							"		<option value=\"眉山市\">眉山市</option>" +
							"		<option value=\"雅安市\">雅安市</option>" +
							"		<option value=\"阿坝藏族羌族自治州\">阿坝藏族羌族自治州</option>" +
							"		<option value=\"甘孜藏族自治区\">甘孜藏族自治区</option>" +
							"		<option value=\"凉山彝族自治州\">凉山彝族自治州</option>" +
							"	</select>"

				var sd_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"济南市\">济南市</option>" +
							"		<option value=\"聊城市\">聊城市</option>" +
							"		<option value=\"德州市\">德州市</option>" +
							"		<option value=\"东营市\">东营市</option>" +
							"		<option value=\"淄博市\">淄博市</option>" +
							"		<option value=\"潍坊市\">潍坊市</option>" +
							"		<option value=\"烟台市\">烟台市</option>" +
							"		<option value=\"威海市\">威海市</option>" +
							"		<option value=\"青岛市\">青岛市</option>" +
							"		<option value=\"日照市\">日照市</option>" +
							"		<option value=\"临沂市\">临沂市</option>" +
							"		<option value=\"枣庄市\">枣庄市</option>" +
							"		<option value=\"济宁市\">济宁市</option>" +
							"		<option value=\"泰安市\">泰安市</option>" +
							"		<option value=\"莱芜市\">莱芜市</option>" +
							"		<option value=\"滨州市\">滨州市</option>" +
							"		<option value=\"菏泽市\">菏泽市</option>" +
							"	</select>"
				var sh_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"上海市\">上海市</option>" +
							"	</select>"
				var sx_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"西安市\">西安市</option>" +
							"		<option value=\"延安市\">延安市</option>" +
							"		<option value=\"铜川市\">铜川市</option>" +
							"		<option value=\"渭南市\">渭南市</option>" +
							"		<option value=\"咸阳市\">咸阳市</option>" +
							"		<option value=\"宝鸡市\">宝鸡市</option>" +
							"		<option value=\"汉中市\">汉中市</option>" +
							"		<option value=\"榆林市\">榆林市</option>" +
							"		<option value=\"安康市\">安康市</option>" +
							"		<option value=\"商洛市\">商洛市</option>" +
							"	</select>"
				var shx_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"太原市\">太原市</option>" +
							"		<option value=\"朔州市\">朔州市</option>" +
							"		<option value=\"大同市\">大同市</option>" +
							"		<option value=\"阳泉市\">阳泉市</option>" +
							"		<option value=\"长治市\">长治市</option>" +
							"		<option value=\"晋城市\">晋城市</option>" +
							"		<option value=\"忻州市\">忻州市</option>" +
							"		<option value=\"晋中市\">晋中市</option>" +
							"		<option value=\"临汾市\">临汾市</option>" +
							"		<option value=\"吕梁市\">吕梁市</option>" +
							"		<option value=\"运城市\">运城市</option>" +
							"	</select>"
				var tj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"天津市\">天津市</option>" +
							"	</select>"
				var xg_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"香港\">香港</option>" +
							"	</select>"

				var xj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"乌鲁木齐市\">乌鲁木齐市</option>" +
							"		<option value=\"克拉玛依市\">克拉玛依市</option>" +
							"		<option value=\"喀什地区\">喀什地区</option>" +
							"		<option value=\"阿克苏地区\">阿克苏地区</option>" +
							"		<option value=\"和田地区\">和田地区</option>" +
							"		<option value=\"吐鲁番地区\">吐鲁番地区</option>" +
							"		<option value=\"哈密地区\">哈密地区</option>" +
							"		<option value=\"塔城地区\">塔城地区</option>" +
							"		<option value=\"阿勒泰地区\">阿勒泰地区</option>" +
							"		<option value=\"克孜勒苏柯尔克孜自治州\">克孜勒苏柯尔克孜自治州</option>" +
							"		<option value=\"博尔塔拉蒙古自治州\">博尔塔拉蒙古自治州</option>" +
							"		<option value=\"昌吉回族自治州\">昌吉回族自治州</option>" +
							"		<option value=\"伊犁哈萨克自治州\">伊犁哈萨克自治州</option>" +
							"		<option value=\"巴音郭楞蒙古自治州\">巴音郭楞蒙古自治州</option>" +
							"	</select>"
				var xz_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"拉萨市\">拉萨市</option>" +
							"		<option value=\"那曲地区\">那曲地区</option>" +
							"		<option value=\"昌都地区\">昌都地区</option>" +
							"		<option value=\"林芝地区\">林芝地区</option>" +
							"		<option value=\"山南地区\">山南地区</option>" +
							"		<option value=\"日喀则地区\">日喀则地区</option>" +
							"		<option value=\"阿里地区\">阿里地区</option>" +
							"       </select>"
				var yn_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"昆明市\">昆明市</option>" +
							"		<option value=\"曲靖市\">曲靖市</option>" +
							"		<option value=\"玉溪市\">玉溪市</option>" +
							"		<option value=\"保山市\">保山市</option>" +
							"		<option value=\"昭通市\">昭通市</option>" +
							"		<option value=\"丽江市\">丽江市</option>" +
							"		<option value=\"普洱市\">普洱市</option>" +
							"		<option value=\"临沧市\">临沧市</option>" +
							"		<option value=\"德宏傣族景颇族自治州\">德宏傣族景颇自治州</option>" +
							"		<option value=\"怒江傈僳族自治州\">怒江傈僳族自治州</option>" +
							"		<option value=\"楚雄彝族自治州\">楚雄彝族自治州</option>" +
							"		<option value=\"红河哈尼族异族自治州\">红河哈尼族彝族自治州</option>" +
							"		<option value=\"文山壮族苗族自治州\">文山壮族苗族自治州</option>" +
							"		<option value=\"大理白族自治州\">大理白族自治州</option>" +
							"		<option value=\"迪庆藏族自治州\">迪庆藏族自治州</option>" +
							"		<option value=\"西双版纳傣族自治州\">西双版纳傣族自治州</option>" +
							"	</select>"
				var zj_district = 	"	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"杭州市\">杭州市</option>" +
							"		<option value=\"湖州市\">湖州市</option>" +
							"		<option value=\"嘉兴市\">嘉兴市</option>" +
							"		<option value=\"舟山市\">舟山市</option>" +
							"		<option value=\"宁波市\">宁波市</option>" +
							"		<option value=\"绍兴市\">绍兴市</option>" +
							"		<option value=\"衢州市\">衢州市</option>" +
							"		<option value=\"金华市\">金华市</option>" +
							"		<option value=\"台州市\">台州市</option>" +
							"		<option value=\"温州市\">温州市</option>" +
							"		<option value=\"丽水市\">丽水市</option>" +
							"	</select>"
				

				 var none =          "	<select name=\"city\" style=\"width:150\">" +
							"		<option value=\"sh_0\">-----请选择(市)----</option>" +
							"	</select>"
		if(province.value == "安徽"){
			document.getElementById("districtcity").innerHTML = ah_district;
		}else if(province.value == "澳门"){
			document.getElementById("districtcity").innerHTML = am_district;
		}else if(province.value == "北京"){
			document.getElementById("districtcity").innerHTML = bj_district;
		}else if(province.value == "重庆"){
			document.getElementById("districtcity").innerHTML = cq_district;
		}else if(province.value == "福建"){
			document.getElementById("districtcity").innerHTML = fj_district;
		}else if(province.value == "广东"){
			document.getElementById("districtcity").innerHTML = gd_district;
		}else if(province.value == "甘肃"){
			document.getElementById("districtcity").innerHTML = gs_district;
		}else if(province.value == "广西"){
			document.getElementById("districtcity").innerHTML = gx_district;
		}else if(province.value == "贵州"){
			document.getElementById("districtcity").innerHTML = gz_district;
		}else if(province.value == "河南"){
			document.getElementById("districtcity").innerHTML = hn_district;
		}else if(province.value == "湖北"){
			document.getElementById("districtcity").innerHTML = hb_district;
		}else if(province.value == "河北"){
			document.getElementById("districtcity").innerHTML = heb_district;
		}else if(province.value == "海南"){
			document.getElementById("districtcity").innerHTML = hain_district;
		}else if(province.value == "黑龙江"){
			document.getElementById("districtcity").innerHTML = hlj_district;
		}else if(province.value == "湖南"){
			document.getElementById("districtcity").innerHTML = hun_district;
		}else if(province.value == "吉林"){
			document.getElementById("districtcity").innerHTML = jl_district;
		}else if(province.value == "江苏"){
			document.getElementById("districtcity").innerHTML = js_district;
		}else if(province.value == "江西"){
			document.getElementById("districtcity").innerHTML = jx_district;
		}else if(province.value == "辽宁"){
			document.getElementById("districtcity").innerHTML = ln_district;
		}else if(province.value == "内蒙古"){
			document.getElementById("districtcity").innerHTML = nmg_district;
		}else if(province.value == "宁夏"){
			document.getElementById("districtcity").innerHTML = nx_district;
		}else if(province.value == "青海"){
			document.getElementById("districtcity").innerHTML = qh_district;
		}else if(province.value == "四川"){
			document.getElementById("districtcity").innerHTML = sc_district;
		}else if(province.value == "山东"){
			document.getElementById("districtcity").innerHTML = sd_district;
		}else if(province.value == "上海"){
			document.getElementById("districtcity").innerHTML = sh_district;
		}else if(province.value == "陕西"){
			document.getElementById("districtcity").innerHTML = sx_district;
		}else if(province.value == "山西"){
			document.getElementById("districtcity").innerHTML = shx_district;
		}else if(province.value == "天津"){
			document.getElementById("districtcity").innerHTML = tj_district;
		}else if(province.value == "新疆"){
			document.getElementById("districtcity").innerHTML = xj_district;
		}else if(province.value == "西藏"){
			document.getElementById("districtcity").innerHTML = xz_district;
		}else if(province.value == "香港"){
			document.getElementById("districtcity").innerHTML = xg_district;
		}else if(province.value == "云南"){
			document.getElementById("districtcity").innerHTML = yn_district;
		}else if(province.value == "浙江"){
			document.getElementById("districtcity").innerHTML = zj_district;
		}else if(province.value == "0"){
			document.getElementById("districtcity").innerHTML = none;
		}
}
//实现"省-大学"条件选择器
function showProvinceUniversity(province_university){
	var bj_university= "<select name=\"university\" style=\"width:150\">" +
 "		<option value=\"清华大学\">清华大学</option>"+
"		<option value=\"北京大学\">北京大学</option>"+
"		<option value=\"北京航空航天大学\">北京航空航天大学</option>"+
"		<option value=\"中国人民大学\">中国人民大学</option>"+
"		<option value=\"中国政法大学\">中国政法大学</option>"+
"		<option value=\"北京邮电大学\">北京邮电大学</option>"+
"		<option value=\"北京师范大学\">北京师范大学</option>"+
"		<option value=\"北京理工大学\">北京理工大学</option>"+
"		<option value=\"北京外国语大学\">北京外国语大学</option>"+
"		<option value=\"北京交通大学\">北京交通大学</option>"+
"		<option value=\"对外经济贸易大学\">对外经济贸易大学</option>"+
"		<option value=\"北京大学医学部\">北京大学医学部</option>"+
"		<option value=\"北京人民警察学院\">北京人民警察学院</option>"+
"		<option value=\"中央财经大学\">中央财经大学</option>"+
"		<option value=\"中国地质大学\">中国地质大学</option>"+
"		<option value=\"北京科技大学\">北京科技大学</option>"+
"		<option value=\"华北电力大学\">华北电力大学</option>"+
"		<option value=\"中央民族大学\">中央民族大学</option>"+
"		<option value=\"首都师范大学\">首都师范大学</option>"+
"		<option value=\"北京林业大学\">北京林业大学</option>"+
"		<option value=\"中国农业大学\">中国农业大学</option>"+
"		<option value=\"北京语言大学\">北京语言大学</option>"+
"		<option value=\"首都经济贸易大学\">首都经济贸易大学</option>"+
"		<option value=\"中国矿业大学\">中国矿业大学</option>"+
"		<option value=\"北方工业大学\">北方工业大学</option>"+
"		<option value=\"中央广播电视大学\">中央广播电视大学</option>"+
"		<option value=\"中国石油大学\">中国石油大学</option>"+
"		<option value=\"北京化工大学\">北京化工大学</option>"+
"		<option value=\"北京工商大学\">北京工商大学</option>"+
"		<option value=\"北京中医药大学\">北京中医药大学</option>"+
"		<option value=\"中国人民公安大学\">中国人民公安大学</option>"+
"		<option value=\"首都医科大学\">首都医科大学</option>"+
"		<option value=\"北京工业大学\">北京工业大学</option>"+
"		<option value=\"北京联合大学\">北京联合大学</option>"+
"		<option value=\"北京体育大学\">北京体育大学</option>"+
"		<option value=\"北京电子科技职业学院\">北京电子科技职业学院</option>"+
"		<option value=\"中国青年政治学院\">中国青年政治学院</option>"+
"		<option value=\"北京财贸职业学院\">北京财贸职业学院</option>"+
"		<option value=\"外交学院\">外交学院</option>"+
"		<option value=\"北京信息科技大学\">北京信息科技大学</option>"+
"		<option value=\"北京电影学院\">北京电影学院</option>"+
"		<option value=\"中央音乐学院\">中央音乐学院</option>"+
"		<option value=\"中国传媒大学\">中国传媒大学</option>"+
"		<option value=\"中央戏剧学院\">中央戏剧学院</option>"+
"		<option value=\"首钢工学院\">首钢工学院</option>"+
"		<option value=\"北京物资学院\">北京物资学院</option>"+
"		<option value=\"北京印刷学院\">北京印刷学院</option>"+
"		<option value=\"北京石油化工学院\">北京石油化工学院</option>"+
"		<option value=\"北京联合大学应用文理学院\">北京联合大学应用文理学院</option>"+
"		<option value=\"中国防卫科技学院\">中国防卫科技学院</option>"+
"		<option value=\"北京服装学院\">北京服装学院</option>"+
"		<option value=\"中国协和医科大学\">中国协和医科大学</option>"+
"		<option value=\"北京建筑工程学院\">北京建筑工程学院</option>"+
"		<option value=\"北京第二外国语学院\">北京第二外国语学院</option>"+
"		<option value=\"北京农学院\">北京农学院</option>"+
"		<option value=\"北京舞蹈学院\">北京舞蹈学院</option>"+
"		<option value=\"中国音乐学院\">中国音乐学院</option>"+
"		<option value=\"北京青年政治学院\">北京青年政治学院</option>"+
"		<option value=\"国际关系学院\">国际关系学院</option>"+
"		<option value=\"北京联合大学旅游学院\">北京联合大学旅游学院</option>"+
"		<option value=\"防灾科技学院\">防灾科技学院</option>"+
"		<option value=\"中国劳动关系学院\">中国劳动关系学院</option>"+
"		<option value=\"北京电子科技学院\">北京电子科技学院</option>"+
"		<option value=\"中国戏曲学院\">中国戏曲学院</option>"+
"		<option value=\"国家法官学院\">国家法官学院</option>"+
"		<option value=\"首都体育学院\">首都体育学院</option>"+
"		<option value=\"北京工业大学通州分校\">北京工业大学通州分校</option>"+
"		<option value=\"北京城市学院\">北京城市学院</option>"+
"		<option value=\"中国社会科学院研究生院\">中国社会科学院研究生院</option>"+
"		<option value=\"军事医学科学院\">军事医学科学院</option>"+
"		<option value=\"中华女子学院\">中华女子学院</option>"+
"		<option value=\"北京科技职业学院\">北京科技职业学院</option>"+
"		<option value=\"北京-其它\">北京-其它</option>"+
"	</select>"

var tj_university= "	<select name=\"university\" style=\"width:150\">" +
"		<option value=\"天津大学\">天津大学</option>"+
"		<option value=\"南开大学\">南开大学</option>"+
"		<option value=\"天津师范大学\">天津师范大学</option>"+
"		<option value=\"天津工业大学\">天津工业大学</option>"+
"		<option value=\"天津医科大学\">天津医科大学</option>"+
"		<option value=\"天津商业大学\">天津商业大学</option>"+
"		<option value=\"天津外国语学院\">天津外国语学院</option>"+
"		<option value=\"中国民用航空学院\">中国民用航空学院</option>"+
"		<option value=\"天津财经大学\">天津财经大学</option>"+
"		<option value=\"天津理工大学\">天津理工大学</option>"+
"		<option value=\"天津音乐学院\">天津音乐学院</option>"+
"		<option value=\"天津科技大学\">天津科技大学</option>"+
"		<option value=\"天津农学院\">天津农学院</option>"+
"		<option value=\"天津城市建设学院\">天津城市建设学院</option>"+
"		<option value=\"天津广播电视大学\">天津广播电视大学</option>"+
"		<option value=\"天津工程师范学院\">天津工程师范学院</option>"+
"		<option value=\"天津美术学院\">天津美术学院</option>"+
"		<option value=\"天津体育学院\">天津体育学院</option>"+
"		<option value=\"天津中医学院\">天津中医学院</option>"+
"		<option value=\"天津企业管理培训中心\">天津企业管理培训中心</option>"+
"		<option value=\"天津轻工职业技术学院\">天津轻工职业技术学院</option>"+
"		<option value=\"天津商学院宝德职业技术学院\">天津商学院宝德职业技术学院</option>"+
"		<option value=\"天狮职业技术学院\">天狮职业技术学院</option>"+
"		<option value=\"天津职业大学\">天津职业大学</option>"+
"		<option value=\"天津中德职业技术学院\">天津中德职业技术学院</option>"+
"		<option value=\"天津对外贸易职业学院\">天津对外贸易职业学院</option>"+
"		<option value=\"天津-其它\">天津-其它</option>"+
"	</select>"

var heb_university =          "	<select name=\"university\" style=\"width:150\">" +
						"		<option value=\"华北电力大学\">华北电力大学</option>"+
"		<option value=\"河北大学\">河北大学</option>"+
"		<option value=\"河北师范大学\">河北师范大学</option>"+
"		<option value=\"河北经贸大学\">河北经贸大学</option>"+
"		<option value=\"燕山大学\">燕山大学</option>"+
"		<option value=\"河北科技大学\">河北科技大学</option>"+
"		<option value=\"河北工业大学\">河北工业大学</option>"+
"		<option value=\"河北农业大学\">河北农业大学</option>"+
"		<option value=\"河北医科大学\">河北医科大学</option>"+
"		<option value=\"河北广播电视大学\">河北广播电视大学</option>"+
"		<option value=\"河北工程大学\">河北工程大学</option>"+
"		<option value=\"中国人民武装警察部队学院\">中国人民武装警察部队学院</option>"+
"		<option value=\"北华航天工业学院\">北华航天工业学院</option>"+
"		<option value=\"华北煤炭医学院\">华北煤炭医学院</option>"+
"		<option value=\"河北理工大学\">河北理工大学</option>"+
"		<option value=\"河北科技师范学院\">河北科技师范学院</option>"+
"		<option value=\"河北建筑工程学院\">河北建筑工程学院</option>"+
"		<option value=\"承德石油高等专科学校\">承德石油高等专科学校</option>"+
"		<option value=\"河北体育学院\">河北体育学院</option>"+
"		<option value=\"河北政法职业学院\">河北政法职业学院</option>"+
"		<option value=\"河北石油职业技术学院\">河北石油职业技术学院</option>"+
"		<option value=\"石家庄铁道学院\">石家庄铁道学院</option>"+
"		<option value=\"石家庄经济学院\">石家庄经济学院</option>"+
"		<option value=\"石家庄邮电职业技术学院\">石家庄邮电职业技术学院</option>"+
"		<option value=\"石家庄职业技术学院\">石家庄职业技术学院</option>"+
"		<option value=\"石家庄学院\">石家庄学院</option>"+
"		<option value=\"保定学院\">保定学院</option>"+
"		<option value=\"邯郸职业技术学院(原邯郸大学)\">邯郸职业技术学院(原邯郸大学)</option>"+
"		<option value=\"邢台学院\">邢台学院</option>"+
"		<option value=\"承德医学院\">承德医学院</option>"+
"		<option value=\"邢台职业技术学院\">邢台职业技术学院</option>"+
"		<option value=\"东北大学秦皇岛分校\">东北大学秦皇岛分校</option>"+
"		<option value=\"唐山师范学院\">唐山师范学院</option>"+
"		<option value=\"廊坊师范学院\">廊坊师范学院</option>"+
"		<option value=\"保定职业技术学院\">保定职业技术学院</option>"+
"		<option value=\"唐山学院\">唐山学院</option>"+
"		<option value=\"河北北方学院\">河北北方学院</option>"+
"		<option value=\"河北交通职业技术学院\">河北交通职业技术学院</option>"+
"		<option value=\"沧州师范专科学校\">沧州师范专科学校</option>"+
"		<option value=\"衡水学院\">衡水学院</option>"+
"		<option value=\"河北金融学院\">河北金融学院</option>"+
"		<option value=\"石家庄铁路职业技术学院\">石家庄铁路职业技术学院</option>"+
"		<option value=\"邯郸学院\">邯郸学院</option>"+
"		<option value=\"河北工业职业技术学院\">河北工业职业技术学院</option>"+
"		<option value=\"河北工程技术高等专科学校\">河北工程技术高等专科学校</option>"+
"		<option value=\"中央司法警官学院\">中央司法警官学院</option>"+
"		<option value=\"华北电力大学科技学院\">华北电力大学科技学院</option>"+
"		<option value=\"中国地质大学长城学院\">中国地质大学长城学院</option>"+
"		<option value=\"河北机电职业技术学院\">河北机电职业技术学院</option>"+
"		<option value=\"河北软件职业技术学院\">河北软件职业技术学院</option>"+
"		<option value=\"石家庄信息工程学院\">石家庄信息工程学院</option>"+
"		<option value=\"唐山职业技术学院\">唐山职业技术学院</option>"+
"		<option value=\"华北科技学院\">华北科技学院</option>"+
"		<option value=\"防灾科技学院\">防灾科技学院</option>"+
"		<option value=\"北京社会管理职业学院\">北京社会管理职业学院</option>"+
"		<option value=\"河北省工运学校\">河北省工运学校</option>"+
"		<option value=\"渤海石油职业学院\">渤海石油职业学院</option>"+
"		<option value=\"廊坊职业技术学院\">廊坊职业技术学院</option>"+
"		<option value=\"石家庄东方美术学院\">石家庄东方美术学院</option>"+
"		<option value=\"石家庄工商职业学院\">石家庄工商职业学院</option>"+
"		<option value=\"石家庄医学高等专科学校\">石家庄医学高等专科学校</option>"+
"		<option value=\"唐山工业职业技术学院\">唐山工业职业技术学院</option>"+
"		<option value=\"张家口教育学院\">张家口教育学院</option>"+
"		<option value=\"张家口职业技术学院\">张家口职业技术学院</option>"+
"		<option value=\"河北化工医药职业技术学院\">河北化工医药职业技术学院</option>"+
"		<option value=\"河北艺术职业学院\">河北艺术职业学院</option>"+
"		<option value=\"河北女子职业技术学院\">河北女子职业技术学院</option>"+
"		<option value=\"保定电力职业技术学院\">保定电力职业技术学院</option>"+
"		<option value=\"北京化工大学北方学院\">北京化工大学北方学院</option>"+
"		<option value=\"石家庄科技工程职业学院\">石家庄科技工程职业学院</option>"+
"		<option value=\"河北-其它\">河北-其它</option>"+
							"	</select>"
var js_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"东南大学\">东南大学</option>"+
"		<option value=\"南京大学\">南京大学</option>"+
"		<option value=\"南京理工大学\">南京理工大学</option>"+
"		<option value=\"苏州大学\">苏州大学</option>"+
"		<option value=\"河海大学\">河海大学</option>"+
"		<option value=\"南京师范大学\">南京师范大学</option>"+
"		<option value=\"南通大学\">南通大学</option>"+
"		<option value=\"南京工业大学\">南京工业大学</option>"+
"		<option value=\"中国矿业大学\">中国矿业大学</option>"+
"		<option value=\"扬州大学\">扬州大学</option>"+
"		<option value=\"江南大学\">江南大学</option>"+
"		<option value=\"南京财经大学\">南京财经大学</option>"+
"		<option value=\"南京航空航天大学\">南京航空航天大学</option>"+
"		<option value=\"南京林业大学\">南京林业大学</option>"+
"		<option value=\"南京农业大学\">南京农业大学</option>"+
"		<option value=\"南京医科大学\">南京医科大学</option>"+
"		<option value=\"南京中医药大学\">南京中医药大学</option>"+
"		<option value=\"中国药科大学\">中国药科大学</option>"+
"		<option value=\"南京邮电大学\">南京邮电大学</option>"+
"		<option value=\"江苏大学\">江苏大学</option>"+
"		<option value=\"江苏科技大学\">江苏科技大学</option>"+
"		<option value=\"南京审计学院\">南京审计学院</option>"+
"		<option value=\"南京信息工程大学\">南京信息工程大学</option>"+
"		<option value=\"南京工程学院\">南京工程学院</option>"+
"		<option value=\"江苏工业学院\">江苏工业学院</option>"+
"		<option value=\"江苏广播电视大学\">江苏广播电视大学</option>"+
"		<option value=\"南京市广播电视大学\">南京市广播电视大学</option>"+
"		<option value=\"苏州科技学院\">苏州科技学院</option>"+
"		<option value=\"淮海工学院\">淮海工学院</option>"+
"		<option value=\"南京晓庄学院\">南京晓庄学院</option>"+
"		<option value=\"淮阴工学院\">淮阴工学院</option>"+
"		<option value=\"盐城师范学院\">盐城师范学院</option>"+
"		<option value=\"淮阴师范学院\">淮阴师范学院</option>"+
"		<option value=\"江苏技术师范学院\">江苏技术师范学院</option>"+
"		<option value=\"河海大学常州校区\">河海大学常州校区</option>"+
"		<option value=\"徐州医学院\">徐州医学院</option>"+
"		<option value=\"徐州师范大学\">徐州师范大学</option>"+
"		<option value=\"徐州工程学院\">徐州工程学院</option>"+
"		<option value=\"江苏教育学院\">江苏教育学院</option>"+
"		<option value=\"西交利物浦大学\">西交利物浦大学</option>"+
"		<option value=\"南京艺术学院\">南京艺术学院</option>"+
"		<option value=\"常熟理工学院\">常熟理工学院</option>"+
"		<option value=\"南通纺织职业技术学院\">南通纺织职业技术学院</option>"+
"		<option value=\"南京工业职业技术学院\">南京工业职业技术学院</option>"+
"		<option value=\"南通职业大学\">南通职业大学</option>"+
"		<option value=\"南通市广播电视大学\">南通市广播电视大学</option>"+
"		<option value=\"南通航运职业技术学院\">南通航运职业技术学院</option>"+
"		<option value=\"南京师范大学泰州学院\">南京师范大学泰州学院</option>"+
"		<option value=\"徐州建筑职业技术学院\">徐州建筑职业技术学院</option>"+
"		<option value=\"南京化工职业技术学院\">南京化工职业技术学院</option>"+
"		<option value=\"南京理工大学泰州科技学院\">南京理工大学泰州科技学院</option>"+
"		<option value=\"常州轻工职业技术学院\">常州轻工职业技术学院</option>"+
"		<option value=\"常州纺织服装职业技术学院\">常州纺织服装职业技术学院</option>"+
"		<option value=\"泰州职业技术学院\">泰州职业技术学院</option>"+
"		<option value=\"扬州职业大学\">扬州职业大学</option>"+
"		<option value=\"南京铁道职业技术学院\">南京铁道职业技术学院</option>"+
"		<option value=\"宿迁学院\">宿迁学院</option>"+
"		<option value=\"淮安信息职业技术学院\">淮安信息职业技术学院</option>"+
"		<option value=\"江苏畜牧兽医职业技术学院\">江苏畜牧兽医职业技术学院</option>"+
"		<option value=\"中国科学技术大学苏州研究院\">中国科学技术大学苏州研究院</option>"+
"		<option value=\"扬州教育学院\">扬州教育学院</option>"+
"		<option value=\"镇江市高等专科学校\">镇江市高等专科学校</option>"+
"		<option value=\"苏州职业大学\">苏州职业大学</option>"+
"		<option value=\"沙洲工学院\">沙洲工学院</option>"+
"		<option value=\"江苏信息职业技术学院\">江苏信息职业技术学院</option>"+
"		<option value=\"苏州农业职业技术学院\">苏州农业职业技术学院</option>"+
"		<option value=\"苏州工业园区职业技术学院\">苏州工业园区职业技术学院</option>"+
"		<option value=\"无锡职业技术学院\">无锡职业技术学院</option>"+
"		<option value=\"苏州经贸职业技术学院\">苏州经贸职业技术学院</option>"+
"		<option value=\"中国传媒大学南广学院\">中国传媒大学南广学院</option>"+
"		<option value=\"金陵科技学院\">金陵科技学院</option>"+
"		<option value=\"江苏海事职业技术学院\">江苏海事职业技术学院</option>"+
"		<option value=\"南京信息职业技术学院\">南京信息职业技术学院</option>"+
"		<option value=\"南通农业职业技术学院\">南通农业职业技术学院</option>"+
"		<option value=\"南京特殊教育职业技术学院\">南京特殊教育职业技术学院</option>"+
"		<option value=\"三江学院\">三江学院</option>"+
"		<option value=\"炎黄职业技术学院\">炎黄职业技术学院</option>"+
"		<option value=\"明达职业技术学院\">明达职业技术学院</option>"+
"		<option value=\"徐州工业职业技术学院\">徐州工业职业技术学院</option>"+
"		<option value=\"江苏食品职业技术学院\">江苏食品职业技术学院</option>"+
"		<option value=\"应天职业技术学院\">应天职业技术学院</option>"+
"		<option value=\"盐城工学院\">盐城工学院</option>"+
"		<option value=\"常州工学院\">常州工学院</option>"+
"		<option value=\"常州信息职业技术学院\">常州信息职业技术学院</option>"+
"		<option value=\"金肯职业技术学院\">金肯职业技术学院</option>"+
"		<option value=\"硅湖职业技术学院\">硅湖职业技术学院</option>"+
"		<option value=\"南京森林公安高等专科学校\">南京森林公安高等专科学校</option>"+
"		<option value=\"苏州卫生职业技术学院\">苏州卫生职业技术学院</option>"+
"		<option value=\"扬州工业职业技术学院\">扬州工业职业技术学院</option>"+
"		<option value=\"南京交通职业技术学院\">南京交通职业技术学院</option>"+
"		<option value=\"江海职业技术学院\">江海职业技术学院</option>"+
"		<option value=\"扬州环境资源职业技术学院\">扬州环境资源职业技术学院</option>"+
"		<option value=\"钟山职业技术学院\">钟山职业技术学院</option>"+
"		<option value=\"苏州工业职业技术学院\">苏州工业职业技术学院</option>"+
"		<option value=\"盐城卫生职业技术学院\">盐城卫生职业技术学院</option>"+
"		<option value=\"江苏经贸职业技术学院\">江苏经贸职业技术学院</option>"+
"		<option value=\"常州工程职业技术学院\">常州工程职业技术学院</option>"+
"		<option value=\"九州职业技术学院\">九州职业技术学院</option>"+
"		<option value=\"无锡南洋职业技术学院\">无锡南洋职业技术学院</option>"+
"		<option value=\"无锡工艺职业技术学院\">无锡工艺职业技术学院</option>"+
"		<option value=\"江苏-其它\">江苏-其它</option>"+
							"	</select>"
var ah_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"中国科学技术大学\">中国科学技术大学</option>"+
"		<option value=\"安徽大学\">安徽大学</option>"+
"		<option value=\"安徽师范大学\">安徽师范大学</option>"+
"		<option value=\"安徽工业大学\">安徽工业大学</option>"+
"		<option value=\"安徽医科大学\">安徽医科大学</option>"+
"		<option value=\"安徽农业大学\">安徽农业大学</option>"+
"		<option value=\"安徽理工大学(原淮南工业学院)\">安徽理工大学(原淮南工业学院)</option>"+
"		<option value=\"合肥工业大学\">合肥工业大学</option>"+
"		<option value=\"合肥学院\">合肥学院</option>"+
"		<option value=\"安徽财经大学\">安徽财经大学</option>"+
"		<option value=\"安徽中医学院\">安徽中医学院</option>"+
"		<option value=\"安徽科技学院\">安徽科技学院</option>"+
"		<option value=\"解放军电子工程学院\">解放军电子工程学院</option>"+
"		<option value=\"安庆师范学院\">安庆师范学院</option>"+
"		<option value=\"皖西学院\">皖西学院</option>"+
"		<option value=\"皖南医学院\">皖南医学院</option>"+
"		<option value=\"阜阳师范学院\">阜阳师范学院</option>"+
"		<option value=\"淮北煤炭师范学院\">淮北煤炭师范学院</option>"+
"		<option value=\"淮南师范学院\">淮南师范学院</option>"+
"		<option value=\"蚌埠医学院\">蚌埠医学院</option>"+
"		<option value=\"巢湖学院\">巢湖学院</option>"+
"		<option value=\"安徽工程科技学院\">安徽工程科技学院</option>"+
"		<option value=\"滁州学院\">滁州学院</option>"+
"		<option value=\"安徽建筑工业学院\">安徽建筑工业学院</option>"+
"		<option value=\"淮南联合大学\">淮南联合大学</option>"+
"		<option value=\"安徽电子信息职业技术学院\">安徽电子信息职业技术学院</option>"+
"		<option value=\"黄山学院(原徽州师专)\">黄山学院(原徽州师专)</option>"+
"		<option value=\"安徽经济管理学院\">安徽经济管理学院</option>"+
"		<option value=\"池州师范专科学校\">池州师范专科学校</option>"+
"		<option value=\"铜陵学院\">铜陵学院</option>"+
"		<option value=\"芜湖师范专科学校\">芜湖师范专科学校</option>"+
"		<option value=\"宿州学院\">宿州学院</option>"+
"		<option value=\"安徽中医药高等专科学校\">安徽中医药高等专科学校</option>"+
"		<option value=\"六安职业技术学院\">六安职业技术学院</option>"+
"		<option value=\"毫州职业技术学院\">毫州职业技术学院</option>"+
"		<option value=\"蚌埠学院\">蚌埠学院</option>"+
"		<option value=\"安徽艺术职业学院\">安徽艺术职业学院</option>"+
"		<option value=\"安徽医学高等专科学校\">安徽医学高等专科学校</option>"+
"		<option value=\"安徽新华学院\">安徽新华学院</option>"+
"		<option value=\"安徽水利水电职业技术学院\">安徽水利水电职业技术学院</option>"+
"		<option value=\"三联职业技术学院\">三联职业技术学院</option>"+
"		<option value=\"安徽教育学院\">安徽教育学院</option>"+
"		<option value=\"安徽国防科技职业学院\">安徽国防科技职业学院</option>"+
"		<option value=\"安徽-其它\">安徽-其它</option>"+
							"	</select>"
var sh_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"复旦大学\">复旦大学</option>"+
"		<option value=\"上海交通大学\">上海交通大学</option>"+
"		<option value=\"同济大学\">同济大学</option>"+
"		<option value=\"上海海洋大学\">上海海洋大学</option>"+
"		<option value=\"第二军医大学\">第二军医大学</option>"+
"		<option value=\"上海外国语大学\">上海外国语大学</option>"+
"		<option value=\"上海财经大学\">上海财经大学</option>"+
"		<option value=\"东华大学\">东华大学</option>"+
"		<option value=\"华东师范大学\">华东师范大学</option>"+
"		<option value=\"华东理工大学\">华东理工大学</option>"+
"		<option value=\"上海中医药大学\">上海中医药大学</option>"+
"		<option value=\"上海师范大学\">上海师范大学</option>"+
"		<option value=\"上海大学\">上海大学</option>"+
"		<option value=\"上海工程技术大学\">上海工程技术大学</option>"+
"		<option value=\"上海第二医科大学\">上海第二医科大学</option>"+
"		<option value=\"上海第二工业大学\">上海第二工业大学</option>"+
"		<option value=\"上海理工大学\">上海理工大学</option>"+
"		<option value=\"上海电视大学\">上海电视大学</option>"+
"		<option value=\"上海海事大学(上海海运学院)\">上海海事大学(上海海运学院)</option>"+
"		<option value=\"复旦大学医学院(原上海医科大学)\">复旦大学医学院(原上海医科大学)</option>"+
"		<option value=\"上海应用技术学院\">上海应用技术学院</option>"+
"		<option value=\"上海电力学院\">上海电力学院</option>"+
"		<option value=\"上海音乐学院\">上海音乐学院</option>"+
"		<option value=\"上海对外贸易学院\">上海对外贸易学院</option>"+
"		<option value=\"上海纺织高等专科学校\">上海纺织高等专科学校</option>"+
"		<option value=\"华东政法学院\">华东政法学院</option>"+
"		<option value=\"上海商学院\">上海商学院</option>"+
"		<option value=\"上海市经济管理干部学院\">上海市经济管理干部学院</option>"+
"		<option value=\"上海思博职业技术学院\">上海思博职业技术学院</option>"+
"		<option value=\"上海立信会计学院\">上海立信会计学院</option>"+
"		<option value=\"中欧国际工商学院\">中欧国际工商学院</option>"+
"		<option value=\"上海国家会计学院\">上海国家会计学院</option>"+
"		<option value=\"上海体育学院\">上海体育学院</option>"+
"		<option value=\"上海交通职业技术学院\">上海交通职业技术学院</option>"+
"		<option value=\"上海工商外国语学院\">上海工商外国语学院</option>"+
"		<option value=\"上海金融学院\">上海金融学院</option>"+
"		<option value=\"上海医疗器械高等专科学校\">上海医疗器械高等专科学校</option>"+
"		<option value=\"上海政法学院\">上海政法学院</option>"+
"		<option value=\"上海杉达学院\">上海杉达学院</option>"+
"		<option value=\"上海电机学院\">上海电机学院</option>"+
"		<option value=\"上海城市管理职业技术学院\">上海城市管理职业技术学院</option>"+
"		<option value=\"新侨职业技术学院\">新侨职业技术学院</option>"+
"		<option value=\"上海海关高等专科学校\">上海海关高等专科学校</option>"+
"		<option value=\"东海职业技术学院\">东海职业技术学院</option>"+
"		<option value=\"上海公安高等专科学校\">上海公安高等专科学校</option>"+
"		<option value=\"上海建桥学院\">上海建桥学院</option>"+
"		<option value=\"上海电子信息职业技术学院\">上海电子信息职业技术学院</option>"+
"		<option value=\"中国浦东干部学院\">中国浦东干部学院</option>"+
"		<option value=\"上海戏剧学院\">上海戏剧学院</option>"+
"		<option value=\"上海外国语大学贤达经济人文学院\">上海外国语大学贤达经济人文学院</option>"+
"		<option value=\"复旦大学上海视觉艺术学院\">复旦大学上海视觉艺术学院</option>"+
"		<option value=\"上海农林职业技术学院\">上海农林职业技术学院</option>"+
"		<option value=\"上海建峰职业技术学院\">上海建峰职业技术学院</option>"+
"		<option value=\"上海工艺美术职业学院\">上海工艺美术职业学院</option>"+
"		<option value=\"上海师范大学天华学院\">上海师范大学天华学院</option>"+
"		<option value=\"上海工会管理职业学院\">上海工会管理职业学院</option>"+
"		<option value=\"上海-其它\">上海-其它</option>"+
							"	</select>"
var zj_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"浙江大学\">浙江大学</option>"+
"		<option value=\"浙江师范大学\">浙江师范大学</option>"+
"		<option value=\"浙江工业大学\">浙江工业大学</option>"+
"		<option value=\"浙江广播电视大学\">浙江广播电视大学</option>"+
"		<option value=\"宁波大学\">宁波大学</option>"+
"		<option value=\"温州大学\">温州大学</option>"+
"		<option value=\"台州广播电视大学\">台州广播电视大学</option>"+
"		<option value=\"中国计量学院\">中国计量学院</option>"+
"		<option value=\"浙江理工大学(原浙江工程学院)\">浙江理工大学(原浙江工程学院)</option>"+
"		<option value=\"浙江林学院\">浙江林学院</option>"+
"		<option value=\"浙江教育学院\">浙江教育学院</option>"+
"		<option value=\"浙江交通职业技术学院\">浙江交通职业技术学院</option>"+
"		<option value=\"浙江交通职业技术学院\">浙江交通职业技术学院</option>"+
"		<option value=\"浙江科技学院\">浙江科技学院</option>"+
"		<option value=\"浙江财经学院\">浙江财经学院</option>"+
"		<option value=\"杭州电子科技大学\">杭州电子科技大学</option>"+
"		<option value=\"浙江工商大学\">浙江工商大学</option>"+
"		<option value=\"杭州师范大学\">杭州师范大学</option>"+
"		<option value=\"绍兴文理学院\">绍兴文理学院</option>"+
"		<option value=\"嘉兴学院\">嘉兴学院</option>"+
"		<option value=\"台州学院\">台州学院</option>"+
"		<option value=\"浙江机电职业技术学院\">浙江机电职业技术学院</option>"+
"		<option value=\"浙江传媒学院\">浙江传媒学院</option>"+
"		<option value=\"金华职业技术学院\">金华职业技术学院</option>"+
"		<option value=\"浙江海洋学院\">浙江海洋学院</option>"+
"		<option value=\"浙江万里学院\">浙江万里学院</option>"+
"		<option value=\"浙江医药职业技术学院\">浙江医药职业技术学院</option>"+
"		<option value=\"浙江工商职业技术学院\">浙江工商职业技术学院</option>"+
"		<option value=\"浙江旅游职业学院\">浙江旅游职业学院</option>"+
"		<option value=\"浙江中医药大学\">浙江中医药大学</option>"+
"		<option value=\"温州医学院\">温州医学院</option>"+
"		<option value=\"同济大学浙江学院\">同济大学浙江学院</option>"+
"		<option value=\"宁波工程学院\">宁波工程学院</option>"+
"		<option value=\"浙江纺织服装职业技术学院\">浙江纺织服装职业技术学院</option>"+
"		<option value=\"湖州师范学院\">湖州师范学院</option>"+
"		<option value=\"丽水职业技术学院\">丽水职业技术学院</option>"+
"		<option value=\"杭州职业技术学院\">杭州职业技术学院</option>"+
"		<option value=\"中国美术学院\">中国美术学院</option>"+
"		<option value=\"杭州广播电视大学\">杭州广播电视大学</option>"+
"		<option value=\"浙江大学城市学院\">浙江大学城市学院</option>"+
"		<option value=\"浙江经贸职业技术学院\">浙江经贸职业技术学院</option>"+
"		<option value=\"浙江经济职业技术学院\">浙江经济职业技术学院</option>"+
"		<option value=\"温州职业技术学院\">温州职业技术学院</option>"+
"		<option value=\"衢州学院\">衢州学院</option>"+
"		<option value=\"丽水学院\">丽水学院</option>"+
"		<option value=\"浙江商业职业技术学院\">浙江商业职业技术学院</option>"+
"		<option value=\"宁波诺丁汉大学\">宁波诺丁汉大学</option>"+
"		<option value=\"浙江大学宁波理工学院\">浙江大学宁波理工学院</option>"+
"		<option value=\"宁波教育局\">宁波教育局</option>"+
"		<option value=\"宁波大红鹰学院\">宁波大红鹰学院</option>"+
"		<option value=\"台州职业技术学院\">台州职业技术学院</option>"+
"		<option value=\"浙江东方职业技术学院\">浙江东方职业技术学院</option>"+
"		<option value=\"嘉兴职业技术学院\">嘉兴职业技术学院</option>"+
"		<option value=\"浙江金融职业学院\">浙江金融职业学院</option>"+
"		<option value=\"宁波职业技术学院\">宁波职业技术学院</option>"+
"		<option value=\"浙江医学高等专科学校\">浙江医学高等专科学校</option>"+
"		<option value=\"浙江水利水电专科学校\">浙江水利水电专科学校</option>"+
"		<option value=\"浙江树人大学\">浙江树人大学</option>"+
"		<option value=\"浙江警官职业学院\">浙江警官职业学院</option>"+
"		<option value=\"浙江广厦建设职业技术学院\">浙江广厦建设职业技术学院</option>"+
"		<option value=\"温州科技职业技术学院\">温州科技职业技术学院</option>"+
"		<option value=\"浙江艺术职业学院\">浙江艺术职业学院</option>"+
"		<option value=\"宁波职业技术学院\">宁波职业技术学院</option>"+
"		<option value=\"浙江越秀外国语学院\">浙江越秀外国语学院</option>"+
"		<option value=\"上海财经大学浙江学院\">上海财经大学浙江学院</option>"+
"		<option value=\"浙江旅游职业学院\">浙江旅游职业学院</option>"+
"		<option value=\"温州科技职业学院\">温州科技职业学院</option>"+
"		<option value=\"温州职业技术学校\">温州职业技术学校</option>"+
"		<option value=\"浙江-其它\">浙江-其它</option>"+
							"	</select>"
var hb_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"中国地质大学(武汉)\">中国地质大学(武汉)</option>"+
"		<option value=\"华中科技大学\">华中科技大学</option>"+
"		<option value=\"华中农业大学\">华中农业大学</option>"+
"		<option value=\"华中师范大学\">华中师范大学</option>"+
"		<option value=\"湖北大学\">湖北大学</option>"+
"		<option value=\"武汉理工大学\">武汉理工大学</option>"+
"		<option value=\"武汉大学\">武汉大学</option>"+
"		<option value=\"武汉科技大学\">武汉科技大学</option>"+
"		<option value=\"江汉大学\">江汉大学</option>"+
"		<option value=\"三峡大学\">三峡大学</option>"+
"		<option value=\"中南财经政法大学\">中南财经政法大学</option>"+
"		<option value=\"中南民族大学(原中南民族学院)\">中南民族大学(原中南民族学院)</option>"+
"		<option value=\"海军工程大学\">海军工程大学</option>"+
"		<option value=\"华中科技大学同济医学院\">华中科技大学同济医学院</option>"+
"		<option value=\"湖北民族学院\">湖北民族学院</option>"+
"		<option value=\"湖北工业大学\">湖北工业大学</option>"+
"		<option value=\"黄石理工学院\">黄石理工学院</option>"+
"		<option value=\"湖北教育学院\">湖北教育学院</option>"+
"		<option value=\"湖北经济学院\">湖北经济学院</option>"+
"		<option value=\"湖北警官学院(原湖北公安高等专科学校)\">湖北警官学院(原湖北公安高等专科学校)</option>"+
"		<option value=\"湖北交通职业技术学院\">湖北交通职业技术学院</option>"+
"		<option value=\"湖北师范学院\">湖北师范学院</option>"+
"		<option value=\"武汉科技学院\">武汉科技学院</option>"+
"		<option value=\"武汉工程大学(原武汉化工学院)\">武汉工程大学(原武汉化工学院)</option>"+
"		<option value=\"武汉职业技术学院\">武汉职业技术学院</option>"+
"		<option value=\"黄冈师范学院\">黄冈师范学院</option>"+
"		<option value=\"郧阳医学院\">郧阳医学院</option>"+
"		<option value=\"襄樊学院\">襄樊学院</option>"+
"		<option value=\"随州职业技术学院\">随州职业技术学院</option>"+
"		<option value=\"武汉工业学院\">武汉工业学院</option>"+
"		<option value=\"湖北广播电视大学\">湖北广播电视大学</option>"+
"		<option value=\"鄂州职业大学\">鄂州职业大学</option>"+
"		<option value=\"武汉船舶职业技术学院\">武汉船舶职业技术学院</option>"+
"		<option value=\"咸宁学院\">咸宁学院</option>"+
"		<option value=\"湖北经济管理干部学院\">湖北经济管理干部学院</option>"+
"		<option value=\"荆楚理工学院\">荆楚理工学院</option>"+
"		<option value=\"中南财经政法大学武汉学院(学校主页)\">中南财经政法大学武汉学院(学校主页)</option>"+
"		<option value=\"武汉体育学院\">武汉体育学院</option>"+
"		<option value=\"湖北中医学院\">湖北中医学院</option>"+
"		<option value=\"孝感学院\">孝感学院</option>"+
"		<option value=\"长江职业学院(湖北经济管理大学)\">长江职业学院(湖北经济管理大学)</option>"+
"		<option value=\"中南汽车科技大学\">中南汽车科技大学</option>"+
"		<option value=\"襄樊职业技术学院\">襄樊职业技术学院</option>"+
"		<option value=\"华中科技大学武昌分校\">华中科技大学武昌分校</option>"+
"		<option value=\"湖北开放职业学院(湖北函授大学)\">湖北开放职业学院(湖北函授大学)</option>"+
"		<option value=\"长江大学\">长江大学</option>"+
"		<option value=\"恩施职业技术学院\">恩施职业技术学院</option>"+
"		<option value=\"武汉工交职业学院\">武汉工交职业学院</option>"+
"		<option value=\"武汉商业服务学院\">武汉商业服务学院</option>"+
"		<option value=\"武汉工业学院工商学院\">武汉工业学院工商学院</option>"+
"		<option value=\"中南民族大学工商学院\">中南民族大学工商学院</option>"+
"		<option value=\"湖北汽车工业学院\">湖北汽车工业学院</option>"+
"		<option value=\"江汉大学文理学院\">江汉大学文理学院</option>"+
"		<option value=\"湖北美术学院\">湖北美术学院</option>"+
"		<option value=\"华中师范大学汉口分校\">华中师范大学汉口分校</option>"+
"		<option value=\"武汉交通职业学院\">武汉交通职业学院</option>"+
"		<option value=\"湖北城市建设职业技术学院\">湖北城市建设职业技术学院</option>"+
"		<option value=\"湖北生物科技职业学院\">湖北生物科技职业学院</option>"+
"		<option value=\"湖北职业技术学院\">湖北职业技术学院</option>"+
"		<option value=\"武汉铁路职业技术学院\">武汉铁路职业技术学院</option>"+
"		<option value=\"黄冈职业技术学院\">黄冈职业技术学院</option>"+
"		<option value=\"江汉艺术职业学院\">江汉艺术职业学院</option>"+
"		<option value=\"武汉民政职业学院\">武汉民政职业学院</option>"+
"		<option value=\"十堰职业技术学院\">十堰职业技术学院</option>"+
"		<option value=\"武汉科技大学中南分校\">武汉科技大学中南分校</option>"+
"		<option value=\"长江大学工程技术学院\">长江大学工程技术学院</option>"+
"		<option value=\"武汉大学东湖分校\">武汉大学东湖分校</option>"+
"		<option value=\"武汉职业技术学院民院路校区\">武汉职业技术学院民院路校区</option>"+
"		<option value=\"湖北三峡职业技术学院\">湖北三峡职业技术学院</option>"+
"		<option value=\"武汉商贸职业学院\">武汉商贸职业学院</option>"+
"		<option value=\"武汉生物工程学院\">武汉生物工程学院</option>"+
"		<option value=\"武汉信息传播职业技术学院\">武汉信息传播职业技术学院</option>"+
"		<option value=\"武汉音乐学院\">武汉音乐学院</option>"+
"		<option value=\"武汉工业职业技术学院\">武汉工业职业技术学院</option>"+
"		<option value=\"武汉软件职业学院\">武汉软件职业学院</option>"+
"		<option value=\"武汉工程职业技术学院\">武汉工程职业技术学院</option>"+
"		<option value=\"华中师范大学武汉传媒学院\">华中师范大学武汉传媒学院</option>"+
"		<option value=\"湖北水利水电职业技术学院\">湖北水利水电职业技术学院</option>"+
"		<option value=\"武汉电子信息专修学院\">武汉电子信息专修学院</option>"+
"		<option value=\"三峡电力职业学院\">三峡电力职业学院</option>"+
"		<option value=\"武汉工程大学邮电与信息工程学院\">武汉工程大学邮电与信息工程学院</option>"+
"		<option value=\"鄂东职业技术学院\">鄂东职业技术学院</option>"+
"		<option value=\"武汉生物工程学院\">武汉生物工程学院</option>"+
"		<option value=\"荆州职业技术学院\">荆州职业技术学院</option>"+
"		<option value=\"武汉科技大学城市学院\">武汉科技大学城市学院</option>"+
"		<option value=\"中国地质大学江城学院\">中国地质大学江城学院</option>"+
"		<option value=\"湖北-其它\">湖北-其它</option>"+
							"	</select>"
var gd_university =          "	<select name=\"university\" style=\"width:150\">" +
						"		<option value=\"广东工业大学\">广东工业大学</option>"+
"		<option value=\"广东外语外贸大学\">广东外语外贸大学</option>"+
"		<option value=\"广东广播电视大学\">广东广播电视大学</option>"+
"		<option value=\"广州大学\">广州大学</option>"+
"		<option value=\"广州中医药大学\">广州中医药大学</option>"+
"		<option value=\"深圳大学\">深圳大学</option>"+
"		<option value=\"华南理工大学\">华南理工大学</option>"+
"		<option value=\"华南农业大学\">华南农业大学</option>"+
"		<option value=\"华南师范大学\">华南师范大学</option>"+
"		<option value=\"中山大学\">中山大学</option>"+
"		<option value=\"中山医科大学\">中山医科大学</option>"+
"		<option value=\"惠州学院\">惠州学院</option>"+
"		<option value=\"汕头大学\">汕头大学</option>"+
"		<option value=\"广东海洋大学\">广东海洋大学</option>"+
"		<option value=\"暨南大学\">暨南大学</option>"+
"		<option value=\"佛山大学\">佛山大学</option>"+
"		<option value=\"韶关大学\">韶关大学</option>"+
"		<option value=\"南方医科大学\">南方医科大学</option>"+
"		<option value=\"嘉应大学\">嘉应大学</option>"+
"		<option value=\"五邑大学\">五邑大学</option>"+
"		<option value=\"广东商学院\">广东商学院</option>"+
"		<option value=\"广东教育学院\">广东教育学院</option>"+
"		<option value=\"广东轻工职业技术学院\">广东轻工职业技术学院</option>"+
"		<option value=\"茂名学院\">茂名学院</option>"+
"		<option value=\"广东技术师范学院\">广东技术师范学院</option>"+
"		<option value=\"广东医学院\">广东医学院</option>"+
"		<option value=\"广东白云职业技术学院\">广东白云职业技术学院</option>"+
"		<option value=\"广东农工商职业技术学院\">广东农工商职业技术学院</option>"+
"		<option value=\"广东水利电力职业技术学院\">广东水利电力职业技术学院</option>"+
"		<option value=\"广州师范学院\">广州师范学院</option>"+
"		<option value=\"广州航海高等专科学校\">广州航海高等专科学校</option>"+
"		<option value=\"广州医学院\">广州医学院</option>"+
"		<option value=\"深圳职业技术学院\">深圳职业技术学院</option>"+
"		<option value=\"湛江师范学院\">湛江师范学院</option>"+
"		<option value=\"东莞理工学院\">东莞理工学院</option>"+
"		<option value=\"肇庆学院\">肇庆学院</option>"+
"		<option value=\"私立华联学院\">私立华联学院</option>"+
"		<option value=\"番禺职业技术学院\">番禺职业技术学院</option>"+
"		<option value=\"广州市轻工业学校\">广州市轻工业学校</option>"+
"		<option value=\"广东药学院\">广东药学院</option>"+
"		<option value=\"仲恺农业技术学院\">仲恺农业技术学院</option>"+
"		<option value=\"广州美国人国际学校\">广州美国人国际学校</option>"+
"		<option value=\"韩山师范学院\">韩山师范学院</option>"+
"		<option value=\"揭阳职业技术学院\">揭阳职业技术学院</option>"+
"		<option value=\"广州民航职业技术学院\">广州民航职业技术学院</option>"+
"		<option value=\"星海音乐学院\">星海音乐学院</option>"+
"		<option value=\"广州市广播电视大学\">广州市广播电视大学</option>"+
"		<option value=\"广州美术学院\">广州美术学院</option>"+
"		<option value=\"广东外语艺术职业学院\">广东外语艺术职业学院</option>"+
"		<option value=\"广州体育学院\">广州体育学院</option>"+
"		<option value=\"广东金融学院\">广东金融学院</option>"+
"		<option value=\"广东科学技术职业学院\">广东科学技术职业学院</option>"+
"		<option value=\"广东女子职业技术学院\">广东女子职业技术学院</option>"+
"		<option value=\"广东纺织职业技术学院\">广东纺织职业技术学院</option>"+
"		<option value=\"广州体育职业技术学院\">广州体育职业技术学院</option>"+
"		<option value=\"民办南华工商学院\">民办南华工商学院</option>"+
"		<option value=\"广东化工制药职业技术学院\">广东化工制药职业技术学院</option>"+
"		<option value=\"顺德职业技术学院\">顺德职业技术学院</option>"+
"		<option value=\"广州城市职业学院\">广州城市职业学院</option>"+
"		<option value=\"广东工贸职业技术学院\">广东工贸职业技术学院</option>"+
"		<option value=\"中山职业技术学院\">中山职业技术学院</option>"+
"		<option value=\"广州涉外经济职业技术学院\">广州涉外经济职业技术学院</option>"+
"		<option value=\"广东文艺职业学院\">广东文艺职业学院</option>"+
"		<option value=\"广州铁路职业技术学院\">广州铁路职业技术学院</option>"+
"		<option value=\"佛山职业技术学院\">佛山职业技术学院</option>"+
"		<option value=\"广东岭南职业技术学院\">广东岭南职业技术学院</option>"+
"		<option value=\"深圳市奥斯翰外语学校\">深圳市奥斯翰外语学校</option>"+
"		<option value=\"广州大学松田学院\">广州大学松田学院</option>"+
"		<option value=\"广东外语外贸大学南国商学院\">广东外语外贸大学南国商学院</option>"+
"		<option value=\"广东机电职业技术学院\">广东机电职业技术学院</option>"+
"		<option value=\"广东科贸职业学院\">广东科贸职业学院</option>"+
"		<option value=\"华南理工大学广州汽车学院\">华南理工大学广州汽车学院</option>"+
"		<option value=\"河源职业技术学院\">河源职业技术学院</option>"+
"		<option value=\"深圳信息职业技术学院\">深圳信息职业技术学院</option>"+
"		<option value=\"广东商学院华商学院\">广东商学院华商学院</option>"+
"		<option value=\"广东-其它\">广东-其它</option>"+
							"	</select>"

var sc_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"四川大学\">四川大学</option>"+
"		<option value=\"四川师范大学\">四川师范大学</option>"+
"		<option value=\"四川农业大学\">四川农业大学</option>"+
"		<option value=\"成都理工大学\">成都理工大学</option>"+
"		<option value=\"成都中医药大学\">成都中医药大学</option>"+
"		<option value=\"西南交通大学\">西南交通大学</option>"+
"		<option value=\"西南财经大学\">西南财经大学</option>"+
"		<option value=\"西南科技大学\">西南科技大学</option>"+
"		<option value=\"华西医科大学\">华西医科大学</option>"+
"		<option value=\"电子科技大学\">电子科技大学</option>"+
"		<option value=\"攀枝花学院\">攀枝花学院</option>"+
"		<option value=\"中国民航飞行学院\">中国民航飞行学院</option>"+
"		<option value=\"西华大学\">西华大学</option>"+
"		<option value=\"西华师范大学\">西华师范大学</option>"+
"		<option value=\"四川理工学院\">四川理工学院</option>"+
"		<option value=\"四川烹饪高等专科学校\">四川烹饪高等专科学校</option>"+
"		<option value=\"成都电子机械高等专科学校\">成都电子机械高等专科学校</option>"+
"		<option value=\"成都信息工程学院\">成都信息工程学院</option>"+
"		<option value=\"成都纺织高等专科学校\">成都纺织高等专科学校</option>"+
"		<option value=\"西南交通大学峨眉分校\">西南交通大学峨眉分校</option>"+
"		<option value=\"西南民族大学\">西南民族大学</option>"+
"		<option value=\"西南石油大学\">西南石油大学</option>"+
"		<option value=\"乐山师范学院\">乐山师范学院</option>"+
"		<option value=\"绵阳师范学院\">绵阳师范学院</option>"+
"		<option value=\"绵阳经济技术高等专科学校\">绵阳经济技术高等专科学校</option>"+
"		<option value=\"川北医学院\">川北医学院</option>"+
"		<option value=\"自贡师范高等专科学校\">自贡师范高等专科学校</option>"+
"		<option value=\"宜宾学院\">宜宾学院</option>"+
"		<option value=\"内江师范学院\">内江师范学院</option>"+
"		<option value=\"泸州医学院\">泸州医学院</option>"+
"		<option value=\"电子科技大学管理学院\">电子科技大学管理学院</option>"+
"		<option value=\"四川文理学院\">四川文理学院</option>"+
"		<option value=\"康定民族师范高等专科学校\">康定民族师范高等专科学校</option>"+
"		<option value=\"成都大学\">成都大学</option>"+
"		<option value=\"成都航空职业技术学院\">成都航空职业技术学院</option>"+
"		<option value=\"西昌师范高等专科学校\">西昌师范高等专科学校</option>"+
"		<option value=\"四川音乐学院成都美术学院\">四川音乐学院成都美术学院</option>"+
"		<option value=\"绵阳职业技术学院\">绵阳职业技术学院</option>"+
"		<option value=\"电子科技大学MBA教育中心\">电子科技大学MBA教育中心</option>"+
"		<option value=\"四川音乐学院国际演艺学院\">四川音乐学院国际演艺学院</option>"+
"		<option value=\"四川职业技术学院\">四川职业技术学院</option>"+
"		<option value=\"成都体育学院\">成都体育学院</option>"+
"		<option value=\"四川建筑职业技术学院\">四川建筑职业技术学院</option>"+
"		<option value=\"成都天一学院\">成都天一学院</option>"+
"		<option value=\"四川师范大学成都学院\">四川师范大学成都学院</option>"+
"		<option value=\"四川外语学院成都学院\">四川外语学院成都学院</option>"+
"		<option value=\"成都医学院\">成都医学院</option>"+
"		<option value=\"四川教育学院\">四川教育学院</option>"+
"		<option value=\"四川化工职业技术学院\">四川化工职业技术学院</option>"+
"		<option value=\"四川国际标榜职业学院\">四川国际标榜职业学院</option>"+
"		<option value=\"成都职业技术学院\">成都职业技术学院</option>"+
"		<option value=\"四川水利职业技术学院\">四川水利职业技术学院</option>"+
"		<option value=\"四川托普信息职业技术学院\">四川托普信息职业技术学院</option>"+
"		<option value=\"南充职业技术学院\">南充职业技术学院</option>"+
"		<option value=\"四川科技职业学院\">四川科技职业学院</option>"+
"		<option value=\"成都艺术职业学院\">成都艺术职业学院</option>"+
"		<option value=\"四川航天职业技术学院\">四川航天职业技术学院</option>"+
"		<option value=\"四川警察学院\">四川警察学院</option>"+
"		<option value=\"四川中医药高等专科学校\">四川中医药高等专科学校</option>"+
"		<option value=\"西昌学院\">西昌学院</option>"+
"		<option value=\"四川工程职业技术学院\">四川工程职业技术学院</option>"+
"		<option value=\"沪州职业技术学院\">沪州职业技术学院</option>"+
"		<option value=\"四川工商职业技术学院\">四川工商职业技术学院</option>"+
"		<option value=\"四川文化传媒职业学院\">四川文化传媒职业学院</option>"+
"		<option value=\"内江职业技术学院\">内江职业技术学院</option>"+
"		<option value=\"达州职业技术学院\">达州职业技术学院</option>"+
"		<option value=\"四川商务职业学院\">四川商务职业学院</option>"+
"		<option value=\"四川文化产业职业学院\">四川文化产业职业学院</option>"+
"		<option value=\"成都理工大学工程技术学院\">成都理工大学工程技术学院</option>"+
"		<option value=\"四川音乐学院\">四川音乐学院</option>"+
"		<option value=\"宜宾职业技术学院\">宜宾职业技术学院</option>"+
"		<option value=\"泸州职业技术学院\">泸州职业技术学院</option>"+
"		<option value=\"眉山职业技术学院\">眉山职业技术学院</option>"+
"		<option value=\"四川师范大学电影电视学院\">四川师范大学电影电视学院</option>"+
"		<option value=\"四川托普信息技术职业学院\">四川托普信息技术职业学院</option>"+
"		<option value=\"四川邮电职业技术学院\">四川邮电职业技术学院</option>"+
"		<option value=\"雅安职业技术学院\">雅安职业技术学院</option>"+
"		<option value=\"西昌农业高等专科学校\">西昌农业高等专科学校</option>"+
"		<option value=\"成都东软信息技术职业学院\">成都东软信息技术职业学院</option>"+
"		<option value=\"四川师范大学成都分院\">四川师范大学成都分院</option>"+
"		<option value=\"四川广播电视大学\">四川广播电视大学</option>"+
"		<option value=\"成都信息工程学院银杏酒店管理学院\">成都信息工程学院银杏酒店管理学院</option>"+
"		<option value=\"阿坝师范高等专科学校\">阿坝师范高等专科学校</option>"+
"		<option value=\"四川交通职业技术学院\">四川交通职业技术学院</option>"+
"		<option value=\"四川-其它\">四川-其它</option>"+
							"	</select>"
var gz_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"贵州大学\">贵州大学</option>"+
"		<option value=\"贵州师范大学\">贵州师范大学</option>"+
"		<option value=\"贵州财经学院\">贵州财经学院</option>"+
"		<option value=\"贵州民族学院\">贵州民族学院</option>"+
"		<option value=\"贵阳中医学院\">贵阳中医学院</option>"+
"		<option value=\"贵阳医学院\">贵阳医学院</option>"+
"		<option value=\"遵义医学院\">遵义医学院</option>"+
"		<option value=\"铜仁学院\">铜仁学院</option>"+
"		<option value=\"黔南民族师范学院\">黔南民族师范学院</option>"+
"		<option value=\"贵州电子信息职业技术学院\">贵州电子信息职业技术学院</option>"+
"		<option value=\"贵州交通职业技术学院\">贵州交通职业技术学院</option>"+
"		<option value=\"贵州省毕节学院\">贵州省毕节学院</option>"+
"		<option value=\"遵义师范学院\">遵义师范学院</option>"+
"		<option value=\"贵州科技工程职业技术学院\">贵州科技工程职业技术学院</option>"+
"		<option value=\"贵阳学院\">贵阳学院</option>"+
"		<option value=\"安顺学院\">安顺学院</option>"+
"		<option value=\"贵州警官职业学院\">贵州警官职业学院</option>"+
"		<option value=\"六盘水师范高等专科学校\">六盘水师范高等专科学校</option>"+
"		<option value=\"黔南民族医学高等专科学校\">黔南民族医学高等专科学校</option>"+
"		<option value=\"贵州航天职业技术学院\">贵州航天职业技术学院</option>"+
"		<option value=\"黔西南民族职业技术学院\">黔西南民族职业技术学院</option>"+
"		<option value=\"黔东南民族职业技术学院\">黔东南民族职业技术学院</option>"+
"		<option value=\"贵州电力职业技术学院\">贵州电力职业技术学院</option>"+
"		<option value=\"安顺职业技术学院\">安顺职业技术学院</option>"+
"		<option value=\"凯里学院\">凯里学院</option>"+
"		<option value=\"贵州广播电视大学\">贵州广播电视大学</option>"+
"		<option value=\"贵州省委党校\">贵州省委党校</option>"+
"		<option value=\"六盘水职业技术学院\">六盘水职业技术学院</option>"+
"		<option value=\"黔南民族医学院高等专科学校\">黔南民族医学院高等专科学校</option>"+
"		<option value=\"黔西南民族师范高等专科学校\">黔西南民族师范高等专科学校</option>"+
"		<option value=\"贵州-其它\">贵州-其它</option>"+
							"	</select>"
var sx_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"西北大学\">西北大学</option>"+
"		<option value=\"西安交通大学\">西安交通大学</option>"+
"		<option value=\"长安大学\">长安大学</option>"+
"		<option value=\"西安电子科技大学\">西安电子科技大学</option>"+
"		<option value=\"西安理工大学\">西安理工大学</option>"+
"		<option value=\"西安建筑科技大学\">西安建筑科技大学</option>"+
"		<option value=\"西北工业大学\">西北工业大学</option>"+
"		<option value=\"西北农林科技大学\">西北农林科技大学</option>"+
"		<option value=\"陕西师范大学\">陕西师范大学</option>"+
"		<option value=\"第四军医大学\">第四军医大学</option>"+
"		<option value=\"陕西理工学院\">陕西理工学院</option>"+
"		<option value=\"西安科技大学\">西安科技大学</option>"+
"		<option value=\"西安邮电学院\">西安邮电学院</option>"+
"		<option value=\"西安工业大学\">西安工业大学</option>"+
"		<option value=\"西安石油大学\">西安石油大学</option>"+
"		<option value=\"西安工程大学\">西安工程大学</option>"+
"		<option value=\"西北政法大学\">西北政法大学</option>"+
"		<option value=\"宝鸡文理学院\">宝鸡文理学院</option>"+
"		<option value=\"西安财经学院\">西安财经学院</option>"+
"		<option value=\"陕西教育学院\">陕西教育学院</option>"+
"		<option value=\"渭南师范学院\">渭南师范学院</option>"+
"		<option value=\"西安思源学院\">西安思源学院</option>"+
"		<option value=\"空军工程大学\">空军工程大学</option>"+
"		<option value=\"陕西工业职业技术学院\">陕西工业职业技术学院</option>"+
"		<option value=\"延安大学\">延安大学</option>"+
"		<option value=\"杨凌职业技术学院\">杨凌职业技术学院</option>"+
"		<option value=\"陕西中医学院\">陕西中医学院</option>"+
"		<option value=\"咸阳师范学院\">咸阳师范学院</option>"+
"		<option value=\"西安外国语大学\">西安外国语大学</option>"+
"		<option value=\"西安体育学院\">西安体育学院</option>"+
"		<option value=\"西安美术学院\">西安美术学院</option>"+
"		<option value=\"西安音乐学院\">西安音乐学院</option>"+
"		<option value=\"西安文理学院\">西安文理学院</option>"+
"		<option value=\"西安航空技术高等专科学校\">西安航空技术高等专科学校</option>"+
"		<option value=\"西安电力高等专科学校\">西安电力高等专科学校</option>"+
"		<option value=\"西安医学院\">西安医学院</option>"+
"		<option value=\"安康学院\">安康学院</option>"+
"		<option value=\"商洛学院\">商洛学院</option>"+
"		<option value=\"陕西服装艺术职业学院\">陕西服装艺术职业学院</option>"+
"		<option value=\"陕西职业技术学院\">陕西职业技术学院</option>"+
"		<option value=\"陕西交通职业技术学院\">陕西交通职业技术学院</option>"+
"		<option value=\"陕西财经职业技术学院\">陕西财经职业技术学院</option>"+
"		<option value=\"陕西航空职业技术学院\">陕西航空职业技术学院</option>"+
"		<option value=\"陕西能源职业技术学院\">陕西能源职业技术学院</option>"+
"		<option value=\"陕西科技大学\">陕西科技大学</option>"+
"		<option value=\"西安培华学院\">西安培华学院</option>"+
"		<option value=\"西安外事学院\">西安外事学院</option>"+
"		<option value=\"西安翻译学院\">西安翻译学院</option>"+
"		<option value=\"西京学院\">西京学院</option>"+
"		<option value=\"西安海棠职业学院\">西安海棠职业学院</option>"+
"		<option value=\"西安通信学院\">西安通信学院</option>"+
"		<option value=\"西藏民族学院\">西藏民族学院</option>"+
"		<option value=\"西安欧亚学院\">西安欧亚学院</option>"+
"		<option value=\"延安大学西安创新学院\">延安大学西安创新学院</option>"+
"		<option value=\"西安航空职工大学\">西安航空职工大学</option>"+
"		<option value=\"铜川职业技术学院\">铜川职业技术学院</option>"+
"		<option value=\"陕西服装艺术学院\">陕西服装艺术学院</option>"+
"		<option value=\"商洛职业技术学院\">商洛职业技术学院</option>"+
"		<option value=\"西安交通大学城市学院\">西安交通大学城市学院</option>"+
"		<option value=\"榆林学院\">榆林学院</option>"+
"		<option value=\"陕西国际商贸职业学院\">陕西国际商贸职业学院</option>"+
"		<option value=\"西安航空职业技术学院\">西安航空职业技术学院</option>"+
"		<option value=\"陕西铁路工程职业技术学院\">陕西铁路工程职业技术学院</option>"+
"		<option value=\"陕西国防工业职业技术学院\">陕西国防工业职业技术学院</option>"+
"		<option value=\"陕西电子信息职业技术学院\">陕西电子信息职业技术学院</option>"+
"		<option value=\"宝鸡职业技术学院\">宝鸡职业技术学院</option>"+
"		<option value=\"西安科技商贸职业学院\">西安科技商贸职业学院</option>"+
"		<option value=\"西安高新科技职业学院\">西安高新科技职业学院</option>"+
"		<option value=\"陕西警官职业学院\">陕西警官职业学院</option>"+
"		<option value=\"西安汽车科技职业学院\">西安汽车科技职业学院</option>"+
"		<option value=\"西安三资职业学院\">西安三资职业学院</option>"+
"		<option value=\"陕西邮电职业技术学院\">陕西邮电职业技术学院</option>"+
"		<option value=\"渭南职业技术学院\">渭南职业技术学院</option>"+
"		<option value=\"陕西-其它\">陕西-其它</option>"+
							"	</select>"
var  nx_university =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"宁夏大学\">宁夏大学</option>"+
"		<option value=\"宁夏医学院\">宁夏医学院</option>"+
"		<option value=\"北方民族大学\">北方民族大学</option>"+
"		<option value=\"宁夏广播电视大学\">宁夏广播电视大学</option>"+
"		<option value=\"宁夏财经职业技术学院\">宁夏财经职业技术学院</option>"+
"		<option value=\"宁夏电力科技教育工程院\">宁夏电力科技教育工程院</option>"+
"		<option value=\"宁夏人民警察学校\">宁夏人民警察学校</option>"+
"		<option value=\"宁夏建设职业技术学院\">宁夏建设职业技术学院</option>"+
"		<option value=\"银川科技职业学院(银川大学)\">银川科技职业学院(银川大学)</option>"+
"		<option value=\"宁夏工商职业技术学院\">宁夏工商职业技术学院</option>"+
"		<option value=\"宁夏-其它\">宁夏-其它</option>"+
							"	</select>"
var xg_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"香港大学\">香港大学</option>"+
"		<option value=\"香港中文大学\">香港中文大学</option>"+
"		<option value=\"香港理工大学\">香港理工大学</option>"+
"		<option value=\"香港科技大学\">香港科技大学</option>"+
"		<option value=\"香港城市大学\">香港城市大学</option>"+
"		<option value=\"香港浸会大学\">香港浸会大学</option>"+
"		<option value=\"岭南大学\">岭南大学</option>"+
"		<option value=\"香港经贸管理学院\">香港经贸管理学院</option>"+
"		<option value=\"美国犹他州立大学香港分校\">美国犹他州立大学香港分校</option>"+
"		<option value=\"伯克莱大学香港分校\">伯克莱大学香港分校</option>"+
"		<option value=\"香港艺术中心艺术学院\">香港艺术中心艺术学院</option>"+
"		<option value=\"香港树仁学院\">香港树仁学院</option>"+
"		<option value=\"对外经济贸易管理学院\">对外经济贸易管理学院</option>"+
"		<option value=\"香港教育学院\">香港教育学院</option>"+
"		<option value=\"珠海书院\">珠海书院</option>"+
"		<option value=\"中国文理学院\">中国文理学院</option>"+
"		<option value=\"香港-其它\">香港-其它</option>"+
							"	</select>"
var ln_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"中国医科大学\">中国医科大学</option>"+
"		<option value=\"东北大学\">东北大学</option>"+
"		<option value=\"渤海大学\">渤海大学</option>"+
"		<option value=\"大连工业大学(原大连轻工业学院)\">大连工业大学(原大连轻工业学院)</option>"+
"		<option value=\"辽宁石油化工大学\">辽宁石油化工大学</option>"+
"		<option value=\"东北财经大学\">东北财经大学</option>"+
"		<option value=\"辽宁大学\">辽宁大学</option>"+
"		<option value=\"辽宁师范大学\">辽宁师范大学</option>"+
"		<option value=\"辽宁工程技术大学\">辽宁工程技术大学</option>"+
"		<option value=\"沈阳大学\">沈阳大学</option>"+
"		<option value=\"沈阳农业大学\">沈阳农业大学</option>"+
"		<option value=\"沈阳工业大学\">沈阳工业大学</option>"+
"		<option value=\"沈阳药科大学\">沈阳药科大学</option>"+
"		<option value=\"大连理工大学\">大连理工大学</option>"+
"		<option value=\"大连医科大学\">大连医科大学</option>"+
"		<option value=\"大连海事大学\">大连海事大学</option>"+
"		<option value=\"大连大学\">大连大学</option>"+
"		<option value=\"中国刑事警察学院\">中国刑事警察学院</option>"+
"		<option value=\"大连水产学院\">大连水产学院</option>"+
"		<option value=\"辽宁工学院\">辽宁工学院</option>"+
"		<option value=\"辽宁省交通高等专科学校\">辽宁省交通高等专科学校</option>"+
"		<option value=\"沈阳理工大学\">沈阳理工大学</option>"+
"		<option value=\"沈阳航空工业学院\">沈阳航空工业学院</option>"+
"		<option value=\"沈阳建筑大学\">沈阳建筑大学</option>"+
"		<option value=\"沈阳师范大学\">沈阳师范大学</option>"+
"		<option value=\"大连外国语学院\">大连外国语学院</option>"+
"		<option value=\"大连交通大学\">大连交通大学</option>"+
"		<option value=\"沈阳化工学院\">沈阳化工学院</option>"+
"		<option value=\"大连职业技术学院\">大连职业技术学院</option>"+
"		<option value=\"辽宁科技学院\">辽宁科技学院</option>"+
"		<option value=\"沈阳体育学院\">沈阳体育学院</option>"+
"		<option value=\"鲁迅美术学院\">鲁迅美术学院</option>"+
"		<option value=\"大连民族学院\">大连民族学院</option>"+
"		<option value=\"鞍山师范学院\">鞍山师范学院</option>"+
"		<option value=\"辽宁科技大学\">辽宁科技大学</option>"+
"		<option value=\"辽宁医学院\">辽宁医学院</option>"+
"		<option value=\"大连广播电视大学\">大连广播电视大学</option>"+
"		<option value=\"大连商务职业技术学院\">大连商务职业技术学院</option>"+
"		<option value=\"大连交通大学软件学院\">大连交通大学软件学院</option>"+
"		<option value=\"辽宁对外经贸学院\">辽宁对外经贸学院</option>"+
"		<option value=\"沈阳医学院\">沈阳医学院</option>"+
"		<option value=\"辽宁中医药大学(原辽宁中医学院)\">辽宁中医药大学(原辽宁中医学院)</option>"+
"		<option value=\"大连东软信息技术职业学院\">大连东软信息技术职业学院</option>"+
"		<option value=\"沈阳工程学院\">沈阳工程学院</option>"+
"		<option value=\"辽宁朝鲜族师范学校\">辽宁朝鲜族师范学校</option>"+
"		<option value=\"东北大学东软信息学院\">东北大学东软信息学院</option>"+
"		<option value=\"辽东学院\">辽东学院</option>"+
"		<option value=\"大连交通大学信息工程学院\">大连交通大学信息工程学院</option>"+
"		<option value=\"渤海大学文理学院\">渤海大学文理学院</option>"+
"		<option value=\"沈阳职业技术学院\">沈阳职业技术学院</option>"+
"		<option value=\"辽宁金融职业学院\">辽宁金融职业学院</option>"+
"		<option value=\"辽宁广告职业学院\">辽宁广告职业学院</option>"+
"		<option value=\"大连艺术职业学院\">大连艺术职业学院</option>"+
"		<option value=\"东北大学大连艺术学院\">东北大学大连艺术学院</option>"+
"		<option value=\"渤海船舶职业学院\">渤海船舶职业学院</option>"+
"		<option value=\"朝阳师范高等专科学校\">朝阳师范高等专科学校</option>"+
"		<option value=\"大连软件职业学院\">大连软件职业学院</option>"+
"		<option value=\"辽宁商贸职业学院\">辽宁商贸职业学院</option>"+
"		<option value=\"辽宁工业大学\">辽宁工业大学</option>"+
"		<option value=\"辽宁-其它\">辽宁-其它</option>"+
							"	</select>"
var cq_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"重庆大学\">重庆大学</option>"+
"		<option value=\"四川外语学院\">四川外语学院</option>"+
"		<option value=\"重庆医科大学\">重庆医科大学</option>"+
"		<option value=\"重庆工商大学\">重庆工商大学</option>"+
"		<option value=\"重庆邮电大学\">重庆邮电大学</option>"+
"		<option value=\"西南政法大学\">西南政法大学</option>"+
"		<option value=\"西南师范大学\">西南师范大学</option>"+
"		<option value=\"西南农业大学\">西南农业大学</option>"+
"		<option value=\"第三军医大学\">第三军医大学</option>"+
"		<option value=\"重庆交通大学\">重庆交通大学</option>"+
"		<option value=\"重庆师范大学\">重庆师范大学</option>"+
"		<option value=\"重庆三峡学院\">重庆三峡学院</option>"+
"		<option value=\"四川美术学院\">四川美术学院</option>"+
"		<option value=\"长江师范学院\">长江师范学院</option>"+
"		<option value=\"重庆工学院\">重庆工学院</option>"+
"		<option value=\"重庆科技学院\">重庆科技学院</option>"+
"		<option value=\"重庆文理学院\">重庆文理学院</option>"+
"		<option value=\"重庆工程职业技术学院\">重庆工程职业技术学院</option>"+
"		<option value=\"重庆工贸职业技术学院\">重庆工贸职业技术学院</option>"+
"		<option value=\"重庆电力高等专科学校\">重庆电力高等专科学校</option>"+
"		<option value=\"西南师范大学育才学院\">西南师范大学育才学院</option>"+
"		<option value=\"重庆师范大学涉外商贸学院\">重庆师范大学涉外商贸学院</option>"+
"		<option value=\"重庆城市管理职业学院\">重庆城市管理职业学院</option>"+
"		<option value=\"四川外语学院南方翻译学院\">四川外语学院南方翻译学院</option>"+
"		<option value=\"重庆教育学院\">重庆教育学院</option>"+
"		<option value=\"重庆职业技术学院\">重庆职业技术学院</option>"+
"		<option value=\"重庆邮电学院高职二分院\">重庆邮电学院高职二分院</option>"+
"		<option value=\"重庆海联学院\">重庆海联学院</option>"+
"		<option value=\"四川-其它\">四川-其它</option>"+
							"	</select>"
var shx_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"山西大学\">山西大学</option>"+
"		<option value=\"太原理工大学\">太原理工大学</option>"+
"		<option value=\"山西大同大学\">山西大同大学</option>"+
"		<option value=\"山西医科大学\">山西医科大学</option>"+
"		<option value=\"山西师范大学\">山西师范大学</option>"+
"		<option value=\"山西财经大学\">山西财经大学</option>"+
"		<option value=\"山西农业大学\">山西农业大学</option>"+
"		<option value=\"太原广播电视大学\">太原广播电视大学</option>"+
"		<option value=\"山西广播电视大学\">山西广播电视大学</option>"+
"		<option value=\"中北大学\">中北大学</option>"+
"		<option value=\"太原工业学院\">太原工业学院</option>"+
"		<option value=\"山西忻州师范学院\">山西忻州师范学院</option>"+
"		<option value=\"山西长治医学院\">山西长治医学院</option>"+
"		<option value=\"运城学院\">运城学院</option>"+
"		<option value=\"山西大学商务学院\">山西大学商务学院</option>"+
"		<option value=\"山西大学工程学院\">山西大学工程学院</option>"+
"		<option value=\"山西医科大学汾阳学院\">山西医科大学汾阳学院</option>"+
"		<option value=\"太原科技大学\">太原科技大学</option>"+
"		<option value=\"吕梁高专\">吕梁高专</option>"+
"		<option value=\"长治学院\">长治学院</option>"+
"		<option value=\"山西省财政税务专科学校\">山西省财政税务专科学校</option>"+
"		<option value=\"山西交通职业技术学院\">山西交通职业技术学院</option>"+
"		<option value=\"山西中医学院\">山西中医学院</option>"+
"		<option value=\"晋中学院\">晋中学院</option>"+
"		<option value=\"太原理工大学阳泉学院\">太原理工大学阳泉学院</option>"+
"		<option value=\"晋城职业技术学院\">晋城职业技术学院</option>"+
"		<option value=\"山西工程职业技术学院\">山西工程职业技术学院</option>"+
"		<option value=\"长治市教育学院\">长治市教育学院</option>"+
"		<option value=\"广播电影电视管理干部学院\">广播电影电视管理干部学院</option>"+
"		<option value=\"吕梁教育学院\">吕梁教育学院</option>"+
"		<option value=\"山西财贸职业技术学院\">山西财贸职业技术学院</option>"+
"		<option value=\"山西电力职业技术学院\">山西电力职业技术学院</option>"+
"		<option value=\"山西工程职业技术学院\">山西工程职业技术学院</option>"+
"		<option value=\"山西工商职业学院\">山西工商职业学院</option>"+
"		<option value=\"山西机电职业技术学院\">山西机电职业技术学院</option>"+
"		<option value=\"山西建筑职业技术学院\">山西建筑职业技术学院</option>"+
"		<option value=\"山西经济管理干部学院\">山西经济管理干部学院</option>"+
"		<option value=\"山西林业职业技术学院\">山西林业职业技术学院</option>"+
"		<option value=\"山西旅游职业学院\">山西旅游职业学院</option>"+
"		<option value=\"山西煤炭职业技术学院\">山西煤炭职业技术学院</option>"+
"		<option value=\"山西水利职业技术学院\">山西水利职业技术学院</option>"+
"		<option value=\"山西同文外国语学校\">山西同文外国语学校</option>"+
"		<option value=\"山西运城农业职业技术学院\">山西运城农业职业技术学院</option>"+
"		<option value=\"山西政法管理干部学院\">山西政法管理干部学院</option>"+
"		<option value=\"山西职工医学院\">山西职工医学院</option>"+
"		<option value=\"山西综合职业技术学院\">山西综合职业技术学院</option>"+
"		<option value=\"太原大学\">太原大学</option>"+
"		<option value=\"太原师范学院\">太原师范学院</option>"+
"		<option value=\"山西生物应用职业技术学院\">山西生物应用职业技术学院</option>"+
"		<option value=\"山西-其它\">山西-其它</option>"+
							"	</select>"
var nmg_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"内蒙古大学\">内蒙古大学</option>"+
"		<option value=\"内蒙古师范大学\">内蒙古师范大学</option>"+
"		<option value=\"内蒙古工业大学\">内蒙古工业大学</option>"+
"		<option value=\"内蒙古科技大学(原包头钢铁学院)\">内蒙古科技大学(原包头钢铁学院)</option>"+
"		<option value=\"内蒙古农业大学\">内蒙古农业大学</option>"+
"		<option value=\"内蒙古民族大学\">内蒙古民族大学</option>"+
"		<option value=\"内蒙古财经学院\">内蒙古财经学院</option>"+
"		<option value=\"内蒙古医学院\">内蒙古医学院</option>"+
"		<option value=\"内蒙古电力学院(内蒙工大电力学院)\">内蒙古电力学院(内蒙工大电力学院)</option>"+
"		<option value=\"包头师范学院\">包头师范学院</option>"+
"		<option value=\"包头职业技术学院\">包头职业技术学院</option>"+
"		<option value=\"包头医学院\">包头医学院</option>"+
"		<option value=\"包头市职工大学\">包头市职工大学</option>"+
"		<option value=\"包头铁道学院\">包头铁道学院</option>"+
"		<option value=\"呼伦贝尔学院\">呼伦贝尔学院</option>"+
"		<option value=\"内蒙古广播电视大学\">内蒙古广播电视大学</option>"+
"		<option value=\"包头钢铁职业技术学院\">包头钢铁职业技术学院</option>"+
"		<option value=\"内蒙古建筑职业技术学院\">内蒙古建筑职业技术学院</option>"+
"		<option value=\"赤峰学院\">赤峰学院</option>"+
"		<option value=\"河套大学\">河套大学</option>"+
"		<option value=\"内蒙古科技职业学院\">内蒙古科技职业学院</option>"+
"		<option value=\"乌海职业技术学院\">乌海职业技术学院</option>"+
"		<option value=\"内蒙古-其它\">内蒙古-其它</option>"+
							"	</select>"
var sd_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"山东大学\">山东大学</option>"+
"		<option value=\"山东科技大学\">山东科技大学</option>"+
"		<option value=\"山东师范大学\">山东师范大学</option>"+
"		<option value=\"山东理工大学\">山东理工大学</option>"+
"		<option value=\"山东农业大学\">山东农业大学</option>"+
"		<option value=\"山东中医药大学\">山东中医药大学</option>"+
"		<option value=\"济南大学\">济南大学</option>"+
"		<option value=\"青岛大学\">青岛大学</option>"+
"		<option value=\"中国海洋大学\">中国海洋大学</option>"+
"		<option value=\"烟台大学\">烟台大学</option>"+
"		<option value=\"烟台职业学院\">烟台职业学院</option>"+
"		<option value=\"曲阜师范大学\">曲阜师范大学</option>"+
"		<option value=\"中国石油大学(华东)\">中国石油大学(华东)</option>"+
"		<option value=\"山东工商学院\">山东工商学院</option>"+
"		<option value=\"青岛农业大学\">青岛农业大学</option>"+
"		<option value=\"山东建筑大学\">山东建筑大学</option>"+
"		<option value=\"山东轻工业学院\">山东轻工业学院</option>"+
"		<option value=\"山东财政学院\">山东财政学院</option>"+
"		<option value=\"山东经济学院\">山东经济学院</option>"+
"		<option value=\"山东教育学院\">山东教育学院</option>"+
"		<option value=\"山东大学威海分校\">山东大学威海分校</option>"+
"		<option value=\"山东艺术学院\">山东艺术学院</option>"+
"		<option value=\"山东工艺美术学院\">山东工艺美术学院</option>"+
"		<option value=\"青岛理工大学\">青岛理工大学</option>"+
"		<option value=\"青岛科技大学\">青岛科技大学</option>"+
"		<option value=\"鲁东大学\">鲁东大学</option>"+
"		<option value=\"临沂师范学院\">临沂师范学院</option>"+
"		<option value=\"泰山医学院\">泰山医学院</option>"+
"		<option value=\"聊城大学\">聊城大学</option>"+
"		<option value=\"山东体育学院\">山东体育学院</option>"+
"		<option value=\"滨州学院\">滨州学院</option>"+
"		<option value=\"潍坊学院\">潍坊学院</option>"+
"		<option value=\"山东交通学院\">山东交通学院</option>"+
"		<option value=\"德州学院\">德州学院</option>"+
"		<option value=\"泰山学院\">泰山学院</option>"+
"		<option value=\"滨州医学院\">滨州医学院</option>"+
"		<option value=\"济宁医学院\">济宁医学院</option>"+
"		<option value=\"中华女子学院山东分院\">中华女子学院山东分院</option>"+
"		<option value=\"山东省农业管理干部学院\">山东省农业管理干部学院</option>"+
"		<option value=\"山东广播电视大学\">山东广播电视大学</option>"+
"		<option value=\"山东南山职业技术学院\">山东南山职业技术学院</option>"+
"		<option value=\"济宁学院\">济宁学院</option>"+
"		<option value=\"潍坊医学院\">潍坊医学院</option>"+
"		<option value=\"枣庄学院\">枣庄学院</option>"+
"		<option value=\"山东警察学院\">山东警察学院</option>"+
"		<option value=\"青岛职业技术学院\">青岛职业技术学院</option>"+
"		<option value=\"山东省青年管理干部学院\">山东省青年管理干部学院</option>"+
"		<option value=\"威海职业技术学院\">威海职业技术学院</option>"+
"		<option value=\"山东协和职业技术学院\">山东协和职业技术学院</option>"+
"		<option value=\"哈尔滨工业大学(威海)\">哈尔滨工业大学(威海)</option>"+
"		<option value=\"青岛远洋船员学院\">青岛远洋船员学院</option>"+
"		<option value=\"山东水利职业学院\">山东水利职业学院</option>"+
"		<option value=\"山东外事翻译职业学院\">山东外事翻译职业学院</option>"+
"		<option value=\"山东省工会管理干部学院\">山东省工会管理干部学院</option>"+
"		<option value=\"山东交通职业学院\">山东交通职业学院</option>"+
"		<option value=\"山东华宇职业技术学院\">山东华宇职业技术学院</option>"+
"		<option value=\"山东菏泽学院\">山东菏泽学院</option>"+
"		<option value=\"山东电力高等专科学校\">山东电力高等专科学校</option>"+
"		<option value=\"山东德州科技职业学院\">山东德州科技职业学院</option>"+
"		<option value=\"青岛求实职业技术学院\">青岛求实职业技术学院</option>"+
"		<option value=\"青岛酒店管理职业技术学院\">青岛酒店管理职业技术学院</option>"+
"		<option value=\"青岛黄海职业学院\">青岛黄海职业学院</option>"+
"		<option value=\"青岛恒星职业技术学院\">青岛恒星职业技术学院</option>"+
"		<option value=\"青岛飞洋职业技术学院\">青岛飞洋职业技术学院</option>"+
"		<option value=\"济南职业学院\">济南职业学院</option>"+
"		<option value=\"济南铁道职业技术学院\">济南铁道职业技术学院</option>"+
"		<option value=\"山东政法学院\">山东政法学院</option>"+
"		<option value=\"聊城职业技术学院\">聊城职业技术学院</option>"+
"		<option value=\"山东医学高等专科学校\">山东医学高等专科学校</option>"+
"		<option value=\"山东中医药高等专科学校\">山东中医药高等专科学校</option>"+
"		<option value=\"山东科技职业学院\">山东科技职业学院</option>"+
"		<option value=\"济南工程职业技术学院\">济南工程职业技术学院</option>"+
"		<option value=\"中国农业大学(烟台)\">中国农业大学(烟台)</option>"+
"		<option value=\"山东商务职业学院\">山东商务职业学院</option>"+
"		<option value=\"青岛港湾职业技术学院\">青岛港湾职业技术学院</option>"+
"		<option value=\"山东省教育招生考试院\">山东省教育招生考试院</option>"+
"		<option value=\"山东财政学院东方学院\">山东财政学院东方学院</option>"+
"		<option value=\"海军航空工程学院\">海军航空工程学院</option>"+
"		<option value=\"青岛滨海学院\">青岛滨海学院</option>"+
"		<option value=\"山东药品食品职业学院\">山东药品食品职业学院</option>"+
"		<option value=\"淄博职业学院\">淄博职业学院</option>"+
"		<option value=\"中国海洋大学青岛学院\">中国海洋大学青岛学院</option>"+
"		<option value=\"山东外贸职业学院\">山东外贸职业学院</option>"+
"		<option value=\"淄博师范高等专科学校\">淄博师范高等专科学校</option>"+
"		<option value=\"山东菏泽医学专科学校\">山东菏泽医学专科学校</option>"+
"		<option value=\"山东-其它\">山东-其它</option>"+
							"	</select>"
var jx_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"南昌大学\">南昌大学</option>"+
"		<option value=\"江西财经大学\">江西财经大学</option>"+
"		<option value=\"江西农业大学\">江西农业大学</option>"+
"		<option value=\"东华理工大学\">东华理工大学</option>"+
"		<option value=\"江西师范大学\">江西师范大学</option>"+
"		<option value=\"华东交通大学\">华东交通大学</option>"+
"		<option value=\"南昌大学医学院\">南昌大学医学院</option>"+
"		<option value=\"江西教育学院\">江西教育学院</option>"+
"		<option value=\"江西科技师范学院(南昌职业技术师范学院)\">江西科技师范学院(南昌职业技术师范学院)</option>"+
"		<option value=\"九江学院(原九江师专、财高专、医专及教育学院合并)\">九江学院(原九江师专、财高专、医专及教育学院合并)</option>"+
"		<option value=\"井冈山大学\">井冈山大学</option>"+
"		<option value=\"南昌工程学院(原南昌水利水电高等专科学校)\">南昌工程学院(原南昌水利水电高等专科学校)</option>"+
"		<option value=\"赣南师范学院\">赣南师范学院</option>"+
"		<option value=\"江西工业职业技术学院工业贸易分院\">江西工业职业技术学院工业贸易分院</option>"+
"		<option value=\"南昌高等专科学校\">南昌高等专科学校</option>"+
"		<option value=\"南昌航空大学\">南昌航空大学</option>"+
"		<option value=\"景德镇陶瓷学院\">景德镇陶瓷学院</option>"+
"		<option value=\"上饶师范学院\">上饶师范学院</option>"+
"		<option value=\"赣南医学院\">赣南医学院</option>"+
"		<option value=\"萍乡高等专科学校\">萍乡高等专科学校</option>"+
"		<option value=\"江西广播电视大学\">江西广播电视大学</option>"+
"		<option value=\"蓝天职业技术学院\">蓝天职业技术学院</option>"+
"		<option value=\"江西理工大学\">江西理工大学</option>"+
"		<option value=\"宜春学院\">宜春学院</option>"+
"		<option value=\"南昌教育学院\">南昌教育学院</option>"+
"		<option value=\"九江职业大学\">九江职业大学</option>"+
"		<option value=\"江西中医药高等专科学校\">江西中医药高等专科学校</option>"+
"		<option value=\"江西应用技术职业学院\">江西应用技术职业学院</option>"+
"		<option value=\"江西艺术职业学院\">江西艺术职业学院</option>"+
"		<option value=\"江西行政管理干部学院\">江西行政管理干部学院</option>"+
"		<option value=\"江西省新余高等专科学校\">江西省新余高等专科学校</option>"+
"		<option value=\"江西旅游商贸职业学院\">江西旅游商贸职业学院</option>"+
"		<option value=\"江西经济管理干部学院\">江西经济管理干部学院</option>"+
"		<option value=\"江西环境工程职业学院\">江西环境工程职业学院</option>"+
"		<option value=\"江西财经职业学院\">江西财经职业学院</option>"+
"		<option value=\"江西-其它\">江西-其它</option>"+
							"	</select>"
var fj_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"福建师范大学\">福建师范大学</option>"+
"		<option value=\"福建农业大学\">福建农业大学</option>"+
"		<option value=\"福建医科大学\">福建医科大学</option>"+
"		<option value=\"福州大学\">福州大学</option>"+
"		<option value=\"厦门大学\">厦门大学</option>"+
"		<option value=\"国立华侨大学\">国立华侨大学</option>"+
"		<option value=\"集美大学\">集美大学</option>"+
"		<option value=\"仰恩大学\">仰恩大学</option>"+
"		<option value=\"厦门理工学院\">厦门理工学院</option>"+
"		<option value=\"福建漳州师范学院\">福建漳州师范学院</option>"+
"		<option value=\"福建职业技术学院\">福建职业技术学院</option>"+
"		<option value=\"福建中医学院\">福建中医学院</option>"+
"		<option value=\"福建建筑专科学校\">福建建筑专科学校</option>"+
"		<option value=\"福建交通职业技术学院\">福建交通职业技术学院</option>"+
"		<option value=\"福建公安高等专科学校\">福建公安高等专科学校</option>"+
"		<option value=\"福建工程学院\">福建工程学院</option>"+
"		<option value=\"泉州师范学院\">泉州师范学院</option>"+
"		<option value=\"莆田高等专科学校\">莆田高等专科学校</option>"+
"		<option value=\"闽江职业大学\">闽江职业大学</option>"+
"		<option value=\"福建师范大学福清校区(福清分校)\">福建师范大学福清校区(福清分校)</option>"+
"		<option value=\"三明高等专科学校\">三明高等专科学校</option>"+
"		<option value=\"厦门南洋学院\">厦门南洋学院</option>"+
"		<option value=\"龙岩学院\">龙岩学院</option>"+
"		<option value=\"黎明职业大学\">黎明职业大学</option>"+
"		<option value=\"漳州职业技术学院\">漳州职业技术学院</option>"+
"		<option value=\"闽江学院\">闽江学院</option>"+
"		<option value=\"福建广播电视大学\">福建广播电视大学</option>"+
"		<option value=\"南平师范高等专科学校\">南平师范高等专科学校</option>"+
"		<option value=\"厦门国家会计学院\">厦门国家会计学院</option>"+
"		<option value=\"福建商业高等专科学校\">福建商业高等专科学校</option>"+
"		<option value=\"福建金融职业技术学院\">福建金融职业技术学院</option>"+
"		<option value=\"厦门演艺职业学院\">厦门演艺职业学院</option>"+
"		<option value=\"厦门软件职业技术学院\">厦门软件职业技术学院</option>"+
"		<option value=\"厦门城市职业学院\">厦门城市职业学院</option>"+
"		<option value=\"三明职业技术学院\">三明职业技术学院</option>"+
"		<option value=\"莆田学院\">莆田学院</option>"+
"		<option value=\"宁德职业技术学院\">宁德职业技术学院</option>"+
"		<option value=\"宁德师范高等专科学校\">宁德师范高等专科学校</option>"+
"		<option value=\"福建水利电力职业技术学院\">福建水利电力职业技术学院</option>"+
"		<option value=\"福建经济管理干部学院\">福建经济管理干部学院</option>"+
"		<option value=\"福建-其它\">福建-其它</option>"+
							"	</select>"
var hun_university=          "	<select name=\"university\" style=\"width:150\">" +
						"		<option value=\"湖南大学\">湖南大学</option>"+
"		<option value=\"湖南师范大学\">湖南师范大学</option>"+
"		<option value=\"湖南农业大学\">湖南农业大学</option>"+
"		<option value=\"湖南广播电视大学\">湖南广播电视大学</option>"+
"		<option value=\"中南大学\">中南大学</option>"+
"		<option value=\"湘潭大学\">湘潭大学</option>"+
"		<option value=\"吉首大学\">吉首大学</option>"+
"		<option value=\"国防科技大学\">国防科技大学</option>"+
"		<option value=\"南华大学\">南华大学</option>"+
"		<option value=\"湖南工程学院\">湖南工程学院</option>"+
"		<option value=\"湖南计算机高等专科学校\">湖南计算机高等专科学校</option>"+
"		<option value=\"怀化医学高等专科学校\">怀化医学高等专科学校</option>"+
"		<option value=\"湖南商学院\">湖南商学院</option>"+
"		<option value=\"怀化学院\">怀化学院</option>"+
"		<option value=\"湖南中医学院\">湖南中医学院</option>"+
"		<option value=\"湖南第一师范\">湖南第一师范</option>"+
"		<option value=\"湖南师范大学医学院\">湖南师范大学医学院</option>"+
"		<option value=\"湖南环境生物职业技术学院\">湖南环境生物职业技术学院</option>"+
"		<option value=\"中南林学院\">中南林学院</option>"+
"		<option value=\"长沙航空职业技术学院\">长沙航空职业技术学院</option>"+
"		<option value=\"邵阳高等专科学校\">邵阳高等专科学校</option>"+
"		<option value=\"邵阳学院\">邵阳学院</option>"+
"		<option value=\"湖南科技大学\">湖南科技大学</option>"+
"		<option value=\"湖南文理学院(原常德师范学院)\">湖南文理学院(原常德师范学院)</option>"+
"		<option value=\"湖南工学院\">湖南工学院</option>"+
"		<option value=\"湖南理工学院(原岳阳师范学院)\">湖南理工学院(原岳阳师范学院)</option>"+
"		<option value=\"湘南学院\">湘南学院</option>"+
"		<option value=\"株洲工学院\">株洲工学院</option>"+
"		<option value=\"衡阳师范学院\">衡阳师范学院</option>"+
"		<option value=\"湖南铁道职业技术学院\">湖南铁道职业技术学院</option>"+
"		<option value=\"湖南生物机电学院网站\">湖南生物机电学院网站</option>"+
"		<option value=\"湖南冶金职业技术学院\">湖南冶金职业技术学院</option>"+
"		<option value=\"湖南经济管理干部学院\">湖南经济管理干部学院</option>"+
"		<option value=\"长沙理工大学\">长沙理工大学</option>"+
"		<option value=\"长沙学院\">长沙学院</option>"+
"		<option value=\"湖南科技学院\">湖南科技学院</option>"+
"		<option value=\"株洲师范高等专科学校\">株洲师范高等专科学校</option>"+
"		<option value=\"张家界航空工业职业技术学院\">张家界航空工业职业技术学院</option>"+
"		<option value=\"岳阳职业技术学院\">岳阳职业技术学院</option>"+
"		<option value=\"潇湘职业学院\">潇湘职业学院</option>"+
"		<option value=\"怀化职业技术学院\">怀化职业技术学院</option>"+
"		<option value=\"湖南中医药高等专科学校\">湖南中医药高等专科学校</option>"+
"		<option value=\"湖南中医药大学\">湖南中医药大学</option>"+
"		<option value=\"湖南司法警官职业学院\">湖南司法警官职业学院</option>"+
"		<option value=\"湖南水利水电职业技术学院\">湖南水利水电职业技术学院</option>"+
"		<option value=\"湖南生物机电职业技术学院\">湖南生物机电职业技术学院</option>"+
"		<option value=\"湖南涉外经济学院\">湖南涉外经济学院</option>"+
"		<option value=\"湖南商务职业技术学院\">湖南商务职业技术学院</option>"+
"		<option value=\"湖南人文科技学院\">湖南人文科技学院</option>"+
"		<option value=\"湖南女子职业大学\">湖南女子职业大学</option>"+
"		<option value=\"湖南民族职业学院\">湖南民族职业学院</option>"+
"		<option value=\"湖南科技职业学院\">湖南科技职业学院</option>"+
"		<option value=\"湖南九嶷职业技术学院\">湖南九嶷职业技术学院</option>"+
"		<option value=\"湖南交通工程职业技术学院\">湖南交通工程职业技术学院</option>"+
"		<option value=\"湖南机电职业技术学院\">湖南机电职业技术学院</option>"+
"		<option value=\"湖南公安高等专科学校\">湖南公安高等专科学校</option>"+
"		<option value=\"湖南工程职业技术学院\">湖南工程职业技术学院</option>"+
"		<option value=\"湖南大众传媒职业技术学院\">湖南大众传媒职业技术学院</option>"+
"		<option value=\"湖南城市学院\">湖南城市学院</option>"+
"		<option value=\"湖南财经高等专科学校\">湖南财经高等专科学校</option>"+
"		<option value=\"郴州职业技术学院\">郴州职业技术学院</option>"+
"		<option value=\"常德职业技术学院\">常德职业技术学院</option>"+
"		<option value=\"长沙医学院\">长沙医学院</option>"+
"		<option value=\"长沙通信职业技术学院\">长沙通信职业技术学院</option>"+
"		<option value=\"长沙商贸旅游职业技术学院\">长沙商贸旅游职业技术学院</option>"+
"		<option value=\"长沙环境保护职业技术学院\">长沙环境保护职业技术学院</option>"+
"		<option value=\"湖南工业职业技术学院\">湖南工业职业技术学院</option>"+
"		<option value=\"湖南-其它\">湖南-其它</option>"+
							"	</select>"
var hn_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"郑州大学\">郑州大学</option>"+
"		<option value=\"中国人民解放军信息工程大学(郑州)\">中国人民解放军信息工程大学(郑州)</option>"+
"		<option value=\"河南理工大学\">河南理工大学</option>"+
"		<option value=\"河南师范大学\">河南师范大学</option>"+
"		<option value=\"河南大学\">河南大学</option>"+
"		<option value=\"河南农业大学\">河南农业大学</option>"+
"		<option value=\"河南科技大学\">河南科技大学</option>"+
"		<option value=\"开封大学\">开封大学</option>"+
"		<option value=\"焦作大学\">焦作大学</option>"+
"		<option value=\"中州大学\">中州大学</option>"+
"		<option value=\"洛阳理工学院\">洛阳理工学院</option>"+
"		<option value=\"黄河科技大学\">黄河科技大学</option>"+
"		<option value=\"郑州师范高等专科学校\">郑州师范高等专科学校</option>"+
"		<option value=\"华北水利水电学院\">华北水利水电学院</option>"+
"		<option value=\"河南科技学院\">河南科技学院</option>"+
"		<option value=\"河南财经学院\">河南财经学院</option>"+
"		<option value=\"河南纺织高等专科学校\">河南纺织高等专科学校</option>"+
"		<option value=\"河南机电高等专科学校\">河南机电高等专科学校</option>"+
"		<option value=\"平顶山工学院\">平顶山工学院</option>"+
"		<option value=\"河南公安高等专科学校\">河南公安高等专科学校</option>"+
"		<option value=\"河南中医学院\">河南中医学院</option>"+
"		<option value=\"河南商业高等专科学校\">河南商业高等专科学校</option>"+
"		<option value=\"郑州牧业工程高等专科学校\">郑州牧业工程高等专科学校</option>"+
"		<option value=\"郑州大学升达经贸管理学院\">郑州大学升达经贸管理学院</option>"+
"		<option value=\"郑州航空工业管理学院\">郑州航空工业管理学院</option>"+
"		<option value=\"河南工业大学\">河南工业大学</option>"+
"		<option value=\"郑州轻工业学院\">郑州轻工业学院</option>"+
"		<option value=\"洛阳师范学院\">洛阳师范学院</option>"+
"		<option value=\"焦作师范高等专科学校\">焦作师范高等专科学校</option>"+
"		<option value=\"平顶山学院\">平顶山学院</option>"+
"		<option value=\"平顶山工业职业技术学院\">平顶山工业职业技术学院</option>"+
"		<option value=\"安阳师范学院\">安阳师范学院</option>"+
"		<option value=\"信阳师范学院\">信阳师范学院</option>"+
"		<option value=\"新乡医学院\">新乡医学院</option>"+
"		<option value=\"周口师范学院\">周口师范学院</option>"+
"		<option value=\"黄淮学院(原驻马店师范高等专科学校)\">黄淮学院(原驻马店师范高等专科学校)</option>"+
"		<option value=\"中原工学院\">中原工学院</option>"+
"		<option value=\"濮阳教育学院\">濮阳教育学院</option>"+
"		<option value=\"黄河水利职业技术学院\">黄河水利职业技术学院</option>"+
"		<option value=\"许昌学院\">许昌学院</option>"+
"		<option value=\"新乡学院\">新乡学院</option>"+
"		<option value=\"郑州电力高等专科学校\">郑州电力高等专科学校</option>"+
"		<option value=\"商丘师范学院\">商丘师范学院</option>"+
"		<option value=\"河南财政税务高等专科学校\">河南财政税务高等专科学校</option>"+
"		<option value=\"南阳师范学院\">南阳师范学院</option>"+
"		<option value=\"南阳理工学院\">南阳理工学院</option>"+
"		<option value=\"郑州大学西亚斯国际学院\">郑州大学西亚斯国际学院</option>"+
"		<option value=\"河南工程技术学校\">河南工程技术学校</option>"+
"		<option value=\"河南省新乡工业贸易学校\">河南省新乡工业贸易学校</option>"+
"		<option value=\"信阳农业高等专科学校\">信阳农业高等专科学校</option>"+
"		<option value=\"鹤壁职业技术学院\">鹤壁职业技术学院</option>"+
"		<option value=\"河南教育学院\">河南教育学院</option>"+
"		<option value=\"商丘医学高等专科学校\">商丘医学高等专科学校</option>"+
"		<option value=\"郑州经贸职业学院\">郑州经贸职业学院</option>"+
"		<option value=\"周口职业技术学院\">周口职业技术学院</option>"+
"		<option value=\"中原工学院信息商务学院\">中原工学院信息商务学院</option>"+
"		<option value=\"新乡医学院三全学院\">新乡医学院三全学院</option>"+
"		<option value=\"河南职业技术学院\">河南职业技术学院</option>"+
"		<option value=\"许昌职业技术学院\">许昌职业技术学院</option>"+
"		<option value=\"河南行政学院\">河南行政学院</option>"+
"		<option value=\"河南工业大学\">河南工业大学</option>"+
"		<option value=\"河南财经学院成功学院\">河南财经学院成功学院</option>"+
"		<option value=\"安阳工学院\">安阳工学院</option>"+
"		<option value=\"郑州大学体育学院\">郑州大学体育学院</option>"+
"		<option value=\"商丘医学院高等专科学校\">商丘医学院高等专科学校</option>"+
"		<option value=\"郑州铁路职业技术学院\">郑州铁路职业技术学院</option>"+
"		<option value=\"信阳职业技术学院\">信阳职业技术学院</option>"+
"		<option value=\"郑州电子信息职业技术学院\">郑州电子信息职业技术学院</option>"+
"		<option value=\"郑州经济管理干部学院\">郑州经济管理干部学院</option>"+
"		<option value=\"铁道警官高等专科学校\">铁道警官高等专科学校</option>"+
"		<option value=\"郑州交通职业学院\">郑州交通职业学院</option>"+
"		<option value=\"三门峡职业技术学院\">三门峡职业技术学院</option>"+
"		<option value=\"济源职业技术学院\">济源职业技术学院</option>"+
"		<option value=\"河南工业职业技术学院\">河南工业职业技术学院</option>"+
"		<option value=\"商丘职业技术学院\">商丘职业技术学院</option>"+
"		<option value=\"漯河医学高等专科学校\">漯河医学高等专科学校</option>"+
"		<option value=\"郑州职业技术学院\">郑州职业技术学院</option>"+
"		<option value=\"永城职业学院\">永城职业学院</option>"+
"		<option value=\"河南省政法管理干部学院\">河南省政法管理干部学院</option>"+
"		<option value=\"郑州旅游职业学院\">郑州旅游职业学院</option>"+
"		<option value=\"河南检察职业学院\">河南检察职业学院</option>"+
"		<option value=\"河南大学民生学院\">河南大学民生学院</option>"+
"		<option value=\"信阳师范学院华锐学院\">信阳师范学院华锐学院</option>"+
"		<option value=\"河南经贸职业学院\">河南经贸职业学院</option>"+
"		<option value=\"嵩山少林武术职业学院\">嵩山少林武术职业学院</option>"+
"		<option value=\"开封教育学院\">开封教育学院</option>"+
"		<option value=\"漯河职业技术学院\">漯河职业技术学院</option>"+
"		<option value=\"河南-其它\">河南-其它</option>"+
							"	</select>"
var xz_university=          "	<select name=\"university\" style=\"width:150\">" +
						"		<option value=\"西藏大学\">西藏大学</option>"+
"		<option value=\"西藏民族学院\">西藏民族学院</option>"+
"		<option value=\"西藏藏医学院\">西藏藏医学院</option>"+
"		<option value=\"西藏-其它\">西藏-其它</option>"+
							"	</select>"

var gs_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"兰州理工大学\">兰州理工大学</option>"+
"		<option value=\"甘肃农业大学\">甘肃农业大学</option>"+
"		<option value=\"兰州大学\">兰州大学</option>"+
"		<option value=\"西北师范大学\">西北师范大学</option>"+
"		<option value=\"甘肃政法学院\">甘肃政法学院</option>"+
"		<option value=\"兰州商学院\">兰州商学院</option>"+
"		<option value=\"兰州交通大学\">兰州交通大学</option>"+
"		<option value=\"兰州工业高等专科学校\">兰州工业高等专科学校</option>"+
"		<option value=\"张掖师范高等专科学校\">张掖师范高等专科学校</option>"+
"		<option value=\"甘肃联合大学\">甘肃联合大学</option>"+
"		<option value=\"西北民族学院\">西北民族学院</option>"+
"		<option value=\"天水师范学院\">天水师范学院</option>"+
"		<option value=\"河西学院\">河西学院</option>"+
"		<option value=\"甘肃广播电视大学\">甘肃广播电视大学</option>"+
"		<option value=\"甘肃中医学院\">甘肃中医学院</option>"+
"		<option value=\"合作民族师范高等专科学校\">合作民族师范高等专科学校</option>"+
"		<option value=\"西北民族大学\">西北民族大学</option>"+
"		<option value=\"兰州城市大学(原兰州师范高等专科学校)\">兰州城市大学(原兰州师范高等专科学校)</option>"+
"		<option value=\"陇南师范高等专科学校\">陇南师范高等专科学校</option>"+
"		<option value=\"甘肃行政学院\">甘肃行政学院</option>"+
"		<option value=\"陇东学院\">陇东学院</option>"+
"		<option value=\"武威职业学院\">武威职业学院</option>"+
"		<option value=\"兰州职业技术学院\">兰州职业技术学院</option>"+
"		<option value=\"兰州交通大学博文学院\">兰州交通大学博文学院</option>"+
"		<option value=\"甘肃林业职业技术学院\">甘肃林业职业技术学院</option>"+
"		<option value=\"甘肃钢铁职业技术学院\">甘肃钢铁职业技术学院</option>"+
"		<option value=\"兰州石化职业技术学院\">兰州石化职业技术学院</option>"+
"		<option value=\"兰州外语职业学院\">兰州外语职业学院</option>"+
"		<option value=\"兰州-其它\">兰州-其它</option>"+
							"	</select>"

var gx_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"广西大学\">广西大学</option>"+
"		<option value=\"广西师范大学\">广西师范大学</option>"+
"		<option value=\"广西民族大学\">广西民族大学</option>"+
"		<option value=\"广西医科大学\">广西医科大学</option>"+
"		<option value=\"广西师范学院\">广西师范学院</option>"+
"		<option value=\"广西工学院\">广西工学院</option>"+
"		<option value=\"广西中医学院\">广西中医学院</option>"+
"		<option value=\"广西大学梧州分校\">广西大学梧州分校</option>"+
"		<option value=\"桂林电子工业学院\">桂林电子工业学院</option>"+
"		<option value=\"桂林工学院\">桂林工学院</option>"+
"		<option value=\"广西机电职业技术学院\">广西机电职业技术学院</option>"+
"		<option value=\"桂林旅游高等专科学校\">桂林旅游高等专科学校</option>"+
"		<option value=\"桂林师范高等专科学校\">桂林师范高等专科学校</option>"+
"		<option value=\"桂林医学院\">桂林医学院</option>"+
"		<option value=\"桂林航天工业高等专科学校\">桂林航天工业高等专科学校</option>"+
"		<option value=\"南宁科技信息网\">南宁科技信息网</option>"+
"		<option value=\"右江民族医学院\">右江民族医学院</option>"+
"		<option value=\"广西财经学院\">广西财经学院</option>"+
"		<option value=\"河池学院\">河池学院</option>"+
"		<option value=\"玉林师范学院\">玉林师范学院</option>"+
"		<option value=\"柳州师范高等专科学校\">柳州师范高等专科学校</option>"+
"		<option value=\"北海宏源足球职业学院\">北海宏源足球职业学院</option>"+
"		<option value=\"广西生态工程职业技术学院\">广西生态工程职业技术学院</option>"+
"		<option value=\"南宁师范高等专科学校\">南宁师范高等专科学校</option>"+
"		<option value=\"贺州学院\">贺州学院</option>"+
"		<option value=\"广西交通职业技术学院\">广西交通职业技术学院</option>"+
"		<option value=\"柳州职业技术学院\">柳州职业技术学院</option>"+
"		<option value=\"北海艺术设计职业学院\">北海艺术设计职业学院</option>"+
"		<option value=\"广西职业技术学院\">广西职业技术学院</option>"+
"		<option value=\"广西电力职业技术学院\">广西电力职业技术学院</option>"+
"		<option value=\"柳州运输职业技术学院\">柳州运输职业技术学院</option>"+
"		<option value=\"河池职业学院\">河池职业学院</option>"+
"		<option value=\"广西经济管理干部学院\">广西经济管理干部学院</option>"+
"		<option value=\"广西城市职业学院\">广西城市职业学院</option>"+
"		<option value=\"钦州学院\">钦州学院</option>"+
"		<option value=\"广西艺术学院\">广西艺术学院</option>"+
"		<option value=\"百色学院\">百色学院</option>"+
"		<option value=\"广西其它\">广西-其它</option>"+
							"	</select>"
var hain_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"海南大学\">海南大学</option>"+
"		<option value=\"琼州大学\">琼州大学</option>"+
"		<option value=\"华南热带农业大学\">华南热带农业大学</option>"+
"		<option value=\"海南师范大学\">海南师范大学</option>"+
"		<option value=\"海南医学院\">海南医学院</option>"+
"		<option value=\"海口经济职业技术学院\">海口经济职业技术学院</option>"+
"		<option value=\"琼台师范高等专科学校\">琼台师范高等专科学校</option>"+
"		<option value=\"海南软件职业技术学院\">海南软件职业技术学院</option>"+
"		<option value=\"海南大学三亚学院\">海南大学三亚学院</option>"+
"		<option value=\"海南广播电视大学\">海南广播电视大学</option>"+
"		<option value=\"海南政法职业学院\">海南政法职业学院</option>"+
"		<option value=\"海南经贸职业技术学院\">海南经贸职业技术学院</option>"+
"		<option value=\"海南职业技术学院\">海南职业技术学院</option>"+
"		<option value=\"海南其它\">海南-其它</option>"+
							"	</select>"
var qh_university=          "	<select name=\"university\" style=\"width:150\">" +
						"		<option value=\"青海大学\">青海大学</option>"+
"		<option value=\"青海师范大学\">青海师范大学</option>"+
"		<option value=\"青海广播电视大学\">青海广播电视大学</option>"+
"		<option value=\"青海民族学院\">青海民族学院</option>"+
"		<option value=\"青海医学院\">青海医学院</option>"+
"		<option value=\"青海省行政学院\">青海省行政学院</option>"+
"		<option value=\"青海卫生职业技术学院\">青海卫生职业技术学院</option>"+
"		<option value=\"青海交通职业技术学院\">青海交通职业技术学院</option>"+
"		<option value=\"青海其它\">青海-其它</option>"+
							"	</select>"
var xj_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"新疆大学\">新疆大学</option>"+
"		<option value=\"新疆农业大学\">新疆农业大学</option>"+
"		<option value=\"新疆医科大学\">新疆医科大学</option>"+
"		<option value=\"新疆师范大学\">新疆师范大学</option>"+
"		<option value=\"乌鲁木齐职业大学\">乌鲁木齐职业大学</option>"+
"		<option value=\"塔里木大学\">塔里木大学</option>"+
"		<option value=\"石河子大学\">石河子大学</option>"+
"		<option value=\"新疆农业职业技术学院\">新疆农业职业技术学院</option>"+
"		<option value=\"新疆财经大学\">新疆财经大学</option>"+
"		<option value=\"新疆石油学院\">新疆石油学院</option>"+
"		<option value=\"昌吉学院\">昌吉学院</option>"+
"		<option value=\"新疆轻工职业技术学院\">新疆轻工职业技术学院</option>"+
"		<option value=\"新疆广播电视大学\">新疆广播电视大学</option>"+
"		<option value=\"新疆艺术学院\">新疆艺术学院</option>"+
"		<option value=\"喀什师范学院\">喀什师范学院</option>"+
"		<option value=\"伊犁师范学院\">伊犁师范学院</option>"+
"		<option value=\"新疆维吾尔自治区行政学院(中共新疆维吾尔自治区委员会党校)\">新疆维吾尔自治区行政学院(中共新疆维吾尔自治区委员会党校)</option>"+
"		<option value=\"武警乌鲁木齐指挥学校\">武警乌鲁木齐指挥学校</option>"+
"		<option value=\"新疆-其它\">新疆-其它</option>"+
							"	</select>"
var jl_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"东北师范大学\">东北师范大学</option>"+
"		<option value=\"吉林大学\">吉林大学</option>"+
"		<option value=\"吉林师范大学(原四平师范学院)\">吉林师范大学(原四平师范学院)</option>"+
"		<option value=\"吉林农业大学\">吉林农业大学</option>"+
"		<option value=\"长春理工大学(原长春光学精密机械学院)\">长春理工大学(原长春光学精密机械学院)</option>"+
"		<option value=\"吉林化工学院\">吉林化工学院</option>"+
"		<option value=\"长春工程学院\">长春工程学院</option>"+
"		<option value=\"延边大学\">延边大学</option>"+
"		<option value=\"延边科学技术大学\">延边科学技术大学</option>"+
"		<option value=\"北华大学\">北华大学</option>"+
"		<option value=\"东北电力大学\">东北电力大学</option>"+
"		<option value=\"吉林建筑工程学院\">吉林建筑工程学院</option>"+
"		<option value=\"长春汽车工业高等专科学校\">长春汽车工业高等专科学校</option>"+
"		<option value=\"吉林电子信息职业技术学院\">吉林电子信息职业技术学院</option>"+
"		<option value=\"吉林师范大学分校(四平师范学院分院)\">吉林师范大学分校(四平师范学院分院)</option>"+
"		<option value=\"长春师范学院\">长春师范学院</option>"+
"		<option value=\"长春金融高等专科学校\">长春金融高等专科学校</option>"+
"		<option value=\"吉林工业职业技术学院\">吉林工业职业技术学院</option>"+
"		<option value=\"长春工业大学(原吉林工学院)\">长春工业大学(原吉林工学院)</option>"+
"		<option value=\"吉林大学农学部\">吉林大学农学部</option>"+
"		<option value=\"长春大学\">长春大学</option>"+
"		<option value=\"长春税务学院国际交流学院\">长春税务学院国际交流学院</option>"+
"		<option value=\"长春税务学院\">长春税务学院</option>"+
"		<option value=\"吉林粮食高等专科学校\">吉林粮食高等专科学校</option>"+
"		<option value=\"吉林商业高等专科学校\">吉林商业高等专科学校</option>"+
"		<option value=\"长春中医药大学(原长春中医学院)\">长春中医药大学(原长春中医学院)</option>"+
"		<option value=\"通化师范学院\">通化师范学院</option>"+
"		<option value=\"吉林交通职业技术学院\">吉林交通职业技术学院</option>"+
"		<option value=\"吉林艺术学院\">吉林艺术学院</option>"+
"		<option value=\"吉林工程技术师范学院\">吉林工程技术师范学院</option>"+
"		<option value=\"吉林建筑工程学院城建学院\">吉林建筑工程学院城建学院</option>"+
"		<option value=\"长春东方职业学院\">长春东方职业学院</option>"+
"		<option value=\"吉林华桥外国语学院\">吉林华桥外国语学院</option>"+
"		<option value=\"长春信息职业技术学院\">长春信息职业技术学院</option>"+
"		<option value=\"白城师范学院\">白城师范学院</option>"+
"		<option value=\"吉林医药学院\">吉林医药学院</option>"+
"		<option value=\"吉林交通职业技术学院\">吉林交通职业技术学院</option>"+
"		<option value=\"吉林财税高等专科学校\">吉林财税高等专科学校</option>"+
"		<option value=\"吉林建筑工程学院建筑装饰学院\">吉林建筑工程学院建筑装饰学院</option>"+
"		<option value=\"长春医学高等专科学校\">长春医学高等专科学校</option>"+
"		<option value=\"辽源职业技术学院\">辽源职业技术学院</option>"+
"		<option value=\"吉林农业科技学院\">吉林农业科技学院</option>"+
"		<option value=\"长春大学光华学院\">长春大学光华学院</option>"+
"		<option value=\"长春工业大学人文信息学院\">长春工业大学人文信息学院</option>"+
"		<option value=\"长春信息技术职业学院\">长春信息技术职业学院</option>"+
"		<option value=\"吉林华桥外国语学院\">吉林华桥外国语学院</option>"+
"		<option value=\"吉林师范大学博达学院\">吉林师范大学博达学院</option>"+
"		<option value=\"吉林省体育学院\">吉林省体育学院</option>"+
"		<option value=\"吉林省经济管理干部学院\">吉林省经济管理干部学院</option>"+
"		<option value=\"吉林省-其它\">吉林省-其它</option>"+
							"	</select>"

var hlj_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"东北农业大学\">东北农业大学</option>"+
"		<option value=\"东北林业大学\">东北林业大学</option>"+
"		<option value=\"黑龙江大学\">黑龙江大学</option>"+
"		<option value=\"黑龙江八一农垦大学\">黑龙江八一农垦大学</option>"+
"		<option value=\"哈尔滨商业大学\">哈尔滨商业大学</option>"+
"		<option value=\"黑龙江科技学院\">黑龙江科技学院</option>"+
"		<option value=\"黑龙江中医药大学\">黑龙江中医药大学</option>"+
"		<option value=\"哈尔滨工程大学\">哈尔滨工程大学</option>"+
"		<option value=\"哈尔滨工业大学\">哈尔滨工业大学</option>"+
"		<option value=\"哈尔滨医科大学\">哈尔滨医科大学</option>"+
"		<option value=\"哈尔滨理工大学\">哈尔滨理工大学</option>"+
"		<option value=\"哈尔滨师范大学\">哈尔滨师范大学</option>"+
"		<option value=\"齐齐哈尔大学\">齐齐哈尔大学</option>"+
"		<option value=\"哈尔滨医科大学附属第二医院\">哈尔滨医科大学附属第二医院</option>"+
"		<option value=\"哈尔滨广播电视大学\">哈尔滨广播电视大学</option>"+
"		<option value=\"黑龙江广播电视大学\">黑龙江广播电视大学</option>"+
"		<option value=\"哈尔滨学院\">哈尔滨学院</option>"+
"		<option value=\"大庆石油学院\">大庆石油学院</option>"+
"		<option value=\"哈尔滨金融高等专科学校\">哈尔滨金融高等专科学校</option>"+
"		<option value=\"哈尔滨体育学院\">哈尔滨体育学院</option>"+
"		<option value=\"黑龙江工程学院\">黑龙江工程学院</option>"+
"		<option value=\"牡丹江师范学院\">牡丹江师范学院</option>"+
"		<option value=\"黑龙江畜牧兽医职业学院\">黑龙江畜牧兽医职业学院</option>"+
"		<option value=\"哈尔滨市南岗教师进修学校\">哈尔滨市南岗教师进修学校</option>"+
"		<option value=\"大庆石油华瑞学院\">大庆石油华瑞学院</option>"+
"		<option value=\"黑河学院\">黑河学院</option>"+
"		<option value=\"哈尔滨理工大学远东学院\">哈尔滨理工大学远东学院</option>"+
"		<option value=\"黑龙江大学剑桥学院\">黑龙江大学剑桥学院</option>"+
"		<option value=\"大庆师范学院\">大庆师范学院</option>"+
"		<option value=\"哈尔滨师范大学恒星学院\">哈尔滨师范大学恒星学院</option>"+
"		<option value=\"黑龙江省招生考试委员会办公室\">黑龙江省招生考试委员会办公室</option>"+
"		<option value=\"绥化学院\">绥化学院</option>"+
"		<option value=\"黑龙江-其它\">黑龙江-其它</option>"+
							"	</select>"
var am_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"澳门大学\">澳门大学</option>"+
"		<option value=\"澳门科技大学\">澳门科技大学</option>"+
"		<option value=\"国际公开大学Asia International Open University\">国际公开大学Asia International Open University</option>"+
"		<option value=\"澳门理工学院Macau Polytechnic Institute \">澳门理工学院Macau Polytechnic Institute</option>"+
"		<option value=\"旅游学院Institute for Tourism Studies\">旅游学院Institute for Tourism Studies</option>"+
"		<option value=\"Inter-University Institute of Macau  \">Inter-University Institute of Macau  </option>"+
"		<option value=\"澳门-其它\">澳门-其它</option>"+
							"	</select>"
var yn_university=          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"云南大学\">云南大学</option>"+
"		<option value=\"云南师范大学\">云南师范大学</option>"+
"		<option value=\"云南农业大学\">云南农业大学</option>"+
"		<option value=\"昆明理工大学\">昆明理工大学</option>"+
"		<option value=\"云南财经大学\">云南财经大学</option>"+
"		<option value=\"云南民族大学\">云南民族大学</option>"+
"		<option value=\"云南广播电视大学\">云南广播电视大学</option>"+
"		<option value=\"云南玉溪师范学院\">云南玉溪师范学院</option>"+
"		<option value=\"云南警官学院\">云南警官学院</option>"+
"		<option value=\"昆明医学院\">昆明医学院</option>"+
"		<option value=\"西南林学院\">西南林学院</option>"+
"		<option value=\"楚雄师范学院\">楚雄师范学院</option>"+
"		<option value=\"曲靖师范学院\">曲靖师范学院</option>"+
"		<option value=\"大理学院\">大理学院</option>"+
"		<option value=\"昆明冶金高等专科学校\">昆明冶金高等专科学校</option>"+
"		<option value=\"云南科技信息职业学院\">云南科技信息职业学院</option>"+
"		<option value=\"昆明学院(原昆明大学)\">昆明学院(原昆明大学)</option>"+
"		<option value=\"云南中医学院\">云南中医学院</option>"+
"		<option value=\"云南艺术学院\">云南艺术学院</option>"+
"		<option value=\"红河学院\">红河学院</option>"+
"		<option value=\"云南农业职业技术学院\">云南农业职业技术学院</option>"+
"		<option value=\"保山师范高等专科学校\">保山师范高等专科学校</option>"+
"		<option value=\"文山师范高等专科学校\">文山师范高等专科学校</option>"+
"		<option value=\"昭通师范高等专科学校\">昭通师范高等专科学校</option>"+
"		<option value=\"云南交通职业技术学院\">云南交通职业技术学院</option>"+
"		<option value=\"云南师范大学商学院\">云南师范大学商学院</option>"+
"		<option value=\"云南省思茅师范高等专科学校\">云南省思茅师范高等专科学校</option>"+
"		<option value=\"云南热带作物职业学院\">云南热带作物职业学院</option>"+
"		<option value=\"云南能源职业技术学院\">云南能源职业技术学院</option>"+
"		<option value=\"云南-其它\">云南-其它</option>"+
							"	</select>"

var none =          "	<select name=\"university\" style=\"width:150\">" +
							"		<option value=\"0\">----请选择大学----</option>" +
							"	</select>"


	     if(province_university.value == "安徽"){
			document.getElementById("districtuniversity").innerHTML = ah_university;
		}else if(province_university.value == "澳门"){
			document.getElementById("districtuniversity").innerHTML = am_university;
		}else if(province_university.value == "北京"){
			document.getElementById("districtuniversity").innerHTML = bj_university;
		}else if(province_university.value == "重庆"){
			document.getElementById("districtuniversity").innerHTML = cq_university;
		}else if(province_university.value == "福建"){
			document.getElementById("districtuniversity").innerHTML = fj_university;
		}else if(province_university.value == "广东"){
			document.getElementById("districtuniversity").innerHTML = gd_university;
		}else if(province_university.value == "甘肃"){
			document.getElementById("districtuniversity").innerHTML = gs_university;
		}else if(province_university.value == "广西"){
			document.getElementById("districtuniversity").innerHTML = gx_university;
		}else if(province_university.value == "贵州"){
			document.getElementById("districtuniversity").innerHTML = gz_university;
		}else if(province_university.value == "河南"){
			document.getElementById("districtuniversity").innerHTML = hn_university;
		}else if(province_university.value == "湖北"){
			document.getElementById("districtuniversity").innerHTML = hb_university;
		}else if(province_university.value == "河北"){
			document.getElementById("districtuniversity").innerHTML = heb_university;
		}else if(province_university.value == "海南"){
			document.getElementById("districtuniversity").innerHTML = hain_university;
		}else if(province_university.value == "黑龙江"){
			document.getElementById("districtuniversity").innerHTML = hlj_university;
		}else if(province_university.value == "湖南"){
			document.getElementById("districtuniversity").innerHTML = hun_university;
		}else if(province_university.value == "吉林"){
			document.getElementById("districtuniversity").innerHTML = jl_university;
		}else if(province_university.value == "江苏"){
			document.getElementById("districtuniversity").innerHTML = js_university;
		}else if(province_university.value == "江西"){
			document.getElementById("districtuniversity").innerHTML = jx_university;
		}else if(province_university.value == "辽宁"){
			document.getElementById("districtuniversity").innerHTML = ln_university;
		}else if(province_university.value == "内蒙古"){
			document.getElementById("districtuniversity").innerHTML = nmg_university;
		}else if(province_university.value == "宁夏"){
			document.getElementById("districtuniversity").innerHTML = nx_university;
		}else if(province_university.value == "青海"){
			document.getElementById("districtuniversity").innerHTML = qh_university;
		}else if(province_university.value == "四川"){
			document.getElementById("districtuniversity").innerHTML = sc_university;
		}else if(province_university.value == "山东"){
			document.getElementById("districtuniversity").innerHTML = sd_university;
		}else if(province_university.value == "上海"){
			document.getElementById("districtuniversity").innerHTML = sh_university;
		}else if(province_university.value == "陕西"){
			document.getElementById("districtuniversity").innerHTML = sx_university;
		}else if(province_university.value == "山西"){
			document.getElementById("districtuniversity").innerHTML = shx_university;
		}else if(province_university.value == "天津"){
			document.getElementById("districtuniversity").innerHTML = tj_university;
		}else if(province_university.value == "新疆"){
			document.getElementById("districtuniversity").innerHTML = xj_university;
		}else if(province_university.value == "西藏"){
			document.getElementById("districtuniversity").innerHTML = xz_university;
		}else if(province_university.value == "香港"){
			document.getElementById("districtuniversity").innerHTML = xg_university;
		}else if(province_university.value == "云南"){
			document.getElementById("districtuniversity").innerHTML = yn_university;
		}else if(province_university.value == "浙江"){
			document.getElementById("districtuniversity").innerHTML = zj_university;
		}else if(province_university.value == "0"){
			document.getElementById("districtuniversity").innerHTML = none;
		}
}

//实现"省-校区"条件选择器
function showProvinceDistrict(province_district){
		var bj_district = 	"	<select name=\"tarenaCenter\" style=\"width:150\">" +
							"		<option value=\"bj_1\">王府井</option>" +
							"		<option value=\"bj_2\">中关村</option>" +
							"		<option value=\"bj_2\">上地</option>" +
							"	</select>"
							
		var sh_district = 	"	<select name=\"tarenaCenter\" style=\"width:150\">" +
							"		<option value=\"sh_1\">上海人民广场</option>" +
							"		<option value=\"sh_2\">上海徐家汇</option>" +
							"		<option value=\"sh_3\">上海大柏树</option>" +
							"	</select>"

		var none =          "	<select name=\"tarenaCenter\" style=\"width:150\">" +
							"		<option value=\"sh_0\">----请选择校区----</option>" +
							"	</select>"

	    if(province_district.value == "安徽"){
			document.getElementById("districtArea").innerHTML = ah_district;
		}else if(province_district.value == "澳门"){
			document.getElementById("districtArea").innerHTML = am_district;
		}else if(province_district.value == "北京"){
			document.getElementById("districtArea").innerHTML = bj_district;
		}else if(province_district.value == "重庆"){
			document.getElementById("districtArea").innerHTML = cq_district;
		}else if(province_district.value == "福建"){
			document.getElementById("districtArea").innerHTML = fj_district;
		}else if(province_district.value == "广东"){
			document.getElementById("districtArea").innerHTML = gd_district;
		}else if(province_district.value == "甘肃"){
			document.getElementById("districtArea").innerHTML = gs_district;
		}else if(province_district.value == "广西"){
			document.getElementById("districtArea").innerHTML = gx_district;
		}else if(province_district.value == "贵州"){
			document.getElementById("districtArea").innerHTML = gz_district;
		}else if(province_district.value == "河南"){
			document.getElementById("districtArea").innerHTML = hn_district;
		}else if(province_district.value == "湖北"){
			document.getElementById("districtArea").innerHTML = hb_district;
		}else if(province_district.value == "河北"){
			document.getElementById("districtArea").innerHTML = heb_district;
		}else if(province_district.value == "海南"){
			document.getElementById("districtArea").innerHTML = hain_district;
		}else if(province_district.value == "黑龙江"){
			document.getElementById("districtArea").innerHTML = hlj_district;
		}else if(province_district.value == "湖南"){
			document.getElementById("districtArea").innerHTML = hun_district;
		}else if(province_district.value == "吉林"){
			document.getElementById("districtArea").innerHTML = jl_district;
		}else if(province_district.value == "江苏"){
			document.getElementById("districtArea").innerHTML = js_district;
		}else if(province_district.value == "江西"){
			document.getElementById("districtArea").innerHTML = jx_district;
		}else if(province_district.value == "辽宁"){
			document.getElementById("districtArea").innerHTML = ln_district;
		}else if(province_district.value == "内蒙古"){
			document.getElementById("districtArea").innerHTML = nmg_district;
		}else if(province_district.value == "宁夏"){
			document.getElementById("districtArea").innerHTML = nx_district;
		}else if(province_district.value == "青海"){
			document.getElementById("districtArea").innerHTML = qh_district;
		}else if(province_district.value == "四川"){
			document.getElementById("districtArea").innerHTML = sc_district;
		}else if(province_district.value == "山东"){
			document.getElementById("districtArea").innerHTML = sd_district;
		}else if(province_district.value == "上海"){
			document.getElementById("districtArea").innerHTML = sh_district;
		}else if(province_district.value == "陕西"){
			document.getElementById("districtArea").innerHTML = sx_district;
		}else if(province_district.value == "山西"){
			document.getElementById("districtArea").innerHTML = shx_district;
		}else if(province_district.value == "天津"){
			document.getElementById("districtArea").innerHTML = tj_district;
		}else if(province_district.value == "新疆"){
			document.getElementById("districtArea").innerHTML = xj_district;
		}else if(province_district.value == "西藏"){
			document.getElementById("districtArea").innerHTML = xz_district;
		}else if(province_district.value == "香港"){
			document.getElementById("districtArea").innerHTML = xg_district;
		}else if(province_district.value == "云南"){
			document.getElementById("districtArea").innerHTML = yn_district;
		}else if(province_district.value == "浙江"){
			document.getElementById("districtArea").innerHTML = zj_district;
		}else if(province_district.value == "0"){
			document.getElementById("districtArea").innerHTML = none;
		}
}
