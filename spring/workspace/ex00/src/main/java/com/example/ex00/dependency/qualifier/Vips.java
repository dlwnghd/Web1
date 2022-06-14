package com.example.ex00.dependency.qualifier;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("vips") @Primary
@ToString
public class Vips implements Restaurant{    // implements 추가
    @Override
    public boolean sidebar() {
        return true;
    }
}
