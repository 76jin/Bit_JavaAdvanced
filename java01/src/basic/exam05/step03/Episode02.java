package basic.exam05.step03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

/* 상속
 * 
 */

public class Episode02 {
	
	public static void main(String[] args) {
		// BorderLayout
		//	- Frame 컨테이너의 기본 UI 배치 관리자다.
		// 	- 컨테이너.add(컴포넌트, 위치지정(동,서,남,북,가운데));
		//	- 컨테이너.add(컴포넌트); => 기본적으로 가운데에 배치시킨다.

		Frame f = new Frame("학생관리 시스템");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		Panel p = new Panel();	// 기본 FlowLayout
		// FlowLayout은 자식 컴포넌트를 배치할 때
		//	자식 컴포넌트가 원하느 크기를 먼저 알아낸 다음에
		//	부모 컨테이너의 크기를 결정한다	=> 자식 컴포넌트를 배치한다.
		//p.setSize(30, 70);			// 기본 크기
		//p.setMaximumSize(new Dimension(30,70));	// 최대 크기
		p.setPreferredSize(new Dimension(70, 70));	// 이랬으면 하는 크기
		
		Button btnStudentMgt = new Button("학생관리");
		
		// 버튼 및 메뉴인 경우, MouseClick 또는 KeyPress 이벤트가 발생했을 때
		//	Action 이벤트를 추가로 발생시킨다.
		btnStudentMgt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "오호라 이거야..");
			}
		});
		
		/*
		// xxxListener class를 지원하기 위해 xxxAdaptor class가 있다.
		btnStudentMgt.addMouseListener(new MouseAdapter() {

			@Override
      public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "눌렀음");
      }
			
		});
		
		btnStudentMgt.addKeyListener(new KeyAdapter() {

			@Override
      public void keyTyped(KeyEvent e) {
				JOptionPane.showMessageDialog(null, "키 눌렀음");
      }
			
		});
		*/
		
		Button btnScoreMgt = new Button("점수관리");
		
		p.add(btnStudentMgt);
		p.add(btnScoreMgt);
		
		f.setLayout(new FlowLayout());
		f.add(p);
		
		f.setVisible(true);
	}
	
	public static void main03(String[] args) {
		// GridLayout
		//	- 바둑판식 배치 => 모든 칸의 너비와 높이가 같다.
		//	- 컨테이너.add(컴포넌트); => 물 흐르듯이 왼쪽->오른쪽, 위->아래

		Frame f = new Frame("FlowLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		// 기본 레이아웃 관리자를 FlowLayout으로 교체
		// row 개수를 기준으로 배치
		// => row 개수로 컬럼의 개수가 결정
		//f.setLayout( new GridLayout(3,4) );
		
		// row가 0이면 column 개수에 따라 row 개수가 계산된다.
		f.setLayout( new GridLayout(0,2) );		// row = 4
		//f.setLayout( new GridLayout(0,3) );		// row = 3
		//f.setLayout( new GridLayout(0,4) );		// row = 2
		
		f.add(new Button("버튼1"));
		f.add(new Button("버튼2"));
		f.add(new Button("버튼3"));
		f.add(new Button("버튼4"));
		f.add(new Button("버튼5"));
		f.add(new Button("버튼6"));
		f.add(new Button("버튼7"));
		f.add(new Button("버튼8"));
		
		f.setVisible(true);
	}
	
	public static void main02(String[] args) {
		// FlowLayout
		//	- Panel 컨테이너의 기본 UI 배치 관리자다.
		//	- 컨테이너.add(컴포넌트); => 물 흐르듯이 왼쪽->오른쪽, 위->아래

		Frame f = new Frame("FlowLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		// 기본 레이아웃 관리자를 FlowLayout으로 교체
		f.setLayout( new FlowLayout(FlowLayout.LEFT) );
		
		f.add(new Button("버튼1"));
		f.add(new Button("버튼2"));
		f.add(new Button("버튼3"));
		f.add(new Button("버튼4"));
		f.add(new Button("버튼5"));
		f.add(new Button("버튼6"));
		
		f.setVisible(true);
	}
	
	public static void main01(String[] args) {
		// BorderLayout
		//	- Frame 컨테이너의 기본 UI 배치 관리자다.
		// 	- 컨테이너.add(컴포넌트, 위치지정(동,서,남,북,가운데));
		//	- 컨테이너.add(컴포넌트); => 기본적으로 가운데에 배치시킨다.

		Frame f = new Frame("BorderLayout 테스트");
		f.setSize(400, 300);
		
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 				
			}
		});
		
		f.add(new Button("버튼1"), BorderLayout.NORTH);
		f.add(new Button("버튼2"), BorderLayout.EAST);
		f.add(new Button("버튼3"), BorderLayout.SOUTH);
		f.add(new Button("버튼4"), BorderLayout.WEST);
		f.add(new Button("버튼5"), BorderLayout.CENTER);
		f.add(new Button("버튼6"));
		
		f.setVisible(true);
	}

}
