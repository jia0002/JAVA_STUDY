package project03;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car extends JFrame {
    private int carX = 100; // 자동차의 초기 X 좌표
    private final int carY = 50; // 자동차의 Y 좌표는 고정
    private final int carWidth = 200; // 자동차의 너비
    private final int carHeight = 100; // 자동차의 높이

    public Car() {
        setTitle("Car Mover");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // LEFT 버튼 생성
        JButton leftButton = new JButton("LEFT");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveLeft();
            }
        });

        // RIGHT 버튼 생성
        JButton rightButton = new JButton("RIGHT");
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveRight();
            }
        });

        // 패널에 버튼 추가
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);

        // 프레임에 버튼 패널 추가
        add(buttonPanel, BorderLayout.SOUTH);

        // 프레임을 그리는 패널 생성
        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 자동차 이미지를 그립니다.
                ImageIcon carIcon = new ImageIcon("C:\\Users\\2002j\\eclipse-workspace-z\\Week03_LJA\\src\\project03\\car.png"); // 이미지 파일 경로를 수정하세요.
                g.drawImage(carIcon.getImage(), carX, carY, carWidth, carHeight, null);
            } 
        };

        // 그리는 패널을 프레임에 추가
        add(drawingPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null); // 화면 중앙에 표시
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void moveLeft() {
        carX -= 10; // 왼쪽으로 10 픽셀 이동
        repaint(); // 화면을 다시 그리도록 요청
    }

    private void moveRight() {
        carX += 10; // 오른쪽으로 10 픽셀 이동
        repaint(); // 화면을 다시 그리도록 요청
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Car c = new Car();
            }
        });
    }
}