<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="helper/helper.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<center><h2>수의사 / 펫도우미 정보</h2></center>
	<table id="board" align="center">
		<tr height="300">
			<td width="400" align="center">
				<c:choose>
					<c:when test="${helperVO.helper_img == null && helperVO.sex == 1}">
						<img src="images/helper/man.png" style="width:300px; height:200px;">
					</c:when>
					<c:when test="${helperVO.helper_img == null && helperVO.sex == 2}">
						<img src="images/helper/girl.png" style="width:300px; height:200px;">
					</c:when>
					<c:otherwise>
						<img src="images/helper/${helperVO.helper_img}" style="width:300px; height:200px;">
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				${helperVO.name} /
				<c:choose> 
					<c:when test="${helperVO.sex == 1}">남성<br></c:when>
					<c:otherwise>여성<br></c:otherwise>
				</c:choose>
				<c:if test="${helperVO.hgroup == 1}">
					병원 이름 : ${helperVO.hos_name} <br>
					병원 주소 : ${helperVO.hos_address}<br> 
				</c:if> 
				이메일 : ${helperVO.email}
			</td>
		</tr>
		<tr align="center">
			<td colspan=2>
				<c:choose>
					<c:when test="${helperVO.helper_kind1 eq 'y' && helperVO.helper_kind2 eq 'y' && helperVO.helper_kind3 eq 'y' }">
						<img src="images/helper/kind1yyy.png">
					</c:when>
					<c:when test="${helperVO.helper_kind1 eq 'n' && helperVO.helper_kind2 eq 'y' && helperVO.helper_kind3 eq 'y' }">
						<img src="images/helper/kind1nyy.png">
					</c:when>
					<c:when test="${helperVO.helper_kind1 eq 'y' && helperVO.helper_kind2 eq 'n' && helperVO.helper_kind3 eq 'y' }">
						<img src="images/helper/kind1yny.png">
					</c:when>
					<c:when test="${helperVO.helper_kind1 eq 'y' && helperVO.helper_kind2 eq 'y' && helperVO.helper_kind3 eq 'n' }">
						<img src="images/helper/kind1yyn.png">
					</c:when>
				</c:choose>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${helperVO.helper_kind4 eq 'y' && helperVO.helper_kind5 eq 'y'}">
						<img src="images/helper/kind2yy.png">
					</c:when>
					<c:when test="${helperVO.helper_kind4 eq 'y' && helperVO.helper_kind5 eq 'n'}">
						<img src="images/helper/kind2yn.png">
					</c:when>
					<c:when test="${helperVO.helper_kind4 eq 'n' && helperVO.helper_kind5 eq 'y'}">
						<img src="images/helper/kind2ny.png">
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<img src="images/helper/kin3.png"><br><br><br><br>
				<b>${helperVO.name} 
				<c:choose>
					<c:when test="${helperVO.hgroup == 1}">
						수의사 님은요<br><br>
					</c:when>
					<c:when test="${helperVO.hgroup == 2}">
						펫도우미 님은요<br>
					</c:when>
				</c:choose></b>
				<pre>${helperVO.helper_index}</pre>
			</td>
		</tr>
	</table>
	<div id="shop_btn">
		<c:choose>
			<c:when test="${adminLogin != null}">
				<input type="button" id="btn" value="수정"
						onclick="location.href='PetServlet?command=helper_update_form&id=${helperVO.id}'">
				<input type="button" id="btn" value="삭제" onclick='delhelperconfirm("${helperVO.id}");'>
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=helper_list'">
			</c:when>
			<c:otherwise>
				<input type="button" id="btn" value="찜" 
						onclick="location.href='PetServlet?command=user_match&helperid=${helperVO.id}'">
				<input type="button" id="btn" value="목록" onclick="location.href='PetServlet?command=helper_list'">
			</c:otherwise>
		</c:choose>
	</div>
</div>

<%@ include file="../footer.jsp"%>