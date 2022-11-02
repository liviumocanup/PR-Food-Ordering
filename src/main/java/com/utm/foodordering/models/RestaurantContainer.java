package com.utm.foodordering.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestaurantContainer {
    public static final Map<Integer, Restaurant> restaurants = new HashMap<>();
}
