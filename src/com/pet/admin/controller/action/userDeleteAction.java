package com.pet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.controller.action.Action;
import com.pet.dao.PetuserDAO;

public class userDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=user_list";
		
		String[] useridArr = request.getParameterValues("userid");
		
		for(String userid : useridArr) {
			System.out.println(userid);
			PetuserDAO pdao = PetuserDAO.getInstance();
			pdao.deleteCart(userid);
			}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
