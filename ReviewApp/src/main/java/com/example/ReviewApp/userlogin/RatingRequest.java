package com.example.ReviewApp.userlogin;

import javax.validation.constraints.NotBlank;


public class RatingRequest {

    @NotBlank
    private int ambiance;
    @NotBlank
    private int food;
    @NotBlank
    private  int service;
    @NotBlank
    private int  cleanliness;
    @NotBlank
    private  int  drinks ;

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(String ambiance) {
        this.ambiance = Integer.parseInt(ambiance);
    }

    public int getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = Integer.parseInt(food);
    }

    public int getService() {
        return service;
    }

    public void setService(String service) {
        this.service = Integer.parseInt(service);
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = Integer.parseInt(cleanliness);
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = Integer.parseInt(drinks);
    }
}
