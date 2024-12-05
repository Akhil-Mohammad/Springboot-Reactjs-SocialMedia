package com.socialmedia.v.controller;

import com.socialmedia.v.entity.Posts;
import com.socialmedia.v.service.impl.PostsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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


    @GetMapping("/getAllPosts")
    public ResponseEntity<List<Posts>> getAllPosts(){
        return ResponseEntity.status(HttpStatus.OK).body(postsServiceImpl.getAllPosts());
    }


    @GetMapping("/getByProfileId")
    public ResponseEntity<List<Posts>> getById(@RequestParam String profileId){
        return ResponseEntity.status(HttpStatus.OK).body(postsServiceImpl.getPostsByProfileId(profileId));
    }

}
