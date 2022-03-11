package com.learningmicroservices.beerservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learningmicroservices.beerservice.bootstrap.BeerBootStrapLoader;
import com.learningmicroservices.beerservice.model.BeerDTO;
import com.learningmicroservices.beerservice.model.BeerStyleEnum;
import com.learningmicroservices.beerservice.services.BeerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerById() throws Exception {
        given(beerService.getById(any())).willReturn(getValidBeerDto());
        mockMvc.perform(get("/api/v1/beer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDTO beer = getValidBeerDto();
        String beerJson = objectMapper.writeValueAsString(beer);
        given(beerService.saveNewBeer(any())).willReturn(getValidBeerDto());
        mockMvc.perform(post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isCreated());

    }

    @Test
    void updateBeerById() throws Exception {
        BeerDTO beer = getValidBeerDto();
        String beerJson = objectMapper.writeValueAsString(beer);

        given(beerService.updateBeer(any(), any())).willReturn(getValidBeerDto());

        mockMvc.perform(put("/api/v1/beer/"+UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isNoContent());
    }

    BeerDTO getValidBeerDto(){
        return BeerDTO.builder()
                .beerName("My Beer")
                .beerStyle(BeerStyleEnum.ALE)
                .price(new BigDecimal("2.99"))
                .upc(BeerBootStrapLoader.BEER_2_UPC)
                .build();
    }
}