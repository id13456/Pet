package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetQnaDAO;
import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetQnaVO;

public class petQnaRepAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_qna_list";
		HttpSession session = request.getSession();
		P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		AdminuserVO avo = (AdminuserVO) session.getAttribute("adminLogin");
		
		if(hvo == null && avo == null)
			url = "PetServlet?command=login_form";
		else {
			PetQnaVO qvo = new PetQnaVO();
			qvo.setQseq(Integer.parseInt(request.getParameter("qseq")));
			qvo.setQreply(request.getParameter("qreply"));
			qvo.setQreid(request.getParameter("qreid"));
			
			PetQnaDAO qdao =  PetQnaDAO.getInstance();
			qdao.qreplyQna(qvo);
		}
		response.sendRedirect(url);
		
	}

}
