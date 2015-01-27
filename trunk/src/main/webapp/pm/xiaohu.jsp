<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<input type="text" value="1" name="pmid"/>
<br>
<input type="text" value="100" name="classid"/>
<a href="${pageContext.request.contextPath}/pm_poll_activate.do?userid=2&clazzid=2" >激活</a> 
<br>
<a href="${pageContext.request.contextPath}/poll_close.do?clazzid=2" >关闭</a>
