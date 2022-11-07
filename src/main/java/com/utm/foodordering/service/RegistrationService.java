package com.utm.foodordering.service;

import com.utm.foodordering.models.Menu;
import com.utm.foodordering.models.Restaurant;
import com.utm.foodordering.models.RestaurantContainer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class RegistrationService {
    public final static String ORDER = "/v2/order";
    public final static String RATING = "/v2/rating";

    public void registerRestaurant(Restaurant restaurant) {
        RestaurantContainer.restaurants.put(restaurant.getRestaurantId(), restaurant);
    }

    public Menu getMenus() {
        Menu menu = new Menu();
        menu.setRestaurants(RestaurantContainer.restaurants.size());
        menu.setRestaurantsData(new ArrayList<>(RestaurantContainer.restaurants.values()));

        return menu;
    }
}
