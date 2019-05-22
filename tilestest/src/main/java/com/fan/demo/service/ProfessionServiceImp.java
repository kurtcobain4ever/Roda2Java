package com.fan.demo.service;

import com.fan.demo.dao.ProfessionDao;
import com.fan.demo.po.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProfessionServiceImp implements ProfessionService {
    @Autowired
    ProfessionDao professionDao;
    @Override
    public List<Profession> getAllProfession() {
        return professionDao.getAllProfession();
    }
}
