<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="adopt/adopt.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>입양</h2></center>
	<table id="board" align="center">
		<tr>
			<td>${poutvo.outtitle}
				<c:choose>
					<c:when test="${poutvo.outmatch == 2}"><b>&nbsp;[입양진행중]</b></c:when>
					<c:when test="${poutvo.outmatch == 3}"><b>&nbsp;[입양완료]</b></c:when>
					<c:otherwise><b>&nbsp;[입양전]</b></c:otherwise>
				</c:choose>
			</td>
			<td align="right">조회수 : ${poutvo.outview}</td>
		</tr>
		<tr height="300">
			<td width="400" align="center">
				<img src="images/adopt/${poutvo.outimg}" style="width:300px; height:200px;">
			</td>
			<td>
				<c:choose>
					<c:when test="${poutvo.outgroup == 1}">	<b>[개인분양]</b>	</c:when>
					<c:when test="${poutvo.outgroup == 2}">	<b>[유기견]</b> 	</c:when>
				</c:choose>
				종류 : 
				<c:choose> 
					<c:when test="${poutvo.outkind == 1}">개&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 2}">고양이&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 3}">물고기&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 4}">햄스터&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 5}">새&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 6}">고슴도치&nbsp;&nbsp;/</c:when>
					<c:when test="${poutvo.outkind == 7}">토끼&nbsp;&nbsp;/</c:when>
				</c:choose>
				나이 : ${poutvo.outage}  /
				<c:choose>
					<c:when test="${poutvo.outsex == 1}"> 남 </c:when>
					<c:when test="${poutvo.outsex == 2}"> 여 </c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan=2> 
				<b>소개</b>
				<pre>${poutvo.outindex}</pre>
			</td>
		</tr>
	</table>
	<div id="shop_btn">
		<c:choose>
			<c:when test="${loginUser != null && poutvo.outid == loginUser.userid}">
				<input type="button" id="btn" value="입양완료" 
						onclick="location.href='PetServlet?command=pet_adopt_view&outmatch=3&outseq=${poutvo.outseq}'">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=pet_adopt_update_form&outseq=${poutvo.outseq}'">
				<input type="button" id="btn" value="삭제" onclick='delconfirm(${poutvo.outseq});'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_adopt_list'">
			</c:when>
			<c:when test="${login != null && poutvo.outid == login.id}">
				<input type="button" id="btn" value="입양완료" 
						onclick="location.href='PetServlet?command=pet_adopt_view&outmatch=3&outseq=${poutvo.outseq}'">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=pet_adopt_update_form&outseq=${poutvo.outseq}'">
				<input type="button" id="btn" value="삭제" onclick='delconfirm(${poutvo.outseq});'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_adopt_list'">
			</c:when>
			<c:otherwise>
				<input type="button" id="btn" value="찜" 
						onclick="location.href='PetServlet?command=pet_adopt_view&outmatch=2&outseq=${poutvo.outseq}'">
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=pet_adopt_list'">
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../footer.jsp"%>