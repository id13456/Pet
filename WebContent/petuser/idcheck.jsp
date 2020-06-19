<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 체크</title>
<style type="text/css">
	body { font-family:한컴 바겐세일 M; background-color:#F5F8FF; }
	table th, td { padding:10px; }
	#btn { width: 80px; height: 30px; text-align: center; font-size: 100%; border-radius: 10px 10px 10px 10px; margin-right: 5px; 
			font-family:한컴 바겐세일 M; font-weight: bold; background-color:#D1DBFF; }
</style>

<script type="text/javascript">
	function idok() {
		opener.frm.userid.value="${id}";
		opener.frm.reid.value="${id}";
		self.close();
	}
</script>
</head>
<body>
<div id="wrap">
	<h1>ID 중복확인</h1>
	<form method="post" name="formm" action="PetServlet?command=id_check_form">
		User ID<input type="text" name="id" value="">
		<input type="submit" value="검색" class="submit" id="btn"><br>
		
		<div style="margin-top:20px;">
			<c:if test="${message ==1}">
				<script type="text/javascript">
					opener.document.frm.userid.value="";
				</script>
				${id}는 이미 사용중인 아이디입니다.
			</c:if>
			<c:if test="${message == -1}">
				${id}는 사용 가능한 ID입니다.
				<input type="button" value="사용" class="cancel" onclick="idok()" id="btn">
			</c:if>
		</div>
	</form>
</div>
</body>
</html>