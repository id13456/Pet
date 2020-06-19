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

public class petBoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_board_list";
		HttpSession session = request.getSession();
	    PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
	    P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && hvo == null){
	      url = "PetServlet?command=login_form";
	    }else{
	    	BorderVO bvo = new BorderVO();
	    	bvo.setBtitle(request.getParameter("btitle"));
	    	bvo.setBgroup(Integer.parseInt(request.getParameter("bgroup")));
	    	bvo.setBcontent(request.getParameter("bcontent"));
	    	
	    	BorderDAO bdao = BorderDAO.getInstance();
	    	if(pvo != null)
	    		bdao.inertBoard(bvo, pvo.getUserid());
	    	else
	    		bdao.inertBoard(bvo, hvo.getId());
	    }
	    response.sendRedirect(url);
	}

}
