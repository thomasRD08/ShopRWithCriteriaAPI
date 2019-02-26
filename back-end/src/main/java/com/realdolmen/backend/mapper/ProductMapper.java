package com.realdolmen.backend.mapper;

import com.realdolmen.backend.domain.*;
import com.realdolmen.backend.dto.*;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    @Autowired
    private FictionMapper fictionMapper;
    @Autowired
    private NonFictionMapper nonFictionMapper;
    @Autowired
    private GameMapper gameMapper;
    @Autowired
    private LpMapper lpMapper;

    ProductDto map(Product product) {
        if (product.getClass().equals(Fiction.class)) {
            return fictionMapper.fictionToFictionDto((Fiction) product);
        } else if (product.getClass().equals(NonFiction.class)) {
            return nonFictionMapper.nonFictionToNonFictionDto((NonFiction) product);
        } else if (product.getClass().equals(Lp.class)) {
            return lpMapper.lpToLpDto((Lp) product);
        } else if (product.getClass().equals(Game.class)) {
            return gameMapper.gameToGameDto((Game) product);
        } else {
            throw new RuntimeException();
        }
    }

    Product map(ProductDto product) {
        if (product.getClass().equals(FictionDto.class)) {
            return fictionMapper.fictionDtoToFiction((FictionDto) product);
        } else if (product.getClass().equals(NonFictionDto.class)) {
            return nonFictionMapper.nonFictionDtoToNonFiction((NonFictionDto) product);
        } else if (product.getClass().equals(LpDto.class)) {
            return lpMapper.lpDtoToLp((LpDto) product);
        } else if (product.getClass().equals(GameDto.class)) {
            return gameMapper.gameDtoToGame((GameDto) product);
        } else {
            throw new RuntimeException();
        }
    }
}
