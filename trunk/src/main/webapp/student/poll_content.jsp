<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<script src="/poll-ver3.2/jquery-1.7.2.min.js"  type="text/javascript"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>${project}</title>
		<link href="${pageContext.request.contextPath}/resource/css/css.css"
			rel="stylesheet" type="text/css">
		<script language="javascript"
			src="${pageContext.request.contextPath}/resource/js/js.js"></script>
		<script>
			function isEmpty1(pObj,num1,num2,errMsg,errMsg1){
        		var obj = eval(pObj);
				if( obj == null || obj.value == ""){
					if (errMsg == null || errMsg ==""){
						alert("输入为空!");
					} else {
                    	alert(errMsg);
                	}
                	obj.focus();
                	return false;
        		}else{
					if(obj.value.length<num1||obj.value.length>num2){
					alert(errMsg1);
					obj.focus();
					return false;
            		}
				return true;
				}
			}
			function checkcb(){
				var a = document.getElementsByTagName("INPUT");
				for(var i=0; i<a.length; i++)
				{
					var tmpStr;
					tmpStr = a[i].name;
					if(a[i].type=="radio" && eval
					("document.form1."+tmpStr+"[0].checked") == false 
						&& eval("document.form1."+tmpStr+"[1].checked")== false
						&& eval("document.form1."+tmpStr+"[2].checked")== false
						&& eval("document.form1."+tmpStr+"[3].checked")== false
						&& eval("document.form1."+tmpStr+"[4].checked")== false)
					{ 
							alert("问题没有全部选择,请完成选择!");
						return false;
					}
				}
			}
		/*  $(function(){
		 		//getRadioLength();
				$("#btn").click(function(){
					alert("aaa");
					checkcb();
					//var arr=${"input[type=radio]:checked"};
					//alert(arr.length);
					alert("bbb");
				});
				//getRadioLength();
			}); 
			function getRadioLength(){
				$("#btn").click(function(){
					alert("aaa");
					checkcb();
					var arr=${"input[type=radio]"};
					//alert(arr.length);
					alert("bbb");
				});
			}  */
		</script>

	</head>
	<body>
		<form name="form1" method="post"
			action="${pageContext.request.contextPath}/poll_submit.do" onsubmit="return checkcb()">
			<table width="1024" border="0" align="center" cellpadding="0" cellspacing="0" class="BorderAllSolidFF99CC">
				<tr>
					<td height="100" colspan="3" valign="top">
                      <jsp:include page="../global/label/head.jsp" />                      
					</td>
				</tr>
				<tr>
                	<td align="center" class="BorderTBSolidFF99CC">
						<table width="1000">
							<tr>
								<td width="977" align="left">
								欢迎进入天智教育在线考评系统！ 你所在班级是：【<font color='green'>${currentClazz.className}</font>】&nbsp;&nbsp;你所要评审的老师是：【<font color='green'>${currentPm.realName}</font>】
								</td>
							</tr>
					  </table>
					</td>
                </tr>
				<tr>
					<td height="542" colspan="3" valign="top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td width="1024" height="542" valign="top">
									<table width="100%" border="0" align="center"
										cellpadding="0" cellspacing="0">
										<tr>
											<td width="12" height="30"></td>
											<td width="1000"></td>
											<td width="12"></td>
										</tr>
										<tr>
											<td height="479" width="12"></td>
											<td align="center" valign="top">
												<table width="100%" height="600" border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td width="100%" height="170" valign="top" align="center">
																<table width="95%" border="0" cellpadding="0"
																	cellspacing="0">
																	
																	<c:forEach items="${maps }" var="m" varStatus="key">
																		<tr>
																		<td colspan="7" align="left" class="tableHeader1">
																				请你对本阶段&nbsp;讲师在班级<font color='red'>${m.key }</font>中的表现进行评价
																		</td>
																	</tr>
																	<tr>
																		<td width="4%" class="odd">&nbsp;</td>
																		<td width="46%" class="odd">&nbsp;</td>
																		<td width="10%" align="center" class="odd">很满意</td>
																		<td width="10%" align="center" class="odd">比较满意</td>
																		<td width="10%" align="center" class="odd">较好</td>
																		<td width="10%" align="center" class="odd">还行</td>
																		<td width="10%" align="center" class="odd">一般</td>
																	</tr>
																		<c:forEach var="v1" items="${m.value }" varStatus="vkey">
																		<tr>
																			<td align="center" class="odd">
																				${vkey.count}
																			</td>
																		
																			<td align="left" class="odd">
																				${v1.content}
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${key.count}${vkey.count}" value="5">
																				5
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${key.count}${vkey.count}" value="4">
																				4
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${key.count}${vkey.count}" value="3">
																				3
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${key.count}${vkey.count}" value="2">
																				2
																			</td>
																			<td align="center" class="odd">
																				<input type="radio" name="c${key.count}${vkey.count}" value="1">
																				1
																			</td>
																		</tr>
																	</c:forEach>
																	</c:forEach>
																	
																	
																	
																	<!-- 第二部份迭代完成 -->
																	
																		<tr>
																			<td colspan="7">&nbsp;</td>
																		</tr>
																	<!--                 -->	
																		<c:forEach var="q" items="${questions }" varStatus="var">
																		<tr>
																			<td colspan="7" class="tableHeader1">
																				${q }
																			</td>
																		</tr>
																		<tr>
																			<td colspan="7">
																				<textarea name="a${var.count }" rows="4" cols="120" class="txtarea_style" onfocus="javaScript:if(this.value=='这家伙很懒，什么也没留下') {this.value='';}" onblur="javaScript:if(this.value == '') {this.value = '这家伙很懒，什么也没留下';}">这家伙很懒，什么也没留下</textarea>
																			</td>
																		</tr>
																		<tr>
																			<td colspan="7">&nbsp;</td>
																		</tr>
																		</c:forEach>
																		
																	<!-- 第三部份迭代完成 -->
																	
																	<tr align="right">
																	  <td colspan="7"><input type="submit" id="btn" name="button" value="提&nbsp;交"></td>
																	</tr>
																</table>
														</td>
													</tr>
												</table>
											</td>
											<td></td>
										</tr>
										<tr>
											<td>&nbsp;
												

											</td>
											<td>&nbsp;
												

											</td>
											<td>&nbsp;
												

											</td>
										</tr>
									</table>

								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="44" colspan="3" valign="top" class="BorderTSolidFF99CC">&nbsp;<jsp:include page="../global/label/foot.jsp" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
