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

public class petAdoptViewAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adopt/petAdoptView.jsp";
		String outmatch = request.getParameter("outmatch");
		HttpSession session = request.getSession();
		PetuserVO puvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO pvo = (P_helperVO) session.getAttribute("login");
		
		P_outDAO pdao = P_outDAO.getInstance();
		pdao.updateOutview(request.getParameter("outseq"));
		
		if(puvo == null && outmatch != null && pvo == null) {
			url = "PetServlet?command=login_form";
		} else {
			if(outmatch != null)
				pdao.updateMatch(outmatch, request.getParameter("outseq"));
		
			P_outVO povo = pdao.getAdopt(request.getParameter("outseq"));
			request.setAttribute("poutvo", povo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}