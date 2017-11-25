package com.example.demo.repo;

import com.example.demo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
    public Comment findByName(String name);
}
