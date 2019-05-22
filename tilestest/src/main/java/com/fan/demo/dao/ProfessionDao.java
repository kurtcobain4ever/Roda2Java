package com.fan.demo.dao;

import com.fan.demo.po.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProfessionDao {
    List<Profession> getAllProfession();
}
