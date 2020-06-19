package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;

public class mypageUpdateAction implements Action {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=mypage_form";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		
		if(pvo == null) 
			url = "PetServlet?command=login_form";
		else {
			int sizeLimit = 5*1024*1024;
			String savsPath = "\\images\\";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savsPath);
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			PetuserDAO pdao = PetuserDAO.getInstance();
			PetuserVO puvo = new PetuserVO();
			puvo.setUserid(pvo.getUserid());
			puvo.setUserpwd(multi.getParameter("userpwd"));
			puvo.setUserphone(multi.getParameter("userphone"));
			puvo.setUseremail(multi.getParameter("useremail"));
			puvo.setUser_zip_num(multi.getParameter("user_zip_num"));
			puvo.setUser_address(multi.getParameter("user_address"));
			puvo.setUser_pet1(Integer.parseInt(multi.getParameter("user_pet1")));
			if(multi.getParameter("user_pet2") != null)
				puvo.setUser_pet2(Integer.parseInt(multi.getParameter("user_pet2")));
			else 
				puvo.setUser_pet2(0);
			
			if(multi.getOriginalFileName("user_img") == null)
				puvo.setUser_img(multi.getParameter("ex_img"));
			else
				puvo.setUser_img(multi.getOriginalFileName("user_img"));
			
			pdao.updateUser(puvo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}