package com.outdoor.apiservice.service;

import com.outdoor.apiservice.dao.IPostDAO;
import com.outdoor.apiservice.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostDAO postDAO;

    @Override
    public Post getPostById(int id) {
        Post objet = postDAO.getPostById(id);
        return objet;
    }

    @Override
    public List<Post> getAllPosts() { return postDAO.getAllPosts(); }

    @Override
    public synchronized boolean addPost(Post post) {
        postDAO.addPost(post);
        return true;
    }

    @Override
    public void updatePost(Post post) { postDAO.updatePost(post);}

    @Override
    public void deletePost(int id) { postDAO.deletePost(id);}
}
