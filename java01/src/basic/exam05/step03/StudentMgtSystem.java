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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

import javax.swing.JOptionPane;

/* 
 * Frame에 들어갈 화면
 * 	1) MenuPanel: 메뉴 출력 화면
 * 	2) StudentPanel: 학생 관리 화면
 * 	3) ScorePanel: 점수 관리 화면
 * 
 */
public class StudentMgtSystem extends Frame implements ActionListener {
	static Scanner scanner = new Scanner(System.in);
	Panel menuPanel = new Panel();
	Button btnStudentMgt = new Button("학생관리");
	Button btnScoreMgt = new Button("점수관리");
	
	private static String promptMenu() {
		System.out.print("메뉴>");
		return scanner.nextLine().toLowerCase(); 
	}
	
	public StudentMgtSystem() {
		super("학생관리시스템");	// 호출할 수퍼 클래스 생성자를 지정할 수 있음.
		//super();	// 호출할 수퍼 클래스 생성자를 지정하지 않으면 기본 생성자 호출.
		//setTitle("학생관리시스템");	// 기본 생성자 호출 후 setTitle()을 호출해도 됨.
		setSize(400, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		menuPanel.setPreferredSize(new Dimension(70, 70));	// 이랬으면 하는 크기
		
		btnStudentMgt.addActionListener(this);
		btnScoreMgt.addActionListener(this);
		
		menuPanel.add(btnStudentMgt);
		menuPanel.add(btnScoreMgt);
		
		setLayout(new FlowLayout());
		add(menuPanel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(btnStudentMgt)) {
			JOptionPane.showMessageDialog(null, "학생관리");
		} else if (e.getSource().equals(btnScoreMgt)) {
			JOptionPane.showMessageDialog(null, "점수관리");
		} else {
			JOptionPane.showMessageDialog(null, "여긴 어디?");
		}
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);
	}
	
}













