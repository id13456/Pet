package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.ShopDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.ShopVO;

public class petShopViewAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop/petShopView.jsp";
		String exseq = request.getParameter("exseq");
		String exmatch = request.getParameter("exmatch");
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && phvo == null)
			url = "PetServlet?command=login_form";
		else {
			ShopDAO sdao = ShopDAO.getInstance();
			sdao.updateExview(exseq);
			if(exmatch != null && pvo != null)
				sdao.updateExmatch(exmatch, exseq, pvo.getUserid());
			else if(exmatch != null && phvo != null)
				sdao.updateExmatch(exmatch, exseq, phvo.getId());
			ShopVO svo = sdao.getProduct(exseq);
			request.setAttribute("svo", svo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}