<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>

  </head>
  
  <body>
  	<script language="javascript">
  		 window.onload=function(){
			var str=document.getElementById("hidden").value;
			str=unescape(unescape(str)).trim();
			var text=document.getElementById("text");
			text.value=str;
  		}; 
  		
  		function goTo(){
			var value=document.getElementById("text").value;
			if(value.trim()==""){
  				alert("请输入内容");
  				return false;
  			}
			document.getElementById("modifyForm").submit();
			window.opener.location.reload();
			window.close();  
			
  		}
  		
  		
  	</script>
	<form id="modifyForm" action="${pageContext.request.contextPath}/pmo/modifycontent" method="post">
  	<input id="text" name="content" type="text" value="" />
  	<input id="hidden" type="hidden" value="${param.text }" /> 
  	<input id="contentId" name="contentId" type="hidden" value="${param.id }" /> 
  	<input type="button" value="确认修改" onclick="return goTo()"/>
	</form>
  </body>
</html>
