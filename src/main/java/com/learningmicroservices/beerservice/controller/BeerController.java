package com.learningmicroservices.beerservice.controller;

import com.learningmicroservices.beerservice.model.Beer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<Beer> getBeerById(@PathVariable("beerId") UUID beerId){
        //TODO Implemetion
        return new ResponseEntity<>(Beer.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity saveNewBeer(@RequestBody Beer beer){
        //TODO Implemetion
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@RequestBody Beer beer, @PathVariable("beerId") UUID beerId){
        //TODO Implemetion
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
