package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;

public class loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=login_form";

		String userid = request.getParameter("userid");
	    String userpwd = request.getParameter("userpwd");
	    PetuserDAO pdao = PetuserDAO.getInstance();
	    PetuserVO pvo = pdao.getPetuser(userid);
	    HttpSession session=request.getSession();

	    if(pvo.getUserid() != null){
	        	if(pvo.getUserpwd().equals(userpwd)){    
			          session.removeAttribute("userid");
			          session.setAttribute("loginUser", pvo);
			          url="PetServlet?command=index";
	        	}
	        	else
	        		request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
	    }
	    else
    		request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
	    request.getRequestDispatcher(url).forward(request, response);
	}
	
}
