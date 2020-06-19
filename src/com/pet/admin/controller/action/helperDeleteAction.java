package com.pet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.controller.action.Action;
import com.pet.dao.P_helperDAO;
import com.pet.dto.AdminuserVO;

public class helperDeleteAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=helper_list";
		HttpSession session = request.getSession();
		AdminuserVO adminLogin = (AdminuserVO)session.getAttribute("adminLogin");
		
		if(adminLogin == null)
			url = "PetServlet?command=admin_login";
		else {
			P_helperDAO pdao = P_helperDAO.getInstance();
			pdao.deleteHelper(request.getParameter("id"));
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}