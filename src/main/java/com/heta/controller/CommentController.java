package com.heta.controller;

import com.heta.entity.Comment;
import com.heta.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heta/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 添加一条新的评论
     * @param comment 要添加的评论对象，通过请求体传递
     */
    @PostMapping("/addNewComment")
    public void addNewComment(@RequestBody Comment comment) {
        commentService.addNewComment(comment);
    }

    /**
     * 根据评论的唯一标识查找评论
     * @param id 评论的唯一标识，通过路径变量传递
     * @return 查找到的评论对象
     */
    @GetMapping("/findCommentById/{id}")
    public Comment findCommentById(@PathVariable("id") int id) {
        return commentService.findCommentById(id);
    }

    /**
     * 根据评论者的用户 ID 查找评论列表
     * @param userId 评论者的用户 ID，通过路径变量传递
     * @return 符合条件的评论列表
     */
    @GetMapping("/findCommentsByUserId/{userId}")
    public List<Comment> findCommentsByUserId(@PathVariable("userId") int userId) {
        return commentService.findCommentsByUserId(userId);
    }

    /**
     * 根据帖子的 ID 查找该帖子下的所有评论列表
     * @param postId 帖子的 ID，通过路径变量传递
     * @return 该帖子下的所有评论列表
     */
    @GetMapping("/findCommentsByPostId/{postId}")
    public List<Comment> findCommentsByPostId(@PathVariable("postId") int postId) {
        return commentService.findCommentsByPostId(postId);
    }

    /**
     * 查找所有的评论
     * @return 所有评论的列表
     */
    @GetMapping("/findAllComments")
    public List<Comment> findAllComments() {
        return commentService.findAllComments();
    }
}