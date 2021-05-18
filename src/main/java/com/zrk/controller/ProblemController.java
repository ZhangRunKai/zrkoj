package com.zrk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Label;
import com.zrk.entity.Problem;
import com.zrk.service.ProblemServlet;
import com.zrk.util.JWTUtil;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/15 13:09
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    public ProblemServlet problemServlet;


    @RequestMapping("/findAll")
    public Result findAll(@RequestBody Page page){
        Page<Problem> problemIPage = (Page<Problem>) problemServlet.findAll(page);
        return Result.seccuss(problemIPage);
    }

    @RequestMapping("/find")
    public Result findProblem(@RequestBody Problem problem){
        return Result.seccuss(problemServlet.find(problem));
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Problem problem){
        if(problem != null){
            Integer userId = Integer.getInteger(JWTUtil.userManager.get().get(JWTUtil.USERID));
            problem.setUserId(userId);
            Integer add = problemServlet.add(problem);
            if(add==1) return Result.seccuss();
            return Result.errorRequest("创建失败");
        }
        return Result.errorRequest("问题条件缺失，无法新建");
    }


    @RequestMapping("/findPrivate")
    public Result findProblemByPrivate(@RequestBody Page page){
        return Result.seccuss(problemServlet.findProblemByPrivate(page));
    }

}
