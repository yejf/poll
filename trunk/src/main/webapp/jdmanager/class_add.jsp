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
						<td align="right" width="500"><jsp:include page="../global/label/jdt_operators.jsp" /></td>
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
					              <td width="1000" align="left" class="fontforwelcometd">后台管理 —> 新增班级</td>
					              <td width="12"></td>
					            </tr>
            					<tr>
					              <td height="271">&nbsp;</td>
					              <td align="center" valign="top" height="429">
			  						<form name="clasForm" method="post" action="${pageContext.request.contextPath}/jdt_class_add.do">
			  						  <table width="70%" border="0" cellpadding="0" cellspacing="0">
                                        <tr>
                                          <td colspan="2"><table width="100%" border="0" cellpadding="0" cellspacing="0" class="BorderAllSolid6699CC">
                                              <tr>
                                                <td width="37%" height="40" align="right" nowrap class="BorderBDotted6699CC">班级类型：</td>
                                                <td width="21%" align="left" nowrap class="BorderBDotted6699CC"><select name="classType" style="width:150px;height:20px;">
                                                    <option value="-1" selected>--请选择班级类型--</option>
                                                    <c:forEach var="ct" items="${types}">
                                                      <option value="${ct.typeName}">${ct.typeName}</option>
                                                    </c:forEach>
                                                </select></td>
                                                <td width="42%" nowrap class="BorderBDotted6699CC">&nbsp;</td>
                                              </tr>
                                              <tr>
                                                <td height="44" align="right" nowrap class="BorderBDotted6699CC">班级：</td>
                                                <td align="left" nowrap class="BorderBDotted6699CC"><input type="text" name="className" style="width:150px;height:15px;"></td>
                                                <td align="left" valign="middle" nowrap class="BorderBDotted6699CC">&nbsp;<font color="#FF0000">
                                                  <html:errors property="add_fail"/>
                                                </font></td>
                                              </tr>
                                              <tr>
                                                <td height="44" align="right" nowrap class="BorderBDotted6699CC">IP段：</td>
                                                <td align="left" nowrap class="BorderBDotted6699CC"><input type="text" name="classIP" style="width:150px;height:15px;"></td>
                                                <td align="left" valign="middle" nowrap class="BorderBDotted6699CC">&nbsp;如：192.168.1&nbsp;<font color="#FF0000">
                                                  <html:errors property="add_fail_ip"/>
                                                </font></td>
                                              </tr>
                                              <tr>
                                                <td height="76" align="right" >备注：</td>
                                                <td align="left"><textarea name="remark" rows="5" cols="15" style="width:150px;height:60px;"></textarea></td>
                                                <td>&nbsp;</td>
                                              </tr>
                                              <tr>
                                                <td height="12" align="right" ></td>
                                                <td align="right"><input type="submit" name="Submit" value="增&nbsp;加" onClick="return checkClassAdd(this.form);">
				     <input type="reset" name="reset" value="重&nbsp;置"></td>
                                                <td>&nbsp;</td>
                                              </tr>
                                          </table></td>
                                        </tr>
                                      </table>
			  						</form>			  </td>
              <td>&nbsp;</td>
            </tr>
          </table>		  </td>
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