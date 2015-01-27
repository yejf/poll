<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${project}</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>
	</head>
	<body>
		<table width="100%" height="1" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="100%" height="3"></td>
			</tr>
		</table>
		<table width="1024" border="0" align="center" cellpadding="0"
			cellspacing="0" class="BorderAllSolidFF99CC">
			<tr>
				<td width="1024" height="63" valign="top">
					<jsp:include page="../global/label/head.jsp" />
				</td>
			</tr>
			<tr>
				<td height="19" class="BorderTBSolidFF99CC" width="1024">
					<table align="center" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="12"></td>
							<td class="fontforwelcometd" width="500">
								<jsp:include page="../global/label/welcome.jsp" />
							</td>
							<td align="right" width="500">
								&nbsp;
							</td>
							<td width="12"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="1024" valign="top">
								<table width="100%" height="86%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="3"></td>
									</tr>
									<tr>
										<td width="12"></td>
										<td width="1000" align="left" class="fontforwelcometd">
											后台管理 —> 修改成功
										</td>
										<td width="12"></td>
									</tr>
									<tr>
										<td height="271">
											&nbsp;
										</td>
										<td align="center" valign="top" height="429">
											<table width="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td width="43%" height="50" align="center"
														class="BorderAllDottedBlack">
														恭喜您！密码修改成功&nbsp;&nbsp;
														<span id="numm" style="color: red">3</span>&nbsp;秒后自动转到首页.如果3秒后没有跳转，
														请
														<c:if test="${currentUser.type==0}">
															<a
																href="${pageContext.request.contextPath}/pm_poll_list.do">点击这里</a>&nbsp;进入首页!
														</c:if>
														<c:if test="${currentUser.type==1}">
															<a
																href="${pageContext.request.contextPath}/pmo_poll_unaudit.do">点击这里</a>&nbsp;进入首页!
														</c:if>
														<c:if test="${currentUser.type==8}">
															<a
																href="${pageContext.request.contextPath}/jd_activate_list.do">点击这里</a>&nbsp;进入首页!
														</c:if>
														<script language="javascript">
								var i=3;
								function showtext()
								{
								   var o=document.getElementById("numm");
								   if(i>0)
								   {
								   o.innerHTML=i;
								   i=i-1;
								  
								   window.setTimeout("showtext()",1000);
								   }
								}
								showtext();
							</script>
														<c:if test="${currentUser.type==0}">
															<script>setTimeout("window.location.href ='${pageContext.request.contextPath}/pm_poll_list.do';", 3000);</script>
														</c:if>
														<c:if test="${currentUser.type==1}">
															<script>setTimeout("window.location.href ='${pageContext.request.contextPath}/pmo_poll_unaudit.do';", 3000);</script>
														</c:if>
														<c:if test="${currentUser.type==8}">
															<script>setTimeout("window.location.href ='${pageContext.request.contextPath}/jd_activate_list.do';", 3000);</script>
														</c:if>
													</td>
												</tr>
											</table>
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="44" valign="top" class="BorderTSolidFF99CC">
					<jsp:include page="../global/label/foot.jsp" />
				</td>
			</tr>
		</table>
	</body>
</html>
