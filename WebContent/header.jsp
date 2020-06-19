<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<link rel="stylesheet" href="css/main2.css">
<html>
<title>My Pet Life</title>
<body>
	<div id="main">
		<header>
			<div id="header" style="height: 80px;">
				<div id="header1">
					<a href="PetServlet?command=index">MY Pet LIFE</a>
				</div>
			<div id="header2">
			<nav>
					<ul>
						<c:choose>
							<c:when test="${empty loginUser && empty adminLogin && empty login}">
								<li>
									<a href="PetServlet?command=login_form"><div id="hlogin">로그인</div></a>
								</li>
								<li>
									<a href="PetServlet?command=join_form"><div id="hlogin">회원가입</div></a>
								</li>
       						</c:when>
       						<c:when test="${adminLogin != null}">
								<div id="my"><b>관리자</b> ${adminLogin.adminname} 님 환영합니다.</div>
         						<li>
       								<a href="PetServlet?command=logout"><div id="hlogin">로그아웃</div></a>
       							</li>
       						</c:when>
       						<c:when test="${login != null}">
								<div id="my">
									<c:choose>
										<c:when test="${login.hgroup == 1}"><b>수의사&nbsp;</b></c:when>
										<c:otherwise><b>펫도우미&nbsp;</b></c:otherwise>
									</c:choose>
									 ${login.name} 님 환영합니다.
									 </div>
         						<li>
       								<a href="PetServlet?command=logout"><div id="hlogin">로그아웃</div></a>
       							</li>
       						</c:when>
       						<c:otherwise>
       							<div id="my">${loginUser.username} 님 환영합니다.</div>
       							<li>
         							<a href="PetServlet?command=mypage_form"><div id="hlogin">마이페이지</div></a>
         						</li>
         						<li>
       								<a href="PetServlet?command=logout"><div id="hlogin">로그아웃</div></a>
       							</li>
       						</c:otherwise>
						</c:choose>
					</ul>
			</nav>
			</div>
		</div>
		</header>
		<div class="clear"></div>
 