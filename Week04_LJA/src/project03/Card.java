package project03;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame{
	private JPanel panel;
	private JLabel label;
	
	public MyFrame() {
		setTitle("BusinessCard");
		setSize(600, 200);
		
		panel=new JPanel();
		label=new JLabel("");
		ImageIcon icon = new ImageIcon("C:\\Users\\2002j\\eclipse-workspace-z\\Week04_LJA\\src\\project03\\a.png");
		label.setIcon(icon);
		panel.add(label);
		add(panel);
		
		JPanel panel1 = new JPanel();
		panel1.add(new JLabel("임지아"));
		panel1.add(new JLabel("프로젝트 매니저"));
		panel1.add(new JLabel("덕성주식회사"));
		add(panel1);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

public class Card {
	public static void main(String[] args) {
		MyFrame F = new MyFrame();
	}

}
