package com.utm.foodordering.models;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrdersContainer {
    public static final Map<Integer, ClientOrder> orders = new HashMap<>();
}
