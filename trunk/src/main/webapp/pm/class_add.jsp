<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
 <link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
</head>
<body>
<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolid3399CC">
    <tr>
      <td width="1024" height="100" valign="top"><jsp:include page="../global/label/head.jsp"/></td>
    </tr>
    <tr>
      <td height="19" class="BorderTBSolidBlack">
	  <table width="100%" align="center" border="0">
	  	<tr>
			<td width="42">&nbsp;</td>
			<td width="470"><jsp:include page="../global/label/welcome.jsp" /></td>
			<td width="452" align="right">
			      <jsp:include page="../global/label/pm_operators.jsp" />
	           </td>
			<td width="38">&nbsp;</td>
		</tr>
	  </table>
	  </td>
    </tr>
    <tr>
      <td height="542" valign="top"><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr>
          <td width="1024" height="542" valign="top"><table width="100%" height="100%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="2%" height="30">&nbsp;</td>
              <td width="96%">&nbsp;</td>
              <td width="2%">&nbsp;</td>
            </tr>
            <tr>
              <td height="479">&nbsp;</td>
              <td align="center" valign="top">
			  <form name="" method="post" action="${pageContext.request.contextPath}/pm_class_add.do">
			  <table width="95%" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td><div align="left" class="pagenav1">后台管理　－＞ 班级管理 －＞ 新增班级 </div></td>
                  <td><div align="right"></div></td>
                </tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td colspan="2"><fieldset><legend>新增班级</legend>
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
                      <tr>
                        <td width="40%" height="40"><div align="right">班级类型：</div></td>
                        <td width="14%">
						  <div align="left">
						    <select name="select" style="width:150px;height:20px;">
							    <option value="" selected>—请选择班级类型—</option>
							    <option value="">JAVA软件工程师</option>
							    <option value="">.net软件工程师</option>
                            </select>
						    </div></td>
                        <td width="46%">&nbsp;</td>
                      </tr>
                      <tr>
                        <td height="44"><div align="right">班级：</div></td>
                        <td><div align="left">
                          <input type="text" name="textfield" style="width:150px;height:15px;">
                        </div></td>
                        <td>&nbsp;</td>
                      </tr>
					  <tr>
                        <td height="44"><div align="right">IP段：</div></td>
                        <td><div align="left">
                          <input type="text" name="textfield" style="width:150px;height:15px;">
                        </div></td>
                        <td align="left" valign="middle">&nbsp;
                          如：192.168.1</td>
                      </tr>
                      <tr>
                        <td height="76"><div align="right">备注：</div></td>
                        <td><div align="left">
                          <textarea name="textarea" rows="5" cols="15" style="width:150px;height:60px;"></textarea>
                        </div></td>
                        <td>&nbsp;</td>
                     </tr>
					 <tr>
					 	<td>&nbsp;</td>
						<td>
						  <div align="right">
						    <input type="submit" name="Submit" value="新&nbsp;增">
						    <input type="reset" name="reset" value="重&nbsp;置">
						    </div></td>
					 </tr>
                    </table>
					</fieldset></td>
				</tr>
               
              </table>
			    </form>
			  </td>
              <td>&nbsp;</td>
            </tr>
            <tr>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
              <td>&nbsp;</td>
            </tr>
          </table>
		
		  </td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="107" valign="top"><jsp:include page="../global/label/foot.jsp"/></td>
    </tr>
  </table>
</body>
</html>