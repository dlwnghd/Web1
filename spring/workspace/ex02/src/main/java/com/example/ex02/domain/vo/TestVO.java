package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TestVO {
    //이름
    private String name;
    //국어
    private Integer kor;
    //영어
    private Integer eng;
    //수학
    private Integer math;
}
