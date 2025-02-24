package com.heta.repo;

import com.heta.entity.Comment;

import java.util.List;

public interface CommentRepository {
    /**
     * 添加一条新的评论
     * @param comment 要添加的评论对象
     */
    public void addNewComment(Comment comment);

    /**
     * 根据评论的唯一标识查找评论
     * @param id 评论的唯一标识
     * @return 查找到的评论对象，如果未找到则返回 null
     */
    public Comment findCommentById(int id);

    /**
     * 根据评论者的用户 ID 查找评论列表
     * @param userId 评论者的用户 ID
     * @return 符合条件的评论列表
     */
    public List<Comment> findCommentsByUserId(int userId);

    /**
     * 根据帖子的 ID 查找该帖子下的所有评论列表
     * @param postId 帖子的 ID
     * @return 该帖子下的所有评论列表
     */
    public List<Comment> findCommentsByPostId(int postId);

    /**
     * 查找所有的评论
     * @return 所有评论的列表
     */
    public List<Comment> findAllComments();
}