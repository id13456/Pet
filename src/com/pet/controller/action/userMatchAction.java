package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;

public class userMatchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=helper_view&id=";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null) {
			url = "PetServlet?command=login_form";
		} else {
			PetuserDAO pdao = PetuserDAO.getInstance();
			pdao.matchHelper(request.getParameter("helperid"), pvo.getUserid());
		}
		
		request.getRequestDispatcher(url+request.getParameter("helperid")).forward(request, response);
	}
	
}
