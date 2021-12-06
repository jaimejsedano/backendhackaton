/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.repositories;

import com.example.g16.Models.Score;
import com.example.g16.repositories.CRUD.IScoreCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author erika
 */
@Repository
public class ScoreRepository {

    @Autowired
    private IScoreCrudRepository crudRepository;

    public List<Score> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Score> getById(Integer idScore) {
        return crudRepository.findById(idScore);
    }

    public Score save(Score score) {
        return crudRepository.save(score);
    }

    public void delete(Integer idScore) {
        crudRepository.deleteById(idScore);
    }
}
