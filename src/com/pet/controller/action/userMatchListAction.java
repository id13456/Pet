package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.P_helperDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class userMatchListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "helper/matchList.jsp";
		HttpSession session = request.getSession();
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if(phvo == null) 
			url = "PetServlet?command=login_form";
		else {
			P_helperDAO phdao = P_helperDAO.getInstance();
			ArrayList<PetuserVO> list = phdao.getMatchuserList(phvo.getId());
			
			request.setAttribute("userList", list);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
