package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/16 12:22
 */
@Data
@AllArgsConstructor
@TableName("problem_label")
public class ProblemLabel {
    private Integer problemId;
    private Integer labelId;
}
