package com.example.ex02.controller;

import com.example.ex02.domain.vo.ExampleVO;
import com.example.ex02.domain.vo.Test2VO;
import com.example.ex02.domain.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "example", method = {RequestMethod.POST, RequestMethod.GET})
    public void ex01(){
        log.info("ex01...................");
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02.................");
    }

    @GetMapping("ex03")
    public void ex03(ExampleVO exampleVO){
        log.info("---------------------------------");
        log.info(exampleVO.toString());
        log.info("---------------------------------");
    }

//    이름, 국어, 영어, 수학 점수를 전달받은 뒤 각 요소를 화면에 출력한다.
    @GetMapping("ex04")
    public void ex04(TestVO testVO){
        log.info("--------------------------------------");
        log.info(testVO.toString());
        log.info("--------------------------------------");
    }

//    숙제
//    화면에서 총점과 평균을 구하지 않고 컨트롤러에서 구한 뒤 화면에 결과를 전달한다.
    @GetMapping("ex05")
    public void ex05(Test2VO test2VO){
        test2VO.setSum(test2VO.getKor() + test2VO.getEng() + test2VO.getMath());
//        test2VO.setAvg(Float.intBitsToFloat(test2VO.getSum()/3)); // Float타입으로 바꾸고 bit까지 나타냄
        test2VO.setAvg((test2VO.getSum().floatValue())/3);
        log.info("--------------------------------------");
        log.info(test2VO.toString());
        log.info("--------------------------------------");
    }
}
