<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>

<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/jquery-1.7.2.min.js"  type="text/javascript"></script>
	
	<script language="javascript">
		function checkName(info){
			if(info.content.value==""){
				alert("输入不能为空");
				//info.focus();
				return false;
			}
			if(info.type.value=="1"&&(info.newType.value==""||info.newType.value=="新增类型")){
				alert("请选择类型或者新建类型");
				return false;
			}
			if(info.type.value!="1"&&(info.newType.value!=""&&info.newType.value!="新增类型")){
				alert("请不要同时选择类型和新建类型");
				return false;
			}
		}
		$(function(){
			$("#newType").focus(function(){
				$("#newType").css("color","black");	
				$("#newType").val("");	
			});
		});
		$(function(){
			$("#newType").blur(function(){
				if($("#newType").val()==""){
					$("#newType").val("新增类型");	
					$("#newType").css("color","gray");	
				}
			});
		});
		var winOpen;
		function ifWinClose(){
			if(winOpen.closed==true){
				alert("111");
			}
		}
		function aaa(obj){
			var str=obj.innerHTML.split(">")[1].split("<")[0].trim();
			var id=obj.id;
			//str=escape(escape(str)).trim();
			/* winOpen=window.open ('${pageContext.request.contextPath}/pmo/modify_content.jsp?text='+str+'&id='+id, 'newWin','scrollbars=yes,status=yes,width=600,height=300,top=220,left=280');
	 		ifWinClose(); */
			$("#div1").css("left","500px");
			$("#div2").css("left","0px");
			$("#text1").val(str);
			$("#text1").attr("name",id);
		}
		function backView(){
			
			$("#div1").css("left","-500px");
			$("#div2").css("left","-2200000px");
		}
		function inputGo(){
			var str = $("#text1").val();
			if(str.trim()==""){
				alert("修改内容不能为空!");
				return false;
			}
			var id=$("#text1").attr("name");
			/* var id = document.getElementById("#text1").name;
			alert(str+":"+id); */
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/ajax/ChangeContent",
				dataType:"json",
				data:{"id":id,"name":str},
				error: function(e){	
				},
				success: function(result){	
				}
			});
			$("#div1").css("left","-500px");
			$("#div2").css("left","-2200000px");
			document.getElementById(id).innerHTML=str;
		}
 		
	</script>
</head>
<body>
	<div id="div1" style="position: absolute;top: 350px;left: -500px;z-index: 2;width: 300;height: 400;border: 1px solid;background: white">
		<form action="" method="post">
			<textarea id="text1" rows="3px" cols="20px"></textarea><br/>
			<input type="button" value="确认修改" onclick="return inputGo()"/> <input type="button" value="取消" onclick="backView()"/>
		</form>
	</div>
	<div id="div2" style="width: 100%;height: 800px;position: absolute;z-index: 1;background-color: grey;opacity:0.5;left: -20000px">
	</div>
	
	
<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
    <tr>
      <td width="1024" height="100" valign="top"><jsp:include page="../global/label/head.jsp"/></td>
    </tr>
    <tr>
      <td height="19" class="BorderTBSolidFF99CC">
	  <table width="100%" align="center" border="0">
	  	<tr>
			<td width="12"></td>
			<td width="500" class="fontforwelcometd"><jsp:include page="../global/label/welcome.jsp" /></td>
			<td width="500" align="right">
			      <jsp:include page="../global/label/pmo_operators.jsp" />
	           </td>
			<td width="12"></td>
		</tr>
	  </table>
	  </td>
    </tr>
    <tr>
      <td height="410" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="1024" valign="top"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
									<td height="3"></td>
								</tr>
            					<tr>
					              <td width="12"></td>
					              <td width="1000" align="left" class="fontforwelcometd">&nbsp&nbsp&nbsp后台管理 —> 考评项管理</td>
					              <td width="12"></td>
					            </tr>
                                <tr>
                                	<td height="5"></td>
                                </tr>
            <tr>
              <td width="12"></td>
              <td align="center" valign="top" width="1000">
			  <form name="" method="post" action="${pageContext.request.contextPath}/add_content.do">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0">

				<tr>
					<td colspan="2"><fieldset>
					<legend></legend>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="50%" height="40"><div align="right">考&nbsp;&nbsp;评&nbsp;&nbsp;项&nbsp;：</div></td>
                        <td width="50%">
						    <input type="text" name="content" />
						    </td>
						    </tr>
						    <tr>
						  
						     <td width="50%" height="40"><div align="right">选&nbsp;择&nbsp;类&nbsp;型：</div></td>
						  <td width="50%">
						    <select name="type">
						    	<option value="1" selected="selected">选择类型或新增</option>
						    	<c:forEach var="type" items="${maps }">
						    	<option value="${type.key }">${type.key }</option>
						    	</c:forEach>
						    </select>
						    <input type="text" id="newType" name="newType" value="新增类型" style="color:gray"/>
						  </td>
                        </tr>
                        <tr>
						<td>
						<div align="right">
						    <input type="submit" name="Submit" value="新增考评" onClick="return checkName(this.form);" />
						    </div>
						    </td>
						    
					 </tr>
						 </table>
						 
					
					<table width="100%" border="0" cellpadding="0" cellspacing="0">	
						<c:forEach var="t" items="${maps }">
						<tr>
							<font face=黑体 size="3">${t.key }</font></br>	
							<ul>
							<c:forEach var="c" items="${t.value }">
								<li ondblclick="aaa(this)" id="${c.id }">
								<font face=黑体 size="2">
									${c.content }
							 	</font>
								</li>
							</c:forEach>
							</ul>
						</tr>
						</c:forEach>
                    </table>
                    	<!-- ************************************* -->
                    	
                    	<!-- ************************************* -->
                    	
                    	
					</fieldset></td>
				</tr>
               
              </table>
  </form>
			  </td>
              <td width="12"></td>
            </tr>
          </table>
		
		  </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="44" valign="top" class="BorderTSolidFF99CC"><jsp:include page="../global/label/foot.jsp"/></td>
    </tr>
  </table>
</body>
</html>