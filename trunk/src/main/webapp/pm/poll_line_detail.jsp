<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>调查明细</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>
	</head>
	<body>
		<form name="form1" method="post"
			action="${pageContext.request.contextPath}/poll_submit.do">
			<table width="1024" border="0" align="center" cellpadding="0"
				cellspacing="0" class="BorderAllSolidFF99CC">
				<tr>
					<td height="19" align="center" valign="middle">
						<font size="+2">调查明细</font>
					</td>
				</tr>
				<tr>
					<td height="542" valign="top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="BorderTBSolidFF99CC">
							<tr>
								<td width="1024" height="542" valign="top">
									<table width="100%" height="100%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td width="12" height="30"></td>
											<td width="1000"></td>
											<td width="12"></td>
										</tr>
										<tr>
											<td height="479"></td>
											<td align="center" valign="top">
												<table width="100%" height="702" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td width="955" height="170" valign="top" align="center">
															<table width="95%" border="0" cellpadding="0"
																cellspacing="0">
																<tr>
																	<td colspan="7" align="left" class="tableHeader1">
																		对教员 授课实施的评审
																	</td>
																</tr>
																<tr>
																	<td width="4%" class="odd">
																		&nbsp;
																	</td>
																	<td width="46%" class="odd">
																		&nbsp;
																	</td>
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
																<c:forEach var="v1" items="${_SKILLS}" varStatus="vkey">
																	<tr>
																		<td align="center" class="odd">
																			${vkey.count}
																		</td>

																		<td align="left" class="odd">
																			${v1.value}
																		</td>
																		<c:set var="attr" value="c${vkey.count}"></c:set>
																		<td align="center" class="odd">
																			<input type="radio" name="c${vkey.count}" value="5"
																				${pollLine[attr]==5?'checked':''}>
																			5
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="c${vkey.count}" value="4"
																				${pollLine[attr]==4?'checked':''}>
																			4
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="c${vkey.count}" value="3"
																				${pollLine[attr]==3?'checked':''}>
																			3
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="c${vkey.count}" value="2"
																				${pollLine[attr]==2?'checked':''}>
																			2
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="c${vkey.count}" value="1"
																				${pollLine[attr]==1?'checked':''}>
																			1
																		</td>
																	</tr>
																</c:forEach>
																<!-- 第一部份迭代完成 -->

																<tr>
																	<td colspan="7">
																		&nbsp;

																	</td>
																</tr>
																<tr>
																	<td colspan="7" align="left" class="tableHeader1">
																		对教员 学习管理的评审
																	</td>
																</tr>
																<c:forEach var="v2" items="${_SERVICES}"
																	varStatus="vkey2">
																	<tr>
																		<td width="4%" align="center" class="odd">
																			${vkey2.count}
																		</td>
																		<td align="left" width="46%" class="odd">
																			${v2.value}
																		</td>
																		<c:set var="attr2" value="s${vkey2.count}"></c:set>
																		<td width="10%" align="center" class="odd">
																			<input type="radio" name="s${vkey2.count}" value="5"
																				${pollLine[attr2]==5?'checked':''}>
																			5
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="s${vkey2.count}" value="4"
																				${pollLine[attr2]==4?'checked':''}>
																			4
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="s${vkey2.count}" value="3"
																				${pollLine[attr2]==3?'checked':''}>
																			3
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="s${vkey2.count}" value="2"
																				${pollLine[attr2]==2?'checked':''}>
																			2
																		</td>
																		<td align="center" class="odd">
																			<input type="radio" name="s${vkey2.count}" value="1"
																				${pollLine[attr2]==1?'checked':''}>
																			1
																		</td>
																	</tr>
																</c:forEach>
																<!-- 第二部份迭代完成 -->
																<tr>
																	<td colspan="7">
																		&nbsp;
																	</td>
																</tr>
																<tr>
																	<td colspan="7" class="tableHeader1">
																		对老师授课过程的建议
																	</td>
																</tr>
																<tr>
																	<td colspan="7">
																		<textarea name="q1" rows="4" cols="120">${pollLine.q1}</textarea>
																	</td>
																</tr>
																<tr>
																	<td colspan="7" class="tableHeader1">
																		对本班级管理的建议
																	</td>
																</tr>
																<tr valign="middle">
																	<td colspan="7">
																		<textarea name="q2" rows="4" cols="120">${pollLine.q2}</textarea>
																	</td>
																</tr>
															</table>
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
			</table>
		</form>
	</body>
</html>
