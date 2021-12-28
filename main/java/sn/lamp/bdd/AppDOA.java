package sn.lamp.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import sn.lamp.Bean.InscriptionBean;
import sn.lamp.Bean.PostBean;

public class AppDOA {

	public static final String URL_DB = "jdbc:mysql://localhost:3306/bdd_TP";
	public static final String DB_USERNAME = "root";
	public static final String DB_PWD = "lamp196";
	public static final String CHAMP_EMAIL  = "email";
    public static final String CHAMP_PASS   = "password";

    public static final String CHAMP_LOGIN   = "login";
    public static final String CHAMP_NOM    = "nom";
    public static final String CHAMP_PROFIL   = "profil";

	// insertion
	public static final String insert_apprenant = "INSERT INTO Utilisateur (email,login,profil,mot_de_passe,nom,date_inscription) "
			+ "VALUES (?,?,?, MD5(?), ?, NOW());";
	// select
	public static final String SELECT_ALL_APP = "SELECT * FROM Utilisateur";
	// select-id
	public static final String SELECT_APP_BY_ID = "SELECT * FROM Utilisateur WHERE id=?";
	// delete-id
	public static final String DELETE_APP_BY_ID = "DELETE FROM Utilisateur  WHERE id=?";
	// update apprant
	public static final String update_app = "UPDATE Utilisateur set email=?,login=?,profil=?,mot_de_passe=?,nom=? WHERE id=? ";

	public Connection getConnection() {

		Connection cone = null;
		String url = URL_DB;
		String utilisateur = DB_USERNAME;
		String mot = DB_PWD;
		

		try {

			cone = DriverManager.getConnection(url, utilisateur, mot);
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erreur driver: " + e.getMessage());
		}
		return cone;
	}

	// insert
	public void INSERTAPP(InscriptionBean app) {
		try {
			Connection cone = getConnection();
			PreparedStatement prep = cone.prepareStatement(insert_apprenant);
//			PreparedStatement prep = cone.prepareStatement(update_app);
			prep.setInt(1, app.getId());
			prep.setString(2, app.getEmail());
			prep.setString(3, app.getLogin());
			prep.setString(4, app.getProfil());
			prep.setString(5, app.getMot_de_passe());
			prep.setString(6, app.getNom());
			// execution
			prep.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Boolean publication(HttpServletRequest request) {
		
		
		  String id = getValeurChamp( request, "id" );
		
		int util =Integer.parseInt(id);
		System.out.println(id+util);
	    String email = getValeurChamp( request, CHAMP_EMAIL );
	    String motDePasse = getValeurChamp( request, CHAMP_PASS );
	    String login = getValeurChamp( request, CHAMP_LOGIN );
	    String nom = getValeurChamp( request, CHAMP_NOM );
	    String profil = getValeurChamp( request, CHAMP_PROFIL );

		InscriptionBean utilisateur=new InscriptionBean(util,nom,email,login,profil,motDePasse);
		
		
		Boolean res = false;
		try {
			res = update_app(utilisateur);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	// update
	public boolean update_app(InscriptionBean app) throws SQLException {
		boolean rowUpdated = false;

		try {
			Connection cone = getConnection();
			PreparedStatement prep = cone.prepareStatement(update_app);
			prep.setInt(6, app.getId());
			prep.setString(1, app.getEmail());
			prep.setString(2, app.getLogin());
			prep.setString(3, app.getProfil());
			prep.setString(4, app.getMot_de_passe());
			prep.setString(5, app.getNom());

			// execution
			rowUpdated = prep.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;

	}

	// select by id
	public InscriptionBean select(int id) {
		PreparedStatement prep;
		ResultSet rs;
		InscriptionBean app = new InscriptionBean();

		try {
			Connection cone = getConnection();
			prep = cone.prepareStatement(SELECT_APP_BY_ID);
//	   prep.setString(1, app.getNom());
			prep.setInt(1, id);
		

			// execution
			rs = prep.executeQuery();
			while (rs.next()) {
				app =new InscriptionBean(rs.getInt("id"), rs.getString("nom"), rs.getString("email"),
						rs.getString("login"), rs.getString("profil"), rs.getString("mot_de_passe"));

			}
//			System.out.println(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return app;

	}



	// delete apprenant
	public boolean DELETE_APP_BY_ID(int id) throws SQLException {
		boolean rowdeleted = false;

		try {
			Connection cone = getConnection();
			PreparedStatement prep = cone.prepareStatement(DELETE_APP_BY_ID);
			prep.setInt(1, id);
			rowdeleted = prep.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowdeleted;

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
