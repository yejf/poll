<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/WEB-INF/extremecomponents.tld" prefix="ec" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
 	<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/extremecomponents.css">
	<script language="Javascript" type="text/javascript" src="${pageContext.request.contextPath}/resource/js/extremecomponents.js"></script>
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
      		<td valign="top">
      			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
								<td height="5"></td>
					</tr>
					<tr>
					              <td width="12"></td>
					              <td width="1000" align="left" class="fontforwelcometd">后台管理 —> 已审查询</td>
					              <td width="12"></td>
					            </tr>
        			<tr>
						<td height="445" width="12"></td>
          				<td width="1024" valign="top">
          					<table width="100%" height="99" border="0" cellpadding="0" cellspacing="0">
							
							<tr>
														<td>
															<ec:table items="pollList" var="statistic" filterable="true" action="" imagePath="${pageContext.request.contextPath}/resource/images/table/*.gif" width="100%" rowsDisplayed="5" >
																	<ec:exportXls fileName="Poll.xls" tooltip="Export Excel" />${class_poll_map_entry.value.clazz.className }
																	<ec:row>
																		<ec:column property="className" title="班&nbsp;&nbsp;级" style="text-align:left;">${statistic.clazz.className}</ec:column>
																		<ec:column property="classType" title="类&nbsp;&nbsp;&nbsp;&nbsp;型" style="text-align:left;">${statistic.clazz.classType.typeName}</ec:column>
																		<ec:column property="realName" title="调&nbsp;查&nbsp;教&nbsp;员" style="text-align:left;">${statistic.user.realName}</ec:column>
																		<ec:column property="amount" title="总&nbsp;份&nbsp;数" style="text-align:right;">${statistic.amount}</ec:column>
																		<ec:column property="validAmount" title="有&nbsp;效&nbsp;份&nbsp;数" style="text-align:right">${statistic.valid_amount}</ec:column>
																		<ec:column property="avgScore" title="平&nbsp;均&nbsp;分&nbsp;数" style="text-align:right">${statistic.avg_score}</ec:column>
																		<ec:column property="createdDate" title="调&nbsp;查&nbsp;日&nbsp;期" format="yyyy-MM-dd hh" style="text-align:center">${statistic.created_date}</ec:column>
																		<ec:column property="term" title="操&nbsp;&nbsp;作" filterable="false">
																			<a href="${pageContext.request.contextPath}/pmo_poll_audited.do?pollId=${statistic.id}" class="pagenavlink">明细</a>
																	   </ec:column>
																	</ec:row>
															</ec:table>
														</td>
														
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