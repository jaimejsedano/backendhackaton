/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.g16.repositories.CRUD;

import com.example.g16.Models.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author erika
 */
public interface IScoreCrudRepository extends MongoRepository<Score, Integer>{
    
}
