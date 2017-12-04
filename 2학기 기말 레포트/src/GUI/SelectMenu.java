package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Menu extends JFrame{
	JPanel jp = new JPanel();
	JButton bt1 = new JButton("학생등록");
	JButton bt2 = new JButton("수정하기");
	JButton bt3 = new JButton("정보보기");
	JButton bt4 = new JButton("끝내기");
	
	Menu_1 lis = new Menu_1();
	
	GridLayout gr = new GridLayout(4, 0, 10, 10);

	Menu(){
		setTitle("학생정보프로그램");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		add(jp);
		jp.setLayout(gr);
		
		jp.add(bt1);
		jp.add(bt2);
		jp.add(bt3);
		jp.add(bt4);
		
		bt1.addActionListener(lis);
		bt2.addActionListener(lis);
		bt3.addActionListener(lis);
		bt4.addActionListener(lis);
	}
	
	class Menu_1 implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bt1)) {
				dispose();
				MainRegister reg = new MainRegister();
			}
			
			else if(e.getSource().equals(bt2)) {
				dispose();
				MainCorrection cor = new MainCorrection();
			}
			
			else if(e.getSource().equals(bt3)) {
				dispose();
				MainInformation inf = new MainInformation();
			}
			
			else if(e.getSource().equals(bt4)) {
				System.exit(0);
			}
		}
	}
	
}

public class SelectMenu{
	public static void main(String[] args) {
		
		new Menu();
	}
}
