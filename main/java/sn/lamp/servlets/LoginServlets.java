package sn.lamp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.Bean.PostBean;
import sn.lamp.bdd.Select;
import sn.lamp.bdd.loginBd;
import sn.lamp.bdd.selectPost;
import sn.lamp.metier.LoginForm;

public class LoginServlets extends HttpServlet {

	public static final String VUE="/WEB-INF/connexion.jsp";
	public static final String ATT_SESS="session"; 

	public static final String ATT_FORM="form"; 
	public static final String ATT_USER="log"; 
	

	public static final String ADMIN_VUE="admin";
//	public static final String CLIENT="/WEB-INF/index.jsp";
	public static final String CLIENTS="accueil";
	List<InscriptionBean> util;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
	}

//	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);gin
		LoginForm form=new LoginForm();
		InscriptionBean log=form.loginUtilisateur(req);
		
		loginBd con=new loginBd();
		InscriptionBean test=new InscriptionBean();
		req.setAttribute(ATT_FORM, form);
		req.setAttribute(ATT_USER, log);
		if(form.getErreurs().isEmpty()) {
			
		test=con.login(req);
			
//		System.out.print("ok"+test.getProfil());
//				req.setAttribute(ATT_SESS, test.getProfil());
//				
				if(test!=null) {
				HttpSession session=req.getSession();
				session.setAttribute(ATT_SESS,test.getLogin());
//				System.out.println(test.);
					if(test.getProfil().equals("admin")){
						
						 resp.sendRedirect(ADMIN_VUE);
						 
					}else {
//						session.setAttribute(ATT_SESS, test);
						resp.sendRedirect(CLIENTS);
						
					}
				}else {	
					this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);}

		}else {
			this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
		}
	
		}
	

}
