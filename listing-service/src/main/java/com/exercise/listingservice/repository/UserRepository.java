package com.exercise.listingservice.repository;


import com.exercise.listingservice.entity.Listing;
import com.exercise.listingservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   Page<User> findAll(Pageable pageable);
    Optional<User> findById(Integer id);
}
