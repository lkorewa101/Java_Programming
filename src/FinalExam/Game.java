package FinalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Game extends JFrame {
    private ArrayList<JLabel> numbers = new ArrayList<>();
    private int nextClickNumber = 1; // 다음에 클릭해야 할 숫자를 나타내는 변수
    private long startTime; // 게임 시작 시간을 저장하는 변수

    public Game() {
        setTitle("1 to 20"); // 프레임 제목 설정
        Container c = getContentPane(); // 컨텐트 팬 가져오기
        c.setLayout(null); // 레이아웃 매니저 설정 - 절대 위치 배치

        setSize(300, 300); // 프레임 크기 설정
        setVisible(true); // 프레임 표시

        Font f = new Font("고딕", Font.ITALIC, 15); // 사용할 폰트 설정
        for (int i = 0; i < 20; i++) { // 1부터 20까지의 레이블 생성
            JLabel label = new JLabel(Integer.toString(i + 1)); // 숫자를 문자열로 변환하여 레이블 생성
            label.setForeground(Color.MAGENTA); // 레이블의 전경색 설정
            label.setFont(f); // 레이블의 폰트 설정
            numbers.add(label); // 레이블을 리스트에 추가
            c.add(label); // 레이블을 컨텐트 팬에 추가
            label.addMouseListener(new MyMouseListener()); // 레이블에 마우스 이벤트 리스너 추가
        }
        gameSetting(); // 게임 초기 설정 메서드 호출
    }

    public void gameSetting() {
        Collections.shuffle(numbers); // 레이블 순서를 랜덤하게 섞음
        for (int i = 0; i < numbers.size(); i++) {
            JLabel label = numbers.get(i); // 리스트에서 레이블을 가져옴
            int x = (int) (Math.random() * 230); // 레이블의 x 좌표를 임의로 설정
            int y = (int) (Math.random() * 230); // 레이블의 y 좌표를 임의로 설정
            label.setLocation(x, y); // 레이블의 위치 설정
            label.setSize(20, 20); // 레이블의 크기 설정
            label.setVisible(true); // 레이블을 보이게 설정
        }
        nextClickNumber = 1; // 다음에 클릭해야 할 숫자 초기화
        startTime = System.currentTimeMillis(); // 게임 시작 시간 저장
    }

    class MyMouseListener extends MouseAdapter {
        public void mouseReleased(MouseEvent e) {
            JLabel nowClickedLabel = (JLabel) e.getSource(); // 현재 클릭한 레이블 가져오기
            int nowClickedNum = Integer.valueOf(nowClickedLabel.getText()); // 레이블에 쓰인 숫자 가져오기

            if (nowClickedNum == nextClickNumber) { // 현재 클릭한 숫자가 다음에 클릭해야 할 숫자인 경우
                nowClickedLabel.setVisible(false); // 레이블을 보이지 않게 설정
                nextClickNumber++; // 다음에 클릭해야 할 숫자를 업데이트
            }

            if (nextClickNumber == 21) { // 모든 숫자를 클릭한 경우
                long endTime = System.currentTimeMillis(); // 게임 종료 시간 저장
                long elapsedTime = endTime - startTime; // 소요된 시간 계산
                double seconds = elapsedTime / 1000.0; // 밀리초를 초 단위로 변환

                // 다이얼로그로 걸린 시간을 표시
                JOptionPane.showMessageDialog(null, "걸린 시간: " + seconds + "초", "게임 종료", JOptionPane.INFORMATION_MESSAGE);
                gameSetting(); // 새로운 게임 시작
            }
        }
    }

    public static void main(String[] args) {
        new Game(); // 게임 객체 생성
    }
}
