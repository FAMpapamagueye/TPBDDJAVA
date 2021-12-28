package sn.lamp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import sn.lamp.Bean.PostBean;
import sn.lamp.bdd.selectPost;

public class CientsServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3293717044914976409L;
	public static final String CLIENTS="/clients/accueil.jsp";
	public static final String ATT_POST="post";
	public static final String SESSION="sessions"; 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		selectPost selpost=new selectPost();
		List<PostBean> pub=new ArrayList<PostBean>();
		pub=selpost.select();
//		 for(PostBean test :pub) {
//				System.out.println("pub"+test.getAuteur());
//		 }
		
//		this.getServletContext().getRequestDispatcher().forward(req,resp);
		req.setAttribute("pub", pub);
		session.setAttribute(SESSION, pub);
  	this.getServletContext().getRequestDispatcher(CLIENTS).forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}
	

}
