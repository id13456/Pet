<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="shop/shop.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>물물교환</h2></center>
	<table id="board" align="center" width="800">
		<tr>
			<th width="100">제목</th>
			<td width="300">
				${svo.extitle}<input type="hidden" name="exseq" value="${svo.exseq}">
				<c:choose>
					<c:when test="${svo.exmatch == 3}">
						<b>[매칭완료]</b>
					</c:when>
					<c:when test="${svo.exmatch == 2}">
						<b>[매칭중]</b>
					</c:when>
				</c:choose>
			</td>
			<th width="100"> 작성자</th>
			<td width="80">${loginUser.userid}</td>
			<th width="100"> 조회수</th>
			<td width="50">${svo.exview}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan=5 align="center">
				<c:if test="${svo.eximg != null}">
					<img src="images/${svo.eximg}" style="height:400px;"><br><br> 
				</c:if> 
				<pre>${svo.excontent}</pre>
			</td>
		</tr>
	</table>
	<div id="shop_btn">
		<c:choose>
			<c:when test="${loginUser != null && svo.exid == loginUser.userid}">
				<input type="button" id="btn" value="매칭완료" 
						onclick="location.href='PetServlet?command=shop_view&exmatch=3&exseq=${svo.exseq}'">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=shop_update_form&exseq=${svo.exseq}'">
				<input type="button" id="btn" value="삭제" onclick='delconfirm(${svo.exseq});'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=shop_list'">
			</c:when>
			<c:when test="${login != null && svo.exid == login.id}">
				<input type="button" id="btn" value="매칭완료" 
						onclick="location.href='PetServlet?command=shop_view&exmatch=3&exseq=${svo.exseq}'">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=shop_update_form&exseq=${svo.exseq}'">
				<input type="button" id="btn" value="삭제" onclick='delconfirm(${svo.exseq});'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=shop_list'">
			</c:when>
			<c:otherwise>
				<input type="button" id="btn" value="찜" 
						onclick="location.href='PetServlet?command=shop_view&exmatch=2&exseq=${svo.exseq}'">
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=shop_list'">
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../footer.jsp"%>