package com.fan.demo.service;

import com.fan.demo.po.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProfessionService {
    List<Profession> getAllProfession();
}
