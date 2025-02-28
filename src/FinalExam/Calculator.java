package FinalExam;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Calculator extends JFrame {

    private JTextField inputSpace; // 계산 결과를 보여줄 텍스트 필드
    private String num = ""; // 현재 입력 중인 숫자
    private String prev_operation = ""; // 이전에 수행된 연산 기호
    private ArrayList<String> equation = new ArrayList<String>(); // 수식을 담을 리스트

    public Calculator() {
        setLayout(null); // 레이아웃을 직접 설정하기 위해 null 레이아웃 사용

        inputSpace = new JTextField(); // 텍스트 필드 생성
        inputSpace.setEditable(false); // 수정 불가능하도록 설정
        inputSpace.setBackground(Color.WHITE); // 배경색 설정
        inputSpace.setHorizontalAlignment(JTextField.RIGHT); // 텍스트 오른쪽 정렬
        inputSpace.setFont(new Font("Arial", Font.BOLD, 50)); // 폰트 설정
        inputSpace.setBounds(8, 10, 270, 70); // 위치와 크기 설정

        JPanel buttonPanel = new JPanel(); // 버튼 패널 생성
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 그리드 레이아웃 설정
        buttonPanel.setBounds(8, 90, 270, 235); // 위치와 크기 설정

        // 버튼에 표시될 이름 배열
        String button_names[] = { "C", "÷", "×", "=", "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "0" };
        JButton buttons[] = new JButton[button_names.length]; // 버튼 배열 생성

        // 버튼 생성 및 설정
        for (int i = 0; i < button_names.length; i++) {
            buttons[i] = new JButton(button_names[i]);
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            // 버튼 색상 설정
            if (button_names[i].equals("C"))
                buttons[i].setBackground(Color.RED);
            else if ((i >= 4 && i <= 6) || (i >= 8 && i <= 10) || (i >= 12 && i <= 14))
                buttons[i].setBackground(Color.BLACK);
            else
                buttons[i].setBackground(Color.GRAY);
            buttons[i].setForeground(Color.WHITE); // 텍스트 색상 설정
            buttons[i].setBorderPainted(false); // 테두리 제거
            buttons[i].addActionListener(new PadActionListener()); // ActionListener 추가
            buttonPanel.add(buttons[i]); // 버튼을 패널에 추가
        }

        add(inputSpace); // 텍스트 필드를 프레임에 추가
        add(buttonPanel); // 버튼 패널을 프레임에 추가

        setTitle("계산기"); // 프레임 제목 설정
        setVisible(true); // 프레임을 보이게 함
        setSize(300, 370); // 크기 설정
        setLocationRelativeTo(null); // 화면 중앙에 위치하도록 설정
        setResizable(false); // 크기 변경 불가능하도록 설정
    }

    // 버튼의 ActionListener를 담당하는 내부 클래스
    class PadActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String operation = e.getActionCommand(); // 눌린 버튼의 텍스트 가져오기

            if (operation.equals("C")) {
                inputSpace.setText(""); // "C" 버튼 눌리면 입력 공간 초기화
            } else if (operation.equals("=")) {
            	// "=" 버튼 눌리면 입력된 수식 계산하고 결과를 텍스트 필드에 표시
                String result = Double.toString(calculate(inputSpace.getText()));
                inputSpace.setText("" + result);
                num = ""; // 현재 입력 중인 숫자 초기화
            } else if (operation.equals("+") || operation.equals("-") || operation.equals("×")
                    || operation.equals("÷")) {
            	// 연산 기호가 입력된 경우
                if (inputSpace.getText().equals("") && operation.equals("-")) {
                    inputSpace.setText(inputSpace.getText() + e.getActionCommand());
                } else if (!inputSpace.getText().equals("") && !prev_operation.equals("+")
                        && !prev_operation.equals("-") && !prev_operation.equals("×")
                        && !prev_operation.equals("÷")) {
                    inputSpace.setText(inputSpace.getText() + e.getActionCommand());
                }
            } else {
                inputSpace.setText(inputSpace.getText() + e.getActionCommand()); // 숫자 버튼인 경우 텍스트에 추가
            }
            prev_operation = e.getActionCommand(); // 이전 연산 기호 업데이트
        }
    }

    // 수식을 파싱하고 계산하는 메서드
    private void fullTextParsing(String inputText) {
        equation.clear(); // 수식 리스트 초기화
        for (int i = 0; i < inputText.length(); i++) {
            char ch = inputText.charAt(i);
            if (ch == '-' || ch == '+' || ch == '×' || ch == '÷') {
                equation.add(num); // 숫자를 리스트에 추가
                num = "";
                equation.add(ch + ""); // 연산 기호를 리스트에 추가
            } else {
                num = num + ch; // 숫자를 문자열에 추가
            }
        }
        equation.add(num); // 마지막 숫자 추가
        equation.remove(""); // 빈 문자열 제거
        equation.add(0, "0"); // 계산을 위해 리스트의 첫 번째에 0 추가
        equation.add(1, "+"); // 계산을 위해 리스트의 두 번째에 + 추가
    }

    public double calculate(String inputText) {
        fullTextParsing(inputText); // 입력된 텍스트를 파싱하여 수식 리스트로 변환

        double prev = 0; // 이전 값 초기화
        double current = 0; // 현재 값 초기화
        String mode = ""; // 연산 모드 초기화

        // 수식 리스트를 순회하며 연산 수행
        for (int i = 0; i < equation.size(); i++) {
            String s = equation.get(i); // 현재 요소 가져오기
            if (s.equals("+")) {
                mode = "add"; // 덧셈 모드 설정
            } else if (s.equals("-")) {
                mode = "sub"; // 뺄셈 모드 설정
            } else if (s.equals("×")) {
                mode = "mul"; // 곱셈 모드 설정
            } else if (s.equals("÷")) {
                mode = "div"; // 나눗셈 모드 설정
            } else {
            	// 숫자인 경우
                if ((mode.equals("mul") || mode.equals("div")) && !s.equals("+") && !s.equals("-")
                        && !s.equals("×") && !s.equals("÷")) {
                	// 곱셈이나 나눗셈 모드이고, 현재 요소가 연산 기호가 아닌 경우
                    Double one = Double.parseDouble(equation.get(i - 2)); // 이전 숫자
                    Double two = Double.parseDouble(equation.get(i)); // 현재 숫자
                    Double result = 0.0; // 결과 값 초기화
                    if (mode.equals("mul")) {
                        result = one * two; // 곱셈 연산 수행
                    } else if (mode.equals("div")) {
                        result = one / two; // 나눗셈 연산 수행
                    }
                    equation.add(i + 1, Double.toString(result)); // 결과 값을 리스트에 추가
                    for (int j = 0; j < 3; j++) {
                        equation.remove(i - 2); // 연산에 사용된 숫자와 연산 기호 제거
                    }
                    i -= 2; // 인덱스 업데이트
                }
            }
        }

        // 최종 결과 계산
        for (String s : equation) {
            if (s.equals("+")) {
                mode = "add"; // 덧셈 모드 설정
            } else if (s.equals("-")) {
                mode = "sub"; // 뺄셈 모드 설정
            } else {
                current = Double.parseDouble(s); // 현재 숫자 가져오기
                if (mode.equals("add")) {
                    prev += current; // 덧셈 수행
                } else if (mode.equals("sub")) {
                    prev -= current; // 뺄셈 수행
                } else {
                    prev = current; // 초기 값 설정
                }
            }
            prev = Math.round(prev * 100000) / 100000.0; // 소수점 다섯 자리까지 반올림
        }
        return prev; // 최종 결과 반환
    }

    public static void main(String[] args) {
        new Calculator(); // 계산기 객체 생성
    }
}
