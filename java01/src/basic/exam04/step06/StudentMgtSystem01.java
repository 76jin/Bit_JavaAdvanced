package basic.exam04.step06;

import java.util.ArrayList;
import java.util.Scanner;

/* 클래스 변수 초기화 : static {} 블록
 * 	- 인스턴스 변수는 생성자를 통해 초기화할 수 있다.
 * 	- 클래스 변수는? static {} 을 통해 초기화 할 수 있다.
 * 
 * 상수 변수의 사용
 * 	- 상수 값이 소스 코드의 여러 곳에서 사용된다면 유지보수를 좋게 하기 위해 클래스 변수로 정의해 두는 것이 좋다.
 * 		=> 변경이 쉬워진다.
 */
public class StudentMgtSystem01 {

	private static Scanner scanner = new Scanner(System.in);
	
	// 메모리가 되는한 무한대로 관리 가능
	// 어떤 객체라도 저장할 수 있음 => 잘못된 값이 들어갈 수 있으므로 제한 필요.
	private static ArrayList scoreList = new ArrayList();
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		String input = scanner.nextLine();

		return input.split(" ");
	}
	
	// 실무에서는 좀더 코드의 잘못된 사용을 방지하기 위해 파라미터 변수에 대해 final로 선언한다.
	private static void executeAdd(final String value) {
		String input;
		
		StudentScore score = StudentScore.fromCSV(value);
		
		System.out.println("이름:" + score.name);
		System.out.println("국어:" + score.kor);
		System.out.println("영어:" + score.eng);
		System.out.println("수학:" + score.math);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			System.out.println("등록되었습니다.");
			scoreList.add(score);
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void executeList() {
		// ArrayList로부터 꺼낸다.
		for (int i = 0; i < scoreList.size(); i++) {
			System.out.println(scoreList.get(i));
		}
	}

	public static void main(String[] args) {
		
		do {
			String[] values = promptCommand();

			// "add"는 Constant pool에 인스턴스로 저장되어 주소가 리턴되서 주소값이 오며, 이 주소에 대한 메서드를 호출한다는 의미. 
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".equals(values[0])) {
				executeList();
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}

		} while (true);
		
		scanner.close();
	}

}
