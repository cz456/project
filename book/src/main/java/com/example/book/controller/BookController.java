package com.example.book.controller;

import com.example.book.common.JsonBean;
import com.example.book.common.PageRequest;
import com.example.book.domain.Book;
import com.example.book.domain.Person;
import com.example.book.service.BookService;
import com.example.book.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * @return
     */
    @RequestMapping("findBookList")
    public JsonBean findBookList() {
        return bookService.selectAll();
    }

    @RequestMapping("findBookObj")
    public JsonBean findBookObj(Integer id) {
        return bookService.selectByPrimaryKey(id);
    }

    @RequestMapping("findBookWherekinds")
    public JsonBean findBookWhere(String kinds) {
        return bookService.selectWherekinds(kinds);
    }

    @RequestMapping("addBookObj")
    public JsonBean addBookObj(Book book) {
        return bookService.insert(book);
    }

    @RequestMapping("updateBookObj")
    public JsonBean updateBookObj(Book book) {
        return bookService.updateByPrimaryKey(book);
    }

    @RequestMapping("removeBookObj")
    public JsonBean removeBookObj(Integer id) {
        return bookService.deleteByPrimaryKey(id);
    }

    @RequestMapping("findBookWhereSearch")
    public JsonBean findBookWhereSearch(String content) {
        return bookService.selectWhereSearch(content);
    }

    @RequestMapping(value = "/findBookPage")
    public Object findPage(PageRequest pageQuery) {

        return bookService.findPage(pageQuery);
    }

}
