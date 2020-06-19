<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="shop/shop.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<form method="post" name="frm" action="PetServlet?command=shop_update&exseq=${svo.exseq}" 
					enctype="multipart/form-data">
	<center><h2>물물교환 수정</h2></center>
		<table id="board" align="center">
			<tr>
				<th width="200">이름</th>
				<td width="200">
					<c:choose>
						<c:when test="${empty login}">${loginUser.username}</c:when>
						<c:when test="${empty loginUser}">${login.name}</c:when>
					</c:choose>
				</td>
				<th width="150">지역</th>
				<td width="200"><input type="text" name="exarea" size="30" value="${svo.exarea}"></td>
			</tr>
			<tr>
				<th width="200">제목</th>
				<td colspan=3><input type="text" name="extitle" size="50" value="${svo.extitle}"></td>
			</tr>
			<tr>
				<th width="200">내용</th>
				<td colspan=3><textarea name="excontent" cols="100" rows="10"> ${svo.excontent}</textarea></td>
			</tr>
			<tr>
				<th width="200">이미지</th>
				<td colspan=3>
					<img src="images/${svo.eximg}"><br><br>
					<input type="file" name="eximg">
					<input type="hidden" name="exeximg" value="${svo.eximg}">
				</td>
			</tr>
		</table>
		<div id="shop_btn">
			<input type="submit" id="btn" value="저장" onclick="return writeconfirm();">
			<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=shop_list'">
		</div>
	</form>
</div>

<%@ include file="../footer.jsp"%>