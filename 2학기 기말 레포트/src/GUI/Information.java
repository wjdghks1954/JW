package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MainInformation extends JFrame{
	
	JPanel jp = new JPanel();
	
	JButton beginning = new JButton("�ʱ�ȭ��");
	
	MainInformation(){
		setTitle("�л��������α׷�");
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(jp);
	}
}


public class Information {

	public static void main(String[] args) {
		new MainInformation();
		
	}

}
