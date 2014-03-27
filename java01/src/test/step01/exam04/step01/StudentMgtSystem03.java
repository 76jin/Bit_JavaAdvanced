package test.step01.exam04.step01;

import java.util.Scanner;

public class StudentMgtSystem03 {

	static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		
		// 명령> add 홍길동,10,20,30
		String input = scanner.nextLine();
		return input.split(" ");
	}
	
	private static void executeAdd(String value) {
	  String input;
	  String[] data = value.split(",");
	  System.out.println("이름:" + data[0]);
	  System.out.println("국어:" + data[1]);
	  System.out.println("영어:" + data[2]);
	  System.out.println("수학:" + data[3]);
	  
	  System.out.print("등록하시겠습니까?(y/n).");
	  input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	System.out.println("등록되었습니다.");
	  } else {
	  	System.out.println("등록 취소하였스니다.");
	  }
  }
	
	public static void main(String[] args) {
		
		do {
			String[] values = promptCommand();
			
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while (true);
		
		scanner.close();
	}

}
