package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Comment;
import com.example.demo.repo.CommentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private CommentRepository commentRepository;
    
    @Test
    public void findByNameTest() {
        this.entityManager.persist(new Comment("name1", "comment 1"));
        Comment c = commentRepository.findByName("name1");
        
        assertThat(c.getName()).isEqualTo("name1");
        assertThat(c.getComment()).isEqualTo("comment 1");
    }
}
