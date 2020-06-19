<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="adopt/adopt.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<form method="post" name="frm" action="PetServlet?command=pet_adopt_write" enctype="multipart/form-data">
	<center><h2>입양</h2></center>
		<table id="board" align="center">
			<tr>
				<th width="200">등록자</th>
				<td width="200">${loginUser.username}(${loginUser.userid})</td>
				<th width="150">지역</th>
				<td width="200"><input type="text" name="outarea" size="30"></td>
			</tr>
			<tr>
				<th width="200">제목</th>
				<td colspan=3><input type="text" name="outtitle" size="50"></td>
			</tr>
			<tr>
				<th width="200">입양종류</th>
				<td>
					<input type="radio" name="outgroup" value=1> 개인입양
					<input type="radio" name="outgroup" value=2> 유기동물
				</td>
				<th width="200">종</th>
				<td>
					<input type="radio" name="outkind" value=1> 개
					<input type="radio" name="outkind" value=2> 고양이
					<input type="radio" name="outkind" value=3> 물고기
					<input type="radio" name="outkind" value=4> 햄스터<br><br>
					<input type="radio" name="outkind" value=5> 새
					<input type="radio" name="outkind" value=6> 고슴도치
					<input type="radio" name="outkind" value=7> 토끼
				</td>
			</tr>
			<tr>
				<th width="200">나이</th>
				<td><input type="text" name="outage"></td>
				<th width="200">성별</th>
				<td>
					<input type="radio" name="outsex" value=1> 남
					<input type="radio" name="outsex" value=2> 여 
				</td>
			</tr>
			<tr>
				<th width="200">내용</th>
				<td colspan=3><textarea name="outindex" cols="100" rows="10"></textarea></td>
			</tr>
			<tr>
				<th width="200">이미지</th>
				<td colspan=3><input type="file" name="outimg"></td>
			</tr>
		</table>
		<div id="shop_btn">
			<input type="submit" id="btn" value="저장" onclick="return writeconfirm();">
			<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_adopt_list'">
		</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>