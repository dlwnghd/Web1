package com.example.ex02.controller;

import com.example.ex02.domain.vo.ExampleVO;
import com.example.ex02.domain.vo.StudentVO;
import com.example.ex02.domain.vo.TestVO;
import com.example.ex02.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

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
    public String ex05(@ModelAttribute("vo") StudentVO studentVO/*, Model model*/){
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
    public void ex06(ExampleVO exampleVO, @ModelAttribute("height") Double height){
        log.info("--------------------------------------");
        log.info(exampleVO.toString());
        log.info(String.valueOf(height));
        log.info("--------------------------------------");
    }

    //    ExampleVO에 있는 이름과 나이를 전달받고, 키와 몸무게 전부 화면에 출력
    @GetMapping("ex07")
//    @RequestParam : 전달받는 파라미터의 이름이 매개변수의 이름과 다를 때 직접 설정하는 방법
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
     *  - goLogin.html : 아이디와 비밀번호 입력 페이지 출력
     *  - admin.html : 관리자 페이지 출력
     *  - user.html : 일반 회원 페이지 출력
     * */

    @GetMapping("goLogin")
    public void goLogin(){}

    @PostMapping("goLogin")
    public String goLogin(UserVO userVO){
        if(userVO.getId().equals("admin")){
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
    @GetMapping("checkIn")
    public String checkIn(){
        return "/work/checkIn";
    }

    @GetMapping("/getToWork")
    public String getToWork(@ModelAttribute("name") String name){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        boolean lateCondition = hour >= 9 && minute > 0;

        return lateCondition ? "/work/late" : "/work/getToWork";
    }

    @GetMapping("/leaveWork")
    public String leaveWork(@ModelAttribute("name") String name){
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);

        boolean leaveWorkCondition = hour >= 17 && minute >= 0;

        return leaveWorkCondition ? "/work/leaveWork" : "/work/work";
    }


    @GetMapping("test")
    public void test(){

    }

    @PostMapping("test")
    public String test(String name, Model model){
        model.addAttribute("name", name);
        return "result";
    }

//    실습

    //    아이디 : apple
//    비밀번호 : banana
//    로그인 성공 시 apple님 환영합니다.
//    로그인 실패 시 로그인 실패
    @GetMapping("login")
    public String login(){
        return "/login/login";
    }

    @PostMapping("login")
    public String login(UserVO userVO, Model model){
        if(userVO.getId().equals("apple")){
            if(userVO.getPw().equals("banana")){
                model.addAttribute("id", userVO.getId());
                return "/login/success";
            }
        }
        return "/login/fail";
    }


    //    노래방 기계 제작
//    사용자의 점수에 따른 알맞는 메세지 출력
    @GetMapping("/songbox")
    public String songbox(){
        return "/songbox/songbox";
    }

    @PostMapping("/songbox")
    public String checkScore(Integer score, Model model){
        if(score < 50){
            model.addAttribute("result", "연습이 부족해요!");
            return "/songbox/result";
        }

        model.addAttribute("result", "훌륭해요!");
        return "/songbox/result";
    }


}



















