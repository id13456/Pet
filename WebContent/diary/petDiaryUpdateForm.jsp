<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 수정</title>
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
	<form name="frm" method="post" action="PetServlet?command=pet_diary_update">
		<table cellspacing="1" bgcolor="black" border="0" width="900">
			<tr height="30" bgcolor="white">
				<td colspan="4" align="center" style="font-weight:bold;"><h2>스케줄수정</h2>
				</td>
			</tr>
			<tr height="50" bgcolor="white">
				<td width="150" style="font-weight:bold; text-align:center;">성명(아이디)</td>
				<td width="450" align="center">${loginUser.username}(${loginUser.userid}) 
						<input type="hidden" name="dseq" value="${dview.dseq}"></td>
				</tr>
				<tr height="50" bgcolor="white">
				<td width="150" style="font-weight:bold; text-align:center;">일정 날짜</td>
				<td width="450"align="left">
					<select name="year" style="height:25px; width:80px; text-align:center;">
						<option value="" selected>- 년 - </option>
						<option value="2019">2019</option>
						<option value="2020">2020</option>
						<option value="2021">2021</option>
						<option value="2022">2022</option>
					</select>
					<select name="month" style="height:25px; width:80px; text-align:center;">
						<option value="" selected>- 월 - </option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
						<option value="09">09</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
					</select>
					<select name="date" style="height:25px; width:80px; text-align:center;">
						<option value="" selected>- 일 - </option>
						<option value="01">01</option>
						<option value="02">02</option>
						<option value="03">03</option>
						<option value="04">04</option>
						<option value="05">05</option>
						<option value="06">06</option>
						<option value="07">07</option>
						<option value="08">08</option>
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
						<option value="25">25</option>
						<option value="26">26</option>
						<option value="27">27</option>
						<option value="28">28</option>
						<option value="29">29</option>
						<option value="30">30</option>
						<option value="31">31</option>
					</select>
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
				<td width="450" align="left">
					&nbsp;<input type="text" name="dtitle" value="${dview.dtitle}" size="50">
				</td>
			</tr>
			<tr height="50" bgcolor="white">
				<td width="150" style="font-weight:bold; text-align:center;">일정 내용</td>
				<td width="450" align="left">
					&nbsp;<input type="text" name="dcontent" value="${dview.dcontent}" size="100">
				</td>
			</tr>
			<tr height="40" align="center" bgcolor="white">
				<td colspan="4">
					<input type="submit" name="btn" value="일정수정" onclick="return updateconfirm()">
					<input type="button" name="btn" value="취소" onclick="window.close()">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>