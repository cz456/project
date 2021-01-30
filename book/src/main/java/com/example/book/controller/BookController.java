package com.example.book.controller;

import com.example.book.common.JsonBean;
import com.example.book.domain.Person;
import com.example.book.service.BookService;
import com.example.book.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cz
 * @Date: 2021/1/29
 * @Description:
 */
@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("findBookList")
    public JsonBean findBookList() {
        return null;
    }
    @RequestMapping("findBookObj")
    public JsonBean findBookObj() {
        return null;
    }
    @RequestMapping("findBookWhere")
    public JsonBean findBookWhere() {
        return null;
    }
}
