package test.step01.exam04.step01;

import java.util.Scanner;

public class StudentMgtSystem01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("명령>");
			
			// 명령> add 홍길동,10,20,30
			String input = scanner.nextLine();
			String[] values = input.split(" ");
			
			if ("add".equals(values[0])) {
				String[] data = values[1].split(",");
				System.out.println("이름:" + data[0]);
				System.out.println("국어:" + data[1]);
				System.out.println("영어:" + data[2]);
				System.out.println("수학:" + data[3]);

			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while (true);
		
		scanner.close();
	}	
}
