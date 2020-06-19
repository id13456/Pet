package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;


public class findIdFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "petuser/findId.jsp";
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");

		if(phone != null && phone.trim().equals("") == false) {
			PetuserDAO pdao = PetuserDAO.getInstance();
			PetuserVO pvo = new PetuserVO();
			pvo = pdao.getMemberByphone(phone);
			
			if(pvo == null)
				request.setAttribute("message", "일치하는 회원이 없습니다.");
			else if(pvo.getUsername().equals(name)) {
				request.setAttribute("selectId", pvo);
			} else {
				request.setAttribute("message", "일치하는 회원이 없습니다.");
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
