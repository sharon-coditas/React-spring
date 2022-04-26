package com.example.ReviewApp.repository;

import com.example.ReviewApp.model.Rating;
import com.example.ReviewApp.userlogin.AverageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AverageRespository extends JpaRepository<Rating,Integer> {

    @Query("select new com.example.ReviewApp.userlogin.AverageResponse(avg(ambiance),avg(cleanliness),avg(drinks),avg(service),avg(food)," +
            "((avg(ambiance)+avg(cleanliness)+avg(drinks)+avg(food)+avg(service))/5)) from Rating")
    AverageResponse totalAverages();


}
