package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetQnaDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetQnaVO;
import com.pet.dto.PetuserVO;

public class petQnaWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="petqna/petQnaWriteForm.jsp";
		HttpSession session = request.getSession();
	    PetuserVO pvo= (PetuserVO) session.getAttribute("loginUser");
	    P_helperVO hvo = (P_helperVO) session.getAttribute("login");
	    if (pvo == null && hvo == null) {
	      url = "PetServlet?command=login_form";
	    }
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
