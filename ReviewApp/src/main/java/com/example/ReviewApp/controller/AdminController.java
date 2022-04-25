package com.example.ReviewApp.controller;


import com.example.ReviewApp.repository.AverageRespository;
import com.example.ReviewApp.repository.RatingFilterRespository;
import com.example.ReviewApp.userlogin.AverageResponse;
import com.example.ReviewApp.userlogin.FilterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')") //security
public class AdminController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RatingFilterRespository ratingFilterRespository;

    @GetMapping("/adminfilterpage")
    public ResponseEntity<?> findRating(@RequestParam(name = "ambiance", defaultValue = "0") String ambiance,
                                        @RequestParam(name = "food", defaultValue = "0") String food,
                                        @RequestParam(name = "service", defaultValue = "0") String service,
                                        @RequestParam(name = "drinks", defaultValue = "0") String drinks,
                                        @RequestParam(name = "cleanliness", defaultValue = "0") String cleanliness
    ) {

        List<FilterResponse> n = ratingFilterRespository.findRating(Integer.parseInt(ambiance),
                Integer.parseInt(food),
                Integer.parseInt(service),
                Integer.parseInt(drinks),
                Integer.parseInt(cleanliness));
        return ResponseEntity.ok(n);


    }

    @Autowired
    AverageRespository averageRespository;

    @GetMapping("/adminform")
    public ResponseEntity<?> findReport() {
        Double ambiance = averageRespository.avgAmbiance();
        Double cleanliness = averageRespository.avgCleanliness();
        Double drinks = averageRespository.avgDrinks();
        Double food = averageRespository.avgFood();
        Double service = averageRespository.avgService();
        Double totalAverage = (ambiance + cleanliness + drinks + food + service/5 );

        return ResponseEntity.ok(new AverageResponse(ambiance,cleanliness,drinks,food,service,totalAverage));

    }
}



