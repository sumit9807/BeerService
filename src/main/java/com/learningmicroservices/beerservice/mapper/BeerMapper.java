package com.learningmicroservices.beerservice.mapper;

import com.learningmicroservices.beerservice.domain.Beer;
import com.learningmicroservices.beerservice.model.BeerDTO;
import org.mapstruct.Mapper;

/**
 * Created by jt on 2019-05-25.
 */
@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDTO BeerToBeerDto(Beer beer);

    Beer BeerDtoToBeer(BeerDTO dto);
}
