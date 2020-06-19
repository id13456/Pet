package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;

public class removeHelperAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=mypage_form&userid=";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null)
			url = "PetServlet?command=login_form";
		else {
			PetuserDAO pdao = PetuserDAO.getInstance();
			pdao.removeHelper(pvo.getUserid());
		}
		
		request.getRequestDispatcher(url + pvo.getUserid()).forward(request, response);
	}

}
