package com.outdoor.apiservice.service;

import com.outdoor.apiservice.entity.Post;

import java.util.List;

public interface IPostService {

    List<Post> getAllPosts();

    Post getPostById(int id);

    boolean addPost (Post post);

    void updatePost(Post post);

    void deletePost(int id);

}
