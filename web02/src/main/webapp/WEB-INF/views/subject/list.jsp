<%-- JSTL 및 EL 적용하기 --%>

<%@page import="sems.vo.SubjectVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<title>과목목록(by JSTL, EL)</title>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
</head>

<body>
<div class="container">
<jsp:include page="/jsp/header.jsp" />
<h1>과목 목록(by JSTL, EL)</h1>
<a class="btn btn-primary" href='insert.bit'>새과목</a><br>
<table class="table">
<tr>
  <th>번호</th>
  <th>과목명</th>
</tr>

<c:forEach var="subject" items="${list}">
<tr>
  <td>${subject.no}</td>
  <td><a href='detail.bit?no=${subject.no}'>${subject.title}</a></td>
</tr>
</c:forEach>

</table>
<jsp:include page="/jsp/footer.jsp" />
</div>
</body>
</html>
