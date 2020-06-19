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

public class petAdoptUpdateAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_adopt_view&outseq=";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		
		if(pvo == null && phvo == null) {
			url = "PetServlet?command=login_form";
			request.getRequestDispatcher(url).forward(request, response);
		} else {
			int sizeLimit = 5 * 1024 * 1024;
			String savePath = "images/adopt";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			String outimg = multi.getOriginalFileName("outimg");
			P_outVO poutvo = new P_outVO();
			poutvo.setOutseq(Integer.parseInt(multi.getParameter("outseq")));
			poutvo.setOutage(Integer.parseInt(multi.getParameter("outage")));
			poutvo.setOutarea(multi.getParameter("outarea"));
			poutvo.setOutgroup(Integer.parseInt(multi.getParameter("outgroup")));
			poutvo.setOutindex(multi.getParameter("outindex"));
			poutvo.setOutkind(Integer.parseInt(multi.getParameter("outkind")));
			poutvo.setOutsex(Integer.parseInt(multi.getParameter("outsex")));
			poutvo.setOuttitle(multi.getParameter("outtitle"));
			if(outimg == null)
				poutvo.setOutimg(multi.getParameter("exoutimg"));
			else
				poutvo.setOutimg(outimg);
			
			P_outDAO pdao = P_outDAO.getInstance();
			
			pdao.updateAdopt(poutvo);
			
			request.getRequestDispatcher(url+multi.getParameter("outseq")).forward(request, response);
		} 
	}
}