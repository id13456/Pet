package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class logoutAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";
		HttpSession session = request.getSession();
		//AdminuserVO adminLogin = (AdminuserVO)session.getAttribute("adminLogin");
	//	PetuserVO pvo = (PetuserVO)session.getAttribute("loginUser");
		//P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		
		session.invalidate();
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}