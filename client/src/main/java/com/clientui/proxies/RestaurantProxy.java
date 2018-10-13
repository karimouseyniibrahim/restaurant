package com.clientui.proxies;

import com.clientui.beans.Restaurant;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "microservice-restaurant", url = "localhost:9101")

public interface RestaurantProxy {
    @PostMapping(value = "/Restaurant")
    public List<Restaurant> listeDesRestaurant(@RequestBody boolean  order);
    @GetMapping( value = "/Restaurant/{id}")
      Restaurant recupererUnRestaurant(@PathVariable("id") int id);
    @PostMapping(value = "/addnote")
     Restaurant Evaluation(@RequestBody Restaurant restaurant);
}
