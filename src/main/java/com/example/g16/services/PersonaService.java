/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.services;

import com.example.g16.Models.Persona;
import com.example.g16.repositories.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author neoge
 */
@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAll() {
        return personaRepository.getAll();

    }

    public Persona getById(Integer id) {
        return personaRepository.getById(id).orElse(null);
    }

    public Persona update(Persona persona) {
        
        if (persona.getId() == null) 
            return persona;
        
        Optional<Persona> existePersona = personaRepository.getById(persona.getId());

        if (existePersona.isEmpty()) 
            return persona;
        
        return personaRepository.save(persona);
    }
    
    public Persona save(Persona persona){
        
        //if(persona.getId()== null)
        //return persona;
        
       Optional<Persona> existePersona = personaRepository.getById(persona.getId());
       
       if(existePersona.isPresent())
           return persona;
               
        return personaRepository.save(persona);
    }
    public void delete(Integer id){
        personaRepository.delete(id);
    }
    
    public boolean emailExists(String email) {
        return personaRepository.emailExists(email);
    }

    public Persona authenticateUser(String email, String contrasenia) {
        Optional<Persona> usuario = personaRepository.authenticateUser(email, contrasenia);

        if (usuario.isEmpty()) {
            return new Persona();
        } else {
            return usuario.get();
        }
    }

}
