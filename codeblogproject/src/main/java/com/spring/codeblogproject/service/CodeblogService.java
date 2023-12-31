package com.spring.codeblogproject.service;

import java.util.List;
import java.util.UUID;

import com.spring.codeblogproject.model.Post;

public interface CodeblogService {
    
    List<Post> findAll(); //método para retornar os posts feitos no blog
    Post FindById(UUID id); //método para retornar um único post feito no blog
    Post save(Post post); //método para salvar um post feito no blog
}
