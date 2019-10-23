package com.tension.myblog.Service;

import com.dataobject.Blog;

import java.util.List;

public interface BlogService {
//
    Blog getBlog(Integer id);

    List<Blog> AllBlogs();

    Blog saveBlog();

}
