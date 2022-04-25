package com.example.ReviewApp.userlogin;

public class FilterResponse {
    private String name;
    private int ambiance;
    private int food;
    private int service;
    private int drinks;
    private int cleanliness;

    public FilterResponse(String name, int ambiance, int food, int service, int drinks, int cleanliness) {
        this.name = name;
        this.ambiance = ambiance;
        this.food = food;
        this.service = service;
        this.drinks = drinks;
        this.cleanliness = cleanliness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmbiance() {
        return ambiance;
    }

    public void setAmbiance(int ambiance) {
        this.ambiance = ambiance;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }

    public int getDrinks() {
        return drinks;
    }

    public void setDrinks(int drinks) {
        this.drinks = drinks;
    }

    public int getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(int cleanliness) {
        this.cleanliness = cleanliness;
    }
}
