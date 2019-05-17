package com.fandemo;

import com.fandemo.pojo.po.Account;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtil {
    public static Map<Integer,String> getAccountMap(List<Account> accounts){
        Map<Integer,String> listMap=new HashMap<Integer, String>();
        for(Account accountx:accounts){
            listMap.put(accountx.getId(),accountx.getNickname());
        }
        return listMap;
    }
    public static Map<Integer,String> getMap(List<Object> objects){
        Map<Integer,String> listMap=new HashMap<Integer, String>();
        for(Object object:objects){

        }
        return listMap;
    }
}
