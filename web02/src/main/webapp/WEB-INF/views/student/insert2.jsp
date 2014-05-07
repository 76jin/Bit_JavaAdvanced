<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생등록폼</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/common.css">
</head>
<body>
<div class="container">
<jsp:include page="/jsp/header.jsp" />
<h1>학생 등록</h1>
<form action="insert3.bit" method="post" role="form">
<h2>추가 정보</h2>

<div class="form-group">
<label for="company">회사</label>
<input id="company" class="form-control"
 type="text" name="company" placeholder="예)비트컴퓨터">
</div>
<div class="form-group">
<label for="position">직위</label>
<input id="position" class="form-control"
 type="text" name="position" placeholder="예)과장">
</div>
<div class="form-group">
<label for="workingState">재직상태</label>
  <select id="workingState" name="workingState" class="form-control">
    <option value="0">재직중</option>
    <option value="1">휴직</option>
    <option value="2">무직</option>
  </select>
</div>
<div class="form-group">
<label for="lastSchool">최종졸업학교</label>
<input id="lastSchool" class="form-control"
 type="text" name="lastSchool" placeholder="예)비트고등학교">
</div>
<div class="form-group">
<label for="bankingAccount">계좌번호</label>
<input id="bankingAccount" class="form-control"
 type="text" name="bankingAccount" placeholder="예)011-12-3456-78">
</div>

<input type="submit" value="다음" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</form>

<jsp:include page="/jsp/footer.jsp" />
</div>
</body>
</html>