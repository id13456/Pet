package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.dao.P_outDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.P_outVO;
import com.pet.dto.PetuserVO;

public class petAdoptWriteAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_adopt_list";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO hvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && hvo == null)
			url = "PetServlet?command=login_form";
		else {
			int sizeLimit = 5 * 1024 * 1024;
			String savePath = "images/adopt";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			P_outVO poutvo = new P_outVO();
			poutvo.setOutid(pvo.getUserid());
			poutvo.setOutage(Integer.parseInt(multi.getParameter("outage")));
			poutvo.setOutarea(multi.getParameter("outarea"));
			poutvo.setOutgroup(Integer.parseInt(multi.getParameter("outgroup")));
			poutvo.setOutindex(multi.getParameter("outindex"));
			poutvo.setOutkind(Integer.parseInt(multi.getParameter("outkind")));
			poutvo.setOutsex(Integer.parseInt(multi.getParameter("outsex")));
			poutvo.setOuttitle(multi.getParameter("outtitle"));
			poutvo.setOutimg(multi.getOriginalFileName("outimg"));
			
			P_outDAO pdao = P_outDAO.getInstance();
			
			pdao.insertAdopt(poutvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
