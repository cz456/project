package com.example.book.serviceImpl;

import com.example.book.common.JsonBean;
import com.example.book.common.PageRequest;
import com.example.book.common.PageResult;
import com.example.book.common.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.example.book.mapper.BookMapper;
import com.example.book.domain.Book;
import com.example.book.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public JsonBean deleteByPrimaryKey(Integer id) {
        int insert = bookMapper.deleteByPrimaryKey(id);
        if (insert > 0) {
            return new JsonBean(200, "", "");
        }
        return new JsonBean(500, "", "");
    }

    @Override
    public JsonBean insert(Book record) {
        int insert = bookMapper.insert(record);
        if (insert > 0) {
            return new JsonBean(200, "", "");
        }
        return new JsonBean(500, "", "");
    }

    @Override
    public int insertSelective(Book record) {
        return bookMapper.insertSelective(record);
    }

    @Override
    public JsonBean selectByPrimaryKey(Integer id) {

        Book book = bookMapper.selectByPrimaryKey(id);
        if (book == null) {
            return new JsonBean(500, "", "");
        }
        return new JsonBean(200, "", bookMapper.selectByPrimaryKey(id));
    }

    @Override
    public int updateByPrimaryKeySelective(Book record) {
        return bookMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public JsonBean updateByPrimaryKey(Book record) {
        int insert = bookMapper.updateByPrimaryKey(record);
        if (insert > 0) {
            return new JsonBean(200, "", "");
        }
        return new JsonBean(500, "", "");
    }

    @Override
    public JsonBean selectAll() {
        List<Book> books = bookMapper.selectAll();
        if (books.isEmpty()) {
            return new JsonBean(500, "", "");
        }
        return new JsonBean(0, "", books);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    @Override
    public JsonBean selectWherekinds(String Kinds) {
        return new JsonBean(0,"",bookMapper.selectWherekinds(Kinds));
    }

    @Override
    public JsonBean selectWhereSearch(String content) {
        return new JsonBean(0,"",bookMapper.selectWhereSearch(content));
    }

    /**
     * 调用分页插件完成分页
     * @param
     * @return
     */
    private PageInfo<Book> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Book> sysMenus = bookMapper.selectPage();
        return new PageInfo<Book>(sysMenus);
    }
}
