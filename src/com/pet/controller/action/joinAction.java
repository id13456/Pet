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

public class joinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sizeLimit = 5*1024*1024;
		String savsPath = "\\images\\";
		HttpSession session = request.getSession();
		
		ServletContext context = session.getServletContext();
		String uploadFilePath = context.getRealPath(savsPath);
		
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
		String img = "main.jpeg";
		
		PetuserVO pvo = new PetuserVO();
		pvo.setUserid(multi.getParameter("userid"));
		pvo.setUserpwd(multi.getParameter("userpwd"));
		pvo.setUsername(multi.getParameter("username"));
		pvo.setUserphone(multi.getParameter("phone"));
		pvo.setUseremail(multi.getParameter("useremail"));
		pvo.setUser_zip_num(multi.getParameter("user_zip_num"));
		pvo.setUser_address(multi.getParameter("user_address"));
		pvo.setUser_pet1(Integer.parseInt(multi.getParameter("user_pet1")));
		if(multi.getParameter("user_pet2") != null)
			pvo.setUser_pet2(Integer.parseInt(multi.getParameter("user_pet2")));
		if(multi.getOriginalFileName("user_img") == null)
			pvo.setUser_img(img);
		else 
			pvo.setUser_img(multi.getOriginalFileName("user_img"));
		
		PetuserDAO pdao = PetuserDAO.getInstance();
		pdao.insertUser(pvo);
		
		request.getRequestDispatcher("PetServlet?command=login_form").forward(request, response);
	}

}
