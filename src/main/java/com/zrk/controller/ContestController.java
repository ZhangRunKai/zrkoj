package com.zrk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Contest;
import com.zrk.entity.User;
import com.zrk.service.ContestServlet;
import com.zrk.util.JWTUtil;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:22
 */
@RestController
@RequestMapping("/contest")
public class ContestController {

    @Autowired
    private ContestServlet contestServlet;

    @RequestMapping("/createContest")
    public Result createContest(@RequestBody Contest contest){
        if (contest == null || contest.getContestBegin() == null || contest.getContestEnd() == null ||
            contest.getContestEnd().before(contest.getContestBegin()) || (contest.getIsPrivate().equals("1") && contest.getExamPassword().equals(""))){
            return Result.errorParams();
        }
        HashMap<String, Integer> hashMap = JWTUtil.userManager.get();

        //权限校验
        if(!User.hasCreateContest(hashMap.get(JWTUtil.ROLEPOWER)))
            return Result.errorRequest("用户无权限创建比赛");
        contest.setUserId(hashMap.get(JWTUtil.USERID));
        if(contestServlet.createContest(contest).equals(1))
            return Result.seccuss();
        return Result.errorRequest("创建失败，请重试");
    }


    @RequestMapping("/findContestByCreate")
    public Result findContestByCreate(@RequestBody Page page){
        Integer userId = JWTUtil.userManager.get().get(JWTUtil.USERID);
        IPage<Contest> allByCreate = contestServlet.findAllByCreate(userId, page);
        return Result.seccuss(allByCreate);
    }

}
