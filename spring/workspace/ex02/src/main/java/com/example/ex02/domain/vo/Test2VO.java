package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Test2VO {
    //이름
    private String name;
    //국어
    private Integer kor;
    //영어
    private Integer eng;
    //수학
    private Integer math;
    //총점
    private Integer sum;
    //평균
    private Float avg;
}
