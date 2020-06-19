package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.P_outDAO;
import com.pet.dao.ShopDAO;
import com.pet.dto.P_outVO;
import com.pet.dto.ShopVO;
import com.pet.dto.paging;

public class petAdoptListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "adopt/petAdoptList.jsp";
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		
		String search = request.getParameter("search");
		String all_view = request.getParameter("all_view");
		String match = request.getParameter("match");
		String group = request.getParameter("group");
		
		if(all_view != null && all_view.equals("y") && session.getAttribute("search") != null)
			session.removeAttribute("search");

		if(request.getParameter("search") != null && !request.getParameter("search").equals("")) {
			search = request.getParameter("search");
		}
		else if(session.getAttribute("search") != null && !session.getAttribute("search").equals("")) {
			search = (String)session.getAttribute("search");
		}
		else {
			search="0";
		}
		P_outDAO pdao = P_outDAO.getInstance();
		ArrayList<P_outVO> list = null;
		paging paging = new paging();
		paging.setPage(page);
		paging.setDisplayRow(6);
		int count=0;
		
		if(match != null) {
			count = pdao.getAllCount();
			paging.setTotalCount(count);
			list = pdao.getAdoptListMatch(paging);
			request.setAttribute("adoptList", list);
			request.setAttribute("paging", paging);
		} else if(group != null) {
			count = pdao.getAllCount(group);
			paging.setTotalCount(count);
			list = pdao.getAdoptListGroup(paging, group);
			request.setAttribute("adoptList", list);
			request.setAttribute("paging", paging);
		} else {
			count = pdao.getAllCountSearch(search);
			paging.setTotalCount(count);
			list = pdao.getAdoptList(paging, search);
			request.setAttribute("adoptList", list);
			request.setAttribute("paging", paging);
		} 

		request.getRequestDispatcher(url).forward(request, response);
	}
}