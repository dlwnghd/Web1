package com.example.ex00.dependency.qualifier;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@Qualifier("outback")
@ToString
public class Outback implements Restaurant{
    @Override
    public boolean sidebar() {
        return false;
    }
}
