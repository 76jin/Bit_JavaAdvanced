package test.step01.exam04.step05;

import java.util.Scanner;

public class StudentMgtSystem03 {

	static Scanner scanner = new Scanner(System.in);
	
	private static StudentScore[] scoreList;
	private static int scoreSize;
	private static final int SCORE_MAX_SIZE = 3;
	
	static {
		scoreList = new StudentScore[SCORE_MAX_SIZE];
	}
	
	private static String[] promptCommand() {
		System.out.print("명령>");
		
		// 명령> add 홍길동,10,20,30
		String input = scanner.nextLine();
		return input.split(" ");
	}
	
	private static void executeAdd(String value) {
	  String input;
	  
	  if (scoreSize < SCORE_MAX_SIZE ) {
	  	scoreList[scoreSize++] = StudentScore.fromCSV(value);
	  } else {
	  	System.out.println("저장소가 꽉 찼습니다.");
	  	return;	// 함수 즉시 탈출
	  }
	  
	  System.out.println("이름:" + scoreList[scoreSize - 1].name);
	  System.out.println("국어:" + scoreList[scoreSize - 1].kor);
	  System.out.println("영어:" + scoreList[scoreSize - 1].eng);
	  System.out.println("수학:" + scoreList[scoreSize - 1].math);
	  
	  System.out.print("등록하시겠습니까?(y/n)");
	  input = scanner.nextLine();
	  if ("y".equals(input.toLowerCase())) {
	  	System.out.println("등록되었습니다.");
	  	
	  } else {
	  	System.out.println("등록 취소하였스니다.");
	  }
  }
	
	public static void executeList() {
		for (StudentScore score : scoreList) {
			System.out.println(score);
		}
	}
	
	public static void main(String[] args) {
		
		do {
			String[] values = promptCommand();
			
			if ("add".equals(values[0])) {
				executeAdd(values[1]);
			} else if ("quit".equals(values[0])) {
				break;
			} else if ("list".equals(values[0])) {
				executeList();
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
			}
			
		} while (true);
		
		scanner.close();
	}

}
