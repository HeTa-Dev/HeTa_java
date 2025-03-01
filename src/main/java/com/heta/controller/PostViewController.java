package com.heta.controller;

import com.heta.entity.PostView;
import com.heta.service.PostViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heta/postView")
public class PostViewController {

    @Autowired
    private PostViewService postViewService;

    @PostMapping("/addNewPostView")
    public void addNewPostView(@RequestBody PostView postView){
        postViewService.addNewPostView(postView);
    }

    @GetMapping("/findPostViewById/{id}")
    public PostView findPostViewById(@PathVariable("id") int id){
        return postViewService.findPostViewById(id);
    }

    @GetMapping("/findPostViewByUserId/{userId}")
    public List<PostView> findPostViewByUserId(@PathVariable("userId") int userId){
        return postViewService.findPostViewByUserId(userId);
    }

    @GetMapping("/findAllPostView")
    public List<PostView> findAllPostView(){
        return postViewService.findAllPostView();
    }

    @PostMapping("/increaseLikeCount/{id}")
    public void increaseLikeCount(@PathVariable("id") int id){
        postViewService.increaseLikeCount(id);
    }

    @PostMapping("/increaseDislikeCount/{id}")
    public void increaseDislikeCount(@PathVariable("id") int id){
        postViewService.increaseDislikeCount(id);
    }

}
