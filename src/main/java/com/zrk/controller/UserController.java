package com.zrk.controller;


import com.zrk.entity.User;
import com.zrk.service.UserServlet;
import com.zrk.util.JWTUtil;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServlet userServlet;

    @RequestMapping("/login")
    public Result login(@RequestBody User user, HttpServletResponse response, HttpServletRequest request){
        if(user!=null&&user.getUserAccount()!=null&&user.getUserPassword()!=null){
            User result = userServlet.login(user);
            if(result==null) Result.errorRequest("登陆失败，账号不存在或密码错误");
            response.setHeader("Access-Control-Expose-Headers",JWTUtil.TOKEN_HEADER);
            response.setHeader(JWTUtil.TOKEN_HEADER,JWTUtil.createToken(result));
            return Result.seccuss(result);
        }
        return Result.errorRequest("登陆失败，请填写账号或密码");
    }

    @RequestMapping("/register")
    public Result register(@RequestBody User user){
        if(user==null||user.getUserAccount()==null||user.getUserPassword()==null) return Result.errorRequest("注册失败，请填写账号或密码");
        try{
            Integer integer = userServlet.addUser(user);
        }catch (Exception e){
            System.out.println(e);
            return Result.errorRequest("注册失败，账号已存在");
        }
        return Result.seccuss();
    }
}
