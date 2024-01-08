package com.spring.codeblogproject.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblogproject.model.Post;
import com.spring.codeblogproject.repository.CodeBlogRepository;

//import jakarta.annotation.PostConstruct;

//classe para popular tabelas para testes 
@Component
public class DummyData {
    
    @Autowired
    CodeBlogRepository codeBlogRepository;

    //@PostConstruct //tudo que vem sob essa anotação é executado conforme a aplicação vai subindo (sendo executada); Descomentar quando for testar posts no blog
    public void savePosts(){
        
        List<Post> postList = new ArrayList();
        
        Post post1 = new Post();
        post1.setAutor("Michelli Brito");
        post1.setData(LocalDate.now());
        post1.setTitulo("Docker");
        post1.setTexto("lorem ipsum aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

        
        Post post2 = new Post();
        post2.setAutor("Michelli Brito");
        post2.setData(LocalDate.now());
        post2.setTitulo("API REST");
        post2.setTexto("lorem 0 ipsum aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaavvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaasvv");

        Post post3 = new Post();
        post3.setAutor("Maíra Nunes Rocha");
        post3.setData(LocalDate.now());
        post3.setTitulo("Lorem Ipsum Completo");
        post3.setTexto("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua." + 
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat." + 
                        "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                        "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

        postList.add(post1);
        postList.add(post2);
        postList.add(post3);

        for (Post post: postList){
            Post postSaved = codeBlogRepository.save(post);
            System.out.println(postSaved.getId()); //printando o id gerado para o post 
        }        
    }
}