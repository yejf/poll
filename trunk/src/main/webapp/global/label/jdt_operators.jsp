<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
			<select name="select" style="width:85px;" class="fontforwelcometd"
				OnChange="return operatorthis(this);">
				<option value="-1" selected>
					--请选择--
				</option>
				<option
					value="${pageContext.request.contextPath}/jdt_class_to_add.do">
					新增班级
				</option>
				<option
					value="${pageContext.request.contextPath}/jdt_class_to_modify.do">
					修改班级
				</option>
				<option
					value="${pageContext.request.contextPath}/to_passwd_modify.do">
					修改密码
				</option>
				<option
					value="${pageContext.request.contextPath}/jdt_poll_list.do">
					考评列表
				</option>
			</select>
		</td>
	</tr>
</table>
