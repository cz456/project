package com.example.book.service;

import com.example.book.common.JsonBean;
import com.example.book.domain.Person;
public interface PersonService{

    /**
     * 登录查询
     *
     * @param phone
     * @param password
     * @return
     */
    JsonBean selectUserByUsername(String phone, String password);

}
