import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MyFrame extends JFrame{
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_l;
	ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame=new MyFrame();
					frame.setVisible(true);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("성적");
		lblNewLabel.setBounds(61, 13, 57, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(170, 10, 97, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("입력");
		btnNewButton.addActionListener(e->{
			list.add(Integer.parseInt(textField.getText()));
		});
		btnNewButton.setBounds(61, 38, 97, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_l = new JButton("평균계산");
		btnNewButton_l.setBounds(170, 38, 97, 23);
		contentPane.add(btnNewButton_l);
		
		JLabel lblNewLabel_l = new JLabel("모든 학생의 평균 ");
		lblNewLabel_l.setBounds(61, 80, 122, 15);
		contentPane.add(lblNewLabel_l);
		
		textField_l = new JTextField();
		textField_l.setBounds(170, 77, 97, 21);
		contentPane.add(textField_l);
		textField_l.setColumns(10);
		btnNewButton_l.addActionListener(e->{
			int sum=0;
			for(int s:list) {
				sum+=s;
			}
			textField_l.setText(""+(sum/list.size()));
		});
	}

}
