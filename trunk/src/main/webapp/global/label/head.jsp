<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table width="1024" border="0" cellpadding="0" cellspacing="0">
	<tr>
	  <td width="100%" height="100" valign="top">
		<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="15%" align="center" align="left">
              	<c:if test="${!empty currentUser}" var="isexit">
              	<a href="${pageContext.request.contextPath}/admin"><img src="${pageContext.request.contextPath}/resource/images/tarena_poll_logo.jpg"  border="0"></a>
             	</c:if>
             	<c:if test="${!isexit}">
              	<img src="${pageContext.request.contextPath}/resource/images/tarena_poll_logo.jpg" border="0">
             	</c:if>
              </td>
              <td width="38%"><div align="center"><img src="${pageContext.request.contextPath}/resource/images/tarena_poll_company.jpg" width="348" height="37"></div></td>
              <td width="25%" align="center"><div align="right"><img src="${pageContext.request.contextPath}/resource/images/tarena_poll_top.jpg" width="229" height="49" ></div></td>
              <td width="22%"><table width="100%" height="59">
			  	<tr>
					<td width="20%">&nbsp;</td>
					<td width="80%">&nbsp;</td>
				</tr>
				<tr>
					<td height="24">&nbsp;</td>
					<c:if test="${!empty currentUser}" var="isexit">
					<td align="right">
						<a href="${pageContext.request.contextPath}/logout.do" title="退出系统"><img src="${pageContext.request.contextPath}/resource/images/close.jpg" width="112" height="28" border="0">
						</a>
					</td>
					</c:if>
					
				</tr>
			  </table></td>
			</tr>
        </table>
	  </td>
	</tr>
</table>
