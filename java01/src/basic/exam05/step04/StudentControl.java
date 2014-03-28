package basic.exam05.step04;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentControl {
	static Scanner scanner;
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();
	
	static {
//		scanner = StudentMgtSystem.scanner;
	}
	
	private static void executeAdd(final String value) {
		String input;
		
		Student student = Student.fromCSV(value);
		
		System.out.println("이름:" + student.name);
		System.out.println("나이:" + student.age);
		System.out.println("전화번호:" + student.tel);
		System.out.println("이메일:" + student.email);
		System.out.println("주소:" + student.address);
		
		System.out.print("등록하시겠습니까?(y/n)");
		input = scanner.nextLine();
		if ("y".equals(input.toLowerCase())) {
			System.out.println("등록되었습니다.");
			studentList.add(student);
		} else {
			System.out.println("등록 취소하였습니다.");
		}
	}
	
	public static void executeList() {
		// ArrayList로부터 꺼낸다.
		// for (변수 : 배열 또는 항목의 타입이 지정된 Collection 구현체)
		int i = 0;
		for (Student student : studentList) {
			System.out.println(i++ + " " + student);
		}
	}

	private static void executeDelete(final int no) {
		if (no >= 0 && no < studentList.size()) {
			studentList.remove(no);
			System.out.println("삭제했습니다.");
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
 }
	
	private static void executeUpdate(final int no) {
		if (no >= 0 && no < studentList.size()) {
			Student student = studentList.get(no);
			
			System.out.print("이름(" + student.name + "):");
			String input = scanner.nextLine();
			Student temp = new Student(input);
			
			System.out.print("나이(" + student.age + "):");
			input = scanner.nextLine();
			temp.age = Integer.parseInt(input);
			
			System.out.print("전화번호(" + student.tel + "):");
			input = scanner.nextLine();
			temp.tel = input;
			
			System.out.print("이메일(" + student.email + "):");
			input = scanner.nextLine();
			temp.email = input;
			
			System.out.print("주소(" + student.address + "):");
			input = scanner.nextLine();
			temp.address = input;
			
			System.out.print("변경하시겠습니까?(y/n)");
			input = scanner.nextLine();
			if ("y".equals(input.toLowerCase())) {
				System.out.println("변경되었습니다.");
				studentList.set(no, temp);
			} else {
				System.out.println("변경 취소하였습니다.");
			}
			
		} else {
			System.out.println("유효하지 않은 번호입니다.");
		}
 }
	
	private static void executeSave() {
		try {
	    FileWriter out = new FileWriter("studentEx.data");
			for (Student student : studentList) {
				out.write(student.toString() + "\n");
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
	    FileReader in = new FileReader("studentEx.data");
	    Scanner s = new Scanner(in);
	    while (true) {
	    	try {
	    		studentList.add(Student.fromCSV(s.nextLine()));
	    		
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
	
	private static void executeCmdList() {
		System.out.println("list 학생 출력");
		System.out.println("add 학생 추가");
		System.out.println("delete 학생 삭제");
		System.out.println("update 학생 갱신");
		System.out.println("save 파일로 저장");
		System.out.println("load 파일로부터 불러오기");
		System.out.println("menu 돌아가기");
		System.out.println("=========");
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
			} else if ("cmdlist".equals(values[0])) {
				executeCmdList();
			} else if ("menu".equals(values[0])) {
				break;
			} else {
				System.out.println("사용할 수 없는 명령어입니다.");
				System.out.println("== 사용 가능 명령어 ==");
				executeCmdList();
			}

		} while (true);
	}
	
	private static String[] promptCommand() {
		System.out.print("학생관리>");
		String input = scanner.nextLine();

		return input.split(" ");
	}
	
}
