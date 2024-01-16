package com.spring.codeblogproject.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblogproject.model.Post;
import com.spring.codeblogproject.service.CodeblogService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller //  também é um tipo de Bean, gerenciado pelo spring
public class CodeblogController {
    //cirando um ponto de injeção do 'service'
    @Autowired
    CodeblogService codeblogService;

    //tipo ModelAndView porque está usando Spring MVC
    @RequestMapping(value = "/posts", method=RequestMethod.GET) //acessa o endpoint '/posts' através do método GET    
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");  //"posts" é o nome da view html
        List<Post> posts = codeblogService.findAll(); //pegando os posts salvos no bd
        mv.addObject("posts", posts); //dentro de 'posts' estarão os objetos posts (acima) que serão renderizados para html
        return mv;
    }       //obs.: se renderizar sem implementar o spring security tem que comentar (atalho vscode: ctrl K + ctrl c) a dependência no pom.xml, senão retorna página de login ao invés da página html criada

    @RequestMapping(value="/posts/{id}", method=RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = codeblogService.FindById(id);
        mv.addObject("post", post); // "post" é uma variável que está sendo criada pra exibir o objeto "post"
        return mv;    
    }

    @RequestMapping(value = "/newpost", method=RequestMethod.GET)
    public String getPostForm() {
        return "postForm"; //retornando a página html criada
    }

    @RequestMapping(value = "/newpost", method=RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes){ //@Valid vem do javax. faz validação das constraints colocadas na criação dos campos da tabela no Model (@NotBlank, etc)
        if (result.hasErrors()){//se vier título, texto ou autor em branco, vai dar erro
            return "redirect:/newpost"; //redireciona o usuário para corrigir 
        } 
        //sem erros
        post.setData(LocalDate.now());
        codeblogService.save(post); //salvando no bd o novo post
        return "redirect:/posts"; //redireciona para a página que mostra os posts
    }     
}