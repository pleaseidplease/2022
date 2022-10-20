package co.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentExam extends JFrame{
	public ComponentExam(){
		setTitle("라벨 예제");
		JPanel panel=new JPanel();
		setSize(new Dimension(300,250));
		
		
		
		JLabel label1=new JLabel("Color Label");
		label1.setFont(new Font("Arial",Font.ITALIC,20));
		label1.setForeground(Color.yellow);
		label1.setText("Yellow Font");
		JLabel label2=new JLabel("Font Label");
		label2.setFont(new Font("Arial",Font.BOLD,25));
		label2.setForeground(Color.green);
		
		JLabel label3=new JLabel();
		
		ImageIcon icon=new ImageIcon("c://Temp/spring.jpg");
		label3.setIcon(icon);
		label3.setSize(200,180);
		label3.setPreferredSize(new Dimension(180,150));
		
		panel.add(label1);
		
		
		panel.add(label2);
		panel.add(label3);
		add(panel);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	public static void main(String[] args) {
		new ComponentExam();
		
	}
}
