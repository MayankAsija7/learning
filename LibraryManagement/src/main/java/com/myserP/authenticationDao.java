package com.myserP;

import java.util.ArrayList;

public interface authenticationDao {
	public String validateUser(String email);
    public ArrayList login(String userName,String userPassword,String userType);
}
