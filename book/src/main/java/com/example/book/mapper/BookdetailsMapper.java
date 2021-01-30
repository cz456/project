package com.example.book.mapper;

import com.example.book.domain.Bookdetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BookdetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookdetails record);

    int insertSelective(Bookdetails record);

    Bookdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookdetails record);

    int updateByPrimaryKey(Bookdetails record);
}