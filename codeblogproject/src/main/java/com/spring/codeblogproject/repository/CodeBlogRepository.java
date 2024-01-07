package com.spring.codeblogproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.codeblogproject.model.Post;


public interface CodeBlogRepository extends JpaRepository<Post,Long>{ //jpaRepository dá à interface acesso a métodos já prontos, como findById, save, delete, etc

}
