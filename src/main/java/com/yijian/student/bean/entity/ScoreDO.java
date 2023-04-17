package com.yijian.student.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("score")
public class ScoreDO {
    /*
    * 外键:studnet表的id
    * */
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long studentId;
    private String examName;
    private Double cnScore;
    private Double enScore;
    private Double mathScore;

}
