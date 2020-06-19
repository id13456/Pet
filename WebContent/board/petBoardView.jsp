<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="board/board.js"></script>
<%@ include file="../sub_menu.jsp"%>
<c:if test="${empty loginUser && empty login && empty adminLogin}">
	<jsp:forward page='PetServlet?command=login_form' />
</c:if>
<div id="img_board1">
	<center><h2>자유게시판</h2></center>
	<form name="form" method="post">
		<table id="board"  align="center">
			<tr height="50">
				<th width="250">제목</th>
				<td width="400">${ border.btitle }</td>
		        <td width="80" align="left">${ border.bid }</td>
				<td width="100" align="left"><fmt:formatDate value="${ border.bindate }" type="date"/></td>
			</tr>
			<tr height="50">
				<th>게시글 종류</th>
				<td colspan="3">
					<c:choose>
						<c:when test="${ border.bgroup==1 }"> 일반게시글 </c:when>
						<c:when test="${ border.bgroup==2 }"> 수의사관리팁 </c:when>
					</c:choose>
				</td>
			</tr>
			<tr height="400">
				<th>게시글 내용</th>
				<td colspan="3">${ border.bcontent }</td> 
			</tr>
		</table>
		<div class="clear"></div>
		<div  id="shop_btn">
			<c:choose>
				<c:when test="${ loginUser.userid==border.bid }">
					<input type="button" value="수정하기" id="btn" 
					onclick="location.href='PetServlet?command=pet_board_update_form&bseq=${ border.bseq }'">
				</c:when>
				<c:when test="${ login.id==border.bid }">
					<input type="button" value="수정하기" id="btn" 
					onclick="location.href='PetServlet?command=pet_board_update_form&bseq=${ border.bseq }'">
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${ loginUser.userid==border.bid }">
					<input type="button" value="삭제하기" id="btn" onclick="delconfirm(${border.bseq });">
				</c:when>
				<c:when test="${ login.id==border.bid }">
					<input type="button" value="삭제하기" id="btn" onclick="delconfirm(${border.bseq });">
				</c:when>
			</c:choose>
			
			<input type="button" value="목록보기" id="btn" onclick="location.href='PetServlet?command=pet_board_list'"> 
		</div>	
	</form>
</div>
<%@ include file="../footer.jsp"%>
