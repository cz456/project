package com.example.book.controller;

import com.example.book.common.JsonBean;
import com.example.book.service.BookcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: cz
 * @Date: 2021/1/31
 * @Description:
 */
@RestController
@RequestMapping("bookcategory")
public class BookcategoryController {
    @Autowired
    private BookcategoryService bookcategoryService;

    @RequestMapping("bookcategoryList")
    public JsonBean bookcategoryList() {
        return bookcategoryService.selectAll();
    }
    
}
