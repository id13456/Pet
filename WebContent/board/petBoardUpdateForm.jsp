<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="board/board.js"></script>
<%@ include file="../sub_menu.jsp"%>
<style>
	tr { margin-bottom: 5px; }
	.clear { clear: both; }
</style>
<div id="img_board1">
	<h1>게시글 수정</h1>
	<form name="frm" method="post" action="PetServlet?command=pet_board_update">
		<input type="hidden" name="bseq" value="${border.bseq}">
		<table id="board" align="center">
			<tr>
				<th>작성자</th>
				<td>${border.bid}<input type="hidden" name="bid" value="${border.bid}"></td>
			</tr>
			<tr>
	       		<th>게시글유형</th>
	       		<td>
	       			<c:choose>
	       				<c:when  test="${border.bgroup == 1}">
	      					<input type="radio" name="bgroup" value="1" checked> 일반 게시글 &nbsp;&nbsp;
	      					<input type="radio" name="bgroup" value="2"> 관리/팁 게시글
	      				</c:when>
	      				<c:when  test="${border.bgroup == 2}">
	      					<input type="radio" name="bgroup" value="1" > 일반 게시글 &nbsp;&nbsp;
	      					<input type="radio" name="bgroup" value="2" checked> 관리/팁 게시글
	      				</c:when>
	      			</c:choose>
	       		</td>
	       	</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" value="${border.btitle}" size="12" name="btitle">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea cols="70" rows="15" name="bcontent">${border.bcontent}</textarea>				
				</td>
			</tr>
		</table>
		<div class="clear"></div>
		<div  id="shop_btn">
			<input type="submit" value="수정하기" id="btn" onclick="return boardCheck()">
			<input type="button" value="취소" id="btn" onclick="location.href='PetServlet?command=pet_board_list'"> 
		</div>	
	</form>
</div>
<%@ include file="../footer.jsp"%>
