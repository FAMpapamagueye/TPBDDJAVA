package sn.lamp.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.lamp.Bean.PostBean;
import sn.lamp.bdd.Post;
import sn.lamp.bdd.selectPost;

import sn.lamp.metier.POSTFrom;

public class new_postServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6675456990884086082L;
	public static final String VUE="/WEB-INF/new_post.jsp";
	public static final String VUES="/clients/accueil.jsp";
	public static final String CLIENT="accueil";
	public static final String ATT_SESS="session"; 
	public static final String ATT_FORM="form"; 
	public static final String ATT_SEL="select"; 
	public static final String ATT_USER="log"; 
	public static final String SESSION_COMMANDES="session"; 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//		selectPost sel=new selectPost();
//		List<PostBean> post=sel.select();
//		System.out.println(post);
//		req.setAttribute("post", post);
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		POSTFrom form=new POSTFrom();
		
		HttpSession session=req.getSession();
//		PostBean post=ff
		PostBean post=form.nouveauPost(req);
	
		req.setAttribute(ATT_FORM, form);
		req.setAttribute(ATT_USER, post);
		Post post1 =new Post();
		PostBean test=new PostBean();
		if(form.getErreurs().isEmpty()) {
			HttpSession ses=req.getSession();
			test=post1.postPUBLICATION(req);
		
			 Map<String, PostBean> postpub = (HashMap<String, PostBean>) ses.getAttribute( SESSION_COMMANDES );
	          
	            if ( postpub == null ) {
	            	postpub = new HashMap<String, PostBean>();
	            }
	       
	            postpub.put( ((PostBean) test).getTitre(), (PostBean) test );
	      
	            session.setAttribute( SESSION_COMMANDES, postpub );
			resp.sendRedirect(CLIENT);

		}else {
			this.getServletContext().getRequestDispatcher(VUE).forward(req,resp);
		}
		
	}
	
	

}
