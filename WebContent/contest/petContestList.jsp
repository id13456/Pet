<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="../header.jsp"%>
 <script type="text/javascript" src="contest/contest.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="main_top">
	<div id="top_title"><h1>My Pet 자랑</h1></div>
	<div id="img_menu">
	<form name="frm" method="post">
		<select name="search" style="height:25px; width:80px; text-align:center; font-family: 한컴 바겐세일 M; font-weight: bold;">
			<option value=0 selected>동물종류</option>
			<option value=1>개</option>
			<option value=2>고양이</option>
			<option value=3>물고기</option>
			<option value=4>햄스터</option>
			<option value=5>새</option>
			<option value=6>고슴도치</option>
			<option value=7>토끼</option>
		</select>
		<input type="button" id="btn" value="검색" onclick="go_search_petkind()">
		<input type="button" id="btn" value="인기순" onclick="go_search_petlike()">
		<input type="button" id="btn" name="btn_all" value="원래대로" onclick="go_total()">
		<input type="hidden" id="btn" name="all_view" value="y">
		<c:if test="${loginUser != null || login != null}">
			<input type="button" id="btn" value="글쓰기" onclick="location.href='PetServlet?command=pet_contest_write_form'">
		</c:if>
	</form>
	</div>
</div>
<div id="img_board">
	<ul id="img_list">
		<c:forEach items="${conList}" var="ConVO">
			<li>
				<a href="PetServlet?command=pet_contest_view&conseq=${ConVO.conseq}">
					<div id="img">
						<img src="images/contest/${ConVO.conimg}">
						<div id="img_text">
							   ${ConVO.contitle}
						</div>
						<div id="img_text_sub">
							조회수 : ${ConVO.conview}<br> 
							좋아요 : ${ConVO.conlike}							
						</div>
					</div>
				</a>
			</li>
		</c:forEach>
	</ul>
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
<div class="clear"></div>
 <%@ include file="../footer.jsp"%>