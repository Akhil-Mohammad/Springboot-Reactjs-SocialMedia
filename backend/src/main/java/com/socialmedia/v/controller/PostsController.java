package com.socialmedia.v.controller;

import com.socialmedia.v.entity.Posts;
import com.socialmedia.v.service.impl.PostsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private PostsServiceImpl postsServiceImpl;

    public PostsController(PostsServiceImpl postsServiceImpl) {
        this.postsServiceImpl = postsServiceImpl;
    }

    @PostMapping("/newPost")
    public ResponseEntity<Posts> createPost(@RequestBody Posts posts){

        Posts createdPost = postsServiceImpl.createPost(posts.getProfileId(), posts);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }


    @GetMapping("/GetAllPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postsServiceImpl.getAllPosts());
    }

}
