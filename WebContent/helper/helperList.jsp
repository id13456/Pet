<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="../header.jsp"%>
 <script type="text/javascript" src="helper/helper.js"></script>
<%@ include file="../sub_menu.jsp"%>
<div id="main_top">
	<div id="top_title"><h1>펫도우미, 수의사 매칭</h1></div>
	<div id="img_menu2">
	<form name="frm" method="post">
		지역명 : <input type="text" name="area_search" value="${area_search}">
		<input type="button" id="btn" value="검색" onclick="go_search_area()">
		<input type="button" id="btn" name="btn_all" value="전체보기" onclick="go_total_helper()">
		<input type="hidden" id="btn" name="all_view" value="y">
		<c:if test="${adminId != null}">
			<input type="button" id="btn" value="글쓰기" onclick="location.href='PetServlet?command=helper_insert_form'">
		</c:if><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" id="btn" value="여성만" onclick="go_search_woman()">
		<input type="button" id="btn" value="남성만" onclick="go_search_men()">
		<input type="button" id="btn" value="수의사" onclick="go_search_doctor()">
		<input type="button" id="btn" value="펫도우미" onclick="go_search_helper()">
	</form>
	</div>
</div>

<div id="img_board">
	<ul id="img_list">
		<c:forEach items="${helperList}" var="HelperVO">
			<li>
				<a href="PetServlet?command=helper_view&id=${HelperVO.id}">
					<div id="img">
						<c:choose>
							<c:when test="${HelperVO.helper_img == null && HelperVO.sex == 1}">
								<img src="images/helper/man.png">
							</c:when>
							<c:when test="${HelperVO.helper_img == null && HelperVO.sex == 2}">
								<img src="images/helper/girl.png">
							</c:when>
							<c:otherwise>
								<img src="images/helper/${HelperVO.helper_img}">
							</c:otherwise>
						</c:choose>
						<div id="img_text">
							<c:choose>
								<c:when test="${HelperVO.hgroup == 1}">
									<b>[수의사]</b>
								</c:when>
							 	<c:otherwise>
									<b>[펫도우미]</b>
								</c:otherwise>
							</c:choose>
							 ${HelperVO.name} / ${HelperVO.sex}
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