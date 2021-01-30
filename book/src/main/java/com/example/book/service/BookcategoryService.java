package com.example.book.service;

import com.example.book.domain.Bookcategory;
public interface BookcategoryService{


    int deleteByPrimaryKey(Integer id);

    int insert(Bookcategory record);

    int insertSelective(Bookcategory record);

    Bookcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookcategory record);

    int updateByPrimaryKey(Bookcategory record);

}
