<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>调查明细</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
		<script language="javascript" src="${pageContext.request.contextPath}/resource/js/js.js"></script>
	</head>
	<body>
		<form name="form1" method="post"
			action="${pageContext.request.contextPath}/poll_submit.do">
			<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
				<tr>
					<td height="19" align="center" valign="middle">
						<font size="+2">调查明细</font>
					</td>
				</tr>
				<tr>
					<td height="542" valign="top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" class="BorderTBSolidFF99CC">
							<tr>
								<td width="1024" height="542" valign="top">
									<table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
										<tr>
											<td width="12" height="30"></td>
											<td width="1000"></td>
											<td width="12"></td>
										</tr>
										<tr>
											<td height="479"></td>
											<td align="center" valign="top">
												<table width="100%" height="702" border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="955" height="170" valign="top" align="center">
																<table width="95%" border="0" cellpadding="0"
																	cellspacing="0">
																	
																	
																	
																	<!-- ****************************** -->
																	<tr>
																		<td colspan="7" align="left" class="tableHeader1">
																			对教员 各项评审的得分
																		</td>
																	</tr>
																	<tr>
																		<td width="4%" class="odd">&nbsp;</td>
																		<td width="46%" class="odd">&nbsp;</td>
																		<td width="10%" align="center" class="odd">
																			很满意
																		</td>
																		<td width="10%" align="center" class="odd">
																			比较满意
																		</td>
																		<td width="10%" align="center" class="odd">
																			较好
																		</td>
																		<td width="10%" align="center" class="odd">
																			还行
																		</td>
																		<td width="10%" align="center" class="odd">
																			一般
																		</td>
																	</tr>
																	<c:forEach var="v1" items="${items}" varStatus="vkey">
																		<tr>
																			<td align="center" class="odd">
																				${vkey.count}
																			</td>
																		
																			<td align="left" class="odd">
																				${v1.key}
																			</td>
																			<c:set var="attr" value="c${vkey.count}"></c:set>
																			<td align="center" class="odd">
																				<input type="radio" name="c${vkey.count}" value="5" ${v1.value==5?'checked':''}>
																				5
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${vkey.count}" value="4" ${v1.value==4?'checked':''}>
																				4
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${vkey.count}" value="3" ${v1.value==3?'checked':''}>
																				3
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${vkey.count}" value="2" ${v1.value==2?'checked':''}>
																				2
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${vkey.count}" value="1" ${v1.value==1?'checked':''}>
																				1
																			</td>
																		</tr>
																	</c:forEach>
																	<!-- 第一部份迭代完成 -->
																	
																	
																	<tr>
																		<td colspan="7">&nbsp;</td>
																	</tr>
																	<!-- ****************************** -->
																	<c:forEach items="${questions}" var="q" varStatus="a">
																	<tr>
																		<td colspan="7" class="tableHeader1">
																			${q.key }
																		</td>
																	</tr>
																	<tr>
																		<td colspan="7">
																			<textarea name="q1" rows="4" cols="120">${q.value}</textarea>
																		</td>
																	</tr>
																	</c:forEach>
																</table>
														</td>
													</tr>
											  </table>
											</td>
											<td>&nbsp;
												
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
