package com.fandemo.service;

import com.fandemo.pojo.po.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> doGetAll();
    public List<Banner> doGetById(int id);
    public List<Banner> doGetUploda();
    public boolean doUpdate(Banner banner);
    public boolean doCreate(Banner banner);
    public boolean doDelete(int id);
    public boolean doLoad(int id,int status,int editor_id);
}
