package com.example.api_quan_ly_post.service;

import com.example.api_quan_ly_post.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControllerRepository extends JpaRepository<Content,Long> {
    @Query("SELECT p FROM Content p where p.title = :titler and p.status = 'onlyme'")
    List<Content> findByTitle(String titler);

    List<Content> findByStatus(String a);

    List<Content> findByOrderByLikesDesc();
    List<Content> findTop4ByOrderByLikesDesc();
}
