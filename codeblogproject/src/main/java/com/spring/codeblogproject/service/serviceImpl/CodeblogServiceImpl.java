package com.spring.codeblogproject.service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblogproject.model.Post;
import com.spring.codeblogproject.repository.CodeBlogRepository;
import com.spring.codeblogproject.service.CodeblogService;

@Service //mostra pro Spring que essa classe é um Bean gerenciado por ele 
public class CodeblogServiceImpl implements CodeblogService{
    
    //criando ponto de injeção do repository pra poder usar instâncias dele pra recuperar info do bd
    @Autowired
    CodeBlogRepository codeBlogRepository; 

    @Override
    public List<Post> findAll() {

        return codeBlogRepository.findAll();
    }
    
    @Override
    public Post FindById(UUID id) {

        return codeBlogRepository.findById(id).get(); //precisa do get() porque senão retorna o tipo errado
    }

    @Override
    public Post save(Post post) {

        return codeBlogRepository.save(post);
    }
}
