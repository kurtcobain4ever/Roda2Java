package com.fandemo.service;

import com.fandemo.dao.BannerDao;
import com.fandemo.pojo.po.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BannerServiceImp implements BannerService {
    @Autowired
    BannerDao bannerDao;
    public List<Banner> doGetAll() {
        return bannerDao.doGetAll();
    }

    public List<Banner> doGetById(int id) {
        return bannerDao.doGetById(id);
    }

    public List<Banner> doGetUploda() {
        return bannerDao.doGetUploda();
    }

    public boolean doUpdate(Banner banner) {
        return bannerDao.doUpdate(banner);
    }

    public boolean doCreate(Banner banner) {
        return bannerDao.doCreate(banner);
    }

    public boolean doDelete(int id) {
        return bannerDao.doDelete(id);
    }

    public boolean doLoad(int id,int status,int editor_id) {
        return bannerDao.doLoad(id,status,editor_id);
    }
}
