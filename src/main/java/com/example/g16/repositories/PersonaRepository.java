/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.repositories;


import com.example.g16.Models.Persona;
import com.example.g16.repositories.CRUD.IPersonaCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;

/**
 *
 * @author neoge
 */
@Repository
public class PersonaRepository {
    
    @Autowired
    private IPersonaCrudRepository crudRepository;
    /**
     * trae todos los registros
     * @return 
     */
    public List<Persona>getAll(){
        return crudRepository.findAll();
    }
    /**
     * trae un registro por id
     * @param id
     * @return 
     */
    public Optional<Persona> getById(Integer id){
        return crudRepository.findById(id);
    }
    /**
     * funciona para actualizar e ingresar registro
     * @param persona
     * @return 
     */
    public Persona save(Persona persona){
        return crudRepository.save(persona);
    }
    /**
     * Funciona para borrar un registro por Id
     * @param id 
     */
    public  void delete(Integer id){
        crudRepository.deleteById(id);
    }
    public boolean emailExists(String email) {
        Optional<Persona> persona = crudRepository.findByEmail(email);
        
        return !persona.isEmpty();
    }
    
    public Optional<Persona> authenticateUser(String email, String password) {
        return crudRepository.findByEmailAndPassword(email, password);
    }

}
