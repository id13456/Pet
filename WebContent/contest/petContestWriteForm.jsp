<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="contest/contest.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<form method="post" name="frm" action="PetServlet?command=pet_contest_write" enctype="multipart/form-data">
	<center><h2>Contest</h2></center>
		<table id="board" align="center">
			<tr>
				<th width="200">등록자</th>
				<td width="500">
					<c:choose>
						<c:when test="${loginUser != null}">${loginUser.username}(${loginUser.userid})</c:when>
						<c:when test="${login != null}">${login.name}(${login.id})</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th width="200">제목</th>
				<td width="500"><input type="text" name="contitle" size=100></td>
			</tr>
			<tr>
				<th width="200">종</th>
				<td width="500">
					<input type="radio" name="conanikind" value=1> 개
					<input type="radio" name="conanikind" value=2> 고양이
					<input type="radio" name="conanikind" value=3> 물고기
					<input type="radio" name="conanikind" value=4> 햄스터<br><br>
					<input type="radio" name="conanikind" value=5> 새
					<input type="radio" name="conanikind" value=6> 고슴도치
					<input type="radio" name="conanikind" value=7> 토끼
				</td>
			</tr>
			<tr>
				<th width="200">내용</th>
				<td width="500"><textarea name="concontent" cols="100" rows="10"></textarea></td>
			</tr>
			<tr>
				<th width="200">이미지</th>
				<td width="500"><input type="file" name="conimg"></td>
			</tr>
		</table>
		<div id="shop_btn">
			<input type="submit" id="btn" value="저장" onclick="return writeconfirmCon();">
			<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_contest_list'">
		</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>