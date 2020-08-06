package com.example.demo.dao;

import com.example.demo.model.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PostDao {


    int insertPost(Post post, UUID id);
    List<Post> selectAllPost();
    int deletePost(UUID id);
    int updatePost(UUID id, Post post);

    Optional<Post> selectPostbyId(UUID id);

    default int insertPost(Post post){
        UUID id = UUID.randomUUID();
        return insertPost(post, id);

    }




}
