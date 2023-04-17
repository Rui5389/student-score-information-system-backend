package com.yijian.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class ScoreUpdateReq {
    @NotNull(message = "必须指定")
    private Long id;
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
