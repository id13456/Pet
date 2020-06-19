<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="petuser/petuser.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>My Page</h2></center>
	<form method="post" name="frm" action="PetServlet?command=mypage_update_form">
		<table id="board" align="center">
			<c:if test="${loginUser.user_img != null}">
				<tr>
					<td colspan=4 align="center"><img src="images/${loginUser.user_img}"></td>
				</tr>
			</c:if>
			<tr height="70">
				<th width="150">이름/아이디</th>
				<td colspan=3>${loginUser.username}(${loginUser.userid})</td>
			</tr>
			<tr height="70">
				<th width="150">전화번호</th>
				<td width="250">${loginUser.userphone}</td>
				<th width="150">이메일</th>
				<td width="250">${loginUser.useremail}</td>
			</tr>
			<tr height="70">
				<th width="150">주소</th>
				<td colspan=3>
					[${loginUser.user_zip_num}] ${loginUser.user_address}
				</td>
			</tr>
			<tr height="70">
				<th width="150">반려동물</th>
				<td colspan=3>
					<c:choose>
						<c:when test="${loginUser.user_pet1 == 1}">개</c:when>
						<c:when test="${loginUser.user_pet1 == 2}">고양이</c:when>
						<c:when test="${loginUser.user_pet1 == 3}">물고기</c:when>
						<c:when test="${loginUser.user_pet1 == 4}">햄스터</c:when>
						<c:when test="${loginUser.user_pet1 == 5}">새</c:when>
						<c:when test="${loginUser.user_pet1 == 6}">고슴도치</c:when>
						<c:when test="${loginUser.user_pet1 == 7}">토끼</c:when>
						<c:otherwise>없음</c:otherwise>
					</c:choose>
					
					<c:if test="${loginUser.user_pet2 != null}">
						<c:choose>
							<c:when test="${loginUser.user_pet2 == 1}">, 개</c:when>
							<c:when test="${loginUser.user_pet2 == 2}">, 고양이</c:when>
							<c:when test="${loginUser.user_pet2 == 3}">, 물고기</c:when>
							<c:when test="${loginUser.user_pet2 == 4}">, 햄스터</c:when>
							<c:when test="${loginUser.user_pet2 == 5}">, 새</c:when>
							<c:when test="${loginUser.user_pet2 == 6}">, 고슴도치</c:when>
							<c:when test="${loginUser.user_pet2 == 7}">, 토끼</c:when>
							<c:otherwise>&nbsp;</c:otherwise>
						</c:choose>
					</c:if>
				</td>
			</tr>
			<c:if test="${loginUser.helperid != null }">
				<tr height="70">
					<th width="150">매칭된 수의사/펫도우미</th>
					<td colspan=3>
						<a href="PetServlet?command=helper_view&id=${loginUser.helperid}">
							${loginUser.helperid} 
						</a>
						<input type="button" id="btn" value="매칭취소"
						onclick="matchCancel('${loginUser.helperid}')">
					</td>
				</tr>
			</c:if>
		</table>
	<div id="shop_btn">
		<input type="submit" id="btn" value="수정">
		<input type="button" id="btn" value="메인" onclick="location.href='PetServlet?command=index'">
	</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>