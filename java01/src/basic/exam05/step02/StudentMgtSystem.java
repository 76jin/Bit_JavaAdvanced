package basic.exam05.step02;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/* 각 기능 별로 Control 클래스 분리
 * 	- Control 클래스 역할: 사용자가 입력한 데이터를 가공하여 Dao에게 전달.
 * 		- Dao가 리턴한 데이터를 가공하여 Boundary에게 전달.
 * 	- 일단, 현재는 Control이 Dao와 Boundary 역할을 겸한다.
 * 		- Dao : 데이터의 지속성을 다루는 객체 - Data Access Object
 */
public class StudentMgtSystem {

	static Scanner scanner = new Scanner(System.in);
	
	private static String promptManu() {
		System.out.print("명령>");
		return scanner.nextLine().toLowerCase();
	}
	
	public static void main(String[] args) {
		
		do {
			String menu = promptManu();

			if ("1".equals(menu)) {
				//StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 명령어입니다.");
			}

		} while (true);
		
		scanner.close();
	}

}
