package sn.lamp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.lamp.bdd.AppDOA;

public class Confirmer extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4501744305431123869L;
	
	public static final String VUE   = "admin";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String id =req.getParameter("id");
		int util=Integer.parseInt(id);
		System.out.println(id);
		AppDOA test=new AppDOA();
	Boolean del;
		try {
			del=test.DELETE_APP_BY_ID(util);
			System.out.println(del);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(del);
//		req.setAttribute("utilisateur", utilisateur);
		resp.sendRedirect(VUE);
	}
	
	

}
