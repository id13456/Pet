<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="helper/helper.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>수의사 / 펫도우미 등록</h2></center>
	<form method="post" name="frm" action="PetServlet?command=helper_update"  enctype="multipart/form-data">
		<table id="board" align="center">
			<tr>
				<th width="100">아이디</th>
				<td width="200" colspan=3>${pvo.id}<input type="hidden" name="id" value="${pvo.id}"></td>
			</tr>
			<tr>
				<th width="100">비밀번호</th>
				<td width="200"><input type="password" name="pwd"></td>
				<th width="100">비밀번호 확인</th>
				<td width="200"> <input type="password" name="pwd_ch"></td>
			</tr>
			<tr>
				<th width="100">이름</th>
				<td width="200">${pvo.name}</td>
				<th width="100">성별</th>
				<td width="200">
					<c:choose>
						<c:when test="${pvo.sex == 1}"> 남자 </c:when>
						<c:otherwise> 여자</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th width="100">전화번호</th>
				<td width="200"><input type="text" name="phone" value="${pvo.phone}"></td>
				<th width="100">이메일</th>
				<td width="200"><input type="text" name="email" value="${pvo.email}"></td>
			</tr>
			<tr>
				<th width="100">구분</th>
				<td width="200" colspan=3>
					<c:choose>
						<c:when test="${pvo.hgroup == 1}"> 수의사</c:when>
						<c:otherwise>펫도우미</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th width="100">병원이름</th>
				<td width="200" colspan=3><input type="text" name="hos_name" value="${pvo.hos_name}"></td>
			</tr>
			<tr>
				<th width="100">병원주소</th>
				<td width="200" colspan=3><input type="text" name="hos_address" value="${pvo.hos_address}"></td>
			</tr>
			<tr>
				<th width="100">케어 가능범위</th>
				<td width="200" colspan=3>
					<c:choose>
						<c:when test="${pvo.helper_kind1 eq 'y'}">
							<input type="checkbox" name="kind" value="kind1" checked> 방문돌봄&nbsp;&nbsp;&nbsp;
						</c:when>
						<c:otherwise><input type="checkbox" name="kind" value="kind1"> 방문돌봄&nbsp;&nbsp;&nbsp;</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pvo.helper_kind2 eq 'y'}">
							<input type="checkbox" name="kind" value="kind2" checked> 위탁돌봄&nbsp;&nbsp;&nbsp;
						</c:when>
						<c:otherwise><input type="checkbox" name="kind" value="kind2"> 위탁돌봄&nbsp;&nbsp;&nbsp;</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pvo.helper_kind3 eq 'y'}">
							<input type="checkbox" name="kind" value="kind3" checked> 도그워킹&nbsp;&nbsp;&nbsp;
						</c:when>
						<c:otherwise><input type="checkbox" name="kind" value="kind3"> 도그워킹&nbsp;&nbsp;&nbsp;</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pvo.helper_kind4 eq 'y'}">
							<input type="checkbox" name="kind" value="kind4" checked> 개&nbsp;&nbsp;&nbsp;
						</c:when>
						<c:otherwise><input type="checkbox" name="kind" value="kind4"> 개&nbsp;&nbsp;&nbsp;</c:otherwise>
					</c:choose>
					<c:choose>
						<c:when test="${pvo.helper_kind5 eq 'y'}">
							<input type="checkbox" name="kind" value="kind5" checked> 고양이
						</c:when>
						<c:otherwise><input type="checkbox" name="kind" value="kind5"> 고양이</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th width="200">내용</th>
				<td colspan=3><textarea name="helper_index" cols="100" rows="10">${pvo.helper_index}</textarea></td>
			</tr>
			<tr>
				<th width="200">이미지</th>
				<td colspan=3><input type="file" name="helper_img"></td>
			</tr>
		</table>
	<div id="shop_btn">
		<input type="submit" id="btn" value="저장" onclick="return helperWriteconfirm();">
		<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=helper_list'">
	</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>