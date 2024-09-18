package com.socialmedia.v.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Posts {

    @Id
    private String postId;

    private String title;

    private String context;

    private String image;

    private String video;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "profile_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Profile profile;

    private String profileId;


    public Posts(String postId, String title, String context, String image, String video, String profileId  ) {
        this.postId = postId;
        this.title = title;
        this.context = context;
        this.image = image;
        this.video = video;
        this.profileId = profileId;
    }

    public Posts() {
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String profileId) {
//        this.username = profileId;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    public String getProfileId() {
        return profileId;
    }

    public void setProfile(String profileId) {
        this.profileId = profileId;
    }


    @Override
    public String toString() {
        return "Posts{" +
                "postId='" + postId + '\'' +
                ", title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", image='" + image + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
