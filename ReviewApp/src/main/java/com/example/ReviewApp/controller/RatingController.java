package com.example.ReviewApp.controller;

import com.example.ReviewApp.model.Rating;
import com.example.ReviewApp.model.User;
import com.example.ReviewApp.repository.RatingFilterRespository;
import com.example.ReviewApp.repository.UserRepository;
import com.example.ReviewApp.userlogin.ApiResponse;
import com.example.ReviewApp.userlogin.ErrorResponse;
import com.example.ReviewApp.userlogin.RatingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api")
public class RatingController {
    @Autowired
    private RatingFilterRespository ratingFilterRespository;

    @Autowired
    private UserRepository userRepository;

    // @PreAuthorize("hasRole('USER')")
    @PostMapping ("/rating")
    public ResponseEntity<?> storeRating(@RequestBody RatingRequest ratingRequest) {
        Rating rating = new Rating();
        rating.setAmbiance(ratingRequest.getAmbiance());
        rating.setFood(ratingRequest.getFood());
        rating.setService(ratingRequest.getService());
        rating.setCleanliness(ratingRequest.getCleanliness());
        rating.setDrinks(ratingRequest.getDrinks());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email : " + email));

        rating.setUser(user);

        ratingFilterRespository.save(rating);

        return new ResponseEntity<>(new ApiResponse( new ErrorResponse("Thanks for rating"),null), HttpStatus.CREATED);
    }
}