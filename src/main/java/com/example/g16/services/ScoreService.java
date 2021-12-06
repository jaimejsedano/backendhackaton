/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.services;

import com.example.g16.Models.Score;
import com.example.g16.repositories.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author erika
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.getAll();

    }

    public Score getById(Integer id) {
        return scoreRepository.getById(id).orElse(null);
    }

    public Score update(Score score) {
        
        if (score.getIdScore() == null) 
            return score;
        
        Optional<Score> existeScore = scoreRepository.getById(score.getIdScore());

        if (existeScore.isEmpty()) 
            return score;
        
        return scoreRepository.save(score);
    }
    
    public Score save(Score score){
        
        //if(score.getId()== null)
        //return score;
        
       Optional<Score> existeScore = scoreRepository.getById(score.getIdScore());
       
       if(existeScore.isPresent())
           return score;
               
        return scoreRepository.save(score);
    }
    public void delete(Integer id){
        scoreRepository.delete(id);
    }
}
