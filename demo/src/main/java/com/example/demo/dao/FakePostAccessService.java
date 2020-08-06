package com.example.demo.dao;

import com.example.demo.model.Post;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePostAccessService implements PostDao {
    List<Post> DB = new ArrayList<>();

    @Override
    public int insertPost(Post post, UUID id) {

        DB.add(new Post(post.getAuthor(), post.getDescription(),id));
        return 1;
    }

    @Override
    public List<Post> selectAllPost() {
        return DB;
    }

    @Override
    public Optional<Post> selectPostbyId(UUID id) {
        // Gli optional vengono utilizzati principalmente all'interno delle stream per ottenere dei filtri evitando il rischio di NullPointerException
        return DB.stream()
                //Espressione Lambda
                .filter(post -> post.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePost(UUID id) {
        Optional<Post> postOptional = selectPostbyId(id);

        if (postOptional.isEmpty()){
            return 0;
        }
        // l'optional è un List perciò se si vuole accedere ad un suo elemento bisogna chiamare il metodo get
        DB.remove(postOptional.get());
        return 1;

    }

    @Override
    public int updatePost(UUID id, Post post) {
        Optional<Post> oldPost = selectPostbyId(id);
        if(oldPost.isEmpty()){
            return 0;
        }
        DB.remove(oldPost.get());
        DB.add(post);
        return 0;
    }



}
