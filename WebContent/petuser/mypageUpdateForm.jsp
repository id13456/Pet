<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="helper/helper.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>My Page</h2></center>
	<form method="post" name="frm" action="PetServlet?command=mypage_update" enctype="multipart/form-data">
		<table id="board" align="center">
			<tr height="70">
				<th width="150">이름/아이디</th>
				<td colspan=3>${loginUser.username}(${loginUser.userid})</td>
			</tr>
			<tr height="70">
				<th width="150">비밀번호</th>
				<td width="250"><input type="password" name="userpwd"></td>
				<th width="150">비밀번호 확인</th>
				<td width="250"><input type="password" name="userpwd_ch"></td>
			</tr>
			<tr height="70">
				<th width="150">전화번호</th>
				<td width="250"><input type="text" name="userphone" value="${loginUser.userphone}"></td>
				<th width="150">이메일</th>
				<td width="250"><input type="text" name="useremail" value="${loginUser.useremail}"></td>
			</tr>
			<tr height="70">
				<th width="150">주소</th>
				<td colspan=3>
					[<input type="text" name="user_zip_num" value="${loginUser.user_zip_num}">] 
					<input type="text" name="user_address" value="${loginUser.user_address}" size="100">
				</td>
			</tr>
			<tr height="70">
				<th width="150">반려동물_1</th>
				<td colspan=3>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 1}"><input type="radio" name="user_pet1" value=1 checked>개</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=1>개</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 2}">
							<input type="radio" name="user_pet1" value=2 checked>고양이
						</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=2>고양이</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 3}">
							<input type="radio" name="user_pet1" value=3 checked>물고기
						</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=3>물고기</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 4}">
							<input type="radio" name="user_pet1" value=4 checked>햄스터
						</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=4>햄스터</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 5}"><input type="radio" name="user_pet1" value=5 checked>새</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=5>새</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 6}">
							<input type="radio" name="user_pet1" value=6 checked>고슴도치
						</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=6>고슴도치</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 7}">
							<input type="radio" name="user_pet1" value=7 checked>토끼
						</c:when>
						<c:otherwise><input type="radio" name="user_pet1" value=7>토끼</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr height="70">
				<th width="150">반려동물_2</th>
				<td>
					<c:if test="${loginUser.user_pet2 != null}">
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 1}">
								<input type="radio" name="user_pet2" value=1 checked>개
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=1>개</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 2}">
								<input type="radio" name="user_pet2" value=2 checked>고양이
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=2>고양이</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 3}">
								<input type="radio" name="user_pet2" value=3 checked>물고기
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=3>물고기</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 4}">
								<input type="radio" name="user_pet2" value=4 checked>햄스터
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=4>햄스터</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 5}">
								<input type="radio" name="user_pet2" value=5 checked>새
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=5>새</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 6}">
								<input type="radio" name="user_pet2" value=6 checked>고슴도치
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=6>고슴도치</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 7}">
								<input type="radio" name="user_pet2" value=7 checked>토끼
							</c:when>
							<c:otherwise><input type="radio" name="user_pet2" value=7>토끼</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<tr>
				<th width="200">이미지</th>
				<td colspan=3>
					<c:if test="${loginUser.user_img != null}">
						<img src="images/${loginUser.user_img}"><br><br>
					</c:if>
					<input type="file" name="user_img">
					<input type="hidden" name="ex_img" value="${loginUser.user_img}">
				</td>
			</tr>
		</table>
	<div id="shop_btn">
		<input type="submit" id="btn" value="저장">
		<input type="button" id="btn" value="메인" onclick="location.href='PetServlet?command=index'">
	</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>