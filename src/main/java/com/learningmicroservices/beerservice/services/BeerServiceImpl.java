package com.learningmicroservices.beerservice.services;

import com.learningmicroservices.beerservice.controller.NotFoundException;
import com.learningmicroservices.beerservice.domain.Beer;
import com.learningmicroservices.beerservice.mapper.BeerMapper;
import com.learningmicroservices.beerservice.model.BeerDTO;
import com.learningmicroservices.beerservice.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService{
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDTO getById(UUID beerId) {
        return beerMapper.BeerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        return beerMapper.BeerToBeerDto(beerRepository.save(beerMapper.BeerDtoToBeer(beer)));
    }

    @Override
    public BeerDTO updateBeer(BeerDTO beerDTO, UUID beerId) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDTO.getBeerName());
        beer.setBeerStyle(beerDTO.getBeerStyle().name());
        beer.setPrice(beerDTO.getPrice());
        beer.setUpc(beerDTO.getUpc());
        return beerMapper.BeerToBeerDto(beerRepository.save(beer));

    }
}
