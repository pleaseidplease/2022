package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class ComponentExam2 extends JFrame{
	public ComponentExam2(){
		setTitle("입력필드 UI");
		setSize(500,300);
		
		setLayout(new BorderLayout());
		JPanel center=new JPanel();
		JPanel bottom=new JPanel();
		
		JPanel panel=new JPanel();
		JLabel idLb1=new JLabel("id");
		idLb1.setPreferredSize(new Dimension(30,16));
		JLabel pwLb1=new JLabel("password");
		pwLb1.setPreferredSize(new Dimension(30,16));
		JTextField idTxt=new JTextField(23);
		JPasswordField pwTxt=new JPasswordField(23);
		
		
		
		center.add(idLb1);
		
		center.add(idTxt);
		center.add(pwLb1);
		center.add(pwTxt);
		JButton btn=new JButton("확인");
		bottom.add(btn);
		
		add("Center",center);
		
		add("South",bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new ComponentExam2();
	}
}
