package com.pet.controller.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pet.dao.ShopDAO;
import com.pet.dto.P_helperVO;
import com.pet.dto.PetuserVO;
import com.pet.dto.ShopVO;

public class petShopWriteAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "PetServlet?command=shop_list";
		HttpSession session = request.getSession();
		PetuserVO pvo = (PetuserVO) session.getAttribute("loginUser");
		P_helperVO phvo = (P_helperVO) session.getAttribute("login");
		
		if(pvo == null && phvo == null) {
			url = "PetServlet?command=login_form";
		}
		else {
			int sizeLimit = 5 * 1024 * 1024;
			String savePath = "images";
			ServletContext context = session.getServletContext();
			String uploadFilePath = context.getRealPath(savePath);
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy() );
			
			ShopVO svo = new ShopVO();
			if(pvo != null)
				svo.setExid(pvo.getUserid());
			else if(phvo != null)
				svo.setExid(phvo.getId());
			svo.setExarea(multi.getParameter("exarea"));
			svo.setExtitle(multi.getParameter("extitle"));
			svo.setExcontent(multi.getParameter("excontent"));
			svo.setEximg(multi.getOriginalFileName("eximg"));
			
			ShopDAO sdao = ShopDAO.getInstance();
			sdao.insertShop(svo);
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}