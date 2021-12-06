/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.g16.repositories.CRUD;

import com.example.g16.Models.Persona;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author neoge
 */
public interface IPersonaCrudRepository extends MongoRepository<Persona, Integer>{
    Optional<Persona> findByEmail(String email);
    Optional<Persona> findByEmailAndPassword(String email,String passsword);

}
