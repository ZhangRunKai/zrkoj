package com.zrk.controller;


import com.zrk.entity.Role;
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
import java.util.HashMap;

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

    @RequestMapping("/update")
    public Result update(@RequestBody User user){
        Integer userId = Integer.getInteger(JWTUtil.userManager.get().get(JWTUtil.USERID));
        Integer result = null;
        if (userId == user.getUserId()
               || Role.canManageRoleAndUser(
                Integer.getInteger(JWTUtil.userManager.get().get(JWTUtil.ROLEPOWER)))){
            result = userServlet.updateUser(user);
            if (result != 0) return Result.seccuss();
            else return Result.errorRequest("修改失败");
        }
        return Result.errorRequest("无权利修改其他人信息");
    }

    @RequestMapping("updateToken")
    public Result updateToken(HttpServletResponse response){
        HashMap<String, String> hashMap = JWTUtil.userManager.get();
        User user = new User();
        user.setUserId(Integer.getInteger(hashMap.get(JWTUtil.USERID)));
        user.setUserName(hashMap.get(JWTUtil.USERNAME));
        user.setRolePower(Integer.getInteger(hashMap.get(JWTUtil.ROLEPOWER)));
        user.setRoleName(hashMap.get(JWTUtil.ROLENAME));
        response.setHeader("Access-Control-Expose-Headers",JWTUtil.TOKEN_HEADER);
        response.setHeader(JWTUtil.TOKEN_HEADER,JWTUtil.createToken(user));
        return Result.seccuss("自动登陆成功");
    }
}
