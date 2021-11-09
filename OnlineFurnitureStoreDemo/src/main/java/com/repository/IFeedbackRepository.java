package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Review;
@Repository
public interface IFeedbackRepository extends JpaRepository<Review, Integer>{

}