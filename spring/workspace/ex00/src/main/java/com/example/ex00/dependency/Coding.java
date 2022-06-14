package com.example.ex00.dependency;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 코딩이 컴퓨터한테 의존

@Component  // ⭐해당 객체를 Spring에서 관리하도록 설정
@Data   // getter setter를 설정해줌 대신 plugin에서 lombok이 설치되어 있어야 함
//@NoArgsConstructor  // 기본생성자를 만들어 줌
//@AllArgsConstructor   // 모든 필드를 초기화할 수 있는 생성자 선언
//@RequiredArgsConstructor    // final 또는 @NonNull이 사용된 필드만 초기화 할 수 있는 생성자 선언
public class Coding {
//    -----------기존 요청방법----------
//    Computer computer = new Computer();  // Computer타입의 computer 결합이 단단함 => 유연한 개발 X => @Component로 유연하게 설정

//    -----------3가지 요청방법----------
//    1. 필드 주입
//    - 굉장히 편하게 주입할 수 있다.
//    - 다른 곳에서 바로 변형이 가능하기 때문에 값이 변할 수 있는 심각한 문제가 생길 수 있다.
//    @Autowired
//    private Computer computer;    // 필드를 메소드로 접근해야하기 때문에 접근자를 private로 줌, 메소드로 접근하도록 getter setter를 @Data로 설정
//    @Autowired
    private final Computer computer;  // 기본 생성자가 아닌 매개변수를 받는 생성자라 final이 오류가 생기지 않음

//    2. Setter 주입
//    실무에서 거의 사용하지 않아서 생략함
//    @Data로 이미 가능하기 때문에 불편하기도 함

//    3. 생성자 주입
//    Alt + Instert키 > Enter > Enter
//    - 메모리에 필드를 할당하면서 초기값이 주입되므로 final키워드를 사용할 수 있다.
//    - 주입이 되지 않으면 객체 자체가 생성이 안되므로, NPE(널 포인터)를 방지할 수 있다.
//    @Autowired  // 생성자를 통해서 주입됨
//    public Coding(Computer computer) {
//        this.computer = computer;
//    }
}