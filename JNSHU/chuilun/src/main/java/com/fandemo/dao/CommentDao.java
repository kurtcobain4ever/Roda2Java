package com.fandemo.dao;

import com.fandemo.pojo.po.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDao {
    boolean doCreate(Comment comment);
    boolean doLoad(@Param("id") int id,@Param("status")int status);
    List<Comment> showOnloadComment(int works_id);
    List<Comment> showComment(int works_id);
}