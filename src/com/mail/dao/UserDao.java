package com.mail.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.PreparedStatement;

import com.mail.entities.User;
import com.mail.metier.IUser;

public class UserDao implements IUser {
	
	@Override
	public User findOne(int id) {
		User user = null;
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usermail WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				String name = result.getString("name");
				String password = result.getString("password");
				String email = result.getString("email");

				user = new User(id,name,email,password);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return user;
	}

	@Override
	public boolean saveUser(User user,String email) {
		 boolean set = false;
		 PreparedStatement pstmt1 = null;
		 PreparedStatement stmt = null;
		 ResultSet rs = null;
		try {
			Connection conn = Singleton.getInstance().getConnection();
		    String queryExi = "SELECT email FROM usermail where email = ?";
		    pstmt1 = conn.prepareStatement(queryExi);
		    pstmt1.setString(1, email);

		    rs = pstmt1.executeQuery();
		    if(!rs.next()) 	            

	      {
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
		String query = "select * from usermail where email = ? and password = ?";		
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
	
@Override
public int findUserByEmail(String email){
    try{
		String query = "select * from usermail where email = ?";		
		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1,email);
        ResultSet set = stmt.executeQuery();
        if(set.next()){
           return set.getInt("id");
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
    return 0;
}

@Override
public void delete(int id) {
	try {

		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement("DELETE FROM usermail WHERE id = ?");
		stmt.setInt(1, id);
		stmt.execute();
	} catch (SQLException ex) {
		System.out.println("Erreur SQL : " + ex.getMessage());
	}
}

public void update(User user) {
	try {

		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement("UPDATE usermail SET name = ?, password = ? WHERE id = ?");
		stmt.setString(1, user.getName());
		stmt.setString(2, user.getPassword());
		stmt.setInt(3,user.getId());
		stmt.execute();
	} catch (SQLException ex) {
		System.out.println("Erreur SQL : " + ex.getMessage());
	}
}

@Override
public Collection<User> findAll() {
	Collection<User> users = new ArrayList<User>();
	try {

		Connection conn = Singleton.getInstance().getConnection();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usermail WHERE NOT email='admin@rida.ma' ");
		ResultSet result = stmt.executeQuery();
		while(result.next()) {
			int id = result.getInt("id");
			String name = result.getString("name");
			String email = result.getString("email");
			String password = result.getString("password");

			User user = new User(id,name,email,password);
			users.add(user);
		}
	} catch (SQLException ex) {
		System.out.println("Erreur SQL : " + ex.getMessage());
	}
	return users;
}


}
