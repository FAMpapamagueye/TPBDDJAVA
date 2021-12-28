package sn.lamp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.bdd.UtilisateurBDD;
import sn.lamp.metier.InscriptionForm;

public class InscriptionServlets extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7809778704506338190L;
	public static final String VUE   = "/WEB-INF/inscription.jsp";
	public static final String ATT_FORM   = "inscription";
	public static final String ATT_TEST   = "utilisateur";
	
	
	

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
//		super.init();
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		
		UtilisateurBDD app =new UtilisateurBDD();
		InscriptionForm inscription =new InscriptionForm();
		InscriptionBean utilisateur=inscription.inscrireUtilisateur(req);
		req.setAttribute(ATT_TEST, utilisateur);
		req.setAttribute(ATT_FORM, inscription);
		if(inscription.getErreurs().isEmpty()) {
//			
		  	app.insert(req);
		  	
		    resp.sendRedirect("login");
			}else {
			 
			 this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}
		
		
	}
	
	

}
