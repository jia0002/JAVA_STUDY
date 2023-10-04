package project02;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair extends JPanel implements ItemListener{
	JCheckBox[] buttons = new JCheckBox[4];
	String[] items = {"엔진오일 교환", "자동변속기오일교환", "에어컨필터교환", "타이어교환"};
	int[] prices = {45000, 80000, 30000, 100000};
	int money=0;
	JLabel label;
	
	public Repair() {
		super();
		JLabel label = new JLabel();
		JCheckBox checkbox1 = new JCheckBox("엔진오일 교환");
		JCheckBox checkbox2 = new JCheckBox("자동변속기오일교환");
		JCheckBox checkbox3 = new JCheckBox("에어컨필터교환");
		JCheckBox checkbox4 = new JCheckBox("타이어교환");
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		add(checkbox4);
		add(label);
		checkbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				label.setText("현재까지의 가격은 "+prices[0]+"입니다.");
			}
		});
		
		
		setSize(300, 150);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("CheckBoxDemo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new Repair();
		newContentPane.setVisible(true);
		frame.setContentPane(newContentPane);
		frame.setSize(500, 200);
		frame.setVisible(true);
	}

}
