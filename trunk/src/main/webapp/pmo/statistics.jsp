<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${project}</title>
		<link href="../resource/css/css.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<table width="1024" border="1" align="center" cellpadding="0"
			cellspacing="0" class="BorderAllSolid3399CC">
			<tr>
				<td width="1024" height="100" valign="top">
					<jsp:include page="../global/label/head.jsp" />
				</td>
			</tr>
			<tr>
				<td height="19" class="BorderTBSolidBlack">
				<form name="form1" method="post" action="">
					<table width="100%" align="center" border="0">
						<tr>
							
							<td width="42" height="23">
								&nbsp;
							</td>
							<td width="470">
								欢迎您！PMO...
							</td>
							<td width="452" align="right">
								<div align="right">
									相关操作：
									<select name="select" style="width:100px;height:19px;">
										<option value="" selected>
											==请选择==
										</option>
										<option value="">
											审核调查
										</option>
										<option value="">
											调查搜索
										</option>
										<option value="">
											统计报表
										</option>
										<option value="">
											修改信息
										</option>
										<option value="">
											退出系统
										</option>
									</select>
								</div>
							</td>
							<td width="38">
								&nbsp;
							</td>
							
						</tr>
					</table>
					</form>
				</td>
			</tr>
			<tr>
				<td height="542" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="1024" height="542" valign="top">
								<table width="100%" height="100%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="2%" height="30">
											&nbsp;
										</td>
										<td width="96%">
											&nbsp;
										</td>
										<td width="2%">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="479">
											&nbsp;
										</td>
										<td align="center" valign="top"
											background="resource/images/poll-login.jpg">
											<form>
												<table width="95%" height="177" border="0" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="23">
															<div align="left">
																后台管理  —>  项目经理考评查询
															</div>
														</td>
													</tr>
													<tr>
														<td>
															&nbsp;
														</td>
													</tr>
													<tr>
														<td>
															<fieldset>
																<legend>
																	月报表
																</legend>
																<table width="97%" height="41" border="0">
																	<tbody align="center">
																		<tr>
																			<td width="26%">
																				<div align="right">
																					请选择日期：
																				</div>
																			</td>
																			<td width="7%">
																				<select name="select">
																					<option value="2008" selected>
																						2008
																					</option>
																					<option value="2009">
																						2009
																					</option>
																					<option value="2010">
																						2010
																					</option>
																				</select>
																			</td>
																			<td width="3%">
																				<div align="left">
																					年
																				</div>
																			</td>
																			<td width="5%">
																				<select name="select">
																					<option value="01" selected>
																						01
																					</option>
																					<option value="02">
																						02
																					</option>
																					<option value="03">
																						03
																					</option>
																					<option value="04">
																						04
																					</option>
																					<option value="05">
																						05
																					</option>
																					<option value="06">
																						06
																					</option>
																					<option value="07">
																						07
																					</option>
																					<option value="08">
																						08
																					</option>
																					<option value="09">
																						09
																					</option>
																					<option value="10">
																						10
																					</option>
																					<option value="11">
																						11
																					</option>
																					<option value="12">
																						12
																					</option>
																				</select>
																			</td>
																			<td width="22%">
																				<div align="left">
																					月
																				</div>
																			</td>
																			<td width="12%">
																				<select name="select">
																					<option value="PM" selected>
																						项目经理
																					</option>
																					<option value="xiangming">
																						项铭
																					</option>
																					<option value="liuxf">
																						刘小飞
																					</option>
																				</select>
																			</td>
																			<td width="12%">
																				<input type="submit" name="Submit" value="提交">
																			</td>
																			<td width="13%"></td>
																		</tr>
																	</tbody>
																</table>
															</fieldset>
														</td>
													</tr>
													<tr>
														<td>
															&nbsp;
														</td>
													</tr>
													<tr>
														<td>
															<fieldset>
																<legend>
																	季报表
																</legend>
																<table width="97%" height="41" border="0">
																	<tbody align="center">
																		<tr>
																			<td width="26%">
																				<div align="right">
																					请选择日期：
																				</div>
																			</td>
																			<td width="7%">
																				<select name="select">
																					<option value="2008" selected>
																						2008
																					</option>
																					<option value="2009">
																						2009
																					</option>
																					<option value="2010">
																						2010
																					</option>
																				</select>
																			</td>
																			<td width="3%">
																				<div align="left">
																					年
																				</div>
																			</td>
																			<td width="5%">
																				<select name="select">
																					<option value="01" selected>
																						01
																					</option>
																					<option value="02">
																						2
																					</option>
																					<option value="03">
																						3
																					</option>
																					<option value="04">
																						4
																					</option>
																				</select>
																			</td>
																			<td width="22%">
																				<div align="left">
																					季度
																				</div>
																			</td>
																			<td width="12%">
																				<select name="select">
																					<option value="PM" selected>
																						项目经理
																					</option>
																					<option value="xiangming">
																						项铭
																					</option>
																					<option value="liuxf">
																						刘小飞
																					</option>
																				</select>
																			</td>
																			<td width="12%">
																				<input type="submit" name="Submit" value="提交">
																			</td>
																			<td width="13%"></td>
																		</tr>
																	</tbody>
																</table>
															</fieldset>
														</td>
													</tr>
													<tr>
														<td>
															&nbsp;
														</td>
													</tr>
													<tr>
														<td>
															<fieldset>
																<legend>
																	年报表
																</legend>
																<table width="97%" height="41" border="0">
																	<tbody align="center">
																		<tr>
																			<td width="26%">
																				<div align="right">
																					请选择日期：
																				</div>
																			</td>
																			<td width="7%">
																				<select name="select">
																					<option value="2008" selected>
																						2008
																					</option>
																					<option value="2009">
																						2009
																					</option>
																					<option value="2010">
																						2010
																					</option>
																				</select>
																			</td>
																			<td width="7%">
																				<div align="left">
																					年
																				</div>
																			</td>
																			<td width="6%">
																				&nbsp;
																			</td>
																			<td width="17%">
																				&nbsp;
																			</td>
																			<td width="12%">
																				<select name="select">
																					<option value="PM" selected>
																						项目经理
																					</option>
																					<option value="xiangming">
																						项铭
																					</option>
																					<option value="liuxf">
																						刘小飞
																					</option>
																				</select>
																			</td>
																			<td width="12%">
																				<input type="submit" name="Submit" value="提交">
																			</td>
																			<td width="13%"></td>
																		</tr>
																	</tbody>
																</table>
															</fieldset>
														</td>
													</tr>
												</table>
											</form>
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
									<tr>
										<td>
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
										<td>
											&nbsp;
										</td>
									</tr>
								</table>

							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="107" valign="top">
					<jsp:include page="../global/label/foot.jsp" />
				</td>
			</tr>
		</table>
	</body>
</html>
