package com.learningmicroservices.beerservice.controller;

import com.learningmicroservices.beerservice.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById(@PathVariable("beerId") UUID beerId){
        //TODO Implemetion
        return new ResponseEntity<>(BeerDTO.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity saveNewBeer(@Validated @RequestBody BeerDTO beer){
        //TODO Implemetion
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@Validated @RequestBody BeerDTO beer, @PathVariable("beerId") UUID beerId){
        //TODO Implemetion
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
