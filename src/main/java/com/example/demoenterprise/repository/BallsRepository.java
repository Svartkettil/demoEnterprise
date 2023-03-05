package com.example.demoenterprise.repository;

import com.example.demoenterprise.entity.BallsEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional

public class BallsRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<BallsEntity> findAll(){
        var query = entityManager.createQuery("SELECT balls FROM BallsEntity balls ", BallsEntity.class);
        return query.getResultList();
    }
    public Optional<BallsEntity> findOne(Long id){
        return Optional.ofNullable(entityManager.find(BallsEntity.class, id));
    }
    public void insertBalls(BallsEntity balls){
        entityManager.persist(balls);
    }
    public void deleteBall(Long id){
        var balls = findOne(id);
        balls.ifPresent((b) -> entityManager.remove(b));
    }
    public BallsEntity update(Long id, BallsEntity balls){
        var entity = entityManager.find(BallsEntity.class, id);
        entity.setName(balls.getName());
        entity.setCategory(balls.getCategory());
        entity.setPrice(balls.getPrice());
        entityManager.persist(entity);
        return entity;
    }
    public List<BallsEntity> findAllByName(){
        var query = entityManager.createQuery
                ("SELECT balls FROM BallsEntity balls WHERE balls.name LIKE :name", BallsEntity.class);
        return query.getResultList();
    }


}
