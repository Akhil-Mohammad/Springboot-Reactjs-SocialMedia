package com.socialmedia.v.controller;

import com.socialmedia.v.entity.Posts;
import com.socialmedia.v.service.impl.PostsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostsController {

    private PostsServiceImpl postsServiceImpl;

    public PostsController(PostsServiceImpl postsServiceImpl) {
        this.postsServiceImpl = postsServiceImpl;
    }

    @PostMapping("/newPost")
    public ResponseEntity<Posts> createPost(@RequestBody Posts posts){
       // return ResponseEntity.status(HttpStatus.CREATED).body(postsRepository.save(posts));

        Posts createdPost = postsServiceImpl.createPost(posts.getProfileId(), posts);
        return ResponseEntity.ok(createdPost);
    }
}
