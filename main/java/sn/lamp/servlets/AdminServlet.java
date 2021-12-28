package sn.lamp.servlets;

import java.io.IOException;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.bdd.Select;

public class AdminServlet extends HttpServlet {

	/**
	 * 
	 */
	public static final String VUE="/auth/admin.jsp";
	private static final long serialVersionUID = 1609366751271242396L;
	public static final  String ATT_TEST="util";
	List<InscriptionBean> util=null;
//	public static final String SESSION="session"; 
	public static final String ATT_SES="session"; 
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session=req.getSession();
//		
//		String ses=(String) session.getAttribute(ATT_SES);
		
		Select post =new Select();
		util=post.executeTests();
//	 for(InscriptionBean test :util) {
//			System.out.println("util"+test.getNom());
//	 }
//		System.out.println("session :"+ ses);
//		session.setAttribute(SESSION, ses);
		req.setAttribute("util", util);
//		this.getServletContext().getRequestDispatcher().forward(req,resp);
//		session.setAttribute(SESSION, tes);
		this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
      
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
	}

}
