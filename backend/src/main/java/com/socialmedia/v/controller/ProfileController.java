package com.socialmedia.v.controller;

import com.socialmedia.v.entity.Profile;
import com.socialmedia.v.service.util.ProfileServiceUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile")
public class ProfileController {


    private final ProfileServiceUtil profileServiceUtil;

    public ProfileController(ProfileServiceUtil profileServiceUtil) {
        this.profileServiceUtil = profileServiceUtil;
    }

    @PostMapping("/newProfile")
    public ResponseEntity<Profile> save(@RequestBody Profile profile){
        return ResponseEntity.status(HttpStatus.CREATED).body(profileServiceUtil.create(profile));
    }

    @GetMapping("/allProfiles")
    public ResponseEntity<List<Profile>> getAllProfiles (){
        return  ResponseEntity.status(HttpStatus.OK).body(profileServiceUtil.getAll());
    }

    @GetMapping("/profileByUserName")
    public ResponseEntity<Profile> getByUserName(@RequestParam String username) {
        Profile profile = profileServiceUtil.getByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body(profile);
    }


    @DeleteMapping("/deleteProfile/{username}")
    public ResponseEntity<String> deleteByUserName(@PathVariable String username){

        profileServiceUtil.deleteByUsername(username);
        return ResponseEntity.status(HttpStatus.OK).body("Profile Deleted Successfully");
    }

    @PutMapping("/updateByUserName")
    public ResponseEntity<Profile> updateProfile(@RequestParam String username,@RequestBody Profile profile){
        return ResponseEntity.status(HttpStatus.OK).body(profileServiceUtil.updateByUsername(username, profile));
    }

}
