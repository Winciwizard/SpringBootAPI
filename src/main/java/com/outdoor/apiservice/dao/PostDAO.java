package com.outdoor.apiservice.dao;

import com.outdoor.apiservice.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class PostDAO implements IPostDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Post getPostById(int id) { return entityManager.find(Post.class, id);}

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> getAllPosts() {
        String hql = "FROM Post as pst ORDER BY pst.id";
        return (List<Post>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public void addPost(Post post) { entityManager.persist(post);}

    @Override
    public void updatePost(Post post) {
        Post pst = getPostById(post.getId());

        pst.setTitle(post.getTitle());
        pst.setMessage(post.getMessage());
        pst.setUserId(post.getUserId());

        entityManager.flush();
    }

    @Override
    public void deletePost(int id) {entityManager.remove(getPostById(id));}
}
