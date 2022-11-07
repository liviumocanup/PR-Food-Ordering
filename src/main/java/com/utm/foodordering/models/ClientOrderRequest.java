package com.utm.foodordering.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClientOrderRequest {
    @JsonAlias("client_id")
    private Integer clientId;

    private List<ClientSubOrderRequest> clientSubOrderRequests;
}
