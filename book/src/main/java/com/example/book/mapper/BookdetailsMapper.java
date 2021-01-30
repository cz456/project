package com.example.book.mapper;

import com.example.book.domain.Bookdetails;

public interface BookdetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookdetails record);

    int insertSelective(Bookdetails record);

    Bookdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookdetails record);

    int updateByPrimaryKey(Bookdetails record);
}