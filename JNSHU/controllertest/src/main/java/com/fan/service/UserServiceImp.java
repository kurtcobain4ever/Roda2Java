package com.fan.service;

import com.fan.dao.UserDao;
import com.fan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userdao;

    public List<User> getAllUser() {
       return userdao.getAllUser();
    }

    public List<User> getUserS(User user) {
        return userdao.getUser(user);
    }


    public List<User> getUserByName(String name) {
        return userdao.getUserByName(name);
    }

    public List<User> getUserById(int id1,int id2){
        return userdao.getUserById(id1,id2);
    }

    public List<User> getPage(int page, int size) {
        return userdao.getPage(page,size);
    }

    public boolean deleteUser(int id) {
        return userdao.deleteUser(id);
    }


    public boolean insertUser(User user) {
        return userdao.insertUser(user);
    }


    public boolean updateUser(User user) {
        return userdao.updateUser(user);
    }
}
