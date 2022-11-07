package com.utm.foodordering.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Restaurant {
    @JsonAlias("restaurant_id")
    private Integer restaurantId;

    private String name;

    private String address;

    @JsonAlias("menu_items")
    private Integer menuItems;

    private List<Food> menu;

    private Double rating;
}
