package com.socialmedia.v.service;

import com.socialmedia.v.entity.Profile;

import java.util.List;

public interface ProfileService {

    public Profile create(Profile profile);

    public List<Profile> getAll();

    public Profile getByUsername(String username);

    public Profile updateByUsername(String username, Profile profile);

    public void deleteByUsername(String username);


}
