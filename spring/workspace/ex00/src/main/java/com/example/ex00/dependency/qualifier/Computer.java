package com.example.ex00.dependency.qualifier;

/*
* @Qualifier
*
*   @Autowired를 통해 객체를 주입할 때 같은 타입의 객체가 여러 개 있다면, 구분할 수 없다.
*   이 때, @Qualifier를 통해 식별자를 부여하면 원하는 객체를 주입 받을 수 있다.
*
* */

public interface Computer {
    public int getScreenWidth();
}
