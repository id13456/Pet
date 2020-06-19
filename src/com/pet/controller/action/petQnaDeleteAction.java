package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.dao.PetQnaDAO;


public class petQnaDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="PetServlet?command=pet_qna_list";
		String qseq = request.getParameter("qseq");
		PetQnaDAO qdao = PetQnaDAO.getInstance();
		qdao.deleteQna(qseq);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
