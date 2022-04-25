package com.example.ReviewApp.repository;

import com.example.ReviewApp.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingFilterRespository extends JpaRepository<Rating,Integer> {
  @Query("select " +
          "new com.example.ReviewApp.userlogin.FilterResponse(u.name, r.ambiance, r.food, r.service, r.drinks, r.cleanliness)" +
          " from " +
          "User u inner join Rating r on " +
          "u.id=r.user.id and r.ambiance > :ambiance and r.food >:food and r.drinks >:drinks and r.cleanliness> :cleanliness and r.service >:service")
    List findRating(@Param("ambiance") int ambiance,
                    @Param("food") int food,
                    @Param("service") int service,
                    @Param("drinks") int drinks,
                    @Param("cleanliness") int cleanliness);




}
