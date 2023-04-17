package com.yijian.student.bean.vo;

import lombok.Data;

@Data
public class ScoreVO {
    private Long id;
    private Long studentId;
    private String studentName;
    private String examName;
    private Double cnScore;
    private Double enScore;
    private Double mathScore;
}
