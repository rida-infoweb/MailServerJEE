package com.mail.metier;

import com.mail.entities.User;

public interface IUser {
	public boolean saveUser(User user);
	public User logUser(String email, String password) ;

}
