package com.example.book.service;

import com.example.book.common.JsonBean;
import com.example.book.domain.Bookdetails;
public interface BookdetailsService{


    int deleteByPrimaryKey(Integer id);

    int insert(Bookdetails record);

    int insertSelective(Bookdetails record);

    JsonBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookdetails record);

    int updateByPrimaryKey(Bookdetails record);

    //JsonBean selectAll();
    JsonBean insertBook(Bookdetails record);

    JsonBean selectByPid(Integer pid);
}
