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


public class petBoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="PetServlet?command=pet_board_list";
		HttpSession session = request.getSession();
		P_helperVO pvo = (P_helperVO) session.getAttribute("login");
		PetuserVO uservo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null && uservo == null)
			url = "PetServlet?command=login_form";
		else {
			BorderVO bvo = new BorderVO();
			bvo.setBseq(Integer.parseInt(request.getParameter("bseq")));
			bvo.setBgroup(Integer.parseInt(request.getParameter("bgroup")));
			bvo.setBtitle(request.getParameter("btitle"));
			bvo.setBcontent(request.getParameter("bcontent"));
			bvo.setBid(request.getParameter("bid"));
			BorderDAO bdao = BorderDAO.getInstance();
			bdao.updateBoard(bvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
