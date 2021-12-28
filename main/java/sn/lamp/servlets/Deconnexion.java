package sn.lamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Deconnexion extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5889076710238240883L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		HttpSession session=req.getSession();
		session.invalidate();
		resp.sendRedirect("login");
	}
	
	

}
