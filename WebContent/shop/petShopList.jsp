<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="../header.jsp"%>
 <script type="text/javascript" src="shop/shop.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="main_top">
	<div id="top_title"><h1>용품 물물교환</h1></div>
	<div id="img_menu2">
	<form name="frm" method="post">
		<select name="s_select" style="height:25px; width:80px; text-align:center; font-family: 한컴 바겐세일 M; font-weight: bold;">
			<option value="" selected>검색유형</option>
			<option value="area">지역명</option>
			<option value="product">상품명</option>
		</select>
		<input type="text" id="search" value="${search}">
		<input type="button" id="btn" value="검색" onclick="go_search()"><br>
		<input type="button" id="btn" value="매칭전 물품만" onclick="go_search_match()">
		<input type="button" id="btn" name="btn_all" value="전체보기" onclick="go_total()">
		<input type="hidden" id="btn" name="all_view" value="y">
		<input type="button" id="btn" value="글쓰기" 
				onclick="location.href='PetServlet?command=shop_write_form'">
		<input type="button" id="btn" value="매칭리스트" 
			onclick="location.href='PetServlet?command=shop_match_list&userid=${loginUser.userid}'">
	</form>
	</div>
</div>
<div id="img_board">
	<ul id="img_list">
		<c:forEach items="${slist}" var="ShopVO">
			<li>
				<a href="PetServlet?command=shop_view&exseq=${ShopVO.exseq}">
					<div id="img">
						<c:choose>
							<c:when test="${ShopVO.eximg == null}">
								<img src="images/nonimg.jpeg">
							</c:when>
							<c:otherwise>
								<img src="images/${ShopVO.eximg}">
							</c:otherwise>
						</c:choose>
						<div id="img_text">${ShopVO.extitle} 
							<c:choose>
							<c:when test="${ShopVO.exmatch == 3}">
								<b>[매칭완료]</b>
							</c:when>
							<c:when test="${ShopVO.exmatch == 2}">
								<b>[매칭중]</b>
							</c:when>
							</c:choose>
						</div>
						<div id="img_text_sub">
							지역 : ${ShopVO.exarea}<br> 
							매칭여부 : 
							<c:choose>
								<c:when test="${ShopVO.exmatch == 2}">매칭중</c:when>
								<c:when test="${ShopVO.exmatch == 3}">매칭완료</c:when>
								<c:otherwise>매칭전</c:otherwise>
							</c:choose>							
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