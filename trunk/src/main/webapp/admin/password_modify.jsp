<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
 	<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
	<script language="javascript" src="${pageContext.request.contextPath}/resource/js/js.js"></script>
</head>
<body onLoad="document.forms.modifyPasswd.oldPassword.focus()">
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
						<td align="right" width="500">
							<c:if test="${currentUser.type==8}"><jsp:include page="../global/label/jdt_operators.jsp" /></c:if>
							<c:if test="${currentUser.type==1}"><jsp:include page="../global/label/pmo_operators.jsp" /></c:if>
							<c:if test="${currentUser.type==0}"><jsp:include page="../global/label/pm_operators.jsp" /></c:if>
						</td>
						<td width="12"></td>
					</tr>
				</table>
			</td>
    	</tr>
    	<tr>
      		<td valign="top">
      			<table width="100%" border="0" cellpadding="0" cellspacing="0">
        			<tr>
          				<td width="1024" valign="top">
          					<table width="100%" height="86%" border="0" align="center" cellpadding="0" cellspacing="0" >
								<tr>
									<td height="3"></td>
								</tr>
            					<tr>
					              <td width="12"></td>
					              <td width="1000" align="left" class="fontforwelcometd">后台管理 —> 修改密码</td>
					              <td width="12"></td>
					            </tr>
            					<tr>
					              <td height="271">&nbsp;</td>
					              <td align="center" valign="top" height="429">
			  						<blockquote>
			  						  <form name="modifyPasswd" method="post" action="${pageContext.request.contextPath}/passwd_modify.do">
			      <table width="95%" border="0" cellpadding="0" cellspacing="0">
                   
				<tr>
					    <td width="4%">&nbsp;</td>
					    <td colspan="2">&nbsp;</td>
				    </tr>
				    <tr>
					    <td colspan="3" align="center">
					      <table width="70%" border="0" cellpadding="0" cellspacing="0" class="BorderAllSolid6699CC">
                          <tr>
                            <td width="43%" height="50" align="right" nowrap class="BorderBDotted6699CC">原密码：</td>
                            <td width="16%" align="left" nowrap class="BorderBDotted6699CC"><input type="password" name="oldPassword" style="width:140px;height:15px;" value="" >
                            </td>
                            <td align="left" valign="middle" nowrap class="BorderBDotted6699CC">&nbsp;<font color="#FF0000"><html:errors property="oldPasswd"/></font></td>
                          </tr>
                          <tr>
                            <td height="46" align="right" nowrap class="BorderBDotted6699CC">新密码：</td>
                            <td align="left" nowrap class="BorderBDotted6699CC"><input type="password" name="newPassword" style="width:140px;height:15px;">
                            </td>
                            <td align="left" nowrap class="BorderBDotted6699CC">&nbsp;</td>
                          </tr>
                          <tr>
                            <td height="47" align="right">新密码确认：</td>
                            <td align="left"><input type="password" name="newPasswordConfim" style="width:140px;height:15px;">
                            </td>
                            <td align="left">&nbsp;</td>
                          </tr>
                          
                    </table></td>
				    </tr>
                    <tr>
                          <td >&nbsp;</td>
                          <td width="55%" align="right"><input type="submit" name="Submit" value="修&nbsp;改" onClick="return checkPasswordV(this.form);">
                              <input type="reset" name="reset" value="重&nbsp;置">
                          </td>
                          <td width="41%" align="right">&nbsp;</td>
                    </tr>
                  </table>
			    </form>
	  						      </blockquote></td>
              <td>&nbsp;</td>
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