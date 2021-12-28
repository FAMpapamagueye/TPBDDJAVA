package sn.lamp.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import sn.lamp.Bean.PostBean;

public class selectPost {

	 Map<String,String> messages=new HashMap<String,String>();
List<PostBean> post=new ArrayList<PostBean>();
	public List<PostBean> select(){
		  try {
//		        messages.add( "Chargement du driver..." );
		        Class.forName("com.mysql.jdbc.Driver");
//		        messages.add( "Driver chargé !\n" );
		    } catch ( ClassNotFoundException e ) {
		        messages.put( "Erreur lors du chargement ",e.getMessage() );
		        System.out.println("driver ajouteer");
		    }
			String url="jdbc:mysql://localhost:3306/bdd_TP";
			String utilisateur="root";
			String pwd="lamp196";
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet  rs=null;
		try {
			conn=DriverManager.getConnection(url, utilisateur, pwd);
//			System.out.println(conn);
			 st=conn.prepareStatement("select * from Publication");
			
			rs= st.executeQuery();
			while(rs.next()) {
	     	 post.add(new PostBean(rs.getInt("id"), rs.getString("titre"),rs.getString("date_pub"),rs.getString("contenu") ,rs.getString("auteur") ));
		 }
			
//			System.out.println(post.get(0));
			
		} catch (SQLException e) {
		messages.put(" Erreur ",	e.getMessage());
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

	public Map<String,String> getMessages() {
		return messages;
	}
}
