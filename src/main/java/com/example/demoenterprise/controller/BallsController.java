package com.example.demoenterprise.controller;
import com.example.demoenterprise.dto.BallsDto;
import com.example.demoenterprise.entity.BallsEntity;
import com.example.demoenterprise.mapper.BallsMapper;
import com.example.demoenterprise.repository.BallsRepository;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@Path("/balls")
public class BallsController {
    @Inject
    BallsRepository ballsRepository;
    @Inject
    BallsMapper mapper;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
        public List<BallsDto> getAll(@QueryParam("name")String name){
        if (name == null)
            return mapper.map(ballsRepository.findAll());
        return mapper.map(ballsRepository.findAllByName(name));
    }
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
        public Response getOne(@PathParam("id")Long id){
            var theBall = ballsRepository.findOne(id);
            if (theBall.isPresent()) {
                return Response.ok().entity(mapper.map(theBall.get())).build();
            }
            throw new NotFoundException("Didn't find the ball with id: " + id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
        public Response addBalls(@Valid BallsDto balls){
            ballsRepository.insertBalls(mapper.map(balls));
        return Response.created(URI.create("balls/" + balls.getId())).build();
    }
    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
        public Response updateBalls(@PathParam("id")Long id, BallsDto balls){
        return Response.ok().entity(ballsRepository.update(id, mapper.map(balls))).build();
    }
    @DELETE
    @Path("/{id}")
        public void delete(@PathParam("id")Long id){
        ballsRepository.deleteBall(id);
    }

}
