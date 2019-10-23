package com.tension.myblog.Service;

import com.tension.myblog.entity.Tag;

import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Tag tag);

    Tag updateTag(Integer id, Tag tag);

    void deleteTag(Integer id);

    List<Tag> AllTags();

    Tag getTagByName(String name);

    Tag getTagByID(Integer id);
}
