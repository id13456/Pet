<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 상세보기</title>
<style type="text/css">
	.content { position:relative; width:900px;  height:328px; margin:0 auto; box-shadow:2px 2px 2px gray; margin-top:60px; }
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
	<form name="frm" action="PetServlet?command=pet_diary_write" method="post">
	<table cellspacing="1" bgcolor="black" border="0" width="900">
		<tr height="30" bgcolor="white">
			<td colspan="4" align="center" style="font-weight:bold;"><h2>스케줄추가</h2>
			</td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">성명(아이디)</td>
			<td width="300" align="center">${loginUser.username}(${loginUser.userid}) </td>
			<td width="150" style="font-weight:bold; text-align:center;">일정 날짜</td>
			<td width="300"align="left">&nbsp;${date}<input type="hidden" name="date" value="${date}"></td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">일정 시간</td>
			<td width="300" align="left" colspan="3">
				<select name="hour" style="height:25px; width:80px; text-align:center;">
					<option value="" selected>- 시 - </option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
				</select>
				<select name="minute" style="height:25px; width:80px; text-align:center;">
					<option value="" selected>- 분 - </option>
					<option value="00">00</option>
					<option value="30">30</option>
				</select>
			</td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">일정 제목</td>
			<td width="300" align="left" colspan="3"><input type="text" name="dtitle" size="50"></td>
		</tr>
		<tr height="50" bgcolor="white">
			<td width="150" style="font-weight:bold; text-align:center;">일정 내용</td>
			<td width="300" align="left" colspan="3"><input type="text" name="dcontent" size="100"></td>
		</tr>
		<tr height="40" align="center" bgcolor="white">
			<td colspan="4">
				<input type="submit" name="btn" value="일정추가" onclick="return writeconfirm();">
				<input type="button" name="btn" value="취소" onclick="window.close()">
			</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>