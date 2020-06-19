package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.P_outDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.P_outVO;
import com.pet.dto.PetuserVO;

public class petAdoptUpdateFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adopt/petAdoptUpdateForm.jsp";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && phvo == null)
			url = "PetServlet?command=login_form";
		else {
			P_outDAO pdao = P_outDAO.getInstance();
			P_outVO poutvo = pdao.getAdopt(request.getParameter("outseq"));
			request.setAttribute("poutvo", poutvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}