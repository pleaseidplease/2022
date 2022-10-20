package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SmsScreen extends JFrame{
	Dimension lbl1=new Dimension(70,15);
	Dimension lbl2=new Dimension(70,15);
	JPanel center,bottom; //컴포넌트를 모아두기 위한 컨테이너.
	JLabel fromLbl,toLbl,subjectLbl,contentLbl; //레이블.
	JTextField fromTxt,toTxt,subjecTxt; //텍스트필드.
	JTextArea contentTxt;
	JButton send, cancel;
	SmsApp app=new SmsApp();
	
	public SmsScreen() {
		setTitle("문자 보내기 UI");
		setSize(340,300);
		setLayout(new BorderLayout());
		
		//panel
		center=new JPanel();
		bottom=new JPanel();
		
		//label..
		toLbl=new JLabel("발신 번호");
		fromLbl=new JLabel("수신 번호");
		contentLbl=new JLabel("내용");
		
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		//textfield
		toTxt=new JTextField(20);
		fromTxt=new JTextField(20);
		contentTxt=new JTextArea(10,25);
		
		//botton.
		send=new JButton("보내기");
		send.addActionListener(new MyActionListener()); //ActionListener 인터페이스 ->구현객체
		cancel=new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		//container setting.
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(toLbl);
		center.add(toTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		// 컨테이너에 컴포넌트 배치.
		bottom.add(send);
		bottom.add(cancel);
		
		//윈도우에 컨테이너 배치
		add("Center",center);
		add("South",bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	
	// 기능을 실현하는 구현객체.
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object src=e.getSource();
			if(src==send) {
				System.out.println("보내기 버튼 actionPerformed.");
				String from=fromTxt.getText();
				String to=toTxt.getText();
				String content=contentTxt.getText();

				
				if(app.sendSms(from, to, content).equals("Success")) {
					//콘솔에 "성공"; -> 값을 지워주도록
					JOptionPane.showMessageDialog(null, "발송성공!!","전송결과",JOptionPane.DEFAULT_OPTION);
					fromTxt.setText("");
					toTxt.setText("");
					contentTxt.setText("");
				}else {
					//콘솔에 "실패";
					JOptionPane.showMessageDialog(null, "발송실패!!","전송결과",JOptionPane.DEFAULT_OPTION);
				}
			}else if(src==cancel) {
				System.out.println("취소 버튼 actionPerformed.");
			}			
		}
		
	}
	
	//화면시작
	public static void main(String[] args) {
		new SmsScreen();
	}
}
