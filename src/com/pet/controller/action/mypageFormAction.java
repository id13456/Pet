package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;

public class mypageFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "petuser/mypageForm.jsp";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO)session.getAttribute("loginUser");
		
		if(pvo == null) {
			url = "PetServlet?command=login_form";
			request.getRequestDispatcher(url).forward(request, response);
		}
		else {
			PetuserDAO pdao = PetuserDAO.getInstance();
			PetuserVO puvo = pdao.getPetuser(pvo.getUserid());
			request.setAttribute("loginUser", puvo);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}