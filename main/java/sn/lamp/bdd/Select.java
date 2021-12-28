package sn.lamp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;




import sn.lamp.Bean.InscriptionBean;

public class Select {
	private List<InscriptionBean> messages=new ArrayList<InscriptionBean>();

	public List<InscriptionBean> executeTests(){
		  try {
//		        messages.add( "Chargement du driver..." );
		        Class.forName("com.mysql.jdbc.Driver");
//		        messages.add( "Driver chargé !\n" );
		    } catch ( ClassNotFoundException e ) {
//		        messages.add( "Erreur lors du chargement "
//		                + e.getMessage() );
		    }
			String url="jdbc:mysql://localhost:3306/bdd_TP";
			String utilisateur="root";
			String pwd="lamp196";
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet  rs=null;
		List<InscriptionBean> test=new ArrayList<InscriptionBean>();
		try {
			conn=DriverManager.getConnection(url, utilisateur, pwd);
			
			 st=conn.prepareStatement("select * from Utilisateur");
			
			 rs=st.executeQuery();
		
			while(rs.next()) {
				  test.add(new InscriptionBean(rs.getInt("id"),rs.getString("nom"),rs.getString("email"),
				            rs.getString("login"),rs.getString("profil"),rs.getString("mot_de_passe")));
			
				
			}
//			messages.add(test);
			
		} catch (SQLException e) {
//		messages.add(e.getMessage());
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
		
		return test;
		
	}

	

	public List<InscriptionBean> getMessages() {
		return messages;
	}
	



}
