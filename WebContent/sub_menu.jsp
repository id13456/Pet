<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<div id="sub_menu">
	<div id="sub_img">
		<c:choose>
			<c:when test="${ empty loginUser || loginUser.user_img == null}">
				<img src="images/main.jpeg" style="width: 315px; height: 350px;">
			</c:when>
			<c:otherwise>
				<img src="images/${loginUser.user_img}" style="width: 315px; height: 350px;">
			</c:otherwise>
		</c:choose>
	</div>
	<div id="list">
		<ul id="m_list">
		<c:choose>
			<c:when test="${ empty loginUser && empty adminLogin && empty login}">
				<li><a href="PetServlet?command=pet_contest_list">My Pet 자랑</a></li>
				<li><a href="PetServlet?command=pet_adopt_list">Pet 분양</a></li>
				<li><a href="PetServlet?command=pet_board_list">자유게시판</a></li>
			</c:when>
			<c:when test="${adminLogin != null}">
				<li><a href="PetServlet?command=user_list">회원리스트</a></li>
				<li><a href="PetServlet?command=helper_list">펫도우미/수의사 리스트</a></li>
				<li><a href="PetServlet?command=pet_qna_list">Q&A</a></li>
			</c:when>
			<c:when test="${login != null}">
				<li><a href="PetServlet?command=user_match_list">매칭리스트</a></li>
				<li><a href="PetServlet?command=pet_contest_list">My Pet 자랑</a></li>
				<li><a href="PetServlet?command=pet_adopt_list">Pet 분양</a></li>
				<li><a href="PetServlet?command=shop_list">용품 물물교환</a></li>
				<li><a href="PetServlet?command=pet_qna_list">Q&A</a></li>
				<li><a href="PetServlet?command=pet_board_list">자유게시판 / 관리팁</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="PetServlet?command=pet_contest_list">My Pet 자랑</a></li>
				<li><a href="PetServlet?command=pet_adopt_list">Pet 분양</a></li>
				<li><a href="PetServlet?command=pet_board_list">자유게시판 / 관리팁</a></li>
				<li><a href="PetServlet?command=pet_diary_calendar&userid=${loginUser.userid}">My Pet 일기</a></li>
				<li><a href="PetServlet?command=shop_list">용품 물물교환</a></li>
				<li><a href="PetServlet?command=pet_qna_list">Q&A</a></li>
				<li><a href="PetServlet?command=helper_list">펫 도우미, 수의사 매칭</a></li>
			</c:otherwise>
		</c:choose>
		</ul>
	</div>
</div>