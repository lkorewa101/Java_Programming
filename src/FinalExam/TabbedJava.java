package FinalExam;

import javax.swing.*;
import java.awt.*;

public class TabbedJava extends JFrame {
	// TabbedJava 클래스 생성자
	public TabbedJava() {
		setTitle("자바란?"); // 프레임 제목 설정
		Container c = getContentPane(); // 컨텐트 팬 가져오기
		JTabbedPane pane = createTabbedPane(); // 탭 팬 생성
		c.add(pane, BorderLayout.CENTER); // 컨텐트 팬에 탭 팬 추가
		setSize(500,300); // 프레임 크기 설정
		setVisible(true); // 프레임을 보이게 함
	}
	
	// 탭 팬 생성 메소드
	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane(JTabbedPane.LEFT); // 왼쪽에 탭을 배치하는 탭 팬 생성
		pane.addTab("자바의 특성", new MyPanel(1)); // "자바의 특성" 탭 추가
		pane.addTab("자바의 장단점", new MyPanel(2)); // "자바의 장단점" 탭 추가
		pane.addTab("자바의 역사", new MyPanel(3)); // "자바의 역사" 탭 추가
		return pane; // 생성된 탭 팬 반환
	}
	
	// 내부 클래스 MyPanel 정의
	class MyPanel extends JPanel {
		public MyPanel(int no) {
			JTextArea ta = new JTextArea(10, 30); // JTextArea 생성
			if (no == 1) {
				// "자바의 특성" 탭의 내용 추가
				ta.append("1. 운영체제에 독립적으로 동작한다. \n");
				ta.append("2. 객체지향언어이다. \n");
				ta.append("3. 가비지컬렉터를 통한 자동 메모리 관리가 가능하다. \n");
			}
			else if(no == 2) {
				// "자바의 장단점" 탭의 내용 추가
				ta.append("장점 \n");
				ta.append("1.C나 C++에 비해 보안성이 높다. \n");
				ta.append("2.효율적인 메모리 할당 전략을 제공한다. \n\n");
				ta.append("단점 \n");
				ta.append("1.수행 속도가 느리고 부족하다. \n");
				ta.append("2.GUI 기능이 부족하다. \n");
			}
			else {
				// "자바의 역사" 탭의 내용 추가
				ta.append("자바의 역사는 1991년 6월 셋톱 프로젝트를 위해 \n");
				ta.append("제임스 고슬링이 만들었다. \n");
				ta.append("초창기 자바의 이름은 오크였으나, 오크라는 이름은 \n");
				ta.append("기존에 다른 회사가 사용 중인이름이라고 하여, \n");
				ta.append("인도네시아 자바섬에서 재배되는 \n");
				ta.append("커피원두에서 차용된 자바라는 이름으로 결정되었다. \n");
			}
			add(ta); // JTextArea를 패널에 추가
		}
	}

	// 프로그램 실행을 위한 main 메서드
	public static void main(String [] args) {
		new TabbedJava(); // TabbedJava 객체 생성하여 프로그램 실행
	}
} 
