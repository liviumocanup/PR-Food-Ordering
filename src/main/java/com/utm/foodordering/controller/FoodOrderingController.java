package com.utm.foodordering.controller;

import com.utm.foodordering.models.*;
import com.utm.foodordering.service.OrderingService;
import com.utm.foodordering.service.RatingService;
import com.utm.foodordering.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FoodOrderingController {
    private final RegistrationService registrationService;
    private final OrderingService orderingService;
    private final RatingService ratingService;

    @PostMapping("/register")
    public void registerRestaurant(@RequestBody Restaurant restaurant) {
        log.info("Registering restaurant : "+restaurant);
        registrationService.registerRestaurant(restaurant);
    }

    @GetMapping("/menu")
    public Menu getMenuForAllAvailableRestaurants() {
        log.info("Returning all menus");
        return registrationService.getMenus();
    }

    @PostMapping("/order")
    @ResponseStatus(HttpStatus.CREATED)
    public ClientOrder submitOrder(@RequestBody ClientOrderRequest clientOrderRequest) {
        log.info("+ Order received : "+ clientOrderRequest);
        return orderingService.submitOrder(clientOrderRequest);
    }

//    @PostMapping("/rating")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void submitRating(@RequestBody ClientOrderRating clientOrderRating){
//        log.info("Rating received : "+clientOrderRating);
//        ratingService.submitRating(clientOrderRating);
//    }
}
