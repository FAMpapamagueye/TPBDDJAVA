package sn.lamp.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.bdd.AppDOA;




public class UpdatePost extends HttpServlet {

	public static final String VUE   = "/WEB-INF/inscription.jsp";
	public static final String SUCCES = "admin";
	/**
	 * 
	 */
	private static final long serialVersionUID = -2603298236866399883L;

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
		System.out.println(utilisateur.getNom());
		req.setAttribute("utilisateur", utilisateur);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		Boolean res=false;
		AppDOA pub = new AppDOA();
		
		res = pub.publication(req);
		System.out.println(res);
//		req.setAttribute("post", post);
		resp.sendRedirect(SUCCES);
	}
	
	

}
