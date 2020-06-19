package com.pet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.controller.action.Action;
import com.pet.dao.P_helperDAO;
import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class helperViewAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "helper/helperView.jsp";
		HttpSession session = request.getSession();
		AdminuserVO adminLogin = (AdminuserVO)session.getAttribute("adminLogin");
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(adminLogin == null && pvo == null)
			url = "PetServlet?command=login_form";
		else {
			P_helperDAO pdao = P_helperDAO.getInstance();
			P_helperVO phvo = pdao.getHelper(request.getParameter("id"));
			request.setAttribute("helperVO", phvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}