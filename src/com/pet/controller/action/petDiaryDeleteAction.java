package com.pet.controller.action;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.DiaryDAO;
import com.pet.dto.PetuserVO;

public class petDiaryDeleteAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_diary_calendar";
		String dseq = request.getParameter("dseq");
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");

		if(pvo == null)
			url = "PetServlet?command=login_form";
		else {
			DiaryDAO ddao = DiaryDAO.getInstance();
			ddao.deleteSchedule(dseq);
		}
		
		response.sendRedirect(url);
	}
}