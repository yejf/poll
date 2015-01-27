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
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>
	</head>
	<body>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="100%" height="1"></td>
			</tr>
		</table>
		<table width="1024" border="0" height="98%" align="center"
			cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
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
								<jsp:include page="../global/label/pm_operators.jsp" />
							</td>
							<td width="12"></td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td valign="top" height="390">
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						height="100%">
						<tr>
							<td width="1024" valign="top">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="3"></td>
									</tr>
									<tr>
										<td width="12"></td>
										<td width="1000" align="left" class="fontforwelcometd">
											后台管理 —> 考评结果
										</td>
										<td width="12"></td>
									</tr>
									<tr>
										<td height="100%">&nbsp;
											
										</td>
										<td align="center" valign="top">
											<form name="form2" method="post" action="">
												<table width="100%" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="95%" colspan="3" valign="top">
															<table border="0" width="100%" cellspacing="0"
																cellpadding="0">
																<tr>
																	<td width="12%" align="center">
																		<table width="100%" border="0" cellpadding="0"
																			cellspacing="0">
																			<tr>
																				<td height="3"></td>
																			</tr>

																			<tr>
																				<td height="100%" colspan="3" valign="top">
																					<table border="0" width="100%" cellspacing="0"
																						cellpadding="0">
																						<tr>
																							<th width="5%" height="23" align="center"
																								class="tableHeader">
																								编号
																							</th>
																							<th width="20%" align="center"
																								class="tableHeader">
																								班级名
																							</th>
																							<th width="12%" align="center"
																								class="tableHeader">
																								总份数
																							</th>
																							<th width="12%" align="center"
																								class="tableHeader">
																								有效份数
																							</th>
																							<th width="12%" align="center"
																								class="tableHeader">
																								调查日期
																							</th>
																							<th width="12%" align="center"
																								class="tableHeader">
																								结束日期
																							</th>
																							<th width="10%" align="center"
																								class="tableHeader">
																								平均分
																							</th>
																							<th width="17%" align="center"
																								class="tableHeader">
																								操作
																							</th>
																						</tr>
																						<c:if test="${empty pmPollList}" var="isexit">
																							<tr>
																								<td colspan="9" align="center" class="odd"
																									height="23">
																									<font color="red">您暂时还没有任何考评信息！</font>
																								</td>
																							</tr>
																						</c:if>
																						<c:if test="${isexit}">
																							<c:set var="i" value="2" />
																							<c:forEach items="${pmPollList}" var="statistics"
																								varStatus="status">
																								<tr class="${i%2==0?'odd':'even'}">
																									<td width="5%" align="center"
																										height="23">
																										${status.count}
																									</td>
																									<td width="25%" align="left">
																										${statistics.clazz.className}${statistics.clazz.classType.typeName}
																									</td>
																									<td width="10%" align="right">
																										${statistics.amount}
																									</td>
																									<td width="10%" align="right">
																										${statistics.validAmount}
																									</td>
																									<td width="15%" align="center">
																										<fmt:formatDate
																											value="${statistics.createdDate}" type="both"
																											dateStyle="full" timeStyle="full"
																											pattern="yyyy-MM-dd HH:mm" />
																									</td>
																									<td width="15%" align="center">
																										<fmt:formatDate value="${statistics.overDate}"
																											type="both" dateStyle="full" timeStyle="full"
																											pattern="yyyy-MM-dd HH:mm" />
																									</td>
																									<td width="5%" align="right">
																										${statistics.avgScore}
																									</td>
																									<td width="10%" align="center">
																										<a
																											href="${pageContext.request.contextPath}/pm_poll_audited.do?pollId=${statistics.pollId}">明细</a>
																									</td>
																								</tr>
																								<c:set var="i" value="${i+1}" />
																							</c:forEach>
																						</c:if>
																					</table>
																				</td>
																				
																			</tr>
																		</table>
																</tr>
															</table>
														</td>
													</tr>
												</table>
											</form>
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
			<tr>
				<td height="44" valign="top" class="BorderTSolidFF99CC">
					<jsp:include page="../global/label/foot.jsp" />
				</td>
			</tr>
		</table>
	</body>
</html>
