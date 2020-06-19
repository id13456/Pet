package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.BorderDAO;
import com.pet.dto.BorderVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class petBoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="board/petBoardView.jsp";
		String bseq = request.getParameter("bseq");
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO hvo  = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && hvo == null)
			url = "PetServlet?command=login_form";
		else {
			BorderDAO bdao = BorderDAO.getInstance();
			BorderVO bvo = bdao.getBoard(bseq);
			request.setAttribute("border", bvo);
		}
		
	    request.getRequestDispatcher(url).forward(request, response);
	}
}
