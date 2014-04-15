package basic.exam06.jdbc.up3;

import java.util.List;
import java.util.Scanner;

// insert, list, update, delete 기능을 하나로 합친다.
public class SubjectMgt {
	
	static Scanner sc = new Scanner(System.in);

	public static void testInsert() throws Throwable {
		SubjectVo subject = new SubjectVo();
		subject.title = "Java의 신";
		subject.description = "자바의 신을 존경할 수 있을 정도의 실력으로 향상 시킴.";

		SubjectDao dao = new SubjectDao();
		dao.insert(subject);

		System.out.println("등록 성공!!!");
	}

	public static void testList() throws Throwable {

		SubjectDao dao = new SubjectDao();
		int pageNo = 1, pageSize = 10;

		do {

			List<SubjectVo> list = dao.list(pageNo, pageSize);

			System.out.println("[" + pageNo + "]-----------------------------");

			for (SubjectVo subject : list) {	// list 자리에 Collection이나 List 구현체 올 수 있음.
				System.out.print(subject.no + ",");
				System.out.println(subject.title);
			}

			pageNo = Integer.parseInt(sc.nextLine());

		} while(pageNo > 0);

	}

	public static void testUpdate() throws Throwable {

		SubjectDao dao = new SubjectDao();

		SubjectVo subject = new SubjectVo();
		subject.no = 105;
		subject.title = "오하라..변경";
		subject.description = "이제 내용도 변경하자!";

		dao.update(subject);

		System.out.println("변경확인!");

	}

	public static void testDelete() throws Throwable {

		SubjectDao dao = new SubjectDao();

		dao.delete( Integer.parseInt(sc.nextLine()) );

		System.out.println("삭제 성공!");

	}

	public static void testDetail() throws Throwable {
		
		SubjectDao dao = new SubjectDao();
		
		SubjectVo subject = dao.detail( Integer.parseInt(sc.nextLine()) );
		
		System.out.println(subject.no);
		System.out.println(subject.title);
		System.out.println(subject.description);
		
	}

	public static void main(String[] args) {
		
		String command = null;

		do {
			try {		// 블록 안에서 예외가 발생하더라도 시스템을 멈추지 않는다.
				System.out.print("명령>");
				command = sc.nextLine();

				switch (command) {
				case "insert":
					testInsert(); break;
				case "list":
					testList();		break;
				case "update":
					testUpdate();	break;
				case "delete":
					testDelete();	break;
				case "detail":
					testDetail();	break;
				}
			} catch (Throwable e) {
				// 예외 무시하도록 함.
			}
		} while (!"q".equals(command));

		sc.close();
	}

}
