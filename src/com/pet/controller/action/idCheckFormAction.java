package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.dao.PetuserDAO;

public class idCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "petuser/idcheck.jsp";
		String id = request.getParameter("id");
		PetuserDAO pdao = PetuserDAO.getInstance();
		int message = pdao.confirmID(id);
		
		request.setAttribute("message", message);
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
