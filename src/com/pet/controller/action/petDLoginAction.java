package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.P_helperDAO;
import com.pet.dto.P_helperVO;

public class petDLoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=p_helper_login_form";
		String id = request.getParameter("id");
	    String pwd = request.getParameter("pwd");
	    P_helperDAO pdao = P_helperDAO.getInstance();
	    P_helperVO hvo = pdao.getP_helper(id);
	    HttpSession session=request.getSession();
	    
	    if(hvo.getId() != null){
	        	if(hvo.getPwd().equals(pwd)){
	        		session.removeAttribute("id");
			        session.setAttribute("login", hvo);
			        url="PetServlet?command=index";
	        	}
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
