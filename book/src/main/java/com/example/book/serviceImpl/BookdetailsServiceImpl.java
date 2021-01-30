package com.example.book.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.book.mapper.BookdetailsMapper;
import com.example.book.domain.Bookdetails;
import com.example.book.service.BookdetailsService;
@Service
public class BookdetailsServiceImpl implements BookdetailsService{

    @Resource
    private BookdetailsMapper bookdetailsMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookdetailsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bookdetails record) {
        return bookdetailsMapper.insert(record);
    }

    @Override
    public int insertSelective(Bookdetails record) {
        return bookdetailsMapper.insertSelective(record);
    }

    @Override
    public Bookdetails selectByPrimaryKey(Integer id) {
        return bookdetailsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bookdetails record) {
        return bookdetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bookdetails record) {
        return bookdetailsMapper.updateByPrimaryKey(record);
    }

}
