package basic.exam05.step03;

/* LayoutManager
 * 	-	컨테이너에 UI  컴포넌트를 위치시키는 역할을 담당
 * 	1) BorderLayout
 * 		- 동,서,남,북,가운데
 * 	2) FlowLayout
 * 		- 왼쪽에서 오른쪽으로 배치 => 끝을 만나면 다음 라인에 이어서 배치
 * 	3) GridLayout
 * 		- 바둑판 방식으로 배치 => 모든 셀의 너비와 높이가 같다.
 * 	4) CardLayout
 * 		- 중첩하여 배치 => 탭화면을 만들 때
 * 	5) GridBagLayout
 * 		- GridLayout + 셀 병합기능 추가 
 * 
 */
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class StudentMgtSystem03 {
	static Scanner scanner = new Scanner(System.in);
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}
	
	public static void main(String[] args) {
		// Java에서 제공하는 추상 클래스의 활용: WindowAdapter
		//	- 우리를 대신하여 WindowListener 인터페이스를 구현한 클래스이다.

		Frame f = new Frame("학생관리시스템");
		f.setSize(400, 300);
		
		// 추상클래스는 인스턴스를 생성할 수 없다.
		// MyWindowAdapter l = new MyWindowAdapter();
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		Button btnStudentMgt = new Button("학생관리");
		Button btnScoreMgt = new Button("점수관리");
		
		f.add(btnStudentMgt);
		f.add(btnScoreMgt);
		
		f.setVisible(true);
		
		
		/*
		do {
			String menu = promptMenu();
			
			if ("1".equals(menu)) {
				StudentControl.execute();
			} else if ("2".equals(menu)) {
				StudentScoreControl.execute();
			} else if ("list".equals(menu)) {
				System.out.println("1 학생관리");
				System.out.println("2 점수관리");
				System.out.println("q 종료");
			} else if ("q".equals(menu)) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
			
		} while(true);
		*/
		scanner.close();
	}
	
}













