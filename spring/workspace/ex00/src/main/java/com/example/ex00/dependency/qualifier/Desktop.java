package com.example.ex00.dependency.qualifier;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component  //⭐⭐⭐⭐⭐
@Qualifier("desktop") /*@Primary*/ // desktop으로 명시, 식별자 부여
@ToString   // 주소형태가 아닌 문자열 형태로 출력하도록 만듬
public @Primary /*⬅default로 설정*/ class Desktop implements Computer{ // implements 추가
    @Override
    public int getScreenWidth() {
        return 1920;
    }
}
