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
									<select name="select" style="width:100px;"
										OnChange="return operatorthis(this);">
										<option value="-1" selected>
											--请选择--
										</option>
										<option value="${pageContext.request.contextPath}/pmo_poll_unaudit.do">
											未审查询
										</option>
										<option value="${pageContext.request.contextPath}/pmo_poll_to_query.do">
											已审查询
										</option>
										<option value="${pageContext.request.contextPath}/pmo_poll_to_query_m.do">
											按月统计
										</option>
										<option value="${pageContext.request.contextPath}/pmo_poll_to_query_q.do">
											按季统计
										</option>
										<option value="${pageContext.request.contextPath}/pmo_poll_to_query_y.do">
											按年统计
										</option>
										<option value="${pageContext.request.contextPath}/to_passwd_modify.do">
											修改密码
										</option>
										<option value="${pageContext.request.contextPath}/to_passwd_reset.do">
											重置密码
										</option>
										<option value="${pageContext.request.contextPath}/to_add_classtype.do">
											新增班级类型
										</option>
										<option value="${pageContext.request.contextPath}/to_content_manage.do">
											考评项管理
										</option>
										<option value="${pageContext.request.contextPath}/to_template_manage.do">
											模板管理
										</option>
										<option value="${pageContext.request.contextPath}/to_teacher_manage.do">
											教师管理
										</option>
									</select>
					  </td>
					</tr>
</table>
