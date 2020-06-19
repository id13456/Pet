package com.pet.controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.DiaryDAO;
import com.pet.dto.DiaryVO;
import com.pet.dto.PetuserVO;

public class petDiaryWriteAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_diary_calendar";
		String date = request.getParameter("date");
		String hour = request.getParameter("hour");
		String minute = request.getParameter("minute");
		String t1 = date + " " + hour + ":" + minute + ":00.0";
		Timestamp dindate = Timestamp.valueOf(t1);
		
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");

		if(pvo == null)
			url = "PetServlet?command=login_form";
		else {
			DiaryVO dvo = new DiaryVO();
			dvo.setDid(pvo.getUserid());
			dvo.setDindate(dindate);
			dvo.setDtitle(request.getParameter("dtitle"));
			dvo.setDcontent(request.getParameter("dcontent"));
			
			DiaryDAO ddao = DiaryDAO.getInstance();
			ddao.insertDiary(dvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}