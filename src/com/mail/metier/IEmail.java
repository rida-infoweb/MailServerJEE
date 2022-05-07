package com.mail.metier;

import java.util.Collection;

import com.mail.entities.Email;


public interface IEmail {
	public void add(Email email);
	public Collection<Email> findAll(int iD);
}
