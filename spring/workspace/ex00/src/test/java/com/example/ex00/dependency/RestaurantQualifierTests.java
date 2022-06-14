package com.example.ex00.dependency;

import com.example.ex00.dependency.qualifier.Restaurant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantQualifierTests {
    @Autowired
    @Qualifier("outback")
    private Restaurant outback;

    @Autowired
    @Qualifier("vips")
    private Restaurant vips;

    @Autowired
    private Restaurant restaurant;

    @Test
    public void restaurantInjectionTest(){
        log.info("------------------------------");
        log.info("outback : " + outback.sidebar());
        log.info("------------------------------");

        log.info("------------------------------");
        log.info("vips : " + vips.sidebar());
        log.info("------------------------------");

        log.info("------------------------------");
        log.info("restaurant : " + restaurant.sidebar());
        log.info("------------------------------");
    }
}
