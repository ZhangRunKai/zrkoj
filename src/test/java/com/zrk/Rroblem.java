package com.zrk;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zrk.mapper.ProblemMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/16 14:57
 */
@SpringBootTest
public class Rroblem {

    @Autowired
    private ProblemMapper problemMapper;
    @Test
    public void test1(){
        Page page = new Page();
        page.setCurrent(1);
        page.setSize(10);
    }

}
