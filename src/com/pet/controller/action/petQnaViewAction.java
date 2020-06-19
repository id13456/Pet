package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetQnaDAO;
import com.pet.dto.PetQnaVO;
import com.pet.dto.PetuserVO;

public class petQnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="petqna/petQnaView.jsp";
	    int qseq = Integer.parseInt(request.getParameter("qseq"));
	    PetQnaDAO qdao = PetQnaDAO.getInstance();
	    PetQnaVO qvo = qdao.getPetQna(qseq);
	    request.setAttribute("petqna", qvo);
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
