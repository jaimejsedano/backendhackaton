/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.g16.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author erika
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "score")
public class Score {
    @Id
    private Integer idScore;
    private Integer score;
    private Integer record;
    private Integer idPersona;
}
