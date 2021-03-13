package com.example.book.controller;

import com.example.book.common.JsonBean;
import com.example.book.domain.Book;
import com.example.book.domain.Bookdetails;
import com.example.book.service.BookService;
import com.example.book.service.BookcategoryService;
import com.example.book.service.BookdetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author: cz
 * @Date: 2021/1/29
 * @Description:
 */
@RestController
@RequestMapping("bookdetails")
public class BookdetailsController {
    @Autowired
    private BookdetailsService bookdetailsService;

    /*@RequestMapping("bookdetailsList")
    public JsonBean bookcategoryList() {
        return bookdetailsService.selectAll();
    }*/

    @RequestMapping("findBookObj")
    public JsonBean finBookdetailsObj(int id) {
        return bookdetailsService.selectByPrimaryKey(id);
    }

    @RequestMapping("findBookWhere")
    public JsonBean findBookWhere() {
        return null;
    }

    //添加借书单
    @RequestMapping("addBookdetailsObj")
    public JsonBean addBookObj(Bookdetails bookdetails) {
        System.out.println(bookdetails.getBookid()+""+bookdetails.getPersonid()+""+new Date());
        return new JsonBean(0,"",null);
    }
    //查询图书单,返回图书信息
    @RequestMapping("findBookByPersonId")
    public JsonBean findBookByPersonId(int personId) {
        System.out.println(personId);
        return bookdetailsService.selectByPrimaryKey(1);
    }
}
