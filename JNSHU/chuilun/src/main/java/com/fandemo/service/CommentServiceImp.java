package com.fandemo.service;

import com.fandemo.dao.AccountDao;
import com.fandemo.dao.CommentDao;
import com.fandemo.pojo.po.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CommentServiceImp implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    AccountDao accountDao;
    public boolean doCreate(Comment comment) {
        return commentDao.doCreate(comment);
    }

    public boolean doLoad(int id, int status) {
        return commentDao.doLoad(id,status);
    }
    public List<Comment> showOnloadComment(int works_id){
        return commentDao.showOnloadComment(works_id);
    }

    public List<Comment> showComment(int works_id) {
        List<Comment> comments=commentDao.showComment(works_id);
        List<Integer> ids = new ArrayList<Integer>();
        for(Comment comment:comments){
            int id=comment.getEditor_id();
            ids.add(id);
        }
        return comments;
    }
}
