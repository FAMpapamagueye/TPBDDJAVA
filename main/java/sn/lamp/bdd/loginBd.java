package sn.lamp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import sn.lamp.Bean.InscriptionBean;

public class loginBd {

	public static final String URL_DB = "jdbc:mysql://localhost:3306/bdd_TP";
	public static final String DB_USERNAME = "root";
	public static final String DB_PWD = "lamp196";

	public static final String CHAMP_PASS = "password";

	public static final String CHAMP_LOGIN = "login";

	private List<String> messages = new ArrayList<String>();
	InscriptionBean log=new InscriptionBean();

	public InscriptionBean login(HttpServletRequest request) {
	

		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String login = getValeurChamp(request, CHAMP_LOGIN);

		try {
			messages.add("Chargement du driver...");
//			System.out.println("Chargement du driver...");
//			System.out.println(motDePasse + login);
			Class.forName("com.mysql.jdbc.Driver");
			messages.add("Driver chargé !");
		} catch (ClassNotFoundException e) {
			messages.add("Erreur lors du chargement " + e.getMessage());
		}
		String url =URL_DB;
		String utilisateur =DB_USERNAME;
		String mot =DB_PWD;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(url, utilisateur, mot);
//			System.out.println("selection");
			st = conn.prepareStatement("select id,profil,nom,login FROM Utilisateur where (email=? or login=?)  and mot_de_passe=MD5(?)");
			st.setString(1, login);
			st.setString(2, login);
			st.setString(3, motDePasse);
			
			try {
				rs = st.executeQuery();
			} catch (Exception e) {
				// TODO: handle exception
			}
		
		
			while (rs.next()) {
				System.out.println("affichage");
				int id = rs.getInt(1);
				String nom=rs.getString(3);
				String profil = rs.getString(2);
				String login1 = rs.getString(4);
			    log.setProfil(profil);
			    log.setNom(nom);
			    log.setId(id);
			    log.setLogin(login1);
//					System.out.println(profil);
					
					return log;
			}
	

		} catch (SQLException e) {
			messages.add(" Erreur " + e.getMessage());
			System.out.println(e.getMessage());
		} finally {

			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
					// TODO: handle exception
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception ignore) {
					// TODO: handle exception
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception ignore) {
					// TODO: handle exception
				}
			}

		}
		return log;
	
	}

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur.trim();
		}
	}
	

}
