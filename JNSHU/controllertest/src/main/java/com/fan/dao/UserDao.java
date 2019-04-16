package com.fan.dao;

import com.fan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserDao{
    public List<User> getAllUser();
    public List<User> getUser(User user);
    public List<User> getUserByName(String name);
    public List<User> getPage(@Param("index")int index,@Param("size")int size);
    public List<User> getUserById(@Param("id1") int minid, @Param("id2") int maxid);
    public boolean deleteUser(int id);
    public boolean insertUser(User user);
    public boolean updateUser(User user);

}
