package basic.exam04.step02;

import java.util.Scanner;

/* Entity 클래스 분리
 * 	- 데이터의 정보를 다루는 명령어를 분리
 * 	- 데이터를 표현하는 객체: Value Object = Data Transfer Object
 * 	- 데이터의 지속성을 다루는 객체: Data Access Object
 * 	- 데이터 지속성(Data Persistence) ?
 * 		=> 애플리케이션을 종료했다 다시 시작해도 기존에 작업한 데이터를 그대로 유지.
 * 		=> 외부 저장장치에 보관해야 한다. => File
 * 	- 목표: 입력받은 값을 VO 객체에 보관
 */
public class StudentMgtSystem {

	static Scanner scanner = new Scanner(System.in);
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine(); // 키보드로부터 들어 온 값을 읽는다. 엔터를 만날 떄까지.

		return input.split(" ");
	}
	
	private static void executeAdd(String value) {
		String input;
		String[] data = value.split(",");
		
		StudentScore score = new StudentScore(data[0]);
		score.kor  = Integer.parseInt(data[1]);
		score.eng  = Integer.parseInt(data[2]);
		score.math = Integer.parseInt(data[3]);
		
		System.out.println("이름:" + score.name);
		System.out.println("국어:" + score.kor);
		System.out.println("영어:" + score.eng);
		System.out.println("수학:" + score.math);
		
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
