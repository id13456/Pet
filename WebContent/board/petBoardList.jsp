<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<script type="text/javascript" src="board/board.js"></script>
<div id="main_top">
	<div id="top_title"><h1>자유게시판 / 관리팁</h1></div>
	<div id="img_menu">
	<form name="frm" method="post">
		<select name="search" style="height:25px; width:80px; text-align:center; font-family: 한컴 바겐세일 M; font-weight: bold;">
			<option value=0 selected>게시글종류</option>
			<option value=1>자유게시판</option>
			<option value=2>관리팁</option>
		</select>
		<input type="button" id="btn" value="검색" onclick="go_search_board()">
		<input type="button" id="btn" name="btn_all" value="전체보기" onclick="go_total()">
		<input type="hidden" id="btn" name="all_view" value="y">
		<c:if test="${loginUser != null || login != null}">
			<input type="button" id="btn" value="글쓰기" onclick="location.href='PetServlet?command=pet_board_write_form'">
		</c:if>
	</form>
	</div>
</div>
<div id="img_board">
	<table id="board" align="center">
		<tr>
			<th width="60">순번</th><th width="100">게시글유형</th><th width="420">제목</th>
			<th width="120">작성일</th><th width="110">작성자</th>
		</tr>			
			<c:forEach items="${ petBoardList }" var="border">
				<tr align="center">
					<td>${ border.bseq }</td>    
			       	<td> 
						<c:choose>
							<c:when test="${ border.bgroup==1 }"> 일반게시글 </c:when>
							<c:when test="${ border.bgroup==2 }"> 수의사관리팁 </c:when>
						</c:choose>
			       	</td>
			       	<td>
			       		<a href="PetServlet?command=pet_board_view&bseq=${ border.bseq }"> ${ border.btitle }</a>
			       	</td>
			       	<td><fmt:formatDate value="${ border.bindate }" type="date"/></td>
			       	<td>${ border.bid }</td>
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
