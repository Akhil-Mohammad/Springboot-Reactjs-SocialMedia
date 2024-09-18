package com.socialmedia.v.repository;

import com.socialmedia.v.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, String> {

}
