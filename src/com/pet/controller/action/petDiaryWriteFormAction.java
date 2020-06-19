package com.pet.controller.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class petDiaryWriteFormAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "diary/PetDiaryWriteForm.jsp";
		String y = request.getParameter("y");
		String m = request.getParameter("m");
		String d = request.getParameter("d");
		String date = y + "-" + m + "-" + d;
		
		request.setAttribute("date", date);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
