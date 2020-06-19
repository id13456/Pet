<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 상세보기</title>
<style type="text/css">
	.content { position:relative; width:900px;  height:277px; margin:0 auto; box-shadow:2px 2px 2px gray; margin-top:60px; }
	table>tbody>tr>th { font-size:110%; font-weight:bold;}
	table>tbody>tr>td { font-size:110%; font-weight:bold;}
	.menu li a {text-decoration:none;}
	.menu li a:HOVER { text-decoration:underline; }
	table>tbody>tr>th a {text-decoration:none; color:black;}
	table>tbody>tr>th a:HOVER { text-decoration:underline; }
</style>

<script type="text/javascript" src="diary/diary.js"></script>

</head>
<body>
<div class="content">
	<table cellspacing="1" bgcolor="black" border="0" width="900">
		<tr height="30" bgcolor="white">
			<td colspan="4" align="center" style="font-weight:bold;"><h2>스케줄보기</h2>
			</td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">성명(아이디)</td>
			<td width="300" align="center">${loginUser.username}(${loginUser.userid}) </td>
			<td width="150" style="font-weight:bold; text-align:center;">일정 날짜</td>
			<td width="300"align="left">&nbsp;${dview.dindate}</td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">일정 제목</td>
			<td width="300" align="left" colspan="3">&nbsp;${dview.dtitle}</td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">일정 내용</td>
			<td width="300" align="left" colspan="3">&nbsp;${dview.dcontent}</td>
		</tr>
		<tr height="40" align="center" bgcolor="white">
			<td colspan="4">
				<input type="button" name="btn" value="일정수정" onclick="location.href='PetServlet?command=pet_diary_update_form&dseq=${dview.dseq}'">
				<input type="button" name="btn" value="일정삭제" onclick='delconfirm(${dview.dseq});'>
				<input type="button" name="btn" value="확인" onclick="window.close()">
			</td>
		</tr>
	</table>
</div>
</body>
</html>