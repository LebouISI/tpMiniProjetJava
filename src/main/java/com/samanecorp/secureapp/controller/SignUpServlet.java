package com.samanecorp.secureapp.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.samanecorp.secureapp.dto.AccountUserDto;
import com.samanecorp.secureapp.service.AccountUserService;
import com.samanecorp.secureapp.service.InterfaceAccountUserService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet(name="signup", value="/signup")
public class SignUpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private InterfaceAccountUserService accountUserService = (InterfaceAccountUserService) new AccountUserService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("WEB-INF/jsp/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			logger .info("email envoyé: {} ", userName);
			System.out.println("email "+userName+ " password: "+password );
			
		
			try {
				Optional<AccountUserDto> accountUserDto = accountUserService.signUp(userName, password);
					
				if (accountUserDto.isPresent()) {
					System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeee");
						response.sendRedirect("signup");
				}else{
					System.out.println("fffffffffffffffffffffffff");
					 	AccountUserDto newUserDto = new AccountUserDto();
					 	newUserDto.setEmail(userName);
					 	newUserDto.setState(true);
					 	newUserDto.setPassword(password);
						accountUserService.save(newUserDto);
						
						request.getSession().setAttribute("username", userName);
						response.sendRedirect("welcome");
						
				}
				
			}catch (Exception e) {
				System.out.println("ggggggggggggggggggg");
					logger.error("{}",e);
					response.sendRedirect("login");
			}
	}

}
