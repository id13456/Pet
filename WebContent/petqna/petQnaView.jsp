<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<script type="text/javascript" src="petqna/qna.js"></script>
<%@ include file="../sub_menu.jsp"%>
<style>
	tr { margin-bottom: 5px; }
	.clear { clear: both; }
</style>
<div id="img_board1">
	<center><h2>Q&A</h2></center>
	<form name="form" method="post">
		<table id="board" align="center">
			<tr height="50">
				<td width="300" align="center" colspan="2">${ petqna.qtitle }</td>
				<td width="80" align="right">${ petqna.qid }</td>
				<td width="100" align="right"><fmt:formatDate value="${ petqna.qindate }" type="date"/></td>
			</tr>
			<tr height="50">
				<th>문의</th>
				<td>
					<c:choose>
						<c:when test="${ petqna.qgroup eq 1 }">수의사문의</c:when>
						<c:when test="${ petqna.qgroup eq 2 }">사이트문의</c:when>
					</c:choose>
				</td>
				<td colspan="2">&nbsp;</td>
			</tr>
			<tr height="200">
				<th>질문내용</th>
				<td colspan="4">${ petqna.qcontent }</td> 
			</tr>
			<c:choose>
				<c:when test="${petqna.qrep eq 'y'}">	
					<tr>
						<th>답변 작성자</th>
						<td colspan="4">${ petqna.qreid }</td>
					</tr>
					<tr>
		        		<th>답변</th>
		        		<td colspan="4">${ petqna.qreply }</td>
		        	</tr>
		        </c:when>
			</c:choose>
		</table>
		<div id="shop_btn">
		<c:if test="${ loginUser.userid == petqna.qid && petqna.qrep eq 'n' }">
			<input type="button" value="수정하기" id="btn"
				onclick="location.href='PetServlet?command=pet_qna_update_form&qseq=${petqna.qseq}'">
		</c:if>
		<c:if test="${ loginUser.userid == petqna.qid }">
			<input type="button" value="삭제하기" id="btn"
				onclick="delconfirm(${ petqna.qseq })">
		</c:if>	
		<input type="button" value="목록보기" id="btn"
				onclick="location.href='PetServlet?command=pet_qna_list'"> 
		</div>	
	</form>
</div>
<%@ include file="../footer.jsp"%>
