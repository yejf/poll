<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath}/jquery-1.7.2.min.js"  type="text/javascript"></script>
	<script language="javascript">
		function checkName(info){
			if(info.addtype.value==""){
				alert("输入不能为空");
				//info.focus();
				return false;
			}
		}
		function goAdd(){
			window.location="${pageContext.request.contextPath }/pmo/add_teacher.jsp";
		}
		function deleteT(id){
		  var c=confirm("确认删除吗?");
		  if(c){
		  	$("a").attr("href","${pageContext.request.contextPath }/delete_teacher.do?id="+id );
		  }else{
		  	$("a").attr("href","#" );
		  }
		}
	</script>
</head>
<body>
<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
    <tr>
      <td width="1024" height="100" valign="top"><jsp:include page="../global/label/head.jsp"/></td>
    </tr>
    <tr>
      <td height="19" class="BorderTBSolidFF99CC">
	  <table width="100%" align="center" border="0">
	  	<tr>
			<td width="12"></td>
			<td width="500" class="fontforwelcometd"><jsp:include page="../global/label/welcome.jsp" /></td>
			<td width="500" align="right">
			      <jsp:include page="../global/label/pmo_operators.jsp" />
	           </td>
			<td width="12"></td>
		</tr>
	  </table>
	  </td>
    </tr>
    <tr>
      <td height="410" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="1024" valign="top"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
									<td height="3"></td>
								</tr>
            					<tr>
					              <td width="12"></td>
					              <td width="1000" align="left" class="fontforwelcometd">&nbsp&nbsp&nbsp后台管理 —> 教师管理</td>
					              <td width="12"></td>
					            </tr>
                                <tr>
                                	<td height="5"></td>
                                </tr>
            <tr>
              <td width="12"></td>
              <td align="center" valign="top" width="600">
			  <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="pink">
               	<tr>
               		<th width="150">用户名</th>
               		<th width="150">真实姓名</th>
               		<th width="200">职位</th>
               		<th width="400">邮箱</th>
               		<th width="100">操作</th>
               	</tr>
               	<c:forEach items="${users }" var="u">
               		<tr>
               			<td align="center">${u.name }</td>
               			<td align="center">${u.realName }</td>
               			<td align="center">${u.description }</td>
               			<td align="center">${u.email }</td>
               			<td align="center"><a href='' onclick="deleteT(${u.id})" >删除</a></td>
               		</tr>
               	</c:forEach>
               		
               		
               	
              </table>
			  </td>
            </tr>
          </table>
              &nbsp;&nbsp;<input type="button" value="新增" onclick="return goAdd()"/>
		
		  </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="44" valign="top" class="BorderTSolidFF99CC"><jsp:include page="../global/label/foot.jsp"/></td>
    </tr>
  </table>
</body>
</html>