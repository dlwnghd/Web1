package com.example.ex00.dependency;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
@NoArgsConstructor  // 기본생성자
@AllArgsConstructor
public class QualifierTests {
    @Autowired
    @Qualifier("desktop")
    private Computer desktop;

    @Autowired
    @Qualifier("laptop")
    private Computer laptop;

    @Autowired
    @Qualifier("computer")
    private Computer computer;

    @Test
    public void computerTest{
        log.info("---------------");
        log.info("computer : "+ desktop);
        log.info("---------------");

        log.info("---------------");
        log.info("computer : "+ laptop());
        log.info("---------------");
    }
}
