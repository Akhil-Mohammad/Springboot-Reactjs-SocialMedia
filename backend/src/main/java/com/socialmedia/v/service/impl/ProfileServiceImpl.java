package com.socialmedia.v.service.impl;

import com.socialmedia.v.entity.Profile;
import com.socialmedia.v.exception.BadRequestException;
import com.socialmedia.v.exception.CustomException;
import com.socialmedia.v.exception.NotFoundException;
import com.socialmedia.v.repository.ProfileRepository;
import com.socialmedia.v.service.ProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile create(Profile profile) {


        if(profile.getUsername() ==null || profile.getUsername().isEmpty()){
            throw new BadRequestException("company name should not be empty");
        }

        if(profile.getFullName() ==null || profile.getFullName().isEmpty()){
            throw new BadRequestException("company name should not be empty");
        }


        if(profileRepository.existsByUsername(profile.getUsername())){
            throw  new IllegalArgumentException("UserName Already Exists: "+ profile.getUsername());
        }

        profile.setId(UUID.randomUUID().toString());

        return profileRepository.save(profile);
    }

    @Override
    public List<Profile> getAll() {

        List<Profile> profile = profileRepository.findAll();

        if(profile ==null || profile.isEmpty()){
            throw new CustomException("204","No Context","The List of profiles are Empty");
        }


        return profile;
    }

    @Override
    public Profile getByUsername(String username) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);

        if (profileOptional.isPresent()) {
            return profileOptional.get();
        } else  {
            throw new NotFoundException("Profile Does not exists with given UserName: " + username);
        }
    }

    @Override
    public Profile updateByUsername(String username, Profile profile) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);

        if(profileOptional.isEmpty() || profileOptional == null){
            throw new NotFoundException(" No Profile Found with given username: "+ username);
        }

        if(profileOptional.isPresent()){
            Profile profile1 = profileOptional.get();

            profile1.setFullName(profile.getFullName());
            profile1.setImage(profile.getImage());
            profile1.setDob(profile.getDob());

            return profileRepository.save(profile1);
        }else {
            throw  new RuntimeException("Something went Wrong");
        }

    }

    @Override
    public void deleteByUsername(String username) {

        Optional<Profile> profileOptional = profileRepository.findByUsername(username);

        if (profileOptional.isEmpty() || profileOptional == null) {
            throw new NotFoundException(" No Profile Found with given username: " + username);
        }

        if (profileOptional.isPresent()) {
            profileRepository.delete(profileOptional.get());

        } else {
            throw new RuntimeException("something went wrong");
        }
    }
}
