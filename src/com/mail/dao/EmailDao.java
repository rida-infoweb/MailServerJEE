package com.mail.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Date;
import com.mail.entities.Email;
import com.mail.metier.IEmail;


public class EmailDao implements IEmail {

	@Override
	public Collection<Email> findAll(int iD) {
		Collection<Email> emails = new ArrayList<Email>();
		try {
			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM email WHERE id = ?");
			stmt.setLong(1,iD);
			ResultSet result = stmt.executeQuery();
			while(result.next()) {
				Email  email = createObjet(result);
				emails.add(email);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
		return emails;
	}

	@Override
	public void add(Email email) {
		try {

			Connection conn = Singleton.getInstance().getConnection();
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO email VALUES (?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1,email.getUuid());

			stmt.setInt(2,email.getId());
			stmt.setString(3,email.getFrom());
			stmt.setString(4,email.getTo());
			stmt.setString(5,email.getSubject());
			stmt.setString(6,email.getMessage());
			stmt.setDate(7,new Date(email.getCreatedAt().getTime()));

			stmt.execute();
		} catch (SQLException ex) {
			System.out.println("Erreur SQL : " + ex.getMessage());
		}
	}
    private Email createObjet(ResultSet set) throws SQLException {
        Email email = new Email();
        email.setSubject(set.getString("subject"));
        email.setTo(set.getString("to"));
        email.setMessage(set.getString("message"));
        email.setCreatedAt(set.getDate("createdAt"));
        return email;
    }



}