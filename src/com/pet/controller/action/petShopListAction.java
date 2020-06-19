package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.ShopDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.ShopVO;
import com.pet.dto.paging;

public class petShopListAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "shop/petShopList.jsp";
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && hvo == null)
			url = "PetServlet?command=login_form";
		else {
			String search = request.getParameter("search");
			String s_select = request.getParameter("s_select");
			String all_view = request.getParameter("all_view");
			String match = request.getParameter("match");
			if(all_view != null && all_view.equals("y") && session.getAttribute("search") != null)
				session.removeAttribute("search");

			if(request.getParameter("search") != null && !request.getParameter("search").equals("")) {
				s_select = request.getParameter("s_select");
				search = request.getParameter("search");
			}
			else if(session.getAttribute("search") != null && !session.getAttribute("search").equals("")) {
				s_select = request.getParameter("s_select");
				search = (String)session.getAttribute("search");
			}
			else {
				s_select = "";
				search="";
			}
			
			paging paging = new paging();
			paging.setPage(page);
			paging.setDisplayRow(6);
			ShopDAO sdao = ShopDAO.getInstance();
			int count=0;
			
			if(match == null) {	
				count = sdao.getAllCount(s_select, search);
				paging.setTotalCount(count);
				ArrayList<ShopVO> list = sdao.getShopList(paging, s_select, search);
				request.setAttribute("slist", list);
				session.setAttribute("search", search);
				request.setAttribute("paging", paging);
			} else {
				count = sdao.getAllCount();
				paging.setTotalCount(count);
				ArrayList<ShopVO> list = sdao.getShopListMatch(paging);
				request.setAttribute("slist", list);
				request.setAttribute("paging", paging);
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
