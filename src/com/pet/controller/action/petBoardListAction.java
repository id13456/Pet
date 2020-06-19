package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.BorderDAO;
import com.pet.dao.P_outDAO;
import com.pet.dto.BorderVO;
import com.pet.dto.P_outVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.paging;
public class petBoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "board/petBoardList.jsp";
		
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		
		String search = request.getParameter("search");
		String all_view = request.getParameter("all_view");
		
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
		
		BorderDAO bdao = BorderDAO.getInstance();
		ArrayList<BorderVO> list = null;
		paging paging = new paging();
		paging.setPage(page);
		paging.setDisplayRow(10);
		int count=0;
		
		count =bdao.getAllCountSearch(search);
		paging.setTotalCount(count);
		
		list = bdao.listPetBoard(paging, search);
		
		request.setAttribute("paging", paging);
		request.setAttribute("petBoardList", list);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
