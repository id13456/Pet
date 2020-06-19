package com.pet.admin.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.controller.action.Action;
import com.pet.dao.P_helperDAO;
import com.pet.dto.AdminuserVO;
import com.pet.dto.P_helperVO;

public class helperUpdateAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=helper_view&id=";
		HttpSession session = request.getSession();
		AdminuserVO adminLogin = (AdminuserVO)session.getAttribute("adminLogin");
		
		if(adminLogin == null) {
			url = "PetServlet?command=admin_login";
			request.getRequestDispatcher(url).forward(request, response);
		}
		else {
			int sizeLimit = 5 * 1024 * 1024;
			String savePath = "images\\helper\\";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			String kind[] = multi.getParameterValues("kind"); 			
			String kind1 = null;
			String kind2 = null;
			String kind3 = null;
			String kind4 = null;
			String kind5 = null;
			
			for(int i=0 ; i<kind.length ; i++) {
				if(kind[i].equals("kind1")) kind1 = "y";
				else if(kind[i].equals("kind2")) kind2 = "y";
				else if(kind[i].equals("kind3")) kind3 = "y";
				else if(kind[i].equals("kind4")) kind4 = "y";
				else if(kind[i].equals("kind5")) kind5 = "y";
			}
			
			if(kind1 == null) kind1 = "n";
			if(kind2 == null) kind2 = "n";
			if(kind3 == null) kind3 = "n";
			if(kind4 == null) kind4 = "n";
			if(kind5 == null) kind5 = "n";
			
			P_helperVO phvo = new P_helperVO();
			phvo.setId(multi.getParameter("id")); 
			phvo.setPwd(multi.getParameter("pwd"));
			phvo.setPhone(multi.getParameter("phone"));
			phvo.setEmail(multi.getParameter("email"));
			phvo.setHos_name(multi.getParameter("hos_name"));
			phvo.setHos_address(multi.getParameter("hos_address"));
			phvo.setHelper_kind1(kind1);
			phvo.setHelper_kind2(kind2);
			phvo.setHelper_kind3(kind3);
			phvo.setHelper_kind4(kind4);
			phvo.setHelper_kind5(kind5);
			phvo.setHelper_index(multi.getParameter("helper_index"));
			phvo.setHelper_img(multi.getOriginalFileName("helper_img"));

			P_helperDAO pdao = P_helperDAO.getInstance();
			pdao.updateHelper(phvo);
			request.getRequestDispatcher(url+multi.getParameter("id")).forward(request, response);
		}
	}
}