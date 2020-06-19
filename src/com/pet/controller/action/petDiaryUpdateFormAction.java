package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.DiaryDAO;
import com.pet.dto.DiaryVO;
import com.pet.dto.PetuserVO;

public class petDiaryUpdateFormAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "diary/petDiaryUpdateForm.jsp";
		String dseq = request.getParameter("dseq");
		
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");

		if(pvo == null)
			url = "PetServlet?command=login_form";
		else {
			DiaryVO dvo = new DiaryVO();
			DiaryDAO ddao = DiaryDAO.getInstance();
			dvo = ddao.getScheduleView(dseq);
			session.setAttribute("dview", dvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}