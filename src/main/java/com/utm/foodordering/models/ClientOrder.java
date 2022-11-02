package com.utm.foodordering.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@ToString
public class ClientOrder {
    @JsonAlias("order_id")
    private Integer id;

    @JsonAlias("orders")
    private List<ClientSubOrderResponse> clientSubOrderResponses;

    private static AtomicInteger atomicInteger = new AtomicInteger();

    public ClientOrder(){
        this.id = atomicInteger.incrementAndGet();
    }
}
