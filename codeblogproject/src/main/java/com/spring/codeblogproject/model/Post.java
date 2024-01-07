package com.spring.codeblogproject.model;
//Entidade Post que irá guardar os artigos e publicações do blog

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data //annotation do Lombok pra automaticamente adicionar os getters/setters dos atributos.
@Entity
@Table(name="TB_POST")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String titulo;
    private String autor;
    
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") //setando o formato pra data ser salva
    private LocalDate data;
    
    @Lob //porque o texto pode ser muito grande, assim o bd vai aceitar e melhorar a performance
    private String texto;
}