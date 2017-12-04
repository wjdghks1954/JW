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
    Object[] columns = {"학번","이름","학과","학년", "성별"};
    DefaultTableModel model = new DefaultTableModel();
   
    
    
   JLabel regjl = new JLabel("등록 입력란");
   
   
   
   JLabel num = new JLabel("학번");
   JTextField num_1 = new JTextField(10);
   JLabel name = new JLabel("이름");
   JTextField name_1 = new JTextField(10);
   JLabel major = new JLabel("학과");
   JTextField major_1 = new JTextField(10);
   JLabel grade = new JLabel("학년");
   //콤보박스 학년 1~4
   String [] str_grade = {"1", "2", "3", "4"};
   JComboBox grade_1 = new JComboBox<String>(str_grade);
   JLabel sex = new JLabel("성별");
   //체크박스 그룹
   CheckboxGroup cg = new CheckboxGroup();
    Checkbox m = new Checkbox("남자",false,cg);
    Checkbox g = new Checkbox("여자",false,cg);
    JLabel air = new JLabel("");
    
   JButton reg = new JButton("등록");
   
   JLabel listjl = new JLabel("학생 리스트");
   JTextArea listja = new JTextArea(19, 40);
   
   JButton delete = new JButton("삭제");
   JButton detailed = new JButton("자세한 정보 입력");
   JButton save = new JButton("저장하기");
   JButton select = new JButton("초기화면");
   
   
   
   Data_Input in = new Data_Input();
   Data_Delete del = new Data_Delete();
   MainPage ma = new MainPage();
   
   
   BorderLayout bo1 = new BorderLayout();
   BorderLayout bo2 = new BorderLayout();
   BorderLayout bo3 = new BorderLayout();
   
   GridLayout gr1 = new GridLayout(2,5,3,10);
   GridLayout gr2 = new GridLayout(0,1,0,10);
   
   MainRegister(){
      setTitle("학생정보프로그램");
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
                      row[4] = "남자";
               }
               else if(m.getState()==false){
                         row[4] = "여자";
               }
               else{
                         row[4] = "";
               }
               
               if(com1.isEmpty()) {
                   JOptionPane.showMessageDialog(null, "데이터를 입렷하시오.", "오류 ", 
                    JOptionPane.ERROR_MESSAGE);
               }else if(com2.isEmpty()) {
            	  JOptionPane.showMessageDialog(null, "데이터를 입렷하시오.", "오류 ", 
                    JOptionPane.ERROR_MESSAGE);
               }else if(com3.isEmpty()) {
             	  JOptionPane.showMessageDialog(null, "데이터를 입렷하시오.", "오류 ", 
                          JOptionPane.ERROR_MESSAGE);
                     }else model.addRow(row);
         }
   }
   
   class Data_Delete implements ActionListener{
      public void actionPerformed(ActionEvent e) {
         int i = table.getSelectedRow();
         if(i >= 0){
            JOptionPane.showConfirmDialog(null, "데이터를 정말"
               + "삭제하시겠습니까??","경고메세지",
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