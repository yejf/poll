<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script language="javascript">
	function operatorthis(selectthis)
	{
		if(selectthis.value==-1)
		{
		   return false;
		}
		else
		{
			window.location=selectthis.value;
		}
	}
</script>
<table width="100%">
					<tr>
						<td align="right">
						相关操作：
						<select name="select" style="width:100px; font-size:12px" OnChange="return operatorthis(this);">
							<option value="-1" selected class="fontforwelcometd">- 请选择 -</option>
							<option value="${pageContext.request.contextPath}/to_passwd_modify.do" class="fontforwelcometd">修改密码</option>
							<option value="${pageContext.request.contextPath}/pm_poll_list.do" class="fontforwelcometd">考评结果</option>
						</select>
					  </td>
					</tr>
</table>
