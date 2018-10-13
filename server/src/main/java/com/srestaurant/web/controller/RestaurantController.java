package com.srestaurant.web.controller;


import com.srestaurant.dao.RestaurantDao;
import com.srestaurant.model.Restaurant;
import com.srestaurant.web.exceptions.RestaurantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantDao restaurantsDao;

    @PostMapping(value = "/Restaurant")
    public List<Restaurant> listeDesRestaurant(@RequestBody boolean  order){

        List<Restaurant> restaurants = order?restaurantsDao.findAll(new Sort(Sort.Direction.DESC,"moyen"))
                :restaurantsDao.findAll();
        if(restaurants.isEmpty()) throw new RestaurantNotFoundException("Aucun restaurant n'est disponible à la vente");

        return restaurants;

    }

    //Récuperer un Restaurant par son id
    @GetMapping( value = "/Restaurant/{id}")
    public Optional<Restaurant> recupererUnRestaurant(@PathVariable int id) {

        Optional<Restaurant> product = restaurantsDao.findById(id);

        if(!product.isPresent())  throw new RestaurantNotFoundException("Le restaurant correspondant à l'id " + id + " n'existe pas");

        return product;
    }
    @PostMapping(value = "/addnote")
    public Optional<Restaurant> Evaluation(@RequestBody Restaurant restaurant){


        Optional<Restaurant> sr=restaurantsDao.findById(restaurant.getId());
        if(!sr.isPresent()) throw new RestaurantNotFoundException("Cette restaurant n'existe pas");
        else{
            sr.get().calculMoyen(restaurant.getQnouriture(),restaurant.getQsalle(),restaurant.getQservice());
            restaurantsDao.save(sr.get());
        }

        return sr;
    }

}

