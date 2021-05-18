package com.zrk.entity;

import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/22 23:53
 */
@Data
public class Submit {

    private Integer problemId;
    /**
     * 1:C
     * 2:C++
     * 3:Java
     */
    private Integer submitType;

    /**
     * 运行Id
     */
    private Integer submitId;

    /**
     * 运行代码
     */
    private String submitCode;

    /**
     * 发送给沙箱时表示：时间空间的限制
     * 返回时表示：运行所用的时间及空间
     */
    private Integer runTime;

    private Integer rumMemory;

    /**
     * 运行结果
     * 0'Accepted',
     *  1   'Presentation Error',
     *   2  'Time Limit Exceeded',
     *    3 'Memory Limit Exceeded',
     *     4'Wrong Answer',
     *     5'Runtime Error',
     *     6'Output Limit Exceeded',
     *     7'Compile Error',
     *     8'System Error'
     *     9:queue
     *     10:judge
     */
    private Integer submitResult;

}
