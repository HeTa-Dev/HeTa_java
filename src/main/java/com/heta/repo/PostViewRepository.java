package com.heta.repo;

import com.heta.entity.PostView;

import java.util.List;

public interface PostViewRepository {
    public void addNewPostView(PostView PostView);
    public PostView findPostViewById(int id);
    public List<PostView> findPostViewByUserId(int userId);
    public List<PostView> findAllPostView();
}
