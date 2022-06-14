package com.example.ex00.dependency;

import lombok.*;
import org.springframework.stereotype.Component;

@Component  // ⭐해당 객체를 Spring에서 관리하도록 설정
@Data   // getter setter를 설정해줌 대신 plugin에서 lombok이 설치되어 있어야 함
@ToString
@RequiredArgsConstructor    // final 또는 @NonNull이 사용된 필드만 초기화 할 수 있는 생성자 선언
public class Chef {
}
