package sn.lamp.bdd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class UtilisateurBDD {
	public static final String URL_DB="jdbc:mysql://localhost:3306/bdd_TP";
	public static final String DB_USERNAME="root";
	    public static final String DB_PWD="lamp196";
	    public static final String CHAMP_EMAIL  = "email";
	    public static final String CHAMP_PASS   = "password";

	    public static final String CHAMP_LOGIN   = "login";
	    public static final String CHAMP_NOM    = "nom";
	    public static final String CHAMP_PROFIL   = "profil";
	

	private List<String> messages=new ArrayList<String>();
	public List<String> insert(HttpServletRequest request) {
	    String email = getValeurChamp( request, CHAMP_EMAIL );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    String login = getValeurChamp( request, CHAMP_LOGIN );
	    String nom = getValeurChamp( request, CHAMP_NOM );
	    String profil = getValeurChamp( request, CHAMP_PROFIL );


			try {
		        messages.add( "Chargement du driver..." );
		        Class.forName("com.mysql.jdbc.Driver");
		        messages.add( "Driver chargé !" );
		    } catch ( ClassNotFoundException e ) {
		        messages.add( "Erreur lors du chargement "
		                + e.getMessage() );
		    }
			String url=URL_DB;
			String utilisateur=DB_USERNAME;
			String mot=DB_PWD;
			Connection conn=null;
			PreparedStatement st=null;
//			ResultSet  rs=null;
		try {
			conn=DriverManager.getConnection(url, utilisateur, mot);
			
			 st=conn.prepareStatement("INSERT INTO Utilisateur (email,login,profil,mot_de_passe,nom,date_inscription) "
			       		+ "VALUES (?,?,?, MD5(?), ?, NOW());");
			  st.setString(1,email);
			  st.setString(2,login);
			  st.setString(3,profil);
			  st.setString(4,motDePasse);
			  st.setString(5,nom);
				
					 int statut=st.executeUpdate();
					messages.add(""+statut);
			 
		     

		} catch (SQLException e) {
		messages.add(" Erreur "+e.getMessage());
		}finally {

//		if(rs!=null) {
//			try {
//				rs.close();
//			} catch (Exception ignore) {
//				// TODO: handle exception
//			}
//		}
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
		return messages;
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


