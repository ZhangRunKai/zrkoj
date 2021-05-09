package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/4/23 16:15
 */
@TableName("oj_contest")
@Data
public class Contest {

    /**
     * 比赛ID,主键
     */
    @TableId(value = "contest_id", type = IdType.AUTO)
    private Integer contestId;

    /**
     * 创建比赛的用户
     */
    private Integer userId;

    /**
     * 比赛名称
     */
    private String contestName;

    /**
     * 比赛详情
     */
    private String contestDetails;

    /**
     * 比赛开始时间和结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contestBegin;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date contestEnd;

    /**
     * 主办方名称
     * 可接受自定义
     */
    private String contestAuthor;

    /**
     * 当前报名的人数
     */
    private Integer studentNum;

    /**
     * 是否私有
     */
    private Integer isPrivate;

    /**
     * 比赛密码
     * 若未公开，则不显示
     */
    private String examPassword;

    /**
     * 比赛状态
     * 0：创建状态
     * 1：发布
     * 2：报名截止
     * 3：废除
     * 4：删除
     */
    private Integer contestStatus;

    /**
     * 报名截止时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date joinEnd;

    /**
     * 比赛的题目
     */
    @TableField(exist = false)
    private List<ContestProblem> problems;
}
