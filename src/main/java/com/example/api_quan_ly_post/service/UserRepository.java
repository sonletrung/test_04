package com.example.api_quan_ly_post.service;

import com.example.api_quan_ly_post.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Object findByPass(String pass);

    Object findByName(String user);
}
