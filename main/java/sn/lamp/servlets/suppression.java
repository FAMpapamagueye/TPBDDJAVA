package sn.lamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.bdd.AppDOA;

public class suppression extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5563749509412645130L;
	public static final String VUE   = "/WEB-INF/suppression.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String id =req.getParameter("id");
		int util=Integer.parseInt(id);
		System.out.println(id);
		AppDOA test=new AppDOA();
		InscriptionBean utilisateur=new InscriptionBean();
		utilisateur=test.select(util);
//		System.out.println(utilisateur.getNom());
		req.setAttribute("utilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	
	
}
