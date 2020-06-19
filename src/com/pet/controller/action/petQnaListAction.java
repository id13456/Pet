package com.pet.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pet.dao.PetQnaDAO;
import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetQnaVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.paging;

public class petQnaListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "petqna/petQnaList.jsp";
		int page = 1;
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		AdminuserVO avo = (AdminuserVO) session.getAttribute("adminLogin");
		
		PetQnaDAO qdao = PetQnaDAO.getInstance();
		ArrayList<PetQnaVO> list = null;
		paging paging = new paging();
		paging.setPage(page);
		int count=0;
		
	    if (pvo == null && hvo == null && avo ==  null) {
	    	url = "PetServlet?command=login_form";
	    } else { 
	    	String my = request.getParameter("my");
	    	String rep = request.getParameter("rep");
			String all_view = request.getParameter("all_view");
			
			if(all_view != null && all_view.equals("y") && session.getAttribute("my") != null
					&& session.getAttribute("rep") != null) {
				session.removeAttribute("my");
				session.removeAttribute("rep");
			}

			if(request.getParameter("my") != null && !request.getParameter("my").equals("")) {
				my = request.getParameter("my");
			} else if(session.getAttribute("my") != null && !session.getAttribute("my").equals("")) {
				my = (String)session.getAttribute("my");
			} else {
				my="2";
			}
			
			if(request.getParameter("rep") != null && !request.getParameter("rep").equals("")) {
				rep = request.getParameter("rep");
			} else if(session.getAttribute("rep") != null && !session.getAttribute("rep").equals("")) {
				rep = (String)session.getAttribute("rep");
			} else {
				rep="y";
			}
			
			if(pvo != null){	
		    	count = qdao.getAllCountUser(pvo.getUserid());
				paging.setTotalCount(count);
		    	list = qdao.listPetQna(paging, pvo.getUserid(), rep);
		    	request.setAttribute("petQnaList", list);
		    } else if(hvo != null){	
		    	count = qdao.getAllCountHelper();
				paging.setTotalCount(count);
		    	list = qdao.p_helperlistPetQna(paging, hvo.getId(), my, rep);
		    	request.setAttribute("petQnaList", list);
		    } else if(avo != null){	
		    	count = qdao.getAllCountAdmin();
				paging.setTotalCount(count);
		    	list = qdao.AdminlistPetQna(paging, rep);
		    	request.setAttribute("petQnaList", list);
		    }
	    }
	    	
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
