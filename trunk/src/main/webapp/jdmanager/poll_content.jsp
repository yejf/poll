<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
	<title></title>
	<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/extremecomponents.css">
	<script>setTimeout('location.reload()',5000)</script>
	<script type="text/javascript">
	function endPoll(href){
		var returnVal = confirm('确实要关闭调查吗?');
		if(returnVal){
			var intPos = href.indexOf("?");
			var strRight = href.substr(intPos + 1);
			var arrTmp = strRight.split("=");
			var arrTemp = arrTmp[1];
			top.location.href="${pageContext.request.contextPath}/jdt_to_close_poll.do?clazzId="+arrTemp;
			return false;
		}else{
			return false;
		}	
	}
	function deletePoll(href){
		var returnVal = confirm('确实要删除调查吗?');
		if(returnVal){
			var intPos = href.indexOf("?");
			var strRight = href.substr(intPos + 1);
			var arrTmp = strRight.split("=");
			var arrTemp = arrTmp[1];
			top.location.href="${pageContext.request.contextPath}/jdt_to_delete_poll.do?clazzId="+arrTemp;
			return false;
		}else{
			return false;
		}
		
	}
	</script>

</head>
<body style="{margin:0;}"> 
<!--  
<ec:table items="class_poll_map" var="class_poll_map_entry" filterable="true"
		action="" imagePath="${pageContext.request.contextPath}/resource/images/table/*.gif"
		title="Polls" width="100%" rowsDisplayed="5"
		>
		<ec:exportXls fileName="Poll.xls" tooltip="Export Excel" />${class_poll_map_entry.value.clazz.className }
		<ec:row>
			<ec:column property="term" title="班级名">${class_poll_map_entry.value.clazz.className}</ec:column>
			<ec:column property="term" title="班级类型">${class_poll_map_entry.value.clazz.classType}</ec:column>
			<ec:column property="term" title="调查项目经理">${class_poll_map_entry.value.user.realName}</ec:column>
			<ec:column property="term" title="参与调查人数">${class_poll_map_entry.value.amount}</ec:column>
			<ec:column property="term" title="已提交调查人数">${class_poll_map_entry.value.valid_amount}</ec:column>
			<ec:column property="term" title="调查日期">${class_poll_map_entry.value.created_date}</ec:column>
			<ec:column property="term" title="操作" >
				<a
						href="javascript:if(confirm('确实要关闭调查吗?'))location='${pageContext.request.contextPath}/jdt_poll_modify.do?userId=${class_poll_map_entry.value.user.id}&clazzId=${class_poll_map_entry.value.clazz.id }'"
						class="pagenavlink">结束调查</a>
					<a
						href="javascript:if(confirm('确实要删除调查吗?'))location='${pageContext.request.contextPath}/jdt_poll_delete.do?userId=${class_poll_map_entry.value.user.id}&clazzId=${class_poll_map_entry.value.clazz.id }'"
						class="pagenavlink">删除调查</a>
		   </ec:column>
		</ec:row>
		
</ec:table>
-->
<table border="0" width="100%" cellspacing="0" cellpadding="0" id="tabletr">
	<c:if test="${empty class_poll_map}" var="isexit">
		<tr>
			<td colspan="9" align="center" class="odd" >
				<font color="red">如果没有你所要的班级请先增加班级，然后请选择班级和项目经理增加调查！</font>
			</td>
		</tr>
	</c:if>
	<c:if test="${!isexit}">
	<c:set var="i" value="2" />
		<c:forEach items="${class_poll_map}" var="class_poll_map_entry"
			varStatus="status">
			
			<c:if test="${class_poll_map_entry.value.status==110 }">
			<tr class="${i%2==0?'odd':'even'}">
				<td  width="4%" align="center">
					${status.count}
				</td>
				<td  width="7%" align="center">
					${class_poll_map_entry.value.clazz.className}
				</td>
				<td width="14%" align="left">
					${class_poll_map_entry.value.clazz.classType.typeName}
				</td>
				<td width="11%" align="left">
					${class_poll_map_entry.value.user.realName}
				</td>
				<td width="12%" align="right">
					${class_poll_map_entry.value.amount}
				</td>
				<td width="13%" align="right">
					${class_poll_map_entry.value.valid_amount}
				</td>
				<td width="12%" align="center">
					<fmt:formatDate value="${class_poll_map_entry.value.created_date}"
						type="both" dateStyle="full" timeStyle="full"
						pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td width="12%" align="center">
					${class_poll_map_entry.value.clazz.classIP}
				</td>
				<td width="15%" align="center">
					<a
						href="?clazzId=${class_poll_map_entry.value.clazz.id }"
						class="pagenavlink" onclick="return endPoll(href);">结束调查</a>
					<a
						href="?clazzId=${class_poll_map_entry.value.clazz.id }"
						class="pagenavlink" onclick="return deletePoll(href);">删除调查</a>
				</td>
			</tr>
			<c:set var="i" value="${i+1}" />
			</c:if>
		
		
		</c:forEach>
	</c:if>
</table>

</body>
</html>