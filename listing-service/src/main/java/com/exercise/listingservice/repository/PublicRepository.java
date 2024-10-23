package com.exercise.listingservice.repository;

import com.exercise.listingservice.entity.Listing;
import com.exercise.listingservice.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublicRepository extends JpaRepository<Listing, Integer> {
//    List<Listing> findByUserId(Integer userId, Pageable pageable);

    Page<Listing> findByUserId(Integer userId, Pageable pageable);


    Page<Listing> findAll(Pageable pageable);
}
