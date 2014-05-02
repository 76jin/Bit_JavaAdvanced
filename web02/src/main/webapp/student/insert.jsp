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
<jsp:include page="../jsp/header.jsp" />
<h1>학생 등록</h1>
<form action="insert2.bit" method="post" role="form">
<h2>기본정보</h2>

<div class="form-group">
<label for="name">이름</label>
<input id="name" class="form-control"
 type="text" name="name" placeholder="예)홍길동">
</div>
<div class="form-group">
<label for="email">이메일</label>
<input id="email" class="form-control"
 type="email" name="email" placeholder="예)hong@test.com">
</div>
<div class="form-group">
<label for="tel">전화</label>
<input id="tel" class="form-control"
 type="tel" name="tel" placeholder="예)010-1234-5678">
</div>
<div class="form-group">
<label for="password">암호</label>
<input id="password" class="form-control"
 type="password" name="password" placeholder="8자리 이상 암호">
</div>
<div class="form-group">
<label for="fax">팩스</label>
<input id="fax" class="form-control"
 type="tel" name="fax" placeholder="예)010-1234-5678">
</div>
<div class="form-group">
<label for="postNo">우편번호</label>
<input id="postNo" class="form-control"
 type="text" name="postNo" placeholder="예)462-160">
</div>
<div class="form-group">
<label for="address">주소</label>
<input id="address" class="form-control"
 type="text" name="address" placeholder="예)서울시 강남구">
</div>
<div class="form-group">
<label for="photo">사진</label>
<input id="photo" class="form-control" type="file" name="photo">
</div>

<input type="submit" value="다음" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</form>
<jsp:include page="../jsp/footer.jsp" />
</div>
</body>
</html>