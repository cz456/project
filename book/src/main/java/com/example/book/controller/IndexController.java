package com.example.book.controller;


import com.example.book.common.Code;
import com.example.book.common.JsonBean;
import com.example.book.domain.Person;
import com.example.book.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("index")
public class IndexController {


    /*@Autowired
    private UsersService usersService;*/
    @Autowired
    private PersonService personService;
    /**
     * 用户注册页面
     *
     * @param
     * @return
     */
/*
    @RequestMapping("getuserSession")
    public JsonBean getuserSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("Users");
        JsonBean jsonBean = new JsonBean(0, "ok", user);
        return jsonBean;
    }*/
    @ResponseBody
    @RequestMapping("registered")
    public JsonBean insertSysUser(Person person) {
        JsonBean registered = personService.registered(person);
        return registered;
    }

    /**
     * 用户登录
     *
     * @param request

     * @param password
     * @param pnum
     * @return
     */
    @RequestMapping("login")
    public JsonBean lodin(HttpServletRequest request, String loginnumber, String password, String pnum,String role) {
        System.out.println(role+"========================"+loginnumber+password+pnum);
        HttpSession session = request.getSession();
        String sessioncode = (String) session.getAttribute("pnum");
        JsonBean jsonBean = personService.selectPerson(loginnumber, password,sessioncode,pnum,role);
        if (jsonBean.getCode() == 0) {
            session.setAttribute("Users", jsonBean.getData());
            /*jsonBean.setData(null);*/
        }
        return jsonBean;
    }

    @RequestMapping("code")
    // 验证码
    public void code(HttpServletRequest request, HttpServletResponse response) {
        // 以图片形式输出
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        // 生成验证码
        Code code = new Code();
        String pnum = code.drawImg(output);
        // code生成放到Session中
        HttpSession session = request.getSession();
        session.setAttribute("pnum", pnum);
        // 往外写内容
        try {
            ServletOutputStream out = response.getOutputStream();
            // 通过字节数组的流往外写,写出了ServletOutputStream的请求
            output.writeTo(out);
            out.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
