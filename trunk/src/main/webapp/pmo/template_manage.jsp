<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style>
</style>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css"/>
	<script src="${pageContext.request.contextPath}/jquery-1.7.2.min.js"  type="text/javascript"></script>
	

	<script language="javascript">
	
	window.onload=function(){
		var arr =document.getElementsByName("myselect");
		arr[0].style.display='block';
	};
	function show(obj){
		var arr =document.getElementsByName("myselect");
		for(var i=0;i<arr.length;i++){
			arr[i].style.display='none';	
		}
		var select=obj.nextSibling.nextSibling;
		select.style.display='block';
	}
	
		
		function checkName(info){
			if(info.content.value==""){
				alert("输入不能为空");
				//info.focus();
				return false;
			}
		}
		function checkInfo(info){
			if(info.name.value==""||info.description.value==""){
				alert("输入不能为空");
				//info.focus();
				return false;
			}
			
			info.submit();
		}
		
		function selectContent(obj){
			var select=document.getElementById("ifselect");
			select.appendChild(obj);
			var contentid=obj.id;
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/ajax/ChangeContentType1",
				dataType:"json",
				data:{"id":contentid},
				error: function(e){	
				},
				success: function(result){	
				}
			});
			obj.ondblclick=function(){
				var id=this.value;
				var select2=document.getElementById(id);
				select2.appendChild(this);
				$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/ajax/ChangeContentType2",
				dataType:"json",
				data:{"id":contentid},
				error: function(e){	
				},
				success: function(result){	
				}
			});
				this.ondblclick=function(){
					selectContent(this);
				};
			};
		}
		function changeType(obj){
			var id = obj.value;
			if(obj.checked){
			$.ajax({
				type:"post",
				url:"${pageContext.request.contextPath}/ajax/ChangeTemplateType1",
				dataType:"json",
				data:{"id":id},
				error: function(e){	
				},
				success: function(result){	
				}
			});
			}else{
				$.ajax({
					type:"post",
					url:"${pageContext.request.contextPath}/ajax/ChangeTemplateType2",
					dataType:"json",
					data:{"id":id},
					error: function(e){	
					},
					success: function(result){	
					}
				});
			}
		}
		function showDetail(obj){
			var id=obj.id.split(":")[1];
			winOpen=window.open ('${pageContext.request.contextPath}/view_template.do?id='+id, 'showWin','scrollbars=yes,status=yes,width=600,height=300,top=220,left=280');
			
		}
 	
	
	</script>
	
</head>
<body>

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
					              <td width="1000" align="left" class="fontforwelcometd">&nbsp&nbsp&nbsp后台管理 —> 模板管理</td>
					              <td width="12"></td>
					            </tr>
                                <tr>
                                	<td height="5"></td>
                                </tr>
            <tr>
              <td width="12"></td>
              <td align="center" valign="top" width="1000">
			  <form name="" method="post" action="${pageContext.request.contextPath}/add_template.do">
			  <table width="100%" border="0" cellpadding="0" cellspacing="0">

				<tr>
					<td colspan="2"><fieldset>
					<legend>新增模板</legend>
					
					
			   
					
                    	<!-- ***************迭代********************** -->
                    <table width="1000px"; >
                    <tr>
                    <td width="500px" height="300px">
                    	<c:forEach var="m" items="${maps }" varStatus="s">
	                    	<div align="left" style="width:400px;height:20px;background-color:#DDA0DD;border-bottom:1px solid #FFFFFF;" onclick="show(this)"><font size="2" face=黑体>&nbsp;&nbsp;${m.key }</font></div>
	                    	<select id="${s.count }" name="myselect" style="display: none;width: 400px;height: 160px" id="${m.key }" multiple="multiple" >
                    			<c:forEach items="${m.value }" var="c">
								<option id="${c.id }" class="opt" value="${s.count }" ondblclick="selectContent(this)">${c.content }</option>
                    			</c:forEach>
                    		</select>
                    	</c:forEach>
                    	<!-- ************************************* -->
                    </td>
                    <td width="500px" height="300px">
	                    	<font face=黑体 size="3" color="purple">双击选入/移出考评项</font></br></br></br></br>
	                    	<select id="ifselect" style="width: 400px;height: 160px" id="" multiple="multiple"  >
                    		</select>
                    </td>
                    	
                    </tr>
                    </table>
                    	
                    	
                    	
					</fieldset></td>
				</tr>
               
              </table>
			    	<font color="purple">模板名称:</font><input type="text" name="name"/>
			    	<font color="purple">模板描述:</font><input type="text" name="description"/>
			    	<input type="submit" value="新建模板" onclick="return checkInfo(this.form)"/>
			    </form>
			    
			  </td>
              <td width="12"></td>
            </tr>
          </table>
          	<font face=宋体 size="2" color="purple">已有模板(点击预览)</font>
          	<table width="600px" class="mytbl" border="1px" bordercolor="pink" cellpadding="0" cellspacing="0" >
          		<tr>
          			<td width="50px">名称</td>
          			<td width="300px">描述</td>
          			<td width="100px">创建时间</td>
          			<td width="50px">启用模板</td>
          		</tr>
          		<c:forEach var="t" items="${templates }">
          		<tr>
          			<td><a id="a:${t.id }" href="#" onclick="showDetail(this)">${t.name }</a></td>
          			<td>${t.description }</td>
          			<td>${t.create_date }</td>
          			<td><input value="${t.id }" type="checkbox" <c:if test="${t.type==1 }">checked="checked"</c:if> onclick="changeType(this)"/></td>
          			
          		</tr>
          		</c:forEach>
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