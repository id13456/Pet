<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="petqna/qna.js"></script>
<%@ include file="../sub_menu.jsp"%>
<div id="img_board1">
	<article>
     <h2> 문의 게시판 </h2>
     <h3> 고객님의 질문에 대해서 답변을 드립니다.</h3>    
	 	<form name="form" method="post" action="PetServlet?command=pet_qna_write">
	   		<table id="board" align="center">
	   			<tr>
	   				<th>작성자</th>
	   				<td>
	   					<c:choose>
	   						<c:when test="${loginUser != null }">
	   							${ loginUser.userid }
	   							<input type="hidden" name="qid" value="${ loginUser.userid }">
	   						</c:when>
	   						<c:when test="${login != null }">
	   							${ login.id }
	   							<input type="hidden" name="qid" value="${ login.id }">
	   						</c:when>
	   					</c:choose>
	   				</td>
	   			</tr>	
	   			<tr>
	       			<th>제목</th>
	       			<td><input type="text" name="qtitle" size="70" ></td>
	       		</tr>
	       		<tr>
	       			<th>게시글유형</th>
	       			<td>
	       				<c:choose>
	       					<c:when test="${loginUser != null }">
	       						<input type="radio" name="qgroup" value="1"> 수의사문의 &nbsp;&nbsp;
	       						<input type="radio" name="qgroup" value="2"> 사이트문의
	       					</c:when>
	       					<c:when test="${login != null }">
	       						<input type="radio" name="qgroup" value="2"> 사이트문의
	       					</c:when>
	       				</c:choose>
	       			</td>
	       		</tr>
	   			<tr>
	   				<th>내용</th>
	       			<td><textarea rows="15" cols="70" name="qcontent"></textarea>
	       			<input type="hidden" name="qrep" value="n">
	       			</td>
	       		</tr>
	       	</table>
	   		<br><br>
	  		<div class="clear"></div>
	   		<div id="shop_btn">
	   			<input type="submit" value="글쓰기" id="btn" onclick="return writeconfirm();"> 
	   			<input type="reset" value="취소" id="btn">
	    	</div>
	 	</form>
	 </article>
</div>
<%@ include file="../footer.jsp"%>
