package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.calc.Calc;

/*
 * Servlet implementation class Oper
 */
@WebServlet("/Oper")
public class Oper extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     * @see HttpServlet#HttpServlet()
     */
    public Oper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=UTF-8");
		
		// 사용자가 입력한 값을 받음
		String input = request.getParameter("input");
		String opers ="+-*/";
		char oper = ' ';
		int result = 0;
		int[] nums = new int[2];
		String[] temp = null;
		Calc c = null;
		String resultMsg = null;
		boolean check = false;
		int count = 0;
		
		for (int i = 0; i < opers.length(); i++) {
			// 연산자를 찾는데 없다면
			if(input.indexOf(opers.charAt(i)) == -1) {
				continue;
			}
			// 연산자를 찾았다면
			check = true;
			oper = opers.charAt(i);
			++count;
		}
		
		if(count > 1) {
			resultMsg = "두 정수의 연산만 가능합니다.";
		}
		
		if(!check) {
			resultMsg = "잘못된 수식입니다.";
		}
		
		temp = input.split("||" + oper);
		
		
		for (int i = 0; i < temp.length; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}
		
		c = new Calc(nums[0], nums[1]);
		
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
		
		if(resultMsg == null) {
			resultMsg = "결과: " + result;
		}
		out.print("<p>");
		out.print(resultMsg);
		out.print("</p>");
		out.print("a href='calc'>");
		out.close();
	}
}
