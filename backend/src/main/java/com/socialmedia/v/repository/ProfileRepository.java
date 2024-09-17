package com.socialmedia.v.repository;

import com.socialmedia.v.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, String> {

    boolean existsByUsername(String username);

    Optional<Profile> findByUsername(String username);
}
