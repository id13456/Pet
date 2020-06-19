package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.dao.ContestDAO;
import com.pet.dto.ContestVO;

public class petContestViewAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "contest/petContestView.jsp";
		ContestDAO cdao = ContestDAO.getInstance();
		String conseq = request.getParameter("conseq");
		String conlike = request.getParameter("conlike");
		if(conlike == null)
			cdao.setConview(conseq);
		else
			cdao.setConlike(conseq);
		
		ContestVO cvo = cdao.getContest(conseq);
		
		request.setAttribute("contest", cvo);
		request.getRequestDispatcher(url).forward(request, response);
	}
}