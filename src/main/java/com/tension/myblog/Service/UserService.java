package com.tension.myblog.Service;

import com.tension.myblog.entity.User;

public interface UserService {

    User checkUser(String username,String password);
}
