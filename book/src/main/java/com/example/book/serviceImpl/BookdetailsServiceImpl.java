package com.example.book.serviceImpl;

import com.example.book.common.JsonBean;
import com.example.book.domain.Book;
import com.example.book.mapper.BookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.example.book.mapper.BookdetailsMapper;
import com.example.book.domain.Bookdetails;
import com.example.book.service.BookdetailsService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class BookdetailsServiceImpl implements BookdetailsService {

    @Resource
    private BookdetailsMapper bookdetailsMapper;
    @Resource
    private BookMapper bookMapper;

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
    public JsonBean selectByPrimaryKey(Integer pid) {
        return new JsonBean(0, "", bookdetailsMapper.selectByPid(pid));
    }
    @Override
    public JsonBean selectByPid(Integer pid) {
        return new JsonBean(0, "", bookdetailsMapper.selectByPid(pid));
    }
    @Override
    public int updateByPrimaryKeySelective(Bookdetails record) {
        return bookdetailsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Bookdetails record) {
        return bookdetailsMapper.updateByPrimaryKey(record);
    }

    @Override
    public JsonBean insertBook(Bookdetails record) {

        Book book = bookMapper.selectByPrimaryKey(record.getBookid());
        if (book.getBooknumber() < 0) {
            return new JsonBean(-1, "库存不足", null);
        } else {
            book.setBooknumber(book.getBooknumber() - 1);
            int i = bookMapper.updateByPrimaryKeySelective(book);
            if (i > 0) {
                SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd");
                Calendar c = Calendar.getInstance();
                c.add(Calendar.DATE, 30);//计算30天后的时间
                String str2=s.format(c.getTime());
                Date now = new Date();
                String n = s.format(now);
                record.setBookdate(n);
                record.setBorrowTime(str2);
                record.setState("1");
                int i2 = bookdetailsMapper.insertBook(record);
                if (i2 > 0) {
                    return new JsonBean(0, "", null);
                }
            }

        }

        return new JsonBean(-1, "", null);
    }


}
