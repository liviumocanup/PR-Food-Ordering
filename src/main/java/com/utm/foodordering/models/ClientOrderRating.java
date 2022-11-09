package com.utm.foodordering.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClientOrderRating {
    @JsonAlias("client_id")
    private Integer clientId;

    @JsonAlias("order_id")
    private Integer orderId;

    private List<ClientSubOrderRatingRequest> orders;
}
