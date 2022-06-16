package com.example.ex02.controller;

import com.example.ex02.domain.vo.ExampleVO;
import com.example.ex02.domain.vo.Test2VO;
import com.example.ex02.domain.vo.TestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Time;
import java.util.Date;

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
    public String ex05(@ModelAttribute("vo") Test2VO studentVO/*, Model model*/){
//        Model
//        화면으로 데이터를 전달할 수 있는 객체
//        2개 이상의 데이터를 전달할 때 적합하고, 한 개의 데이터를 전달할 때에는
//        @ModelAttribute("KEY")를 사용하여 간단하게 데이터를 전달할 수 있다.
        log.info("--------------------------------------");
        log.info(studentVO.toString());
        log.info("--------------------------------------");

        int total = studentVO.getKor() + studentVO.getEng() + studentVO.getMath();
        double avg = total / 3.0;

        studentVO.setTotal(total);
        studentVO.setAvg(Double.parseDouble(String.format("%.2f", avg)));

//        model.addAttribute("vo", studentVO);

        return "ex05";
    }

    @GetMapping("ex06")
    public void ex06(ExampleVO exampleVO,@ModelAttribute("height") Double height){
        log.info("--------------------------------------");
        log.info(exampleVO.toString());
        log.info(String.valueOf(height));
        log.info("--------------------------------------");
    }

//    ExampleVO에 있는 이름과 나이를 전달받고, 키와 몸무게 전부 화면에 출력
    @GetMapping("ex07")
    public void ex07(ExampleVO exampleVO, Double height, @RequestParam("data") Double weight, Model model){
        log.info("--------------------------------------");
        log.info(exampleVO.toString());
        log.info(String.valueOf(height));
        log.info(String.valueOf(weight));
        log.info("--------------------------------------");

        model.addAttribute("height", height);
        model.addAttribute("weight", weight);
    }

// 실습1
    /*
     *  아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
     *  아이디가 user일 경우 user.html로 이동
     *
     *  - login.html : 아이디와 비밀번호 입력 페이지 출력
     *  - admin.html : 관리자 페이지 출력
     *  - user.html : 일반 회원 페이지 출력
     * */
    @GetMapping("login")
    public void login(){

    }

    @PostMapping("login")
    public String login(String id, Model model){
        model.addAttribute("id",id);
        log.info(id);
        if(id.equals("admin")){
            return "/ex/admin";
        }
        return "/ex/user";
    }

    // 실습2
    /*
     *   이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
     *   출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
     *   출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
     *   퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
     *
     *   - getToWork.html
     *   - leaveWork.html
     *   - late.html
     *   - work.html
     *
     * */
    @GetMapping("work")
    public void work(){

    }

    @PostMapping("work")
    public String work(String time, String getToWork, String leave , Model model){
        model.addAttribute("time",time);
        model.addAttribute("getToWork",getToWork);
        model.addAttribute("leave",leave);
        log.info(time);
        log.info(getToWork);
        log.info(leave);
//        Integer.parseInt(time);
//        Integer.parseInt(getToWork);
//        Integer.parseInt(leave);
        if(Integer.parseInt(time)<Integer.parseInt(getToWork)){
            return "/ex/getToWork";
        }else if(Integer.parseInt(time) > Integer.parseInt(getToWork) && Integer.parseInt(time) < Integer.parseInt(leave)){
            return "/ex/late";
        }
        return "/ex/leaveWork";
    }
}
