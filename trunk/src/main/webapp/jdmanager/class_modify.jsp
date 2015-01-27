<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
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
	  <table width="100%" align="center" border="0" cellpadding="0" cellspacing="0">
	  	<tr>
			<td width="12"></td>
			<td width="500" class="fontforwelcometd"><jsp:include page="../global/label/welcome.jsp" /></td>
			<td width="500" align="right">
			      <jsp:include page="../global/label/jdt_operators.jsp" />
	           </td>
			<td width="12"></td>
		</tr>
	  </table>
	  </td>
    </tr>
    <tr>
      <td height="444" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="1024" height="436" valign="top">
		  <table width="100%" height="80%" border="0" align="center" cellpadding="0" cellspacing="0">
		  	<tr>
				<td height="3"></td>
			</tr>
            <tr>
               <td width="12"></td>
              <td width="500" align="left" class="fontforwelcometd">后台管理 —> 修改班级</td>
              <td width="500" align="right" class="fontforwelcometd">
			   <select name="select" OnChange="window.location=this.value">
				  	<option selected>--请选择要修改的班级--</option>
					<c:forEach items="${classList}" var="clazz">
						<option value="${pageContext.request.contextPath}/jdt_class_to_modify.do?classId=${clazz.id}">${clazz.className}</option>
					</c:forEach>
				  </select>
			  </td>
              <td width="12"></td>
            </tr>
			<tr>
				<td height="20"></td>
			</tr>
            <tr>
              <td width="12" height="384"></td>
              <td colspan="2" align="center" valign="top">
			  <form name="class_form" method="post" action="${pageContext.request.contextPath}/jdt_class_modify.do">
			  <table width="60%" border="0" cellpadding="0" cellspacing="0" >
                <tr>
                  <td colspan="2" align="left" ></td>
                  <td width="36%" colspan="2" align="right">
				 
				  </td>
                </tr>
				<c:if test="${empty clazzById}" var="isexit">
				<tr valign="middle">
					<td colspan="4" align="center" height="119" class="BorderAllSolid6699CC"><font color="red">！请选择要修改的班级</font></td>
				</tr>
				</c:if>
				<c:if test="${!isexit}">
				<tr>
					<td colspan="4">
					<table width="100%" border="0" cellpadding="0" cellspacing="0" class="BorderAllSolid6699CC">
                      <tr>
                        <td width="40%" height="40" align="right" nowrap class="BorderBDotted6699CC">班级类型：</td>
                        <td width="14%" align="left" nowrap class="BorderBDotted6699CC">
                            <select name="classType" style="width:150px;height:20px;">
							  	<option value="-1" selected>—请选择班级类型—</option>
							  	<c:forEach var="ct" items="${types}">
							    	<option value="${ct.typeName}" ${clazzById.classType == ct.typeName ?'selected':''}>${ct.typeName}</option>
							    </c:forEach>
								
                  			</select>
						</td>
                        <td width="46%" nowrap class="BorderBDotted6699CC">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="44" align="right" nowrap class="BorderBDotted6699CC">班级：</td>
                        <td align="left" nowrap class="BorderBDotted6699CC">
                          <input type="text" name="className" value="${clazzById.className}" style="width:150px;height:15px;"><input type="hidden" name="id" value="${clazzById.id}">
                        </td>
                        <td nowrap class="BorderBDotted6699CC"><font color="#FF0000"> <html:errors property="classname" /></font></td>
                      </tr>
					  <tr>
                        <td height="44" align="right" nowrap class="BorderBDotted6699CC">IP段：</td>
                        <td align="left" nowrap class="BorderBDotted6699CC">
                          <input type="text" name="classIP" value="${clazzById.classIP}" style="width:150px;height:15px;">
                        </td>
                        <td align="left" valign="middle" nowrap class="BorderBDotted6699CC">&nbsp;如：192.168.1<font color="#FF0000"> <html:errors property="classip" /></font></td>
                      </tr>
                      
                      <!-- add by yejf on 2009/10/14, 添加修改班级状态的选项 -->
                     <tr>
                     	<td height="44" align="right" nowrap class="BorderBDotted6699CC">毕业状态：</td>
                     	<td align="left" nowrap class="BorderBDotted6699CC">
                     		<input type="radio" name="status" value="0" ${clazzById.status == 0 ? 'checked':''}/>未毕业
                     		<input type="radio" name="status" value="1" ${clazzById.status == 1 ? 'checked':''}/>已毕业
                     	</td>
                     	<td></td>
                     </tr>
                     
                      <tr>
                        <td height="76" align="right">备注：</td>
                        <td align="left">
                          <textarea name="remark" rows="5" cols="15" style="width:150px;height:60px;">${clazzById.remark}</textarea>
                        </td>
                        <td></td>
                     </tr>
                     
                     <tr>
                        <td height="12" align="right"></td>
                        <td align="right">
                          <input type="submit" name="Submit" value="修&nbsp;改" onClick="return checkClassAdd(this.form);">
				     <input type="reset" name="reset" value="重&nbsp;置">                        </td>
                        <td></td>
                     </tr>
					 
                    </table>
					</td>
				</tr>
				 </c:if>
              </table>
			 
			 
			    </form>
				
			  </td>
              <td>&nbsp;</td>
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