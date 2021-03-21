package com.example.book.mapper;

import com.example.book.domain.Bookdetails;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BookdetailsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Bookdetails record);

    int insertSelective(Bookdetails record);

    Bookdetails selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Bookdetails record);

    int updateByPrimaryKey(Bookdetails record);

    int insertBook(Bookdetails record);

   List<Bookdetails>  selectByPid(Integer pid);
}