package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.DiaryDAO;
import com.pet.dto.DiaryVO;
import com.pet.dto.PetuserVO;

public class petDiaryCalendarAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "diary/petDiaryCalendar.jsp";
		Calendar cal = Calendar.getInstance();
		int year;
		int month;
		if(request.getParameter("y") == null)
			year = cal.get(Calendar.YEAR);
		else 
			year = Integer.parseInt(request.getParameter("y"));
		if(request.getParameter("m") == null)
			month = cal.get(Calendar.MONTH);
		else 
			month = Integer.parseInt(request.getParameter("m"));
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");

		if(pvo == null)
			url = "PetServlet?command=login_form";
		else {
			String userid = request.getParameter("userid");
		
			List<DiaryVO> list = new ArrayList<DiaryVO>();
			DiaryDAO sdao = DiaryDAO.getInstance();
			list = sdao.getSchedule(year, month+1, userid);
		
			session.setAttribute("dlist", list);
			request.setAttribute("y", year);
			request.setAttribute("m", month);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
