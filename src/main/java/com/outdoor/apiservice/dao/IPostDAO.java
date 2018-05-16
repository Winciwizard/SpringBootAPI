package com.outdoor.apiservice.dao;


import com.outdoor.apiservice.entity.Post;

import java.util.List;

public interface IPostDAO {

    List<Post> getAllPosts();

    Post getPostById(int id);

    void addPost(Post post);

    void updatePost(Post post);

    void deletePost(int id);

}
