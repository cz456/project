package com.example.book.mapper;

import com.example.book.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    /**
     * 登陆查询
     * @param loginnumber
     * @return
     */
    Person selectByUserName(String loginnumber);

    /**
     * 注册
     * @param person
     * @return
     */
    int insert(Person person);
}