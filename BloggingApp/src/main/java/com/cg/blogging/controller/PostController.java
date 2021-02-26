package com.cg.blogging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.service.IPostService;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private IPostService postService;

    @PostMapping("/addPost")
    public ResponseEntity<Post> addPost(@PathVariable Post post) throws IdNotFoundException {
        Post addedPost = null;
        addedPost = postService.addPost(post);
        return new ResponseEntity<Post>(addedPost, HttpStatus.OK);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) throws IdNotFoundException {
        Post updatedPost = postService.updatePost(post);
        return new ResponseEntity<Post>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/deletePost/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable int id) throws IdNotFoundException {
        Post deletedPost = postService.deletePost(id);
        return new ResponseEntity<Post>(deletedPost, HttpStatus.OK);
    }
    
    @GetMapping("/getPostBySearchString/{searchStr}")
    public ResponseEntity<List<Post>> getPostBySearchString(@PathVariable  String searchStr) throws IdNotFoundException{
        List<Post> matchingPostsList = postService.getPostBySearchString(searchStr);
        return new ResponseEntity<List<Post>>(matchingPostsList, HttpStatus.OK);
    }
    
    @GetMapping("/getPostByBlogger")
    public ResponseEntity<List<Post>> getPostByBlogger(@RequestBody Blogger blogger) throws IdNotFoundException {
        List<Post> bloggersPostList = postService.getPostByBlogger(blogger);
        return new ResponseEntity<List<Post>>(bloggersPostList, HttpStatus.OK);
    }
    
    public ResponseEntity<Boolean> upVote(@PathVariable boolean upVote,@RequestBody Post post) {
        postService.upVote(upVote, post);
        return new ResponseEntity<Boolean>(upVote,HttpStatus.OK);
    }
   
}