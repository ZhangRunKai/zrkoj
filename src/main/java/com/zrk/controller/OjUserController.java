package com.zrk.controller;


import com.zrk.entity.OjUser;
import com.zrk.service.OJUserService;
import com.zrk.util.JWTUtil;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class OjUserController {
    @Autowired
    private OJUserService ojUserService;

    @RequestMapping("/login")
    public Result login(@RequestBody OjUser ojUser, HttpServletResponse response,HttpServletRequest request){
        if(ojUser==null||ojUser.getUserAccount()==null||ojUser.getUserPassword()==null) return Result.errorRequest("登陆失败，请填写账号或密码");
        OjUser result = ojUserService.login(ojUser);
        if(result==null) Result.errorRequest("登陆失败，账号不存在或密码错误");
        response.setHeader(JWTUtil.TOKEN_HEADER,JWTUtil.createToken("user",result.getUserName(),result.getUserId(),result.getUserPower(),request.getLocalAddr()));
        return Result.seccuss();
    }

    @RequestMapping("/register")
    public Result register(@RequestBody OjUser ojUser){
        if(ojUser==null||ojUser.getUserAccount()==null||ojUser.getUserPassword()==null) return Result.errorRequest("注册失败，请填写账号或密码");

        try{
            ojUserService.register(ojUser);
        }catch (Exception e){
            return Result.errorRequest("注册失败，账号已存在");
        }
        return Result.seccuss();
    }

    @RequestMapping("/changeUserPassword")
    public Result changeUserPassword(@RequestBody OjUser ojUser){
        Integer result = ojUserService.changeOjUser(ojUser);
        if(result==1) return Result.seccuss("修改成功");
        return Result.errorRequest("修改失败");

    }

    @RequestMapping("/test")
    public Result Test(HttpServletRequest request){
        System.out.println("111");
        return Result.seccuss("ip",request);
    }
    @RequestMapping("/test1")
    public String Test1(HttpServletRequest request){
        System.out.println("111");
        return request.getRemoteAddr();
    }
}
