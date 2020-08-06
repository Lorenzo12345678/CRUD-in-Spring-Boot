package com.example.demo.service;

import com.example.demo.dao.PostDao;
import com.example.demo.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PostService {
    private final PostDao postDao;


    @Autowired
    public PostService(@Qualifier("fakeDao") PostDao postDao) {
        this.postDao = postDao;
    }

    public int insertPost(Post post){
        return postDao.insertPost(post);
    }

    public List<Post> getPost(){
        return postDao.selectAllPost();
    }

    public int deletePost(UUID id){
        return postDao.deletePost(id);
    }

    public Optional<Post> getPostById(UUID id){
        return postDao.selectPostbyId(id);
    }
    public int updatePost(UUID id, Post post){
        return postDao.updatePost(id, post);
    }



}
