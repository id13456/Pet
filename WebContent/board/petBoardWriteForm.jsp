<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="board/board.js"></script>
<%@ include file="../sub_menu.jsp"%>
<style>
	.clear { clear: both; }
	#buttons { margin:0 auto; align: center; }
</style>
<div id="img_board1">
     <h2> 자유 게시판 </h2>
	 	<form name="frm" method="post" action="PetServlet">
	 	<input type="hidden" name="command" value="pet_board_write">
	   		<table id="board" align="center">
	   			<tr>
	   				<th>작성자</th>
	   				<td>
	   					<c:choose>
	   						<c:when test="${empty login}">${ loginUser.userid }</c:when>
	   						<c:when test="${empty loginUser}">${ login.id }</c:when>
	   					</c:choose>
	   				</td>
	   			<tr> 
	       			<th>제목</th>
	       			<td><input type="text" name="btitle" size="70" ></td>
	       		</tr>
	       		<tr>
	       			<th>게시글유형</th>
	       			<td>
	       				<c:choose>
	   						<c:when test="${empty login}"><input type="radio" name="bgroup" value="1"> 일반 게시글</c:when>
	   						<c:when test="${empty loginUser}">
								<input type="radio" name="bgroup" value="1"> 일반 게시글
								<input type="radio" name="bgroup" value="2"> 관리팁
							</c:when>
	   					</c:choose>
	       			</td>
	       		</tr>
	       		<tr>
	   				<th>내용</th>
	       			<td><textarea rows="15" cols="70" name="bcontent"></textarea></td>
	       		</tr>
	   		</table>
	   		<br><br>
	  		<div class="clear"></div>
	   		<div id="shop_btn">
	   			<input type="submit" value="글쓰기" id="btn" onclick="return boardCheck()"> 
	   			<input type="reset" value="취소" id="btn">
	    	</div>
	 	</form>
</div>
<%@ include file="../footer.jsp"%>
