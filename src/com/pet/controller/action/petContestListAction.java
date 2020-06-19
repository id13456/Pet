package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.ContestDAO;
import com.pet.dto.ContestVO;
import com.pet.dto.paging;

public class petContestListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "contest/petContestList.jsp";
		int page=1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		paging paging = new paging();
		paging.setPage(page);
		paging.setDisplayRow(6);
		int count=0;
		
		String search = request.getParameter("search");
		String all_view = request.getParameter("all_view");
		String like = request.getParameter("like");
		
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
		
		ContestDAO cdao = ContestDAO.getInstance();
		count = cdao.getAllCount(search);
		paging.setTotalCount(count);
		ArrayList<ContestVO> clist = null;
		
		if(like != null) {
			clist = cdao.getContestLikeList(paging);
		} else {
			clist = cdao.getContestList(paging, search);
		}
		
		request.setAttribute("conList", clist);
		request.setAttribute("paging", paging);
		request.getRequestDispatcher(url).forward(request, response);
	}
}