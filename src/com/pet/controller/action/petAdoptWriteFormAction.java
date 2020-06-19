package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dto.PetuserVO;

public class petAdoptWriteFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adopt/petAdoptWriteForm.jsp";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null)
			url = "PetServlet?command=login_form";
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
