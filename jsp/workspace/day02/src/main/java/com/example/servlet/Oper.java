package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.calc.Calc;

/**
 * Servlet implementation class Oper
 */
@WebServlet("/Oper")
public class Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		//사용자가 화면에서 입력한 수식
		String input = request.getParameter("input");
		//연산자의 종류를 담고 있는 문자열(문자배열)
		String opers = "-+*/";
		//수식 중 연산자를 담아줄 변수
		char oper = ' ';
		//계산 결과를 담아줄 변수
		int result = 0;
		//각 정수를 담아줄 자료구조
		ArrayList<Integer> nums = new ArrayList<>();
		//연산자를 기준으로 첫번째 정수, 두번째 정수를 담아줄 배열
		String[] temp = null;
		//사칙연산 메소드를 사용할 수 있는 객체
		Calc c = null;
		//오류 발생 시 오류 메세지를 담아줄 변수
		String resultMsg = null;
		//수식에서의 연산자 유무를 판단해줄 FLAG
		boolean check = false;
		//입력한 수식에서 연산자를 기준으로 나눠진 배열의 인덱스 번호로 활용할 변수
		int index = 0;
		
		//연산자 종류 개수 만큼 반복
		for (int i = 0; i < opers.length(); i++) {
			//사용자가 입력한 수식에서 각 연산자를 찾고, 만약 못찾았다면
			if(input.indexOf(opers.charAt(i)) == -1) {
				//다음 반복
				continue;
			}
			//만약 연산자를 찾았다면 oper에 해당 연산자 저장
			oper = opers.charAt(i);
			//연산자를 찾았다는 표시
			check = true;
		}
		
		//위 반복문에서 연산자를 찾지 못했다면 check는 false
		if(!check) {
			resultMsg = "잘못된 수식입니다.";
		}
		
		try {
			//찾은 연산자를 기준으로 정수들을 분리
			temp = input.split("\\" + oper);
			
			//만약 연산자로 분리했더니 3개의 정수를 찾았다면,
			//0번째 방에 정수가 아닌 빈 문자열이 있다면,
			//이는 음수로 시작하는 수식이다.
			if(temp.length == 3 && temp[0].equals("")) {
				//음수로 시작하는 수식이라면
				//두번째 방에 있는 정수가 첫번째 정수이고, 앞에 -를 붙여줘야 한다.
				temp[1] = "-" + temp[1];
				//첫번째 방에 접근하지 못하도록 index를 1 증가시켜준다.
				index++;
				
			}else if(temp.length > 2 && !temp[0].equals("")) { //세 개 이상의 정수이면서 첫번째 방에 있는 값이 정수일 경우
				resultMsg = "두 정수의 연산만 가능합니다.";
			}
			
			//음수로 시작하는 수식이라면 index는 1부터 시작된다.
			//양수로 시작하는 수식이라면 index는 0부터 시작된다.
			for (int i = index; i < temp.length; i++) {
				nums.add(Integer.parseInt(temp[i]));
			}
			
			//첫번째 정수와 두번째 정수를 Calc 생성자에 전달한다.
			c = new Calc(nums.get(0), nums.get(1));
			
			//위에서 알아낸 연산자 종류에 따라 알맞는 메소드를 호출하여 연산한다.
			switch(oper) {
			case '+':
				result = c.add();
				break;
			case '-':
				result = c.sub();
				break;
			case '*':
				result = c.mul();
				break;
			case '/':
				try {
					result = c.div();
				} catch (Exception e) {
					resultMsg = "0으로 나눌 수 없습니다.";
				}
				break;
			}
		} catch (Exception e) {
			//두 개 이상의 연산자, 세 개 이상의 정수가 수식에 있다면 들어오는 영역
			resultMsg = "두 정수의 연산만 가능합니다.";
		}
		
		// 오류 메세지가 없다는 것은
		if(resultMsg == null) {
			//정상적인 수식을 입력받아 계산했다는 뜻.
			resultMsg = "결과 : " + result;
		}
		out.print("<p>");
		out.print(resultMsg);
		out.print("</p>");
		out.print("<a href='calc'>다시 계산하기</a>");
		out.close();
	}
}

















