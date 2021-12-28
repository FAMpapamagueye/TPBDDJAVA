package sn.lamp.bdd;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import sn.lamp.Bean.PostBean;

public class PubDAO {

	public static final String URL_DB = "jdbc:mysql://localhost:3306/bdd_TP";
	public static final String DB_USERNAME = "root";
	public static final String DB_PWD = "lamp196";

	// select-id
	public static final String SELECT_APP_BY_ID = "SELECT * FROM Publication WHERE id=?";
	// delete-id
	public static final String DELETE_APP_BY_ID = "DELETE FROM Publication  WHERE id=?";
	// update apprant
	public static final String update_app = "UPDATE Publication set titre=?,contenu=?,auteur=?,date_pub=? where id=? ";
	public static final String CHAMP_TITRE = "titre";
	public static final String CHAMP_CONTENU = "contenu";

	public static final String CHAMP_AUTEUR = "auteur";
	public static final String CHAMP_DATE = "date";

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

	public Boolean publication(HttpServletRequest request) {
		String id = getValeurChamp(request, "id");
		int util = Integer.parseInt(id);
		String auteur = getValeurChamp(request, CHAMP_AUTEUR);
		String contenu = getValeurChamp(request, CHAMP_CONTENU);
		String date = getValeurChamp(request, CHAMP_DATE);
		String titre = getValeurChamp(request, CHAMP_TITRE);

		PostBean post = new PostBean(util, titre, date, contenu, auteur);
		Boolean res = false;
		try {
			res = update_app(post);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// update
	public boolean update_app(PostBean post) throws SQLException {
		boolean rowUpdated = false;

		try {
			Connection cone = getConnection();
			PreparedStatement prep = cone.prepareStatement(update_app);
			prep.setInt(5, post.getId());
			prep.setString(1, post.getContenu());
			prep.setString(2, post.getTitre());
			prep.setString(3, post.getAuteur());
			prep.setString(4, post.getDate());

			// execution
			rowUpdated = prep.executeUpdate() > 0;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated;

	}

	// select by id
	public PostBean select(int id) {
		PreparedStatement prep;
		ResultSet rs;
		PostBean post = new PostBean();

		try {
			Connection cone = getConnection();
			prep = cone.prepareStatement(SELECT_APP_BY_ID);
//		   prep.setString(1, app.getNom());
			prep.setInt(1, id);

			// execution
			rs = prep.executeQuery();
			while (rs.next()) {
				post = new PostBean(rs.getInt("id"), rs.getString("titre"), rs.getString("date_pub"),
						rs.getString("contenu"), rs.getString("auteur"));

			}
//				System.out.println(app);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return post;

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
