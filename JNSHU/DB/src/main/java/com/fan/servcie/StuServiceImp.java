package com.fan.servcie;

import com.fan.dao.StuDao;
import com.fan.dao.StuDaoImp;

public class StuServiceImp implements StuService {
    private StuDao stuDao0;
    private StuDao stuDao;

    public StuDao getStuDao0() {
        return stuDao0;
    }


    public void setStuDao0(StuDao stuDao0) {
        this.stuDao0 = stuDao0;
    }

    public StuDao getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDao stuDao) {
        this.stuDao = stuDao;
    }
}
