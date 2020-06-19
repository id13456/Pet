<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
 <script type="text/javascript" src="petqna/qna.js"></script>
<%@ include file="../sub_menu.jsp"%>
<div id="img_board1">
	<center><h2>Q&A 답변</h2></center>
	<form name="form" method="post">
		<table id="board" align="center">
			<tr height="50">
				<td width="500" align="center" colspan="2">${ petqna.qtitle }</td>
				<td width="80" align="right">${ petqna.qid }</td>
				<td width="100" align="right"><fmt:formatDate value="${ petqna.qindate }" type="date"/></td>
			</tr>
			<tr height="50">
				<th>문의</th>
				<td>
					<c:choose>
						<c:when test="${ petqna.qgroup eq 1 }">수의사문의</c:when>
						<c:when test="${ petqna.qgroup eq 2 }">사이트문의</c:when>
					</c:choose>
				</td>
				<td width="100" align="right" colspan="2">답변 유무 : ${petqna.qrep}</td>
			</tr>
			<tr height="200">
				<th>질문내용</th>
				<td colspan="4">${ petqna.qcontent }</td> 
			</tr>
		</table>
		<c:choose>         
			<c:when test='${petqna.qrep eq "n" && !(petqna.qid eq login.id)}'>
		  		<table align="center" width="580">
		  			<tr>
		  				<th>답변자 </th>
		  				<td>
		  					<c:choose>
		  						<c:when test="${login != null }">
		  							수의사(${ login.id })	
		  							<input type="hidden" name="qreid" value="${login.id }">
		  						</c:when>
		  						<c:when test="${adminLogin != null }">
		  							관리자(${ adminLogin.adminid })	
		  							<input type="hidden" name="qreid" value="${adminLogin.adminid }">
		  						</c:when>
		  					</c:choose>
		  				</td>
		  			</tr>
		    		<tr>
		          		<td colspan="2" width="500">   
		      				<textarea name="qreply" rows="5" cols="1000" style="width:500px; height:100px;">
		      				</textarea><br><br>
		      				<center>
		      					<input type="button" id="btn" value="저장" onclick="go_rep(${petqna.qseq});">
		      				</center>   
		      			</td>
		      		</tr>
		 		</table>
		  	</c:when>
		</c:choose>
		<c:if test="${petqna.qrep eq 'y' }"> 
			<table align="center"  width="580">
				<tr>
			    	<th>답변</th>
			     	<td>답변자 ${petqna.qreid }</td>
			    </tr>
			    <tr>
			    	<td colspan="2"> <center>${petqna.qreply}</center></td>
			    </tr>
			</table>
		</c:if>
		<div id="shop_btn">
			<c:if test="${ login.id == petqna.qid && petqna.qrep eq 'n' }">
				<input type="button" value="수정하기" id="btn" style="align:center;"
				onclick="location.href='PetServlet?command=pet_qna_update_form&qseq=${petqna.qseq}'">
			</c:if>
			<c:if test="${ login.id == petqna.qid }">
				<input type="button" value="삭제하기" id="btn" style="align:center;"
					onclick="delconfirm(${ petqna.qseq })">
			</c:if>
			<input type="button" value="목록보기" id="btn" style="align:center;"
				onclick="location.href='PetServlet?command=pet_qna_list'"> 
		</div>	
	</form>
</div>
<%@ include file="../footer.jsp"%>
