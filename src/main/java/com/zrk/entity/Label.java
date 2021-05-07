package com.zrk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhang run kai
 * @version 1.0
 * @date 2021/3/13 18:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("oj_label")
public class Label {

    @TableId(value = "label_id",type = IdType.AUTO)
    private Integer labelId;
    private String labelName;

    @TableField(exist = false)
    private Integer labelCount;

    public static boolean check(Label label){
        if(label!=null&&label.getLabelName()!=null) return true;
        return false;
    }
}
