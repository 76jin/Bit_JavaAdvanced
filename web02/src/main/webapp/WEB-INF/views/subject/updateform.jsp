<%-- EL 적용 --%>
<%@page import="sems.vo.SubjectVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<jsp:useBean id="subject" class="sems.vo.SubjectVo" scope="request" />

<%--
SubjectVo subject = (SubjectVo) request.getAttribute("subject");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>과목변경폼(JSP, EL)</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/jsp/header.jsp" />
<h1>과목 변경(EL 적용)</h1>
<form action='update.bit' method='post' role="form">
<div class="form-group">
<label for="no">번호</label>
<input id="no" type='text' name='no' value='${subject.no}' readonly>
</div>
<div class="form-group">
<label for="title">과목명</label>
<input id="title" class="form-control"
 type='text' name='title' value='${subject.title}'>
</div>
<div class="form-group">
<label for="description">설명</label>
<textarea id="description" class="form-control"
 name='description' rows='10' cols='80'>${subject.description}</textarea>
</div>
<input type='submit' value='변경' class="btn btn-primary">
<input type='button' value='취소' class="btn btn-primary"
      onclick="location.href='detail.bit?no=${subject.no}'">
</form>

<c:set var="studyClass" value="Java48$$" scope="request" />

<jsp:include page="/jsp/footer.jsp" />
<%-- 비추 <%@ include file="../jsp/footer.jsp" %> --%>
</div>
</body>
</html>
    