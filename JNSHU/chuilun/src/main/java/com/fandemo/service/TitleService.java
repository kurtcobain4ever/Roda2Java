package com.fandemo.service;

import com.fandemo.pojo.po.Title;
import com.fandemo.pojo.vo.TitleVo;

import java.util.List;

public interface TitleService {
    List<Title> doGetAll();
    Title doGetById(int id);
    List<Title> doGetUploda();
    List<TitleVo> doGetUploadSetList();
    List<Title> doGetUploadThemeList(int set_id);
    List<Title> doGetSetList();
    List<Title> doGetThemeList(int set_id);
    List<Title> doGetChildList(int id);
    boolean doUpdate(Title title);
    boolean doCreate(Title title);
    boolean doDelete(int id);
    boolean doLoad(int id, int status);
}
