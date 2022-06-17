package com.example.ex02.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentVO {
    private String name;
    private Integer kor;
    private Integer eng;
    private Integer math;
    private Integer total;
    private Double avg;
}

