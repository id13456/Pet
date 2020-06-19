<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.Timestamp" %>
<%@ page import="com.pet.dto.DiaryVO" %>

<%@ include file="../header.jsp"%>
<%@ include file="../sub_menu.jsp"%>
<%
	Calendar cal = Calendar.getInstance();
	int year = (int)request.getAttribute("y");
	int month = (int)request.getAttribute("m");

	cal.set(year, month, 1);
	// 오늘이 속한 달 또는 전달된 파라미터에 의해 구성된 달의 1일자로 날짜 셋팅
	
	int bgnWeek = cal.get(Calendar.DAY_OF_WEEK);
	// 1일자의 요일 계산
	
	int prevYear = year;
 	int prevMonth = month-1;
 	int nextYear = year;
    int nextMonth = month+1; 
   
    if (prevMonth < 1) {
        prevYear--;
        prevMonth = 11;
    }//1월의 이전달 => 이전년도 12월
   
    if (nextMonth > 11) {
        nextYear++;
        nextMonth = 0;
    }//12월의 다음달 => 다음 년도 1월
%>
<style type="text/css">
	table>tbody>tr>th { font-size:110%; font-weight:bold;}
	table>tbody>tr>td { font-size:110%; font-weight:bold; text-align:right; vertical-align:top; }
	a {text-decoration:none; color:black;}
	a:HOVER { text-decoration:underline; }
	
	table>tbody>tr a {text-decoration:none;}
	table>tbody>tr a:HOVER { text-decoration:underline; }
	
	table>tbody>tr>td:nth-child(1) { color:red; }
	table>tbody>tr>td:nth-child(7) { color:blue; }
</style>

<script type="text/javascript" src="diary/diary.js"></script>
<div id="img_board1"><br><Br><br><br>
	<table cellspacing="1" bgcolor="black" align="center" border="0" width="840">
		<tr align="center" height="70" bgcolor="white">
			<th  colspan="7">
				<a href="PetServlet?command=pet_diary_calendar&y=<%=prevYear %>&m=<%=prevMonth %>&userid=${loginUser.userid}">◀</a>
				<b><%=year %>년 <%=month+1 %>월</b>
				<a href="PetServlet?command=pet_diary_calendar&y=<%=nextYear %>&m=<%=nextMonth %>&userid=${loginUser.userid}">▶</a>
			</th>
		</tr>
		<tr align="center" height="80"  bgcolor="white">
			<th width="128">일</th>
			<th width="128">월</th>
			<th width="128">화</th>
			<th width="128">수</th>
			<th width="128">목</th>
			<th width="128">금</th>
			<th width="128">토</th>
		</tr>
		<tr bgcolor="white" height="80">
			<%
				// 시작요일까지 이동
				for(int i=1 ; i<bgnWeek ; i++) {
					out.println("<td>&nbsp;</td>");
				}
				List<DiaryVO> dlist = (List<DiaryVO>)session.getAttribute("dlist");
				int k=0;
				// 첫날~마지막날까지 처리
				while (cal.get(Calendar.MONTH) == month) {
					String kk = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" 
										+ cal.get(Calendar.DATE) + " 00:00:00.0";
					Timestamp t = Timestamp.valueOf(kk);
					String t1 = (t.getYear()+1900) + "-" + t.getMonth() + "-" + t.getDate();
					out.println("<td><a href='javascript:openwriteview("+cal.get(Calendar.YEAR)+ "," + (cal.get(Calendar.MONTH)+1) + "," 
										+ cal.get(Calendar.DATE)+")'>" + cal.get(Calendar.DATE) + "</a><br>");
					
					 if(dlist.size() != 0){
					      String t2 = (dlist.get(k).getDindate().getYear()+1900) + "-"+dlist.get(k).getDindate().getMonth() 
					    		  						+ "-"+dlist.get(k).getDindate().getDate();
					      while(t1.equals(t2)){
					        out.println("<a href='javascript:openview(" + dlist.get(k).getDseq() + ")'>"
					      										+ dlist.get(k).getDtitle() + "</a><br>");
					        if(k == dlist.size()-1)break;
					        else k++;
					        t2 = (dlist.get(k).getDindate().getYear()+1900) + "-"+dlist.get(k).getDindate().getMonth() + "-"
					        								+dlist.get(k).getDindate().getDate();
					        if(!t1.equals(t2))break;
					      }    
					    }
			
					out.println("</td>");
					
					if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
						if(cal.get(Calendar.DATE) == cal.getActualMaximum(Calendar.DAY_OF_MONTH) ) {
							out.println("</tr>");
						}
						else
							out.println("</tr><tr height='80' bgcolor='white'>");
					// 토요일인 경우 다음줄로 이동
					cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)+1);
					// 날짜 1씩 증가
				}  // 날짜를 하루씩 이동하여 월이 바뀔때까지 화면 출력 
			
				int i=cal.get(Calendar.DAY_OF_WEEK);
				
				if(i != 1)
					for (i=cal.get(Calendar.DAY_OF_WEEK); i<=7; i++)
			        	out.println("<td bgcolor='white'>&nbsp;</td>");
				//끝날짜 부터 토요일 자리까지 빈칸 출력
			%>
		</tr>
	</table>
</div>

<div class="clear"></div>
<%@ include file="../footer.jsp"%>