package com.utm.foodordering.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientSubOrderRequest {
    @JsonAlias("restaurant_id")
    private Integer restaurantId;

    private List<Integer> items = new ArrayList<>();

    private Integer priority;

    @JsonAlias("created_time")
    private Long createdTime;

    @JsonAlias("max_wait")
    private Double maximumWaitTime;
}
