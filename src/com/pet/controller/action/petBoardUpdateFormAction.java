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

public class petBoardUpdateFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/petBoardUpdateForm.jsp";
		String bseq = request.getParameter("bseq");
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if (pvo == null && phvo == null) {
			url = "PetServlet?command=login_form";
		}else {
			BorderDAO bdao = BorderDAO.getInstance();
			BorderVO bvo = bdao.getUpdate(bseq);
			request.setAttribute("border", bvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
