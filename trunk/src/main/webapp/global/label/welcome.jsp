<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<table width="100%">
	<c:if test="${currentUser.type==0}">
		<tr>
			<td align="left">
				欢迎您！${currentUser.name }&nbsp;【${currentUser.description }】
			</td>
		</tr>
	</c:if>

	<c:if test="${currentUser.type==1}">
		<tr>
			<td align="left">
				欢迎您！${currentUser.name }&nbsp;【${currentUser.realName }】
			</td>
		</tr>
	</c:if>
	
	<c:if test="${currentUser.type==8}">
		<tr>
			<td align="left">
				欢迎您！${currentUser.name }&nbsp;【${currentUser.realName }】
			</td>
		</tr>
	</c:if>

</table>
