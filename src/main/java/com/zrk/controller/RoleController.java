package com.zrk.controller;

import com.zrk.entity.Role;
import com.zrk.service.RoleServlet;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/14 14:32
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServlet roleServlet;

    @RequestMapping("/addRole")
    public Result insert(@RequestBody Role role){
        Integer insert = roleServlet.insert(role);

        return Result.seccuss(insert);
    }
}
