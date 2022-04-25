package com.example.ReviewApp.repository;


import com.example.ReviewApp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRespository extends JpaRepository<Rating, Integer> {

}
