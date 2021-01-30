package com.example.book.serviceImpl;

import com.example.book.common.JsonBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.book.domain.Bookcategory;
import com.example.book.mapper.BookcategoryMapper;
import com.example.book.service.BookcategoryService;
@Service
public class BookcategoryServiceImpl implements BookcategoryService{

    @Resource
    private BookcategoryMapper bookcategoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bookcategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Bookcategory record) {
        return bookcategoryMapper.insert(record);
    }

    @Override
    public int insertSelective(Bookcategory record) {
        return bookcategoryMapper.insertSelective(record);
    }

    @Override
    public Bookcategory selectByPrimaryKey(Integer id) {
        return bookcategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Bookcategory record) {
        return bookcategoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bookcategory record) {
        return bookcategoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public JsonBean selectAll() {
        return new JsonBean(1,"",bookcategoryMapper.selectAll());
    }

}
