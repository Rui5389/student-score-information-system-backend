package com.yijian.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ScoreAddReq {
    @NotNull
    private Long studentId;
    @NotBlank
    private String examName;
    @NotNull
    private Double cnScore;
    @NotNull
    private Double enScore;
    @NotNull
    private Double mathScore;
}
