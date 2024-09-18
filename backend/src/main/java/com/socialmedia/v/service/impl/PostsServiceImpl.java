package com.socialmedia.v.service.impl;

import com.socialmedia.v.entity.Posts;
import com.socialmedia.v.entity.Profile;
import com.socialmedia.v.repository.PostsRepository;
import com.socialmedia.v.repository.ProfileRepository;
import com.socialmedia.v.service.PostsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PostsServiceImpl implements PostsService {


    private ProfileRepository profileRepository;

    private PostsRepository postsRepository;

    public PostsServiceImpl(ProfileRepository profileRepository , PostsRepository postsRepository) {
        this.profileRepository = profileRepository;
        this.postsRepository =postsRepository;
    }

    @Override
    public Posts createPost(String profileId, Posts post) {

        post.setPostId(UUID.randomUUID().toString());

        Profile profile = profileRepository.findById(profileId)
                .orElseThrow(() -> new IllegalArgumentException("Profile with id " + profileId + " not found"));

        // Set the fetched Profile to the post
        post.setProfile(profileId);

            return postsRepository.save(post);
        }

    @Override
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }
}
