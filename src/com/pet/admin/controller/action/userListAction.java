package com.pet.admin.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pet.controller.action.Action;
import com.pet.dao.PetuserDAO;
import com.pet.dto.PetuserVO;


public class userListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/userList.jsp";

		PetuserDAO pdao = PetuserDAO.getInstance();
		ArrayList<PetuserVO> userList = pdao.ListUser();
		request.setAttribute("userList", userList);
		
		 request.getRequestDispatcher(url).forward(request, response);

	}

}
