package com.pet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.controller.action.Action;
import com.pet.dao.AdminuserDAO;
import com.pet.dto.AdminuserVO;

public class adminLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="PetServlet?command=admin_login_form";
	    String msg = "";
	    String adminId = request.getParameter("adminId");
	    String adminPwd = request.getParameter("adminPwd");
	    AdminuserDAO adao = AdminuserDAO.getInstance();
	    AdminuserVO avo = adao.adminCheck(adminId);
	    HttpSession session = request.getSession();
	    if(avo != null) {
	    	if(avo.getAdminpwd().equals(adminPwd)) {	    	
	    		session.setAttribute("adminLogin", avo);
	    		url = "PetServlet?command=user_list";
	    	}else {
	    		msg = "비밀번호를 확인하세요.";
	    	}
	    } else {
	    	msg = "아이디를 확인하세요.";
	    }
	    request.setAttribute("message", msg);
	    request.getRequestDispatcher(url).forward(request, response);
	}
}
