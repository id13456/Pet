<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../header.jsp"%>
<script type="text/javascript" src="shop/shop.js"></script>
<%@ include file="../sub_menu.jsp"%>

<div id="img_board1">
	<h1><center>물물교환 - 매칭리스트</center></h1>  
	<form name="frm" method="post">
	<table id="board" align="center">
	  <tr>
	  	<th width=50>번호</th>
  		<th width=150>물품제목</th>
  		<th width=80> 아이디 </th>
  		<th width=100>전화</th>
  		<th width=100> 이메일 </th>	
  		<th width=50> &nbsp; </th>
  	</tr>
  	<c:forEach items="${matchList}" var="MatchVO">  
  	<tr align="center">
  		<td>${MatchVO.exseq }</td>
    	<td>
			<a href="PetServlet?command=shop_view&exseq=${MatchVO.exseq }">${MatchVO.extitle }</a>
		</td>
	    <td>${MatchVO.exmatchid } </td>
    	<td> ${MatchVO.userphone} </td>
    	<td> ${MatchVO.useremail} </td>
    	<td> 
    		<input type="button" id="btn" value="매칭취소"	onclick="matchCancel(${MatchVO.exseq })">
    	</td>
  </tr>
  </c:forEach>											
  </table>
</form>
</div>

<%@ include file="../footer.jsp"%>

