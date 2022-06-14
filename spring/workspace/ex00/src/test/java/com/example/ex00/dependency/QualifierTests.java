package com.example.ex00.dependency;

import com.example.ex00.dependency.qualifier.Computer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //현재 클래스는 단위 테스트 클래스
@Slf4j  // 로그 출력 라이브러리
public class QualifierTests {
    // 필드 주입
    @Autowired
    @Qualifier("desktop")   // 분류 desktop으로 명시된 객체, 식별자 부여
    private Computer desktop;

    @Autowired
    @Qualifier("laptop")   // 분류 laptop으로 명시된 객체, 식별자 부여
    private Computer laptop;

    @Autowired
    private Computer computer;

    @Test
    public void computerTest(){
        log.info("------------------------------");
        log.info("desktop : " + desktop.getScreenWidth());
        log.info("------------------------------");

        log.info("------------------------------");
        log.info("laptop : " + laptop.getScreenWidth());
        log.info("------------------------------");

        log.info("------------------------------");
        log.info("computer : " + computer.getScreenWidth());
        log.info("------------------------------");
    }

}
