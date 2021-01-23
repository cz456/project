package com.example.book.mapper;

import com.example.book.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    Person selectByUserName(String loginnumber);
}