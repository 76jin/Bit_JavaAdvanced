package basic.exam05.step02;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentScoreControl {
	static Scanner scanner;

	private static ArrayList<StudentScore> scoreList = new ArrayList<StudentScore>();

	static {
		scanner = StudentMgtSystem.scanner;
	}

	//실무에서는 좀더 코드의 잘못된 사용을 방지하기 위해 파라미터 변수에 대해 final로 선언한다.
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

	private static void executeList() {
		// ArrayList로부터 꺼낸다.
		// for (변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)
		int i = 0;
		for (StudentScore score : scoreList) {
			System.out.println(i++ + " " + score);
		}
	}

	private static void executeDelete(final int no) {
		if (no >= 0 && no < scoreList.size()) {
			scoreList.remove(no);
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
	}

	private static void executeUpdate(final int no) {
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

	private static void executeSave() {
		try {
			FileWriter out = new FileWriter("student.data");
			for (StudentScore score : scoreList) {
				out.write(score.toString() + "\n");
			}
			out.close();
			System.out.println("저장되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static void executeLoad() {
		try {
			// FileReader가 line 단위로 잘라 주지 못해서 Scanner class를 사용하여 구현함
			FileReader in = new FileReader("student.data");
			Scanner s = new Scanner(in);
			while (true) {
				try {
					scoreList.add(StudentScore.fromCSV(s.nextLine()));

				} catch(NoSuchElementException ex) {
					break;
				}
			}
			s.close();
			in.close();
			System.out.println("로딩되었습니다.");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void execute() {
		do {
			String[] values = promptCommand();

			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("list".equals(values[0])) {
				executeList();
			} else if ("delete".equals(values[0])) {
				executeDelete(Integer.parseInt(values[1]));
			} else if ("update".equals(values[0])) {
				executeUpdate(Integer.parseInt(values[1]));
			} else if ("save".equals(values[0])) {
				executeSave();
			} else if ("load".equals(values[0])) {
				executeLoad();
			} else if ("menu".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}

		} while (true);
	}

	private static String[] promptCommand() {
		System.out.print("점수관리>");
		String input = scanner.nextLine();

		return input.split(" ");
	}
}
