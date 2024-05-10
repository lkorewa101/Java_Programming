package Week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickPracticeEx extends JFrame {
    public ClickPracticeEx() {
        setTitle("클릭 연습 용 응용프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("C");
        la.setSize(10, 10);
        la.setLocation(100, 100);
        c.add(la);

        la.setFocusable(true);
        la.requestFocus();

        la.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel)e.getSource();
                label.setLocation((int)(Math.random() * 250), (int)(Math.random() * 250));
            }
        });
    }

    public static void main(String[] args) {
        new ClickPracticeEx();
    }
}
