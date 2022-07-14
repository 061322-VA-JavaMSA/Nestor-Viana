package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.UserDTO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.AuthService;
import com.revature.services.UserService;
import com.revature.util.CorsFix;

public class UserServlet extends HttpServlet{
	
	UserService us = new UserService();
	ObjectMapper om = new ObjectMapper();
	AuthService as = new AuthService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
//		CorsFix.addCorsHeader(req.getRequestURI(), res);
		res.addHeader("Content-Type", "application/json");
		
		
		String pathInfo = req.getPathInfo();
		if (pathInfo == null) {
			
			HttpSession session = req.getSession();
			
			if (session.getAttribute("userRole")!= null && session.getAttribute("userRole").equals(Role.MANAGER)) {

				List<User> users = us.getUsers();
				List<UserDTO> usersDTO = new ArrayList<>();
				users.forEach(u -> usersDTO.add(new UserDTO(u)));

				PrintWriter pw = res.getWriter();
				pw.write(om.writeValueAsString(usersDTO));

				pw.close();
			}else {
				// if the user making the request is not an admin
				res.sendError(401, "Unauthorized request.");
			}
		
		}else {
			int id = Integer.parseInt(pathInfo.substring(1));
			try (PrintWriter pw = res.getWriter()){
				User u = us.getUserById(id);
				pw.write(om.writeValueAsString(new UserDTO(u)));
				res.setStatus(200);
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				res.setStatus(404);
				e.printStackTrace();
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
	}


}
