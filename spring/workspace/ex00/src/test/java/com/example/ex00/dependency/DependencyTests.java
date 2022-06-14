package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //현재 클래스는 단위 테스트 클래스임을 나타내고, JUnit 라이브러리를 통해 독립적으로 단위 테스트가 가능해진다.
@Slf4j // 로그 출력 라이브러리
public class DependencyTests {

    //  1. 필드 주입
    @Autowired //단위 테스트에서는 필드 주입만 가능하다.
    private Coding coding;

    // 주입이 되는지 안되는지 테스트
    @Test
    public void dependencyInjectionTest(){
        log.info("----------------------------");
        log.info("coding : " + coding);
        log.info("computer : " + coding.getComputer());
        log.info("----------------------------");
    }
    // 실행 단축키 : Ctrl + Shift + F10
}
