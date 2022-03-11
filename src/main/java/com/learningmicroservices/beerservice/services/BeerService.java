package com.learningmicroservices.beerservice.services;

import com.learningmicroservices.beerservice.model.BeerDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDTO getById(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beer);

    BeerDTO updateBeer(BeerDTO beer, UUID beerId);
}
