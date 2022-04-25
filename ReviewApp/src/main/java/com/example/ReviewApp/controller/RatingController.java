package com.example.ReviewApp.controller;

import com.example.ReviewApp.model.Ratings;
import com.example.ReviewApp.model.User;
import com.example.ReviewApp.repository.RatingRespository;
import com.example.ReviewApp.repository.UserRepository;
import com.example.ReviewApp.userlogin.ApiResponse;
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

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth/ratings")
public class RatingController {
    @Autowired
    private   RatingRespository ratingRespository;

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/insertReview")
    public ResponseEntity<Ratings> create(@RequestBody @Valid RatingRequest ratingRequest) {
        Ratings r = new Ratings();
        r.setAmbiance(ratingRequest.getAmbiance());
        r.setAmbiance(ratingRequest.getFood());
        r.setCleanliness(ratingRequest.getCleanliness());
        r.setService(ratingRequest.getService());
        r.setDrinks(ratingRequest.getDrinks());

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found with email : " + email));
        r.setUser(user);

        ratingRespository.save(r);
        return new ResponseEntity(new ApiResponse(true, "Users rating added"), HttpStatus.CREATED);


    }

}
