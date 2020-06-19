<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 검색</title>
<style type="text/css">
	body { font-family:한컴 바겐세일 M; background-color:#F5F8FF; }
	table th, td { padding:10px; }
	#btn { width: 80px; height: 30px; text-align: center; font-size: 100%; border-radius: 10px 10px 10px 10px; margin-right: 5px; 
			font-family:한컴 바겐세일 M; font-weight: bold; background-color:#D1DBFF; }
</style>

<script type="text/javascript">
	function result(id) {
		opener.document.formm.id.value = id;
		self.close();
	}
</script>
</head>
<body>
<article>
	<center>
	<form name="findId" method="post" action="PetServlet?command=find_id_form">
		<table>
			<tr>
				<td align="right"><label>이름</label></td>
				<td><input type="text" name="name" value=""></td>
			</tr>
			<tr>
				<td align="right"><label>전화번호</label></td>
				<td><input type="text" name="phone" value=""></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="submit" value="아이디 찾기" id="btn"></td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td>
				<c:choose>
					<c:when test="${empty selectId}">
						해당 이름과 전화번호의 사용자가 없습니다.
					</c:when>
					<c:otherwise>
						검색결과 : ${selectId.username}(${selectId.userphone})의 아이디는 ${selectId.userid}입니다.
					</c:otherwise>
				</c:choose> 	
		</tr>
	</table>
</article>
</body>
</html>