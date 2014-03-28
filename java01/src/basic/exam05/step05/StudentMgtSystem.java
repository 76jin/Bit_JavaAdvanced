package basic.exam05.step05;

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
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/* 
 * Frame에 들어갈 화면
 * 	1) MenuPanel: 메뉴 출력 화면
 * 	2) StudentPanel: 학생 관리 화면
 * 	3) ScorePanel: 점수 관리 화면
 */

/* 상속
 * 	1) specialization
 * 		- 수퍼클래스로부터 상속 받아서 기능을 덧붙임 => 특화시킴.
 * 	2) Generalization
 * 		- 서브클래스들의 공통점을 찾아 수퍼클래스로 정의한다.
 * 		- 그리고 수퍼클래스를 상속받는다.
 * 
 * 목표: ScorePanel, StudentPanel의 공통점을 찾아 ContentPanel로 정의
 */
@SuppressWarnings("serial")
public class StudentMgtSystem extends Frame {
	public static final String MENU_PANEL = "MenuPanel";
	public static final String STUDENT_PANEL = "StudentPanel";
	public static final String SCORE_PANEL = "ScorePanel";
	
	MenuPanel menuPanel;
	StudentPanel studentPanel;
	ScorePanel scorePanel;

	public StudentMgtSystem() {
		super("학생관리시스템");
		setSize(400, 300);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		setLayout(new CardLayout());	// 메뉴화면,학생관리화면,점수화면 겹치게 함.
		
		menuPanel = new MenuPanel(this);
		studentPanel = new StudentPanel(this);
		scorePanel = new ScorePanel(this);
		
		// CardLayout인 경우 자식 컴포넌트를 붙일 때, 이름을 함께 주어야 한다.
		add(menuPanel, MENU_PANEL);
		add(studentPanel, STUDENT_PANEL);
		add(scorePanel, SCORE_PANEL);
	}
	
	// 자식 패널들이 호출한다.
	public void changePanel(String panelName) {
		CardLayout cardLayout = (CardLayout)this.getLayout();

		cardLayout.show(this, panelName);
	}
	
	public static void main(String[] args) {
		StudentMgtSystem f = new StudentMgtSystem();
		f.setVisible(true);
	}
	
}













