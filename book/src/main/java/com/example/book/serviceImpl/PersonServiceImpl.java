package com.example.book.serviceImpl;

import com.example.book.common.JsonBean;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.book.mapper.PersonMapper;
import com.example.book.domain.Person;
import com.example.book.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService{

    @Resource
    private PersonMapper personMapper;


    @Override
    public JsonBean selectUserByUsername(String loginnumber, String password) {
        JsonBean jsonBean = new JsonBean(-3, "用户名为空", null);
        Person dbUser = personMapper.selectByUserName(loginnumber);
        System.out.println("=========================="+dbUser.getState());
        if (dbUser != null) {
            if (!dbUser.getState().equals("1")) {
                jsonBean = new JsonBean(-4, "没有访问权限", null);
                System.out.println("ssssssssssssssssssssssssssssssssssssss");
            }else if (dbUser.getPassword().equals(password)) {
                jsonBean = new JsonBean(0, "用户登陆成功，将要跳转首页", dbUser);

            }else {
                jsonBean = new JsonBean(-1, "密码错误", dbUser);
            }
        }
        return jsonBean;
    }
}
