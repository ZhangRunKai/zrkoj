package com.zrk.controller;

import com.zrk.entity.Admin;
import com.zrk.service.AdminService;
import com.zrk.service.impl.AdminServiceImpl;
import com.zrk.util.JWTUtil;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/8 13:40
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin, HttpServletRequest request, HttpServletResponse response){
        if(Admin.checkAdmin(admin)){
            Admin login = adminService.login(admin);
            if(login==null) return Result.errorRequest("账号不存在或密码错误");
            response.setHeader(JWTUtil.TOKEN_HEADER,JWTUtil.createToken("admin",admin.getAdminName(),admin.getAdminId(),login.getAdminId(),request.getLocalAddr()));
            return Result.seccuss();
        }
        return Result.errorRequest("账号或密码缺失，请重新填写");
    }

    @RequestMapping("/register")
    public Result register(@RequestBody Admin admin){
        if(Admin.checkAdmin(admin)){
            Integer register = adminService.register(admin);
            if(register==1) return Result.seccuss();
        }
        return Result.errorRequest("账号或密码缺失，请重新填写");
    }
}
