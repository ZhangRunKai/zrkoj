package com.zrk.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/6 20:02
 */
@Data
public class OjClass {
    private Integer classId;
    private Integer classTeacherId;
    private String className;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Data classBegin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Data classEnd;
    private String classAbout;
    private Integer classStatus;
}
