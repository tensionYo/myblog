package com.tension.myblog.Service.Impl;

import com.tension.myblog.Exceptions.NotFoundException;
import com.tension.myblog.Service.TypeService;
import com.tension.myblog.entity.Type;
import com.tension.myblog.entityMapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Transactional
    @Override
    public Type saveType(Type type) {
        typeMapper.insert(type);
        return type;
    }

    @Transactional
    @Override
    public Type getType(Type type) {
        Type type1 =  typeMapper.selectByPrimaryKey(type.getId());
        return type1;
    }

    @Transactional
    @Override
    public Type updateType(Integer id, Type type) {
        Type t =  typeMapper.selectByPrimaryKey(id);
        if(t!=null){
            typeMapper.updateByPrimaryKey(type);
        }
        else {
            throw new NotFoundException("数据库中不存在此数据");
        }
        return t;
    }

    @Transactional
    @Override
    public void deleteType(Integer id) {
        typeMapper.deleteByPrimaryKey(id);

    }

    @Transactional
    @Override
    public List<Type> AllTypes() {
        return typeMapper.findall();
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        Type type = typeMapper.getTypeByName(name);
        return (type==null)? null:type;
    }

    @Override
    public Type getTypeByID(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }
}
