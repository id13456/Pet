<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<style>
	tr { margin-bottom: 5px; }
	.clear { clear: both; }
</style>
<div id="img_board1">
	<center><h2>Q&A</h2></center>
	<form name="form" method="post" action="PetServlet?command=pet_qna_update&qseq=${ petqna.qseq }">
		<input type="hidden" name="qesq" value="${petqna.qseq}">
		<table id="board" align="center">
		   	<tr> 
		   		<td width="100">작성자</td>
	    		<td width="500"><input type="text" value="${ petqna.qid }" size="12" name="qid" readonly></td>
	    	</tr>
			<tr>
				<td>질문유형</td>
		       	<td>
		       		<c:choose>
		       			<c:when test="${petqna.qgroup == 1 }">
			    			<input type="radio" name="qgroup" value="1" checked>수의사문의 &nbsp;&nbsp;
			       			<input type="radio" name="qgroup" value="2">사이트문의
			       		</c:when>
			       		<c:when test="${petqna.qgroup == 2 }">
			    			<input type="radio" name="qgroup" value="1">수의사문의 &nbsp;&nbsp;
			       			<input type="radio" name="qgroup" value="2" checked>사이트문의
			       		</c:when>
			       	</c:choose>
				</td>
			</tr>
		    <tr>
		    	<td>제목</td>
		      	<td><input type="text" name="qtitle" size="60" value="${ petqna.qtitle }"></td>
		    </tr>
			<tr height="50">
		   		<td>내용</td>
		    	<td><textarea rows="8" cols="65" name="qcontent">${ petqna.qcontent }</textarea></td>
		    </tr>   
	   	</table>
		<div class="clear"></div>
		<div id="shop_btn">
			<input type="submit" value="수정하기" id="btn">
			<input type="reset" value="취소" id="btn" onclick="location.href='PetServlet?command=pet_qna_list'"> 
		</div>	
	</form>
</div>
<%@ include file="../footer.jsp"%>
