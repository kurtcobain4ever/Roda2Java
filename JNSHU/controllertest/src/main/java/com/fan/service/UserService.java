package com.fan.service;

import com.fan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
public interface UserService {
    public List<User> getAllUser();
    public List<User> getUserS(User user);
    public List<User> getUserByName(String name);
    public List<User> getUserById(int minid,int maxid);
    public List<User> getPage(int page,int size);
    public boolean deleteUser(int id);
    public boolean insertUser(User user);
    public boolean updateUser(User user);
}
