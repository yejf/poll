<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

		<title>${project}</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
		<link
			href="${pageContext.request.contextPath}/resource/css/extremecomponents.css"
			rel="stylesheet" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>


	<script type="text/javascript">
		function checkClassAndPm(obj){
			if(obj.className.value=="-1"){
				alert("请选择班级");
				return false;
			}
			if(obj.realName.value=="-1"){
				alert("请选择教师");
				return false;
			}
			if(obj.templateName.value=="-1"){
				alert("请选择模板");
				return false;
			}
		}
		function showTemplate(obj){
			if(obj.templateName.value=="-1"){
				alert("请选择模板！");
				return false;
			}
			var id=obj.templateName.value;
			winOpen=window.open ('${pageContext.request.contextPath}/view_template.do?id='+id, 'showWin','scrollbars=yes,status=yes,width=600,height=300,top=220,left=280');
		}
			
	</script>
	</head>
	<body>
		<table width="100%" height="1" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="100%" height="1" ></td>
			</tr>
		</table>
		<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
			<tr>
				<td height="63" width="1024" valign="top">
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
							<td align="right" width="499">
								<jsp:include page="../global/label/jdt_operators.jsp" />
							</td>
							<td width="13"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top" width="1024">
					<table width="100%"  border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="1024"  valign="top">
								<table width="1024" height="86%" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td width="12"></td>
										<td width="1000"></td>
										<td width="12"></td>
									</tr>
									<tr>
										<td width="12"></td>
										<td align="center" valign="top" width="1000">
											<form name="form2" method="post" action="${pageContext.request.contextPath}/jdt_poll_add.do">
												<table width="100%" border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td height="3"></td>
													</tr>
													<tr>
														<td width="76%" height="19" align="left" class="fontforwelcometd">
															后台管理 —> 考评列表
														</td>
														<td width="15%">&nbsp;</td>
														<td width="9%">&nbsp;</td>
													</tr>
													<tr>
														<td height="20" align="right">
															<select name="className">
																<option value="-1" selected>
																	--请选择班级--
																</option>
																<c:forEach items="${classlists}" var="clazz">
																		<option value="${clazz.id}">
																			${clazz.className}
																		</option>
																</c:forEach>

															</select>
														</td>
														<td align="right">
															<select name="realName">
																<option value="-1" selected>
																	--请选择教员--
																</option>
																<c:forEach items="${pmList}" var="pm">
																	<option value="${pm.id}">
																		${pm.realName}
																	</option>
																</c:forEach>
															</select>
														</td>
														<td height="20" align="right">
															<select name="templateName">
																<option value="-1" selected>
																	--请选择模板--
																</option>
																
																<c:forEach items="${templates}" var="t">
																		<option value="${t.id}">
																			${t.name}
																		</option>
																</c:forEach>

															</select>
														</td>
														<td width="9%" align="right">
															<input type="button" value="模板预览" onclick="return showTemplate(this.form);">
														</td>
														
														<td width="9%" align="right">
															<input type="submit" value="增加调查" onclick="return checkClassAndPm(this.form);">
														</td>
													</tr>
													<tr>
														<td height="100%" colspan="3" valign="top">
															<table border="0" width="100%" cellspacing="0" cellpadding="0">
																<tr>
																	<th width="4%" height="23" align="center"
																		class="tableHeader">
																		编号
																	</th>
																	<th width="7%" align="center" class="tableHeader">
																		班级名
																	</th>
																	<th width="14%" align="center" class="tableHeader">
																		班级类型
																	</th>
																	<th width="11%" align="center" class="tableHeader">
																		调查教员名
																	</th>
																	<th width="12%" align="center" class="tableHeader">
																		参与调查人数
																	</th>
																	<th width="13%" align="center" class="tableHeader">
																		已提交调查人数
																	</th>
																	<th width="12%" align="center" class="tableHeader">
																		调查日期
																	</th>
																	<th width="12%" align="center" class="tableHeader">
																		调查班级IP段
																	</th>
																	<th width="15%" align="center" class="tableHeader">
																		操作
																	</th>
																</tr>
																<tr valign="top">
																	<td colspan="9" align="center" height="375">
																		<iframe id="iFrame1"
																			src="${pageContext.request.contextPath}/jdt_poll_show.do"
																			name="iFrame1" width="100%" scrolling="
																			no" frameborder="no" style="overflow:hidden"
																			onload="this.height=iFrame1.document.body.scrollHeight">
																		</iframe>
																	</td>
																</tr>
															</table>
														</td>
														<td width="0%">&nbsp;</td>
													</tr>
												</table>
											</form>
										</td>
										<td width="12"></td>
									</tr>
									<tr>
										<td height="5"></td>
										<td></td>
										<td></td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
						  <td width="1000" height="44" align="center" valign="top" class="BorderTSolidFF99CC"><jsp:include page="../global/label/foot.jsp"/></td>
						</tr>
					</table>
		</table>
	</body>
</html>
