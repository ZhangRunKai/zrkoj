package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/5/9 0:49
 */
@Data
@TableName("contest_problem")
public class ContestProblem {
    private Integer problemId;
    private Integer problemNum;
    private Integer problemAccept;
    private Integer contestId;
    private Integer problemNo;
}
