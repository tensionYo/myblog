package com.tension.myblog.Service;

import com.tension.myblog.entity.Type;

import java.util.List;


public interface TypeService {

    Type saveType(Type type);

    Type getType(Type type);

    Type updateType(Integer id, Type type);

    void deleteType(Integer id);

    //返回列表待做
    List<Type> AllTypes();

    Type getTypeByName(String name);

    Type getTypeByID(Integer id );


}
