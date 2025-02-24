package com.heta.service;

import com.heta.entity.Comment;
import com.heta.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    /**
     * 添加一条新的评论
     * @param comment 要添加的评论对象
     */
    public void addNewComment(Comment comment) {
        commentRepository.addNewComment(comment);
    }

    /**
     * 根据评论的唯一标识查找评论
     * @param id 评论的唯一标识
     * @return 查找到的评论对象，如果未找到则返回 null
     */
    public Comment findCommentById(int id) {
        return commentRepository.findCommentById(id);
    }

    /**
     * 根据评论者的用户 ID 查找评论列表
     * @param userId 评论者的用户 ID
     * @return 符合条件的评论列表
     */
    public List<Comment> findCommentsByUserId(int userId) {
        return commentRepository.findCommentsByUserId(userId);
    }

    /**
     * 根据帖子的 ID 查找该帖子下的所有评论列表
     * @param postId 帖子的 ID
     * @return 该帖子下的所有评论列表
     */
    public List<Comment> findCommentsByPostId(int postId) {
        return commentRepository.findCommentsByPostId(postId);
    }

    /**
     * 查找所有的评论
     * @return 所有评论的列表
     */
    public List<Comment> findAllComments() {
        return commentRepository.findAllComments();
    }
}