package com.tension.myblog.Service.Impl;

import com.tension.myblog.Service.UserService;
import com.tension.myblog.entity.User;
import com.tension.myblog.entityMapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {

        User user = userMapper.selectByName(username);
        if(user != null){
            if(user.getPassword().equals(password)){
                System.out.println("用户校验正确......");
                return user;
            }
        }
        System.out.println("用户校验失败......");
        return null;
    }
}
