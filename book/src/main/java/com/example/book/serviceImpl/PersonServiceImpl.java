package com.example.book.serviceImpl;

import com.example.book.common.JsonBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.example.book.mapper.PersonMapper;
import com.example.book.domain.Person;
import com.example.book.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Resource
    private PersonMapper personMapper;


    @Override
    public JsonBean selectPerson(String loginnumber, String password, String sessioncode, String pnum, String role) {
        JsonBean jsonBean = new JsonBean(0, "", null);
        // 判断验证码是否正确
        if (!sessioncode.equalsIgnoreCase(pnum)) {
            return new JsonBean(-1, "验证码错误", null);
        }
       /* if (loginnumber == null || loginnumber.equals("") || password == null
                || password.equals("") || pnum == null || pnum.equals("")) {
            return new JsonBean(-2, "请正确填写", null);
        }*/
        Person dbPeron = personMapper.selectByUserName(loginnumber);
        if (dbPeron != null) {
            if (!dbPeron.getState().equals("1")) {
                jsonBean = new JsonBean(-4, "该用户被注销", null);
            } else if (dbPeron.getPassword().equals(password) && dbPeron.getRole().equals(role)) {
                if (dbPeron.getRole().equals("1")) {
                    jsonBean = new JsonBean(1, "管理员登陆成功", dbPeron);
                } else if (dbPeron.getRole().equals("0")) {
                    jsonBean = new JsonBean(0, "学生登陆成功", dbPeron);
                }
            } else {
                jsonBean = new JsonBean(-1, "密码错误", dbPeron);
            }
        } else {
            jsonBean = new JsonBean(-3, "用户名为空", null);
        }
        return jsonBean;
    }

    @Override
    public JsonBean registered(Person person) {
        JsonBean jsonBean = new JsonBean(-1, "用户注册失败", 1);
        Person dbPero = personMapper.selectByUserName(person.getLoginnumber());
        if (dbPero == null) {
            person.setRole("0");
            person.setState("1");
            int insert = personMapper.insert(person);
            if (insert > 0) {
                jsonBean = new JsonBean(0, "注册成功", person);
            } else {
                jsonBean = new JsonBean(-1, "注册失败请稍后。。。", person);
            }
        } else {
            jsonBean = new JsonBean(-2, "该学号已注册", null);
        }

        return jsonBean;
    }
}
