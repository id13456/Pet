package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.dao.ContestDAO;
import com.pet.dto.ContestVO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;

public class petContestUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=pet_contest_view&conseq=";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		ContestDAO cdao = ContestDAO.getInstance();
		
		int sizeLimit = 5 * 1024 * 1024;
		String savePath = "images/contest/";
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		String conimg = multi.getOriginalFileName("conimg");
		ContestVO cvo = new ContestVO();
		cvo.setConseq(Integer.parseInt(request.getParameter("conseq")));
		if(pvo != null)
			cvo.setConid(pvo.getUserid());
		else if(phvo != null)
			cvo.setConid(phvo.getId());
		cvo.setContitle(multi.getParameter("contitle"));
		cvo.setConcontent(multi.getParameter("concontent"));
		cvo.setConanikind(Integer.parseInt(multi.getParameter("conanikind")));
		if(conimg == null)
			cvo.setConimg(multi.getParameter("exconimg"));
		else 
			cvo.setConimg(conimg);
		
		cdao.updateContest(cvo);
		
		request.getRequestDispatcher(url+request.getParameter("conseq")).forward(request, response);
	}

}
