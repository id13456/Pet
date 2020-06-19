package com.pet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.controller.action.Action;
import com.pet.dao.P_helperDAO;
import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.paging;

public class helperListAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "helper/helperList.jsp";
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		HttpSession session = request.getSession();
		
		AdminuserVO adminLogin = (AdminuserVO)session.getAttribute("adminLogin");
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null && adminLogin == null)
			url = "PetServlet?command=login_form";
		else {
			String area_search = request.getParameter("area_search");
			String all_view = request.getParameter("all_view");
			String sex = request.getParameter("sex");
			String group = request.getParameter("group");
			if(all_view != null && all_view.equals("y") && session.getAttribute("area_search") != null)
				session.removeAttribute("area_search");

			if(request.getParameter("area_search") != null && !request.getParameter("area_search").equals("")) {
				area_search = request.getParameter("area_search");
			}
			else if(session.getAttribute("area_earch") != null && !session.getAttribute("area_search").equals("")) {
				area_search = (String)session.getAttribute("area_search");
			}
			else {
				area_search="";
			}
			paging paging = new paging();
			paging.setPage(page);
			paging.setDisplayRow(6);
			P_helperDAO pdao = P_helperDAO.getInstance();
			int count=0;
			
			if(!area_search.equals("")) {
				count = pdao.getAllCountSearch(area_search);
				paging.setTotalCount(count);
				ArrayList<P_helperVO> phlist = pdao.getHelperSearchList(paging, area_search);
				request.setAttribute("helperList", phlist);
				session.setAttribute("area_search", area_search);
			} else if(sex != null){
				count = pdao.getAllCountSex(sex);
				paging.setTotalCount(count);
				ArrayList<P_helperVO> phlist = pdao.getHelperSexList(paging, sex);
				
				request.setAttribute("helperList", phlist);
			} else if(group != null){
				count = pdao.getAllCountGroup(group);
				paging.setTotalCount(count);
				ArrayList<P_helperVO> phlist = pdao.getHelperGroupList(paging, group);
				
				request.setAttribute("helperList", phlist);
			} else {
				count = pdao.getAllCount();
				paging.setTotalCount(count);
				ArrayList<P_helperVO> phlist = pdao.getHelperList(paging);
			
				request.setAttribute("helperList", phlist);
			}
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}