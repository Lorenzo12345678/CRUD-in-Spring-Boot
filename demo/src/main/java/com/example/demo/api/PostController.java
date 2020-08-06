package com.example.demo.api;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/post")
@RestController
public class PostController {

    PostService postService;


    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void insertPost(@RequestBody Post post){
       postService.insertPost(post);
    }

    @GetMapping
    public List<Post> getPost(){
        return postService.getPost();
    }

    @GetMapping(path = "{id}")
    public Post getPostById(@PathVariable("id") UUID id){
        return postService.getPostById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePost(@PathVariable("id") UUID id){
         postService.deletePost(id);
    }

    @PutMapping(path = "{id}")
    public void updatePost(@PathVariable("id") UUID id,@RequestBody Post post){
        postService.updatePost(id,post);
    }

}
