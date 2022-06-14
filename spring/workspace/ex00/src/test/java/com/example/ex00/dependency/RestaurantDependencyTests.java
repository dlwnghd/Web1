package com.example.ex00.dependency;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantDependencyTests {
    //  1. 필드 주입
    @Autowired //단위 테스트에서는 필드 주입만 가능하다.
    private Restaurant restaurant;

    // 주입이 되는지 안되는지 테스트
    @Test
    public void restaurantInjectionTest(){
        log.info("------------------------------");
        log.info("restaurant : " + restaurant);
        log.info("chef : " + restaurant.getChef());
        log.info("------------------------------");
    }
}
