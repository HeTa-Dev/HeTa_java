package com.heta.repo;

import com.heta.entity.PostView;

import java.util.List;

public interface PostViewRepository {
    void addNewPostView(PostView PostView);
    PostView findPostViewById(int id);
    List<PostView> findPostViewByUserId(int userId);
    List<PostView> findAllPostView();
    void increaseLikeCount(int id);
    void increaseDislikeCount(int id);
    void setReported(int id);
    void setUnReported(int id);
    void deletePostView(int id);
}
