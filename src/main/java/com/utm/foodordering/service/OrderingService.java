package com.utm.foodordering.service;

import com.utm.foodordering.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static com.utm.foodordering.service.RegistrationService.ORDER;

@Service
public class OrderingService {
    private static final RestTemplate restTemplate = new RestTemplate();

    public ClientOrder submitOrder(ClientOrderRequest clientOrderRequest) {
        List<CompletableFuture<ClientSubOrderResponse>> completableFutures = new ArrayList<>();

        for (ClientSubOrderRequest clientSubOrderRequest : clientOrderRequest.getClientSubOrderRequests()) {
            CompletableFuture<ClientSubOrderResponse> completableFuture = CompletableFuture.supplyAsync(() -> submitSubOrderToRestaurant(clientSubOrderRequest));
            completableFutures.add(completableFuture);
        }

        List<ClientSubOrderResponse> clientSubOrderResponses = completableFutures.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());

        ClientOrder clientOrder = new ClientOrder();
        clientOrder.setClientSubOrderResponses(clientSubOrderResponses);
        return clientOrder;
    }

    private ClientSubOrderResponse submitSubOrderToRestaurant(ClientSubOrderRequest clientSubOrderRequest) {
        Restaurant restaurant = RestaurantContainer.restaurants.get(clientSubOrderRequest.getRestaurantId());
        ResponseEntity<ClientSubOrderResponse> response =
                restTemplate.postForEntity(restaurant.getAddress() + ORDER, clientSubOrderRequest, ClientSubOrderResponse.class);

        return response.getBody();
    }
}
