package sn.lamp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.HashMap;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import sn.lamp.Bean.PostBean;

public class Post {
	public static final String URL_DB="jdbc:mysql://localhost:3306/bdd_TP";
	public static final String DB_USERNAME="root";
	    public static final String DB_PWD="lamp196";
	    public static final String CHAMP_TITRE  = "titre";
	    public static final String CHAMP_CONTENU   = "contenu";

	    public static final String CHAMP_AUTEUR  = "auteur";
	    public static final String CHAMP_DATE  = "date";
	    public static final String CHAMP_SESSION  = "session";
	    PostBean post=new PostBean();
	private Map<String,String> messages=new HashMap<String,String>();
	public PostBean postPUBLICATION(HttpServletRequest request) {
	    String auteur = getValeurChamp( request, CHAMP_AUTEUR );
	    String contenu = getValeurChamp( request, CHAMP_CONTENU );
	    String date = getValeurChamp( request, CHAMP_DATE );
	    String titre = getValeurChamp( request, CHAMP_TITRE );
	    HttpSession ses =request.getSession();
	    try {
		     
		        Class.forName("com.mysql.jdbc.Driver");
		   
		    } catch ( ClassNotFoundException e ) {
		        messages.put( "Erreur lors du chargement ",
		                 e.getMessage() );
		    }
			String url=URL_DB;
			String utilisateur=DB_USERNAME;
			String mot=DB_PWD;
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet  rs=null;
		try {
			conn=DriverManager.getConnection(url, utilisateur, mot);
			
			 st=conn.prepareStatement("INSERT INTO Publication (titre,contenu,auteur,date_pub) "
			       		+ "VALUES (?,?,?,?)");
			  st.setString(1,titre);
			  st.setString(2,contenu);
			  st.setString(3,auteur);
			  st.setString(4,date);
			  st.executeUpdate();
					
					
					post.setAuteur(auteur);
					post.setContenu(contenu);
					post.setDate(date);
			        post.setTitre(titre);
			      
		     

		} catch (SQLException e) {
		System.out.println(" Erreur "+e.getMessage());
		}finally {

		if(rs!=null) {
			try {
				rs.close();
			} catch (Exception ignore) {
				// TODO: handle exception
			}
		}
		if(st!=null) {
			try {
				st.close();
			} catch (Exception ignore) {
				// TODO: handle exception
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			} catch (Exception ignore) {
				// TODO: handle exception
			}
		}

		}
		return post;
		}
	
		
	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
	    String valeur = request.getParameter( nomChamp );
	    if ( valeur == null || valeur.trim().length() == 0 ) {
	        return null;
	    } else {
	        return valeur.trim();
	    }
	}



}
