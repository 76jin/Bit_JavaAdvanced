package basic.exam04.step06;

import java.util.ArrayList;
import java.util.Scanner;

/* ArrayList의 Generic 기능 이용하기
 * 	- ArrayList에는 어떠한 타입(클래스)의 인스턴스(의 주소)라도 저장할 수 있다.
 * 		=> 장점인 동시에 단점이 될 수 있다.
 * 		==> 원하지 않는 인스턴스가 들어가는 것을 막을 수 없다.
 * 		===> Generic 문법이 등장함. 
 * 	- ArrayList에 넣을 인스턴스의 타입을 지정할 수 있다.
 * 		지정된 타입이 아닌 인스턴스를 넣으면 컴파일 오류가 발생한다.
 * 	- 문법: ArrayList<저장할 인스턴스 타입을 선언> 변수명;
 */
public class StudentMgtSystem {

	private static Scanner scanner = new Scanner(System.in);
	
	// 메모리가 되는한 무한대로 관리 가능
	// 어떤 객체라도 저장할 수 있음 => 잘못된 값이 들어갈 수 있으므로 제한 필요.
	// ArrayList에 저장할 인스턴스의 타입을 지정.
	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();
	
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
			// scoreList.add("okok");	// StudentScore 아니면 넣을 수 없다.
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void executeList() {
		// ArrayList로부터 꺼낸다.
		// for (변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)
		int i = 0;
		for (StudentScore score : scoreList) {
			System.out.println(i++ + " " + score);
		}
	}

	private static void executeDelete(int no) {
		if (no >= 0 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
  }
	
	private static void executeUpdate(int no) {
		if (no >= 0 && no < scoreList.size()) {
			StudentScore score = scoreList.get(no);
			
			System.out.print("이름(" + score.name + "):");
			String input = scanner.nextLine();
			StudentScore temp = new StudentScore(input);
			
			System.out.print("국어(" + score.kor + "):");
			input = scanner.nextLine();
			temp.kor = Integer.parseInt(input);
			
			System.out.print("영어(" + score.eng + "):");
			input = scanner.nextLine();
			temp.eng = Integer.parseInt(input);
			
			System.out.print("수학(" + score.math + "):");
			input = scanner.nextLine();
			temp.math = Integer.parseInt(input);
			
			System.out.print("변경하시겠습니까?(y/n)");
			input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				System.out.println("변경되었습니다.");
				scoreList.set(no, temp);
			} else {
				System.out.println("변경 취소하였습니다.");
			}
			
		} else {
			System.out.println("유효하지 않은 번호입니다.");
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
			} else if ("delete".equals(values[0])) {
				executeDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0])) {
				executeUpdate(Integer.parseInt(values[1]));
			} else if ("quit".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}

		} while (true);
		
		scanner.close();
	}

}