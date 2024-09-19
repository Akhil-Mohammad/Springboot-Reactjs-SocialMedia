package com.socialmedia.v.repository;

import com.socialmedia.v.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, String> {

    List<Posts> findByProfileId(String profileId);
}
