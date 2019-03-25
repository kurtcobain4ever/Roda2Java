package com.fan.dao;

import com.fan.pojo.Stu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuDao {
    public boolean doCreate(Stu stu) throws Exception;

    public boolean doCreate1(List<Stu> stus) throws Exception;

    public boolean doUpdate(Stu stu) throws Exception;

    public boolean doRemove(int id) throws Exception;

//    @Select( "select * from stu where id =#{id}")
    public Stu queryById(int id) throws Exception;

    public List<Stu> queryAll() throws Exception;

}
