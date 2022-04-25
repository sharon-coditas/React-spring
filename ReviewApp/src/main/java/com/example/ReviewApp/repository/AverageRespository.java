package com.example.ReviewApp.repository;

import com.example.ReviewApp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AverageRespository extends JpaRepository<Rating,Integer> {

    @Query("select avg(ambiance) from Rating ")
    Double  avgAmbiance() ;
    @Query("select avg(cleanliness) from Rating")
    Double avgCleanliness();
    @Query("select avg(drinks)  from Rating")
    Double avgDrinks();
    @Query("select avg(food) from Rating")
    Double avgFood();
    @Query("select avg(service) from Rating")
    Double avgService();





}
