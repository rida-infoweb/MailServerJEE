package com.mail.metier;

import java.util.Collection;

import com.mail.entities.User;

public interface IUser {
	public boolean saveUser(User user,String email);
	public User logUser(String email, String password) ;
	public int findUserByEmail(String email);
	public void delete(int id);
	public User findOne(int id);
	public void update(User user);
	public Collection<User> findAll();

}
