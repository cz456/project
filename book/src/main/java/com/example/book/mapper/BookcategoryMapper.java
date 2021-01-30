package com.example.book.mapper;

import com.example.book.domain.Bookcategory;

public interface BookcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookcategory record);

    int insertSelective(Bookcategory record);

    Bookcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookcategory record);

    int updateByPrimaryKey(Bookcategory record);
}