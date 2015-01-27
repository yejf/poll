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
	<script language="javascript">
		function checkName(info){
			if(info.pmName.value=="-1"){
				alert("请选择项目经理");
				info.focus();
				return false;
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
					              <td width="1000" align="left" class="fontforwelcometd">&nbsp&nbsp&nbsp后台管理 —> 重置密码</td>
					              <td width="12"></td>
					            </tr>
                                <tr>
                                	<td height="5"></td>
                                </tr>
            <tr>
              <td width="12"></td>
              <td align="center" valign="top" width="1000">
			  <form name="" method="post" action="${pageContext.request.contextPath}/passwd_reset.do" >
			  <table width="100%" border="0" cellpadding="0" cellspacing="0">

				<tr>
					<td colspan="2"><fieldset>
					<legend>重置密码</legend>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="40%" height="40"><div align="right">项目经理：</div></td>
                        <td width="14%">
						  <div align="left">
						    <select name="pmName" style="width:130px;height:20px;">
							    <option value="-1" selected>--请选择项目经理--</option>
							    <c:forEach items="${pmList}" var="pm">
							    	<c:if test="${pm.passwd=='password!'}">
							    	<option style='color:red' value="${pm.id}">${pm.realName}</option>
							    	</c:if>
							    	<c:if test="${pm.passwd!='password!'}">
							    	<option value="${pm.id}">${pm.realName}</option>
							    	</c:if>
							    </c:forEach>
                            </select>
						    </div></td>
                        
						<td>
						  <div align="left">
						    <input type="submit" name="Submit" value="重置" onClick="return checkName(this.form);">
						    </div></td>
					 </tr>
                    </table>
					</fieldset></td>
				</tr>
               
              </table>
			    </form>
			  </td>
              <td width="12"></td>
            </tr>
          </table>
		
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