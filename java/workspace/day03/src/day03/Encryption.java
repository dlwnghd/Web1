package day03;

public class Encryption {
	public static void main(String[] args) {
		String pw = "ehdtjrdl";
		String en_pw = "";
		String de_pw = "";
		final int KEY = 3;
		
		for (int i = 0; i < pw.length(); i++) {
			en_pw += (char)(pw.charAt(i) * KEY);
		}
		
		for (int i = 0; i < en_pw.length(); i++) {
			de_pw += (char)(en_pw.charAt(i) / KEY);
		}
		
		System.out.println(en_pw);
		System.out.println(de_pw);
		
	}
}
