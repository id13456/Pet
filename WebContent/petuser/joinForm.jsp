<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="petuser/petuser.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>My Page</h2></center>
	<form method="post" name="frm" action="PetServlet?command=join"  enctype="multipart/form-data">
		<table id="board" align="center">
			<tr height="70">
				<th width="150">아이디</th>
				<td colspan="3"><input type="text" name="userid">
					<input type="hidden" name="reid">
					<input type="button" value="중복체크" class="dup" onclick="idcheck()" id="btn"><br>
				</td>
			</tr>
			<tr height="70">
				<th width="150">비밀번호</th>
				<td width="250"><input type="password" name="userpwd"></td>
				<th width="150">비밀번호 확인</th>
				<td width="250"><input type="password" name="userpwd_ck"></td>
			</tr>
			<tr height="70">
				<th width="150">이름</th>
				<td width="250"><input type="text" name="username"></td>
				<th width="150">전화번호</th>
				<td width="250"><input type="text" name="userphone"></td>
			</tr>
			<tr height="70">
				<th width="150">이메일</th>
				<td colspan="3"><input type="text" name="useremail" size="50"></td>
			</tr>
			<tr height="70">
				<th width="150">주소</th>
				<td colspan=3>
					우편번호 [<input type="text" name="user_zip_num">] 
					<input type="text" name="user_address" size="50">
				</td>
			</tr>
			<tr height="70">
				<th width="150">반려동물_1</th>
				<td colspan=3>
					<input type="radio" value=1 name="user_pet1"> 개 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=2 name="user_pet1"> 고양이 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=3 name="user_pet1"> 물고기 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=4 name="user_pet1"> 햄스터 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=5 name="user_pet1"> 새 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=6 name="user_pet1"> 고슴도치 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=7 name="user_pet1"> 토끼 &nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr height="70">
				<th width="150">반려동물_2</th>
				<td colspan=3>
					<input type="radio" value=1 name="user_pet2"> 개 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=2 name="user_pet2"> 고양이 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=3 name="user_pet2"> 물고기 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=4 name="user_pet2"> 햄스터 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=5 name="user_pet2"> 새 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=6 name="user_pet2"> 고슴도치 &nbsp;&nbsp;&nbsp;
					<input type="radio" value=7 name="user_pet2"> 토끼 &nbsp;&nbsp;&nbsp;
				</td>
			</tr>
			<tr height="70">
				<th >이미지</th>
				<td colspan=3>
					<input type="file" name="user_img">
				</td>
			</tr>
		</table>
	<div id="shop_btn">
		<input type="submit" id="btn" value="가입" onclick="return userWriteconfirm();">
		<input type="reset" id="btn" value="취소">
		<input type="button" id="btn" value="메인" onclick="location.href='PetServlet?command=index'">
	</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>