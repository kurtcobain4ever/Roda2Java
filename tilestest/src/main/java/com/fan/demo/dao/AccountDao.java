package com.fan.demo.dao;

import com.fan.demo.po.Account;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    Account doLogin(@Param("username")String username,@Param("password")String password);
    boolean doRegister(Account account);
    Account doGetByUsername(String username);
    Account doGetUserInfo(String nickname);
}
