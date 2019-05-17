package com.fandemo.dao;

import com.fandemo.pojo.po.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BannerDao {
    public List<Banner> doGetAll();
    public List<Banner> doGetById(int id);
    public List<Banner> doGetUploda();
    public boolean doUpdate(Banner banner);
    public boolean doCreate(Banner banner);
    public boolean doDelete(int id);
    public boolean doLoad(@Param("id") int id,@Param("status") int status,@Param("editor_id")int editor_id);
}
