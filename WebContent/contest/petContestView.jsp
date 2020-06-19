<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="contest/contest.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>Contest</h2></center>
	<table id="board" align="center">
		<tr>
			<td>${contest.contitle}
			</td>
			<td align="right">
				조회수 : ${contest.conview}&nbsp;&nbsp;&nbsp;
				좋아요 : ${contest.conlike}
			</td>
		</tr>
		<tr height="300">
			<td width="400" align="center">
				<img src="images/contest/${contest.conimg}" style="width:300px; height:200px;">
			</td>
			<td>
				종류 : 
				<c:choose> 
					<c:when test="${contest.conanikind == 1}">개</c:when>
					<c:when test="${contest.conanikind == 2}">고양이</c:when>
					<c:when test="${contest.conanikind == 3}">물고기</c:when>
					<c:when test="${contest.conanikind == 4}">햄스터</c:when>
					<c:when test="${contest.conanikind == 5}">새</c:when>
					<c:when test="${contest.conanikind == 6}">고슴도치</c:when>
					<c:when test="${contest.conanikind == 7}">토끼</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan=2> 
				<b>소개</b>
				<pre>${contest.concontent}</pre>
			</td>
		</tr>
	</table>
	<div id="shop_btn">
		<c:choose>
			<c:when test="${(loginUser != null && contest.conid == loginUser.userid) 
						|| (login != null && contest.conid == login.id)}">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=pet_contest_update_form&conseq=${contest.conseq}'">
				<input type="button" id="btn" value="삭제" onclick='delconfirm(${contest.conseq});'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_contest_list'">
			</c:when>
			<c:when test="${loginUser != null || login != null}">
				<input type="button" id="btn" value="좋아요" 
						onclick="location.href='PetServlet?command=pet_contest_view&conseq=${contest.conseq}&conlike=1'">
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_contest_list'">
			</c:when>
			<c:otherwise>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_contest_list'">
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../footer.jsp"%>