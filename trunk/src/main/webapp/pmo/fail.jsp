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
	<script language="javascript">
  		function goTo(){
  			window.location="${pageContext.request.contextPath }/pmo/poll_list.jsp";
  		}
  	</script>
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
        <td height="19" class="BorderTBSolidFF99CC" width="1024"><table align="center" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="12"></td>
              <td class="fontforwelcometd" width="500">&nbsp;</td>
              <td align="right" width="500">&nbsp;</td>
              <td width="12"></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
            <tr>
              <td width="1024" valign="top"><table width="100%" height="86%" border="0" align="center" cellpadding="0" cellspacing="0" >
                  <tr>
                    <td height="3"></td>
                  </tr>
                  <tr>
                    <td width="12"></td>
                    <td width="1000" align="left"></td>
                    <td width="12"></td>
                  </tr>
                  <tr>
                    <td height="271">&nbsp;</td>
                    <td align="center" valign="top" height="429">
					<table width="100%" height="93">
					<tr>
						<td width="157">&nbsp;</td>
					</tr>
					<tr>
					  <td>
					  <fieldset>
					  <legend><font color="red">^ 模板名称已存在</font></legend>
					  	<table width="100%">
								<tr>
									<td width="100%" align="center">${message}</td>
								</tr>
								<tr>
									&nbsp;
								</tr>
								<tr align="center">
									<td><input type="submit" onclick="goTo()" value="返回"></input></td>
								</tr>
						</table>
					  </fieldset>
					  </td>
					</tr>
				</table>
					</td>
                    <td>&nbsp;</td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
      </tr>
      <tr>
        <td height="44" valign="top" class="BorderTSolidFF99CC"><jsp:include page="../global/label/foot.jsp"/></td>
      </tr>
    </table>
</body>
</html>