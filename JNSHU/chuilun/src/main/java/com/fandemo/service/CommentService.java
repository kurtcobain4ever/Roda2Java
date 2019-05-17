package com.fandemo.service;

import com.fandemo.pojo.po.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    boolean doCreate(Comment comment);
    boolean doLoad(int id,int status);
    List<Comment> showOnloadComment(int works_id);
    List<Comment> showComment(int works_id);
}
