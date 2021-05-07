package com.zrk.entity.sandbox;

import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/22 23:53
 */
@Data
public class SandboxSubmit {

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
     */
    private Integer runTime;

    private Integer rumMemory;

    /**
     * 运行结果
     */
    private Integer submitResult;

}
