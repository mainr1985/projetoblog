package com.spring.codeblogproject.service.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblogproject.model.Post;
import com.spring.codeblogproject.repository.CodeBlogRepository;
import com.spring.codeblogproject.service.CodeblogService;

/*
 * @Service -> classes que fazem intermédio com outras classes (recebem informações pra repassar, etc). 
 *      contém lógica de negócios; essa classe será injetada nas classes que precisem dela
 * @Component -> serve pra dizer pro spring que é um bean (é pro spring gerenciar a classe). É uma anotação geral
 * @Repository -> coleção de info que podem ser buscadas, consultadas, etc.
*/

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
