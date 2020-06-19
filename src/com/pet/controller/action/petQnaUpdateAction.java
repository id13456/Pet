package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.dao.PetQnaDAO;
import com.pet.dto.PetQnaVO;

public class petQnaUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="PetServlet?command=pet_qna_list";
		PetQnaVO qvo = new PetQnaVO();
		qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
		qvo.setQgroup(Integer.parseInt(request.getParameter("qgroup")));
		qvo.setQtitle(request.getParameter("qtitle"));
		qvo.setQcontent(request.getParameter("qcontent"));
		qvo.setQid(request.getParameter("qid"));
		
		PetQnaDAO qdao = PetQnaDAO.getInstance();
		qdao.updateQna(qvo);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
