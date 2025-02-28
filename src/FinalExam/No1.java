package FinalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class No1 extends JFrame {
    JPanel contentPane = new JPanel(); // 프레임의 컨텐츠 패널
    Notepad notepadPanel = new Notepad(); // 메모장 패널
    JPanel infoPanel = new JPanel(); // 정보 패널

    No1() {
        setTitle("21113038_고기현"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫기 버튼 동작 설정
        setContentPane(contentPane); // 프레임의 컨텐츠 패널 설정
        contentPane.setLayout(new BorderLayout()); // 컨텐츠 패널 레이아웃 설정

        contentPane.add(infoPanel, BorderLayout.CENTER); // 정보 패널을 중앙에 추가

        createMenu(); // 메뉴 생성 메소드 호출
        setSize(1000, 1000); // 프레임 크기 설정
        setVisible(true); // 프레임 표시 설정
    }

    void createMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴 바 생성
        JMenu menu1 = new JMenu("1번문제");
        JMenuItem oneItem = new JMenuItem("실행");
        oneItem.addActionListener(new OneActionListener());
        menu1.add(oneItem);
        
        // 두 번째 메뉴 생성
        JMenu menu2 = new JMenu("2-1번문제");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem saveAsItem = new JMenuItem("SaveAs");
        
        // New 메뉴 아이템에 액션 리스너 추가하여 메모장 패널을 보여줌
        newItem.addActionListener(e -> {
            contentPane.removeAll();
            contentPane.add(notepadPanel, BorderLayout.CENTER);
            contentPane.revalidate();
            contentPane.repaint();
        });
        openItem.addActionListener(e -> notepadPanel.openFile()); // Open
        saveItem.addActionListener(e -> notepadPanel.saveFile()); // Save
        saveAsItem.addActionListener(e -> notepadPanel.saveFileAs()); // SaveAs
        
        // 두 번째 메뉴 아이템 추가
        menu2.add(newItem);
        menu2.add(openItem);
        menu2.addSeparator();
        menu2.add(saveItem);
        menu2.add(saveAsItem);
        
        // 세 번째 메뉴 생성 및 아이템 추가
        JMenu menu3 = new JMenu("2-2번문제");
        menu3.add(new JMenuItem("Open"));
        menu3.addSeparator();
        menu3.add(new JMenuItem("Color"));
        menu3.addSeparator();
        menu3.add(new JMenuItem("Line"));
        menu3.add(new JMenuItem("Rect"));
        menu3.add(new JMenuItem("Oval"));
        menu3.add(new JMenuItem("RndRect"));
        menu3.add(new JMenuItem("Text"));
        menu3.add(new JMenuItem("FreeLine"));

        // 네 번째 메뉴 생성 및 아이템 추가
        JMenu menu4 = new JMenu("3,4,5번문제");
        JMenuItem q3Item = new JMenuItem("3. 게임시작");
        menu4.add(q3Item);
        q3Item.addActionListener(new Q3ItemActionListener());
        
        JMenuItem q4Item = new JMenuItem("4. 계산기");
        menu4.add(q4Item);
        q4Item.addActionListener(new Q4ItemActionListener());
        
        JMenuItem q5Item = new JMenuItem("5. 자바란?");
        menu4.add(q5Item);
        q5Item.addActionListener(new Q5ItemActionListener());

        //메뉴 바에 메뉴 추가
        mb.add(menu1);
        mb.add(menu2);
        mb.add(menu3);
        mb.add(menu4);
        setJMenuBar(mb);
    }

    // 5. 자바란? 메뉴 아이템에 대한 액션 리스너 구현
    class Q5ItemActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new TabbedJava();
        }
    }

    // 실행에 대한 액션 리스너 구현
    class OneActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            question1();
        }
    }

    // 4. 계산기 메뉴 아이템에 대한 액션 리스너 구현
    class Q4ItemActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Calculator();
        }
    }
    
    // 3. 게임시작에 대한 액션 리스너 구현
    class Q3ItemActionListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
    		new Game();
    	}
    }

    // 실행 부분 내용 출력부
    void question1() {
        contentPane.removeAll(); // contentPane의 모든 구성 요소를 제거
        contentPane.add(infoPanel, BorderLayout.CENTER); // infoPanel을 contentPane의 중앙에 추가
        infoPanel.setLayout(new GridLayout(8, 2, 5, 5)); // infoPanel의 레이아웃을 8행 2열의 그리드로 설정
        infoPanel.removeAll(); // infoPanel의 모든 구성 요소를 제거
        
        // 각 레이블과 해당하는 텍스트 필드를 생성하여 infoPanel에 추가
        infoPanel.add(new JLabel("이름: "));
        infoPanel.add(new JTextField("고기현 "));
        infoPanel.add(new JLabel("학번: "));
        infoPanel.add(new JTextField("21113038 "));
        infoPanel.add(new JLabel("학과: "));
        infoPanel.add(new JTextField("컴퓨터공학전공 "));
        infoPanel.add(new JLabel("장래희망: "));
        infoPanel.add(new JTextField("백엔드 개발자 "));
        infoPanel.add(new JLabel("여름방학 계획: "));
        infoPanel.add(new JTextField("휴식 및 알고리즘 공부 "));
        infoPanel.add(new JLabel("다음학기 계획: "));
        infoPanel.add(new JTextField("토익 취득 및 기사 자격증 준비 "));
        infoPanel.add(new JLabel("좌우명: "));
        infoPanel.add(new JTextField("늦었다고 생각할 땐 늦은거다. "));
        infoPanel.add(new JLabel("내 인생의 멘토: "));
        infoPanel.add(new JTextField("아직까진 없음. "));
        
        infoPanel.revalidate(); // infoPanel을 새로 고쳐서 레이아웃을 갱신
        infoPanel.repaint(); // infoPanel을 다시 그려서 변경 사항을 즉시 적용
        contentPane.revalidate(); // contentPane을 새로 고쳐서 레이아웃을 갱신
        contentPane.repaint(); // contentPane을 다시 그려서 변경 사항을 즉시 적용
    }

    public static void main(String[] args) {
        new No1(); // No1 클래스의 인스턴스를 생성하여 프로그램을 실행.
    }
    
    class Notepad extends JPanel {
        JTextArea textArea; // 텍스트를 입력할 수 있는 텍스트 입력 영역
        JFileChooser fileChooser; // 파일을 선택할 수 있는 파일 선택기
        File currentFile; // 현재 열려있는 파일을 저장하는 변수

        Notepad() {
            setLayout(new BorderLayout()); // 패널의 레이아웃을 설정
            textArea = new JTextArea(); // 텍스트 영역을 생성
            fileChooser = new JFileChooser(); // 파일 선택기를 생성
            add(new JScrollPane(textArea), BorderLayout.CENTER); // 텍스트 영역을 스크롤 가능하도록 패널에 추가
        }

        // 파일 열기 메소드
        void openFile() {
            int returnValue = fileChooser.showOpenDialog(this); // 파일 선택 다이얼로그를 열고 사용자의 선택 결과를 받음
            if (returnValue == JFileChooser.APPROVE_OPTION) { // 사용자가 파일을 선택했을 때
                currentFile = fileChooser.getSelectedFile(); // 선택한 파일을 가져와서 현재 파일로 설정
                try (BufferedReader br = new BufferedReader(new FileReader(currentFile))) { // 선택한 파일을 읽어오기 위해 BufferedReader 사용
                    textArea.read(br, null); // 텍스트 영역에 파일의 내용을 읽어와서 표시
                } catch (IOException ex) {
                    ex.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력
                }
            }
        }

        // 파일 저장 메소드
        void saveFile() {
            if (currentFile == null) { // 현재 파일이 없을 경우
                saveFileAs(); // 다른 이름으로 저장 메서드 호출
            } else { // 현재 파일이 있을 경우
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                    textArea.write(bw); // 텍스트 영역의 내용을 파일에 쓰기
                } catch (IOException ex) {
                    ex.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력
                }
            }
        }

        // 다른 이름으로 저장 메소드
        void saveFileAs() {
            int returnValue = fileChooser.showSaveDialog(this); // 파일 선택 다이얼로그를 열고 사용자의 선택 결과를 받음
            if (returnValue == JFileChooser.APPROVE_OPTION) { // 사용자가 파일을 선택했을 때
                currentFile = fileChooser.getSelectedFile(); // 선택한 파일을 가져와서 현재 파일로 설정
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                    textArea.write(bw); // 텍스트 영역의 내용을 파일에 쓰기
                } catch (IOException ex) {
                    ex.printStackTrace(); // 예외가 발생하면 스택 트레이스를 출력
                }
            }
        }
    }
}