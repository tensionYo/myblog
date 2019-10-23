package com.tension.myblog.Service.Impl;

import com.tension.myblog.Exceptions.NotFoundException;
import com.tension.myblog.Service.TagService;
import com.tension.myblog.entity.Tag;
import com.tension.myblog.entityMapper.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;


    @Override
    @Transactional
    public Tag saveTag(Tag tag) {
        tagMapper.insert(tag);
        return tag;
    }
    @Transactional
    @Override
    public Tag getTag(Tag tag) {
        Tag tag1 = tagMapper.selectByPrimaryKey(tag.getId());
        return tag1;
    }

    @Transactional
    @Override
    public Tag updateTag(Integer id, Tag tag) {
        Tag tag1 = tagMapper.selectByPrimaryKey(id);
        if(tag1!=null){
            tagMapper.updateByPrimaryKey(tag);
        }
        else {
            throw new NotFoundException("数据库中不存在此数据");
        }
        return tag1;
    }

    @Transactional
    @Override
    public void deleteTag(Integer id) {
        tagMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public List<Tag> AllTags() {
        return tagMapper.findall();
    }

    @Transactional
    @Override
    public Tag getTagByName(String name) {
        Tag tag = tagMapper.selectByName(name);

        return tag;
    }

    @Transactional
    @Override
    public Tag getTagByID(Integer id) {
        return tagMapper.selectByPrimaryKey(id);
    }
}
