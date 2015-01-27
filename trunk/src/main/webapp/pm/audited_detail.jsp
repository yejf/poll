<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${project}</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
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
				<td height="19" class="BorderTBSolidFF99CC" width="1025">
					<table align="center" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="12"></td>
							<td class="fontforwelcometd" width="500">
								<jsp:include page="../global/label/welcome.jsp" />
							</td>
							<td align="right" width="500">
								<jsp:include page="../global/label/pm_operators.jsp" />
							</td>
							<td width="12"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="388" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="1024" valign="top">
								<table width="100%" height="100%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="3"></td>
									</tr>
									<tr>
										<td width="12"></td>
										<td width="1000" align="left" class="fontforwelcometd">
											后台管理 —> 调查明细</td>
										<td width="12"></td>
									</tr>
									<tr>
										<td height="300">&nbsp;
											


										</td>
										<td align="center" valign="top">
											<form>
												<table width="100%" height="100%" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	概要信息
																</legend>
																<table width="100%">
																	<tr>
																		<td width="9%" align="right">
																			<strong>项目经理</strong>：
																		</td>
																		<td width="6%" align="left">
																			${audited.realName}
																		</td>
																		<td width="6%" align="right">
																			<strong>班级</strong>：
																		</td>
																		<td width="17%" align="left">
																			${audited.className}${audited.classType}
																		</td>
																		<td width="11%" align="right">
																			<strong>调查开始时间</strong>：
																		</td>
																		<td width="10%" align="left">
																			${audited.createdDate}
																		</td>
																		<td width="11%" align="right">
																			<strong>调查结束时间</strong>：
																		</td>
																		<td width="10%">
																			${audited.overDate}
																		</td>
																		<td width="8%" align="right">
																			<strong>审核时间</strong>：
																		</td>
																		<td width="12%" align="left">
																			${audited.checkedDate}
																		</td>
																	</tr>
																	<tr>
																		<td align="right">
																			<strong>状态</strong>：
																		</td>
																		<td align="left">
																			<font color="#FF0000">已审</font>
																		</td>
																		<td align="right">
																			<strong>总份数</strong>：
																		</td>
																		<td align="left">
																			${audited.amount}
																		</td>
																		<td align="right">
																			<strong>有效份数</strong>：
																		</td>
																		<td align="left">
																			${audited.validAmount}
																		</td>
																		<td align="right">
																			<strong>平均分数</strong>：
																		</td>
																		<td align="left">
																			${audited.avgScore}
																		</td>
																		<td>&nbsp;
																			

																		</td>
																		<td>&nbsp;
																			

																		</td>
																	</tr>
																</table>
															</fieldset>
														</td>
													</tr>
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	主要问题
																</legend>
																<table width="100%">
																	<c:if test="${empty pollLines}" var="isexit">
																		<tr>
																			<td width="13%" align="center" colspan="4">
																				<font color="red">没有找到相关主要问题</font>
																			</td>
																		</tr>
																	</c:if>
																	<c:forEach items="${pollLines}" var="pollLine"
																		varStatus="status">
																		<tr>
																			<td width="13%" align="right">
																				<strong>第${status.count}个问题</strong>
																			</td>
																			<td width="87%" align="left">
																				a.${pollLine.q1 }
																				<br>
																				b.${pollLine.q2}
																			</td>
																		</tr>
																	</c:forEach>
																</table>
															</fieldset>
														</td>
													</tr>
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	详细信息
																</legend>
																<table width="100%">
																	<c:if test="${empty pollLines}" var="isexit">
																		<tr>
																			<td width="13%" align="center" colspan="4">
																				<font color="red">没有找到相关调查详细信息</font>
																			</td>
																		</tr>
																	</c:if>
																	<c:forEach items="${pollLines}" var="pollLine">
																		<c:if test="${fn:trim(pollLine.isValid) == 'y'}">
																			<tr>
																				<td width="13%" align="right"></td>
																				<td align="left">
																					<table>
																						<tr>
																							<td width="${pollLine.avgScore*100}"
																								bgcolor="#AAAAFF" height="5"></td>
																						</tr>
																					</table>
																				</td>
																				<td width="12%" align="center">
																					平均分：${pollLine.avgScore}
																				</td>
																				<td width="17%" align="center">
																					<a onclick='window.showModalDialog("${pageContext.request.contextPath}/pm_poll_line_detail.do?pollLineId=${pollLine.id}",null,"dialogHeight:700px;dialogWidth:1100px;center:yes;help:no;resizable:no;status:no;")' target="_blank"><u>查看</u></a>
																				</td>
																			</tr>
																		</c:if>
																		<c:if test="${fn:trim(pollLine.isValid) == 'n'}">
																			<tr>
																				<td width="13%" align="right"></td>
																				<td align="left">
																					<table>
																						<tr>
																							<td width="${pollLine.avgScore*100}"
																								bgcolor="red" height="5"></td>
																						</tr>
																					</table>
																				</td>
																				<td width="12%" align="center">
																					平均分：${pollLine.avgScore}
																				</td>
																				<td width="17%" align="center">
																					<a onclick='window.showModalDialog("${pageContext.request.contextPath}/pm_poll_line_detail.do?pollLineId=${pollLine.id}",null,"dialogHeight:700px;dialogWidth:1100px;center:yes;help:no;resizable:no;status:no;")' target="_blank"><u>查看</u></a>
																				</td>
																			</tr>
																		</c:if>
																	</c:forEach>
																</table>
															</fieldset>
														</td>
													</tr>
												</table>
											</form>
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
