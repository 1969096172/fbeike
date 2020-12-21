package com.li.ers.dao;

public interface ILoginDAO {
    int user_login_in(String useraccount, String userpassword);

    void adduser(String useraccount, String userpassword, String username, String usertel, String usercardid);
}
