package sn.lamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.lamp.Bean.PostBean;

import sn.lamp.bdd.PubDAO;

public class UpdatePublication extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5707791971807026817L;

	public static final String VUE = "/WEB-INF/new_post.jsp";
	public static final String SUCCES = "accueil";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String id = req.getParameter("id");
		int util = Integer.parseInt(id);
		System.out.println(id);
		PubDAO pub = new PubDAO();
		PostBean post = new PostBean();
		post = pub.select(util);
		System.out.println(post.getContenu());
		req.setAttribute("post", post);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		Boolean res;
		PubDAO pub = new PubDAO();
		
		res = pub.publication(req);
		System.out.println(res);
//		req.setAttribute("post", post);
		resp.sendRedirect(SUCCES);
//		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);

	}

}
