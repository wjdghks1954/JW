package GUI;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class MainRegister extends JFrame{
   JPanel mainjp = new JPanel();
   
   JPanel noregjp = new JPanel();
   JPanel ceregjp = new JPanel();
   JPanel ceregjbjp = new JPanel();
   JPanel regjp = new JPanel();   
   
   JPanel nolistjp = new JPanel();
   JPanel celistjp = new JPanel();
   JPanel listjp = new JPanel();
   JPanel sublistjp = new JPanel();
   
   
   JTable table = new JTable(); 
    JScrollPane pane = new JScrollPane(table);
    Object[] row = new Object[5];
    Object[] columns = {"�й�","�̸�","�а�","�г�", "����"};
    DefaultTableModel model = new DefaultTableModel();
   
    
    
   JLabel regjl = new JLabel("��� �Է¶�");
   
   
   
   JLabel num = new JLabel("�й�");
   JTextField num_1 = new JTextField(10);
   JLabel name = new JLabel("�̸�");
   JTextField name_1 = new JTextField(10);
   JLabel major = new JLabel("�а�");
   JTextField major_1 = new JTextField(10);
   JLabel grade = new JLabel("�г�");
   //�޺��ڽ� �г� 1~4
   String [] str_grade = {"1", "2", "3", "4"};
   JComboBox grade_1 = new JComboBox<String>(str_grade);
   JLabel sex = new JLabel("����");
   //üũ�ڽ� �׷�
   CheckboxGroup cg = new CheckboxGroup();
    Checkbox m = new Checkbox("����",false,cg);
    Checkbox g = new Checkbox("����",false,cg);
    JLabel air = new JLabel("");
    
   JButton reg = new JButton("���");
   
   JLabel listjl = new JLabel("�л� ����Ʈ");
   JTextArea listja = new JTextArea(19, 40);
   
   JButton delete = new JButton("����");
   JButton detailed = new JButton("�ڼ��� ���� �Է�");
   JButton save = new JButton("�����ϱ�");
   JButton select = new JButton("�ʱ�ȭ��");
   
   
   
   Data_Input in = new Data_Input();
   Data_Delete del = new Data_Delete();
   MainPage ma = new MainPage();
   
   
   BorderLayout bo1 = new BorderLayout();
   BorderLayout bo2 = new BorderLayout();
   BorderLayout bo3 = new BorderLayout();
   
   GridLayout gr1 = new GridLayout(2,5,3,10);
   GridLayout gr2 = new GridLayout(0,1,0,10);
   
   MainRegister(){
      setTitle("�л��������α׷�");
      setSize(600,500);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      add(mainjp);
      mainjp.setLayout(bo1);
      
      mainjp.add(regjp, bo1.NORTH);
      regjp.setLayout(bo2);
      regjp.add(noregjp, bo2.NORTH);
      noregjp.add(regjl);
      regjp.add(ceregjp, bo2.CENTER);
      ceregjp.setLayout(gr1);
      ceregjp.add(num);
      ceregjp.add(name);
      ceregjp.add(major);
      ceregjp.add(grade);
      ceregjp.add(sex);
      ceregjp.add(air);
      
      ceregjp.add(num_1);
      ceregjp.add(name_1);
      ceregjp.add(major_1);
      ceregjp.add(grade_1);
      ceregjp.add(m);
      ceregjp.add(g);
      
      mainjp.add(listjp, bo1.CENTER);
      listjp.setLayout(bo3);
      listjp.add(nolistjp, bo3.NORTH);
      nolistjp.add(listjl);
      listjp.add(celistjp, bo3.CENTER);
      celistjp.add(pane);
      model.setColumnIdentifiers(columns);
       table.setModel(model);
      
      listjp.add(sublistjp, bo3.EAST);
      sublistjp.setLayout(gr2);
      sublistjp.add(reg);
      sublistjp.add(delete);
      sublistjp.add(detailed);
      sublistjp.add(save);
      sublistjp.add(select);
      
      reg.addActionListener(in);
      delete.addActionListener(del);
      select.addActionListener(ma);
   }
   
   class Data_Input implements ActionListener{
         public void actionPerformed(ActionEvent e) {
            JButton jb = (JButton)e.getSource();
            String com1= num_1.getText();
            String com2 = name_1.getText();
            String com3 = major_1.getText();


            
               row[0] = num_1.getText();
               row[1] = name_1.getText();
               row[2] = major_1.getText();
               num_1.getText();
               name_1.getText();
               
               String str = grade_1.getSelectedItem().toString();
               row[3] = str;
               
               
               
               num_1.setText(null);
               name_1.setText(null);
               major_1.setText(null);
              
               
               if(m.getState()==true){
                      row[4] = "����";
               }
               else if(m.getState()==false){
                         row[4] = "����";
               }
               else{
                         row[4] = "";
               }
               
               if(com1.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "�����͸� �Է��Ͻÿ�.", "���� ", 
                    JOptionPane.ERROR_MESSAGE);
               }else if(com2.isEmpty()) {
            	  JOptionPane.showMessageDialog(null, "�����͸� �Է��Ͻÿ�.", "���� ", 
                    JOptionPane.ERROR_MESSAGE);
               }else if(com3.isEmpty()) {
             	  JOptionPane.showMessageDialog(null, "�����͸� �Է��Ͻÿ�.", "���� ", 
                          JOptionPane.ERROR_MESSAGE);
                     }else model.addRow(row);
         }
   }
   
   class Data_Delete implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         int i = table.getSelectedRow();
         if(i >= 0){
            JOptionPane.showConfirmDialog(null, "�����͸� ����"
               + "�����Ͻðڽ��ϱ�??","���޼���",
               JOptionPane.YES_NO_OPTION);
               
            model.removeRow(i);
            
            }
      }
      
   }
   
}


class MainPage implements ActionListener{
	public void actionPerformed(ActionEvent e) {
			e.getSource();
			SelectMenu reg = new SelectMenu();
		
	}
	
}


public class Register{
   JFrame f;  
      Register(){  
          f=new JFrame();   
         
      }  
   public static void main(String[] args) {
      
      new MainRegister();
   }
   
}