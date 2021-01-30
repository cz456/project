package com.example.book.service;

import com.example.book.domain.Bookdetails;
public interface BookdetailsService{


    int deleteByPrimaryKey(Integer id);

    int insert(Bookdetails record);

    int insertSelective(Bookdetails record);

    Bookdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookdetails record);

    int updateByPrimaryKey(Bookdetails record);

}
