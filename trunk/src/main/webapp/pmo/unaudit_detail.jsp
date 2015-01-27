<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${project}</title>
 	<link href="${pageContext.request.contextPath}/resource/css/css.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
	var isSubmit=true;
	
	//var avgElem=parent.document.getElementById("avgScore");
	//var avgScore=avgElem.value;
	function changeSatuts(elem){
		var pid=elem.value;
		var pollLineId="pollLine"+pid.toLocaleString();
		var pollLine=document.getElementById(pollLineId);
		var availableNum=parent.document.getElementById("availableNumber");
		var num=parseInt(availableNum.innerHTML);
		var avgScore=parent.document.getElementById("avgScore");
		var t_avg=parent.document.getElementById("t_avg");
		if(elem.checked){//无效
			pollLine.title="无效调查表";
			pollLine.bgColor="red";
			availableNum.innerHTML=num-1;
			num=num-1;
			if(num<1){
				alert("现在有效调查表为0份, 请重新审查!")
				avgScore.value=0.0;
				//t_avg.innerHTML=0.0;
				t_avg.value=0.0;
				isSubmit=false;
				return isSubmit;
			}
		}else{//有效
			pollLine.title="有效调查表";
			pollLine.bgColor="#AAAAFF";
			availableNum.innerHTML=num+1;
			num=num+1;
		}
		//计算平均分
		var totalScore=avgTotalScore();
		var as=totalScore/num;
		avgScore.value=as.toPrecision(2);
		//t_avg.innerHTML=(as.toPrecision(3)).toLocaleString();
		t_avg.value=(as.toPrecision(2)).toLocaleString();
		//alert(t_avg.innerText);
		isSubmit=true;
		return isSubmit;
	}
	
	function avgTotalScore(){
		var totalScore=0.0;
		var pls=document.getElementsByName("isValid");
		var id=0;
		for(var i=0;i<pls.length;i++){
			var pAvgScore=document.getElementById("avg"+(pls[i].value).toLocaleString());
			if(!pls[i].checked){
				totalScore+=parseFloat(pAvgScore.value);
			}
		}
		return totalScore;
	}
	function init(){
		var pls=document.getElementsByName("isValid");
		var id=0;
		var pid="";
		var pollLineId="";
		var pollLine="";
		for(var i=0;i<pls.length;i++){		
			pid=pls[i].value;
			pollLineId="pollLine"+pid.toLocaleString();
			pollLine=document.getElementById(pollLineId);	
			if(pls[i].checked){
				pollLine.title="无效调查表";
				pollLine.bgColor="red";
			}else{
				pollLine.title="有效调查表";
				pollLine.bgColor="#3399FF";
			}
		}
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
    		<td height="19" class="BorderTBSolidFF99CC" width="1024">
				<table align="center" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="12"></td>
						<td class="fontforwelcometd" width="500"><jsp:include page="../global/label/welcome.jsp" /></td>
						<td align="right" width="500"><jsp:include page="../global/label/pmo_operators.jsp" /></td>
						<td width="12"></td>
					</tr>
				</table>
			</td>
    	</tr>
    	<tr>
				<td height="443" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="1024" height="400" valign="top">
								<table width="100%" height="100%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td width="12" height="19"></td>
										<td width="1000" class="fontforwelcometd">后台管理 —> 未审明细</td>
										<td width="12"></td>
									</tr>
									<tr>
										<td height="402">&nbsp;
											

										</td>
										<td align="center" valign="top">
										<html:form action="/pmo_poll_audit.do">
											<input type="hidden" name="pollId" value="${unaudit.pollId}">
											<input type="hidden" name="pollUserName" value="${unaudit.realName}"/>
											<input type="hidden" name="className" value="${unaudit.className}"/>
											<input type="hidden" name="email" value="${unaudit.email}"/>
											
												<table width="100%" height="300" border="0" cellpadding="0" cellspacing="0">
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	概要信息
																</legend>
																<table width="100%">
																	<tr>
																		<td width="9%" align="right">
																			<strong>教员</strong>：
																		</td>
																		<td width="6%" align="left">
																			${unaudit.realName}
																		</td>
																		<td width="6%" align="right">
																			<strong>班级</strong>：
																		</td>
																		<td width="17%" align="left">
																			${unaudit.className}
																		</td>
																		<td width="11%" align="right">
																			<strong>调查开始时间</strong>：
																		</td>
																		<td width="10%" align="left">
																			${unaudit.createdDate}
																		</td>
																		<td width="11%" align="right">
																			<strong>调查结束时间</strong>：
																		</td>
																		<td width="10%" align="left">
																			${unaudit.overDate}
																		</td>
																	</tr>
																	<tr >
																		<td height="20" align="right">
																			<strong>状态</strong>：
																		</td>
																		<td align="left">
																			<font color="#FF0000">未审</font>
																		</td>
																		<td align="right">
																			<strong>总份数</strong>：
																		</td>
																		<td align="left">
																			${unaudit.amount}
																		</td>
																		<td align="right">
																			<strong>有效份数</strong>：
																		</td>
																		<td align="left" id="availableNumber">
																				${unaudit.validAmount}
																		</td>
																		<td align="right">
																			<strong>平均分数</strong>：
																		</td>
																		<td align="left">
																			<input type="text" id="t_avg"
																				value="${unaudit.avgScore}" disabled="disabled"
																				style="border: 3px solid #FFFFFF; padding-left: 4px; padding-right: 4px; padding-top: 1px; padding-bottom: 1px; color: red; font-weight: 700" />
																			<input type="hidden" id="avgScore"  name="t_avg"
																				value="${unaudit.avgScore}" />
																		</td>
																	</tr>
																</table>
															</fieldset>
														</td>
													</tr>
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	主要反馈
																</legend>
																<table width="100%">
																<c:forEach items="${maps }" var="m">
																<tr>
																		<td width="13%" height="50" align="right">
																			<strong>第${m.key}个反馈</strong>
																		</td>
																		
																		<td width="87%" align="left">
																		<c:forEach items="${m.value }" var="ans" >
																			<font color='#CCCCCC'>班级管理:</font>
																			<c:choose>
																				<c:when test="${ans == '这家伙很赖，什么也没留下'}">无</c:when>
																				<c:otherwise>
																					${ans}
																				</c:otherwise>
																			</c:choose>
																			<br>
																		</c:forEach>
																		</td>
																		
																		
																	</tr>
																</c:forEach>
																
																
																</table>
															</fieldset>
													  </td>
													</tr>
													<tr>
														<td height="10">
															<div align="center">
																以下是该次调查的细节信息，请在"详细信息"处选择您认为的无效调查表(系统已预刷选，以红色图标标出)，然后点击 
																
																<input type="submit" value="审核" style="width:40px;height:20px;">
															</div>
													  </td>
													</tr>
													<tr>
														<td height="50">
															<fieldset>
																<legend>
																	详细信息
																</legend>
																<table width="100%">
																	<c:forEach items="${pollLines}" var="pollLine">
																		<%-- 注：tomcat6.36及后面的版 本有一个bug, 会把取到的值当long看待--%>
																		<c:if test="${fn:trim(pollLine.isValid) eq 'n'}">
																		<tr>
																			<td width="13%" height="10" align="right">
																				<input type="checkbox" name="isValid" value="${pollLine.id}" onclick="changeSatuts(this)" checked>
																		  </td>
																			<td align="left">
																			<table>
																				<tr>
																				  <td width="${pollLine.avgScore*100}" bgcolor="red" height="5" title="有效调查表" id="pollLine${pollLine.id}" >
																				  </td>
																				</tr>
																			</table>
																			</td>
																			<td width="13%" align="center">
																				平均分：${pollLine.avgScore}
																				<input type="hidden" value="${pollLine.avgScore}" name="avg" id="avg${pollLine.id}"/>
																			</td>
																			<td width="16%" align="center">
																				<a  onclick='window.showModalDialog("${pageContext.request.contextPath}/pmo_poll_line_detail.do?pollLineId=${pollLine.id}&pollId=${audited.pollId }",null,"dialogHeight:700px;dialogWidth:1100px;center:yes;help:no;resizable:yes;status:no;")'
																					target="_blank"><u>查看</u></a>
																			</td>
																		</tr>
																		</c:if>
																		<c:if test="${fn:trim(pollLine.isValid) eq fn:trim('y')}">
																		<tr>
																			<td width="13%" height="10" align="right">
																				<input type="checkbox" name="isValid" value="${pollLine.id}" onclick="changeSatuts(this)">
																		  </td>
																			<td align="left">
																			<table>
																				<tr>
																				  <td width="${pollLine.avgScore*100}" bgcolor="#AAAAFF" height="5" title="有效调查表" id="pollLine${pollLine.id}" >
																				  </td>
																				</tr>
																			</table>
																			</td>
																			<td width="13%" align="center">
																				平均分：${pollLine.avgScore}
																				<input type="hidden" value="${pollLine.avgScore}" name="avg" id="avg${pollLine.id}"/>
																			</td>
																			<td width="16%" align="center">
																				<a  onclick='window.showModalDialog("${pageContext.request.contextPath}/pmo_poll_line_detail.do?pollLineId=${pollLine.id}&pollId=${unaudit.pollId }",null,"dialogHeight:700px;dialogWidth:1100px;center:yes;help:no;resizable:yes;status:no;")'
																					target="_blank"><u>查看</u></a>
																			</td>
																		</tr>
																		</c:if>
																	</c:forEach>
																</table>
															</fieldset>
														</td>
													</tr>
											  </table>
											  </html:form>
										</td>
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