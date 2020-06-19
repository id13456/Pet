<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="helper/helper.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<h1><center>매칭리스트</center></h1>  
	<form name="frm" method="post">
	<table id="board" align="center">
	  <tr>
  		<th width=50>아이디 </th>
  		<th width=50> 이름 </th>
  		<th width=50>전화</th>
  		<th width=80> 이메일 </th>	
  		<th width=100> 주소 </th>
  		<th width=50>반려동물1</th>
  		<th width=50>반려동물2</th>
  	</tr>
  	<c:forEach items="${userList}" var="PetuserVO">  
  	<tr align="center">
	    <td>${PetuserVO.userid} </td>
    	<td> ${PetuserVO.username} </td>
    	<td> ${PetuserVO.userphone} </td>
    	<td> ${PetuserVO.useremail} </td>
    	<td> [ ${PetuserVO.user_zip_num} ] ${PetuserVO.user_address} </td>
    	<td> 
    		<c:choose> 
 				<c:when test="${PetuserVO.user_pet1 == 1}">개</c:when>
				<c:when test="${PetuserVO.user_pet1 == 2}">고양이</c:when>
				<c:when test="${PetuserVO.user_pet1 == 3}">물고기</c:when>
				<c:when test="${PetuserVO.user_pet1 == 4}">햄스터</c:when>
				<c:when test="${PetuserVO.user_pet1 == 5}">새</c:when>
				<c:when test="${PetuserVO.user_pet1 == 6}">고슴도치</c:when>
				<c:when test="${PetuserVO.user_pet1 == 7}">토끼</c:when>
			</c:choose>
    	</td>
    	<c:choose>
    		<c:when test="${PetuserVO.user_pet2 == null}"><td>&nbsp;</td></c:when>
    		<c:otherwise> 	
    			<td> 
    				<c:choose> 
		 				<c:when test="${PetuserVO.user_pet2 == 1}">개</c:when>
						<c:when test="${PetuserVO.user_pet2 == 2}">고양이</c:when>
						<c:when test="${PetuserVO.user_pet2 == 3}">물고기</c:when>
						<c:when test="${PetuserVO.user_pet2 == 4}">햄스터</c:when>
						<c:when test="${PetuserVO.user_pet2 == 5}">새</c:when>
						<c:when test="${PetuserVO.user_pet2 == 6}">고슴도치</c:when>
						<c:when test="${PetuserVO.user_pet2 == 7}">토끼</c:when>
					</c:choose>
				</td> 
			</c:otherwise>
    	</c:choose>
  </tr>
  </c:forEach>											
  </table>
</form>
</div>

<%@ include file="../footer.jsp"%>

