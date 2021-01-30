package com.example.book.service;

import com.example.book.common.JsonBean;
import com.example.book.common.PageRequest;
import com.example.book.common.PageResult;
import com.example.book.domain.Book;

import java.util.List;

public interface BookService{


    JsonBean deleteByPrimaryKey(Integer id);

    JsonBean insert(Book record);

    int insertSelective(Book record);

    JsonBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Book record);

    JsonBean updateByPrimaryKey(Book record);

    JsonBean selectAll();

    PageResult findPage(PageRequest pageRequest);

}
