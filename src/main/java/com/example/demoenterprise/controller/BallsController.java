package com.example.demoenterprise.controller;

import com.example.demoenterprise.repository.BallsRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/balls")
public class BallsController {
    @Inject
    BallsRepository ballsRepository;
    @GET
        public String getBalls(){
        return "Maddafacka";
    }
    @POST
        public String postBalls(){
        return "Posted balls";
    }
}
