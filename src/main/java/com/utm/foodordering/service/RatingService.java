package com.utm.foodordering.service;

import com.utm.foodordering.models.ClientOrderRating;
import com.utm.foodordering.models.ClientSubOrderRatingRequest;
import com.utm.foodordering.models.ClientSubOrderRatingResponse;
import com.utm.foodordering.models.Restaurant;
import com.utm.foodordering.models.RestaurantContainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RatingService {
    private static final RestTemplate restTemplate = new RestTemplate();

    public static Double foodOrderingServiceRating;

    public void submitRating(ClientOrderRating orderRating) {
        for (ClientSubOrderRatingRequest subOrderRatingRequest : orderRating.getOrders()) {
            submitRatingToSpecificRestaurant(subOrderRatingRequest);
        }
    }

    @Async
    public void submitRatingToSpecificRestaurant(ClientSubOrderRatingRequest subOrderRatingRequest) {

        Restaurant restaurant = RestaurantContainer.restaurants.get(subOrderRatingRequest.getRestaurantId());
        ResponseEntity<ClientSubOrderRatingResponse> response =
                restTemplate.postForEntity(restaurant.getAddress() + RegistrationService.RATING, subOrderRatingRequest, ClientSubOrderRatingResponse.class);

        ClientSubOrderRatingResponse subOrderRatingResponse = response.getBody();

        restaurant.setRating(subOrderRatingResponse.getRestaurantAvgRating());
        foodOrderingServiceRating =
                RestaurantContainer.restaurants.values().stream().mapToDouble(Restaurant::getRating).sum() / RestaurantContainer.restaurants.size();
        log.info("====Average rating is :" + foodOrderingServiceRating+"====");
    }
}
