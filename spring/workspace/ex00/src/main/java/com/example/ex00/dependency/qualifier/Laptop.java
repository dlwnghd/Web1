package com.example.ex00.dependency.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component  //⭐⭐⭐⭐⭐
@Qualifier("laptop")    // laptop으로 명시, 식별자 부여
@ToString   // 주소형태가 아닌 문자열 형태로 출력하도록 만듬
public class Laptop implements Computer{    // implements 추가
    @Override
    public int getScreenWidth() {
        return 1280;
    }
}
