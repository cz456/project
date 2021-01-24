package com.example.book.service;

import com.example.book.common.JsonBean;
import com.example.book.domain.Person;

public interface PersonService {

    /**
     * 用户注册
     * @param loginnumber
     * @param password
     * @param sessioncode
     * @param pnum
     * @param role
     * @return
     */
    JsonBean selectPerson(String loginnumber, String password, String sessioncode, String pnum, String role);

    /**
     * 人员
     * @param person
     * @return
     */
    JsonBean registered(Person person);
}
