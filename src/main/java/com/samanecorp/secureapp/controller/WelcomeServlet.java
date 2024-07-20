package com.samanecorp.secureapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.samanecorp.secureapp.dto.AccountUserDto;
import com.samanecorp.secureapp.entities.AccountUserEntity;
import com.samanecorp.secureapp.service.AccountUserService;
import com.samanecorp.secureapp.service.InterfaceAccountUserService;


/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet(name="welcome", value="/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InterfaceAccountUserService accountUserService = new AccountUserService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Optional<List<AccountUserDto>> users = accountUserService.findAll();
		if (users.isPresent()) {
			request.setAttribute("userList", users.get());
		} else {
			request.setAttribute("userList", new ArrayList<AccountUserEntity>());
		}
		request.getRequestDispatcher("WEB-INF/jsp/welcome.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
