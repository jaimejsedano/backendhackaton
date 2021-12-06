/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.controllers;

import com.example.g16.Models.Persona;
import com.example.g16.Models.Score;
import com.example.g16.services.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.mongodb.core.aggregation.MergeOperation.UniqueMergeId.id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author erika
 */
@RestController
@RequestMapping("/api/score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {
    
    @Autowired
    private  ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score> getAll() {
        return scoreService.getAll();
    }
    
    @GetMapping("/{id}")
    public Score getById(@PathVariable Integer idScore) {
        return scoreService.getById(idScore);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Persona> update(@PathVariable String id, @RequestBody Score score) {
        Score s = scoreService.update(score);
        return new ResponseEntity(s,HttpStatus.CREATED);
    }
    
    @PostMapping("/save")
    public ResponseEntity<Persona> save(@RequestBody Score score) {
        Score p = scoreService.save(score);
        return new ResponseEntity(p,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete")
    public ResponseEntity delete(@PathVariable Integer idScore) {
        scoreService.delete(idScore);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
