package com.mail.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import com.mail.entities.User;
import com.mail.metier.IUser;

public class UserDao implements IUser {

	@Override
	public boolean saveUser(User user,String email) {
		 boolean set = false;
		 PreparedStatement pstmt1 = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		try {
			Connection conn = Singleton.getInstance().getConnection();
		    String queryExi = "SELECT email FROM usermail where email=?";
		    pstmt1 = conn.prepareStatement(queryExi);
		    pstmt1.setString(1, email);

		    rs = pstmt1.executeQuery();
		    if(rs.next()) {
		    	 	            System.out.println("Compte " + email + " existe déjà.");
		    	 	            

	    }  else {
	    	System.out.println("Compte " + email + " n\'existe pas.");
	    	String query = "INSERT INTO usermail VALUES (DEFAULT, ?, ?, ?)";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            set=true;
	    }
			
           
            
			
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return set;
	}

@Override
public User logUser(String email, String password) {
	 User user = null;
	try {
		String query = "select * from usermail where email=? and password=?";		
		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, email);
		stmt.setString(2, password);
        ResultSet rs  = stmt.executeQuery();
        if(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
       }
        
        
		
	} catch (SQLException ex) {
		System.out.println("Erreur SQL : " + ex.getMessage());
	}
	return user;
}
	
	



}
