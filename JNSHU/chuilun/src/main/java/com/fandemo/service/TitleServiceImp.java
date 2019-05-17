package com.fandemo.service;

import com.fandemo.dao.TitleDao;
import com.fandemo.dao.WorksDao;
import com.fandemo.pojo.po.Title;
import com.fandemo.pojo.vo.TitleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TitleServiceImp implements TitleService {
    @Autowired
    TitleDao titleDao;
    @Autowired
    WorksDao worksDao;
    List<Title> results=new ArrayList<Title>();

    public List<Title> doGetAll() {
        return titleDao.doGetAll();
    }

    public Title doGetById(int id) {
        return titleDao.doGetById(id);
    }

    public List<Title> doGetUploda() {
        return titleDao.doGetUploda();
    }
    public List<TitleVo> doGetUploadSetList(){
        List<Title> titles= titleDao.doGetUploadSetList();
        List<TitleVo> titleVos=new ArrayList<TitleVo>();
        for(Title title:titles){
            TitleVo titleVo=new TitleVo();
            titleVo.setId(title.getId());
            titleVo.setName(title.getName());
            titleVo.setLevel(title.getLevel());
            titleVo.setCategory(title.getCategory());
            titleVo.setParent_id(title.getParent_id());
            titleVo.setStatus(title.getStatus());
            titleVo.setSeq(title.getSeq());
            titleVo.setEditor_id(title.getEditor_id());
            titleVo.setCreate_at(title.getCreate_at());
            titleVo.setUpdate_at(title.getUpdate_at());
            titleVos.add(titleVo);
        }
        return titleVos;
    }

    public List<Title> doGetUploadThemeList(int set_id) {
        return titleDao.doGetUploadThemeList(set_id);
    }

    public List<Title> doGetSetList(){
        return titleDao.doGetSetList();
    }

    public List<Title> doGetThemeList(int set_id) {
        return titleDao.doGetThemeList(set_id);
    }

    public boolean doUpdate(Title title) {
        return titleDao.doUpdate(title);
    }

    public boolean doCreate(Title title) {
        return titleDao.doCreate(title);
    }

    public boolean doDelete(int id) {
        return false;
    }

    public boolean doLoad(int id, int status) {
        if(status==1){
            Title title=titleDao.doGetById(id);
            Title parent_title=titleDao.doGetById(title.getParent_id());
            if(parent_title.getStatus()==0){
                return false;
            }
            return titleDao.doLoad(id,status);
        }if(status==0) {
            if(titleDao.doGetById(id).getParent_id()==0){
                List<Title> titles=titleDao.doGetThemeList(id);
                for(Title title:titles){
                    int set_id=title.getId();
                    titleDao.doLoad(set_id,status);
                    worksDao.doLoadByTitle(set_id,status);
                }
            }
            titleDao.doLoad(id,status);
            worksDao.doLoadByTitle(id,status);
            return true;
        }
        return false;
    }
    //利用递归查询该标题的所有子集到最后一层
    public List<Title> doGetChildList(int id){
        List<Title> titles=titleDao.doGetChildList(id);
        if(titles!=null){
            for (Title title:titles){
//                results.add(title);
                int parent_id=title.getId();
                doGetChildList(parent_id);
            }
        }
        results.add(titleDao.doGetById(id));
        return results;
    }
}
