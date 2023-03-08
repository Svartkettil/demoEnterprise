package com.example.demoenterprise.mapper;

import com.example.demoenterprise.controller.BallsController;
import com.example.demoenterprise.dto.BallsDto;
import com.example.demoenterprise.entity.BallsEntity;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class BallsMapper {
    public List<BallsDto> map(List<BallsEntity> allBalls){
        return allBalls.stream().map(BallsDto::new).toList();
    }
    public BallsEntity map(BallsDto balls){
        var b = new BallsEntity();
        b.setId(balls.getId());
        b.setName(balls.getName());
        b.setCategory(balls.getCategory());
        b.setPrice(balls.getPrice());
        return b;
    }
    public BallsDto map(BallsEntity balls){
        return new BallsDto(balls);
    }
}
