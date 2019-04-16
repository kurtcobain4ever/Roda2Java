package com.fan.service;

import com.fan.dao.UserDao;
import com.fan.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAllUser() {
       return userDao.getAllUser();
    }

    public List<User> getUserS(User user) {
        return userDao.getUser(user);
    }


    public List<User> getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public List<User> getUserById(int id1,int id2){
        return userDao.getUserById(id1,id2);
    }

    public List<User> getPage(int page, int size) {
        int index=(page-1)*size;
        return userDao.getPage(index,size);
    }
    public List<User> getPage2(int page,int size){
        int index1=(page-1)*size;
        int index2=page*size;
        List<User> users=userDao.getAllUser();
        return users.subList(index1,index2);
    }

    public boolean deleteUser(int id) {
        return userDao.deleteUser(id);
    }


    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }


    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }
}
