package com.fandemo.dao;

import com.fandemo.pojo.po.Title;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TitleDao {
    List<Title> doGetAll();
    Title doGetById(int id);
    List<Title> doGetUploda();
    List<Title> doGetSetList();
    List<Title> doGetThemeList(int set_id);
    List<Title> doGetUploadSetList();
    List<Title> doGetUploadThemeList(int set_id);
    List<Title> doGetChildList(int id);
    List<Title> doGetChild(List<Integer> ids);
    boolean doUpdate(Title title);
    boolean doCreate(Title title);
    boolean doDelete(int id);
    boolean doLoad(@Param("id") int id, @Param("status") int status);
}
