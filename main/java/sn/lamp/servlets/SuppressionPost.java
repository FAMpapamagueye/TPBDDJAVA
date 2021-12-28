package sn.lamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import sn.lamp.Bean.PostBean;

import sn.lamp.bdd.PubDAO;

public class SuppressionPost extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String VUE   = "/WEB-INF/suppressionPublication.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String id =req.getParameter("id");
		int util=Integer.parseInt(id);
		System.out.println(id);
		PubDAO pub=new PubDAO();
		PostBean post=new PostBean();
		post=pub.select(util);
//		System.out.println(utilisateur.getNom());
		req.setAttribute("post", post);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		
	}
	
	
	

}
