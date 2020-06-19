package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.ShopDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class petShopMatchCancleAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=shop_match_list&userid=";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && phvo == null)
			url = "PetServlet?command=login_form";
		else {
			ShopDAO sdao = ShopDAO.getInstance();
			sdao.matchCancle(request.getParameter("exseq"));
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
