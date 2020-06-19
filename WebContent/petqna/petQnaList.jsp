<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript" src="petqna/qna.js"></script>
<style>
.clear { clear: both; }
</style>
<div id="main_top">
	<div id="top_title"><h1>Q&A</h1></div>
	<div id="img_menu">
		<form name="frm" method="post">
			<c:if test="${loginUser != null || login != null}">
				<input type="button" id="btn" value="글쓰기"
						 onclick="location.href='PetServlet?command=pet_qna_write_form'">
			</c:if>
			<c:if test="${loginUser != null}">
				<input type="button" id="btn" value="답변완료" onclick="go_search_myrep()">
				<input type="button" id="btn" name="btn_all" value="전체보기" onclick="go_total_qna()">
				<input type="hidden" name="all_view" value="y">
			</c:if>
			<c:if test="${login != null }">
				<input type="button" id="btn" value="내 질문" onclick="go_search_my()">
			</c:if>
			<c:if test="${login != null || adminLogin != null }">
				<input type="button" id="btn" value="답변전" onclick="go_search_rep()">
				<input type="button" id="btn" name="btn_all" value="전체보기" onclick="go_total_qna()">
				<input type="hidden" name="all_view" value="y">
			</c:if>
		</form>
	</div>
</div>
<div id="img_board">
	<table id="board" align="center">
		<tr>
			<th width="50">순번</th><th width="80">질문유형</th><th width="350">제목</th>
			<th width="100">작성일</th><th width="100">작성자</th><th width="80">답변유무</th>
		</tr>		
			<c:forEach items="${ petQnaList }" var="petqna">
				<tr align="center">
					<td>${ petqna.qseq }</td>    
		        	<td> 
						<c:choose>
							<c:when test="${ petqna.qgroup==1 }"> 수의사문의 </c:when>
							<c:when test="${ petqna.qgroup==2 }"> 사이트문의 </c:when>
						</c:choose>
		       		</td>
		       		<td>
		       			<c:choose>
		       				<c:when test="${ loginUser != null && loginUser.userid==petqna.qid }">
		       					<a href="PetServlet?command=pet_qna_view&qseq=${ petqna.qseq }"> 
		       						${ petqna.qtitle }</a>
		       				</c:when>
		       				<c:when test="${ login.id != null || adminLogin != null}">
		       					<a href="PetServlet?command=helper_qna_dview&qseq=${ petqna.qseq }"> 
		       					${ petqna.qtitle }</a>
		       				</c:when>
		       			</c:choose>
		       		</td>
		       		<td><fmt:formatDate value="${ petqna.qindate }" type="date"/></td>
		       		<td>${ petqna.qid }</td>
		       		<td> 
						<c:choose>
							<c:when test="${petqna.qrep eq 'n'}"> NO </c:when>
							 <c:when test="${petqna.qrep eq 'y'}"> YES </c:when>
						 </c:choose>
		       		</td>
		       	</tr>
	      	</c:forEach>
	</table>
</div>
<div id="pag">
	<br>
	<jsp:include page="paging.jsp">
		<jsp:param value="${paging.page}" name="page"/>
		<jsp:param value="${paging.beginPage}" name="beginPage"/>
		<jsp:param value="${paging.endPage}" name="endPage"/>
		<jsp:param value="${paging.prev}" name="prev"/>
		<jsp:param value="${paging.next}" name="next"/>
	</jsp:include>
</div>
<%@ include file="../footer.jsp"%>
