<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>OceanSoft Poll</title>
		<link rel="shortcut icon"
			href="${pageContext.request.contextPath}/resource/images/TICK.ICO">
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>
		<script language="javascript">
		function checkinput(){
	    	if(!isEmpty(document.login_form.loginName,1,20,'您输入的用户名不能为空')){
	    		return false;
	    	}
	    	if(!isEmpty(document.login_form.password,1,20,"您输入的密码不能为空")){
	    		return false;
	    	}
	    }
	    function onloadFoucs(){
	    
	    	<c:if test="${empty name}" var="isexit">
	    		document.forms.login_form.loginName.focus();
	    	</c:if>
	    	<c:if test="${!isexit}">
	    		document.forms.login_form.password.focus();
	    	</c:if>
	    }
	</script>
	</head>
	<body onLoad="onloadFoucs()">
		<form name="login_form" method="post"
			action="${pageContext.request.contextPath}/login.do">
			<table width="100%" height="95%" border="0">
				<tr>
					<td>&nbsp;
						
					</td>
					<td width="605">&nbsp;
						
				  </td>
					<td>&nbsp;
						
				  </td>
				</tr>
				<tr>
					<td>&nbsp;
						
					</td>
					<td width="605" height="204" align="center"
						class="BorderBSolidFF99CC">
						<table width="100%" height="100%" border="0" align="center"
							background="${pageContext.request.contextPath}/resource/images/admin-login-back.png">
							<tr>
								<td width="25%" height="90">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
							</tr>
							<c:if test="${empty currentUser}" >
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								
								<td width="25%" align="right">
									用户名：
								</td>
								<td width="25%" align="right">
									<input type="text" name="loginName" value="${name }"
										style="width: 140px; height: 20px;">
								</td>
								<td width="35%">
									&nbsp;&nbsp;
									<font color="#FF0000"><html:errors property="loginname" />
									</font>
								</td>
							</tr>
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%" align="right">
									密&nbsp;&nbsp;码：
								</td>
								<td width="25%" align="right">
									<input type="password" name="password"
										style="width: 140px; height: 20px;">
								</td>
								<td width="25%">
									&nbsp;&nbsp;
									<font color="#FF0000"><html:errors property="password" />
									</font>
								</td>
							</tr>
							
							
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%" align="right">
									<input onClick="return checkinput();" type=image width="57"
										height="18"
										src="${pageContext.request.contextPath}/resource/images/tarena_poll_login.jpg"
										name=login>
									&nbsp;
									<input onClick="this.form.reset();return false;" type=image
										width="57" height="18"
										src="${pageContext.request.contextPath}/resource/images/tarena_poll_reset.jpg"
										name=reset>
								</td>
								<td width="25%">&nbsp;
									
								</td>
							</tr>
							</c:if>
							<c:if test="${!empty currentUser}" >
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%" align="center" colspan="2">
									<font color="#B4045F">${currentUser.name}&nbsp;</font>
						
									<font color="#B4045F">您已登陆本系统</font>
								</td>
								<td width="25%">
									
								</td>
							</tr>
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%" align="center" colspan="2">
									<font color="#B4045F">请确认操作</font>
								
								<font color="#B4045F">
									<a href="javascript:history.go(-1)">返回</a>
									&nbsp;
									或
									&nbsp;
									<a href="${pageContext.request.contextPath}/logout.do">退出</a>
								</font>
								</td>
								<td width="25%">&nbsp;
									
								</td>
								
							</tr>
							</c:if>
							<tr>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
								<td width="25%">&nbsp;
									
								</td>
							</tr>
						</table>
					</td>
					<td>&nbsp;
						
					</td>
				</tr>
				<tr>
					<td>&nbsp;
						
					</td>
					<td align="right" valign="top">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td rowspan="2" align="center" valign="middle">&nbsp;
									
								</td>
								<td rowspan="2" align="center" valign="middle"
									class="BorderRDottedFF99CC">
									<img
										src="${pageContext.request.contextPath}/resource/images/tarena_poll_logo.jpg"
										width="107" height="64" />
								</td>
								<td height="22" align="right">
									<span class="STYLE3"><a href="http://www.sz-tz.org">天创集团(中国)
											版权所有</a>
									</span>
								</td>
							</tr>
							<tr>
								<td height="22" align="right">
									<span class="STYLE1">TianZhi EDU POLL | 在线考评系统 | 2006-2012 </span>
								</td>
							</tr>
						</table>
					</td>
					<td>&nbsp;
						
					</td>
				</tr>
				<tr>
					<td>&nbsp;
						
					</td>
					<td>&nbsp;
						
				  </td>
					<td>&nbsp;
						
				  </td>
				</tr>
			</table>
		</form>
	</body>
</html>
