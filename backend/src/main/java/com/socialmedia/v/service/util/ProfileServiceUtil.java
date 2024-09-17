package com.socialmedia.v.service.util;

import com.socialmedia.v.entity.Profile;
import com.socialmedia.v.repository.ProfileRepository;
import com.socialmedia.v.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceUtil implements ProfileService {



    private ProfileRepository profileRepository;

    public ProfileServiceUtil(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {

        if(profileRepository.existsByUsername(profile.getUsername())){
            throw  new IllegalArgumentException("UserName Already Exists: "+ profile.getUsername());
        }

        profile.setId(UUID.randomUUID().toString());

        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile getByUsername(String username) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);

        if(profileOptional.isPresent()){
            return profileOptional.get();
        }else{
            throw  new IllegalArgumentException("Profile Does not exists with given UserName: "+ username);
        }

    }

    @Override
    public Profile updateByUsername(String username, Profile profile) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);

        if(profileOptional.isPresent()){
            Profile profile1 = profileOptional.get();

            profile1.setFullName(profile.getFullName());
            profile1.setImage(profile.getImage());
            profile1.setDob(profile.getDob());

            return profileRepository.save(profile1);
        }else {
            throw  new IllegalArgumentException("Profile with userName : "+ username + " Does not Exist");
        }


    }

    @Override
    public void deleteByUsername(String username) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);


        if(profileOptional.isPresent()){
            profileRepository.delete(profileOptional.get());

        }else {
            throw new IllegalArgumentException("Profile with userName : " + username + "Does not exists to delete");
        }
    }
}
