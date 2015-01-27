<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
 	<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" height="1" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="100%" height="3" ></td>
	</tr>
	</table>
	<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
	    <tr>
	    	<td width="1024" height="63" valign="top"><jsp:include page="../global/label/head.jsp"/></td>
	    </tr>
    	<tr>
    		<td height="19" class="BorderTBSolidFF99CC" width="1024">
				<table align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="12"></td>
						<td class="fontforwelcometd" width="500"><jsp:include page="../global/label/welcome.jsp" /></td>
						<td align="right" width="500"><jsp:include page="../global/label/pmo_operators.jsp" /></td>
						<td width="12"></td>
					</tr>
				</table>
			</td>
    	</tr>
    	<tr>
				<td height="400" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" height="442">
						<tr>
							<td width="1024" height="439" valign="top">
								<table width="100%" height="81%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="12"></td>
									<td height="19" align="left" class="fontforwelcometd">
										后台管理 —> 按月统计
									</td>
									<td width="12"></td>
								</tr>
								<tr>
										<td height="315">&nbsp;
											
										</td>
										<td align="center" valign="top">
											<form name="statistics_form" method="post" action="${pageContext.request.contextPath}/pmo_poll_query_m.do">
												<table width="100%" height="207" border="0" cellpadding="0"
													cellspacing="0">
													
													<tr>
														<td height="46" align="center">
															<fieldset><legend>月报表查询</legend>
																<table width="100%" height="27" border="0">
																	<tbody align="center">
																		<tr>
																			<td width="43%" height="23" align="right">
																				请选择日期：
																			</td>
																			<td width="6%">
																				<select name="year">
																					<option value="2014" ${year=='2014'?'selected':''}>
																						2014
																					</option>
																					<option value="2015" ${year=='2015'?'selected':''}>
																						2015
																					</option>
																					<option value="2016" ${year=='2016'?'selected':''}>
																						2016
																					</option>
																				</select>
																			</td>
																			<td width="2%" align="left">年</td>
																			<td width="5%">
																				<select name="month">
																					<option value="1" ${month=='1'?'selected':''}>
																						01
																					</option>
																					<option value="2" ${month=='2'?'selected':''}>
																						02
																					</option>
																					<option value="3" ${month=='3'?'selected':''}>
																						03
																					</option>
																					<option value="4" ${month=='4'?'selected':''}>
																						04
																					</option>
																					<option value="5" ${month=='5'?'selected':''}>
																						05
																					</option>
																					<option value="6" ${month=='6'?'selected':''}>
																						06
																					</option>
																					<option value="7" ${month=='7'?'selected':''}>
																						07
																					</option>
																					<option value="8" ${month=='8'?'selected':''}>
																						08
																					</option>
																					<option value="9" ${month=='9'?'selected':''}>
																						09
																					</option>
																					<option value="10" ${month=='10'?'selected':''}>
																						10
																					</option>
																					<option value="11" ${month=='11'?'selected':''}>
																						11
																					</option>
																					<option value="12" ${month=='12'?'selected':''}>
																						12
																					</option>
																				</select>
																			</td>
																			<td width="3%" align="left">
																					月
																			</td>
																			
																			<td width="26%" align="left">
																				<input type="submit" name="Submit" value="查&nbsp;询">
																		  </td>
																			<td width="15%"></td>
																		</tr>
																	</tbody>
															</table>
															</fieldset>
													  </td>
													</tr>
													<tr>
														<td height="19" align="center">
																天智教育(苏州) 学员评教反馈
																<FONT color=#ff0000><B>${year }</B>
																</FONT> 年
																<FONT color=#ff0000><B>${month }</B>
																</FONT> 月份统计表 
														</td>
													</tr>
													<c:if test="${empty groupByPM}" var="isexit">
													<tr>
														<td height="19" colspan="7" align="center" class="odd"><font color="#FF0000">${year}年&nbsp;${month}没有相关课程调查统计信息</font></td>
													</tr>
													</c:if>
													<c:if test="${!isexit}">
													<c:forEach items="${groupByPM}" var="gropMap">
													<tr>
														<td height="118">
															<table width="100%" border="0" cellpadding="0" cellspacing="0">
																<tr>
																	<td align="center" class="tableHeader">序号</td>
																	<td align="center" class="tableHeader">教员</td>
																	<td align="center" class="tableHeader">班级</td>
																	<td align="center" class="tableHeader">总份数</td>
																	<td align="center" class="tableHeader">有效份数</td>
																	<td align="center" class="tableHeader">平均分数</td>
																	<td align="center" class="tableHeader">调查时间</td>
																</tr>
																<c:set var="i" value="2" />
																<c:forEach items="${gropMap.value}" var="statistics" varStatus="status">
																<tr class="${i%2==0?'odd':'even'}">
																	<td align="center" >${status.count}</td>
																	<td >${statistics.user.realName}</td>
																	<td align="center">${statistics.clazz.className}${statistics.clazz.classType.typeName}</td>
																	<td align="right">${statistics.amount}</td>
																	<td align="right">${statistics.valid_amount}</td>
																	<td align="right">${statistics.avg_score}</td>
																	<td align="center"><fmt:formatDate value="${statistics.created_date}" type="both" dateStyle="full" timeStyle="full" pattern="yyyy-MM-dd HH:mm"/></td>
																</tr>
																<c:set var="i" value="${i+1}" />
																<c:set var="scoreAll" value="${statistics.avg_score+scoreAll}"/>
																<c:set var="count" value="${status.count}"/>
																<c:set var="avg" value="${scoreAll/count}" />
																<c:if test="${status.last}">
																	<c:set var="scoreAll" value="0"/>
																</c:if>
																</c:forEach>
																<tr>
																	<td colspan="6" align="right">教&nbsp;员：${gropMap.key}</td>
																	<td align="right">月平均分：<fmt:formatNumber value="${avg}" pattern="#.0" type="number"/></td>
																</tr>
															</table>
															<hr />
														</td>
													</tr>
													</c:forEach>
													</c:if>
											  </table>
											</form>
										</td>
										<td width="12"></td>
								  </tr>
							  </table>

						  </td>
						</tr>
				  </table>
		  </td>
	  </tr>
    <tr>
      <td height="44" valign="top" class="BorderTSolidFF99CC"><jsp:include page="../global/label/foot.jsp"/></td>
    </tr>
  </table>
</body>
</html>