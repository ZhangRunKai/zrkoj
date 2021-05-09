package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/5/9 1:29
 */
@TableName("contest_student")
@Data
public class ContestStudent {
    private Integer contestId;
    private Integer studentId;
    private Integer studentStatus;
    private Integer acceptNum;
    private Integer useTime;
}
