package com.example.ex01.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TimeMapperTests {
    @Autowired
    private TimeMapper timeMapper;  // 버그로 빨갛게 뜨는거임

    @Test
    public void getTimeTest(){
        log.info("-------------------------------");
        log.info(timeMapper.getTime());
        log.info("-------------------------------");
    }
}
