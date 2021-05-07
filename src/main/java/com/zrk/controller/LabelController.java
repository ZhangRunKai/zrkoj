package com.zrk.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.entity.Label;
import com.zrk.service.LabelServlet;
import com.zrk.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/16 12:35
 */
@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private LabelServlet labelServlet;

    @RequestMapping("/add")
    public Result add(@RequestBody Label label){
       if(Label.check(label)){
           Integer add = labelServlet.add(label);
           if(add!=null){
               if(add==2) return Result.errorRequest("存在问题带有该标签，无法删除");
               return Result.seccuss();
           }
           return Result.errorRequest("添加失败");
       }
       return Result.errorRequest("标签名称不能为空");
    }

    @RequestMapping("/findAll")
    public Result find(@RequestBody Page page){
        Page<Label> all = (Page<Label>) labelServlet.findAll(page);
        return Result.seccuss(all);
    }
}
