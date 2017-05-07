package com.service;

import com.entity.User;

public interface LoginService {
	public User doLoginGetUser(String username,String password);
}
