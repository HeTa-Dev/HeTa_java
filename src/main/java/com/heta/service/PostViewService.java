package com.heta.service;

import com.heta.entity.PostView;
import com.heta.repo.PostViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostViewService {
    @Autowired
    private PostViewRepository postViewRepository;

    public void addNewPostView(PostView postView){
        postViewRepository.addNewPostView(postView);
    }

    public PostView findPostViewById(int id){
        PostView postView = postViewRepository.findPostViewById(id);
        postView.setImagePathList(List.of(postView.getImagePathList().get(0).split(",")));
        return postView;
    }

    public List<PostView> findPostViewByUserId(int userId){
        List<PostView> postViewList = postViewRepository.findPostViewByUserId(userId);
        for(PostView postView: postViewList){
            postView.setImagePathList(List.of(postView.getImagePathList().get(0).split(",")));
        }
        return postViewList;
    }

    public List<PostView> findAllPostView(){
        List<PostView> postViewList = postViewRepository.findAllPostView();
        for(PostView postView: postViewList){
            postView.setImagePathList(List.of(postView.getImagePathList().get(0).split(",")));
        }
        return postViewList;
    }

    public void increaseLikeCount(int id){
        postViewRepository.increaseLikeCount(id);
    }

    public void increaseDislikeCount(int id){
        postViewRepository.increaseDislikeCount(id);
    }

}
