package basic.exam04.step01;

import java.util.Scanner;

/* 메서드로 분리2
 * 	- add(, view, update, delete)을 처리하는 명령어들을 분리하여 메서드로 정의.
 */
public class StudentMgtSystem {

	static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand() {
		System.out.print("명령>");
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
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			System.out.println("등록되었습니다.");
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}

	public static void main(String[] args) {
		
		do {
			String[] values = promptCommand();

			// "add"는 Constant pool에 인스턴스로 저장되어 주소가 리턴되서 주소값이 오며, 이 주소에 대한 메서드를 호출한다는 의미. 
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
