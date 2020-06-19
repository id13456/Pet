package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		HttpSession session = request.getSession();
		P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		AdminuserVO avo = (AdminuserVO) session.getAttribute("adminLogin");
		
		if(hvo != null)
			url = "PetServlet?command=user_match_list";
		else if(pvo != null)
			url = "PetServlet?command=pet_diary_calendar";
		else if(avo != null)
			url = "PetServlet?command=user_list";
		else 
			url = "main.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
