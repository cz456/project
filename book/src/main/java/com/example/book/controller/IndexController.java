package com.example.book.controller;


import com.example.book.common.Code;
import com.example.book.common.JsonBean;
import com.example.book.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    /*@ResponseBody
    @RequestMapping("registered")
    public JsonBean insertSysUser(Users users) {
        JsonBean jsonBean = new JsonBean(-1, "用户注册失败", 1);

        JsonBean jsonBean1 = usersService.selectUserByphone(users.getPhone());
        if (jsonBean1.getCode() == 0) {
            users.setStatus("0");
            int insert = usersService.insert(users);
            if (insert > 0) {
                jsonBean = new JsonBean(0, "用户注册成功，请重新登录", 1);
            }
        }else {
            jsonBean = new JsonBean(-1, "手机号已注册", 1);
        }
        System.out.println(users);
        System.out.println(users.getPhone());

        return jsonBean;
    }*/

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
        // 登陆判断是否为空
        System.out.println(password + loginnumber + pnum);
        if (loginnumber == null || loginnumber.equals("") || password == null
                || password.equals("") || pnum == null || pnum.equals("")) {
            return new JsonBean(-2, "请正确填写", null);
        }
        // 判断验证码是否正确
        if (!sessioncode.equalsIgnoreCase(pnum)) {
            return new JsonBean(-1, "验证码错误", null);
        }
        JsonBean jsonBean = personService.selectUserByUsername(loginnumber, password);
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
