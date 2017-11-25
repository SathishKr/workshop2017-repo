package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Comment;
import com.example.demo.repo.CommentRepository;

@RestController
public class FeedbackController {
 
    @Autowired
    CommentRepository commentRepository;
    
    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> feedback(@RequestBody Comment comment) {
        //Comment comment = new Comment(data.get("name"), data.get("comment"));
        comment.setTs(System.currentTimeMillis() / 1000);
        commentRepository.save(comment);
        return new ResponseEntity<String>("{\"result\": \"" + "ok" + "\"}", HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<Comment>> feedback() {
        List<Comment> comments = commentRepository.findAll();

        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }
}