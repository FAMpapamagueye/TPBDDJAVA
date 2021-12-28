package sn.lamp.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sn.lamp.bdd.PubDAO;

public class ConfirmerSup extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1890209065180570756L;
	public static final String VUE = "accueil";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		String id = req.getParameter("id");
		int util = Integer.parseInt(id);
		System.out.println(id);
		PubDAO pub = new PubDAO();
		Boolean post = false;
		try {
			post = pub.DELETE_APP_BY_ID(util);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(utilisateur.getNom());
		req.setAttribute("post", post);
//		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		resp.sendRedirect(VUE);

	}

}
