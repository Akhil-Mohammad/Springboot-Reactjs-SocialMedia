package com.socialmedia.v.service;

import com.socialmedia.v.entity.Posts;

import java.util.List;

public interface PostsService {

    public Posts createPost(String username, Posts post);

    public List<Posts> getAllPosts();

    }
