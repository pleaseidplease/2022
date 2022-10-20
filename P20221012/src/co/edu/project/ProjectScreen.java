package co.edu.project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ProjectScreen extends JFrame implements ActionListener, MouseListener {
	private String[] labels = { "사원번호", "이름", "나이", "직급", "부서" };
	private JTextField[] fields = new JTextField[5];

	private JPanel topPanel;
	private JScrollPane centerPanel;
	private JPanel rightPanel;

	private JTable table;

	private JButton addBtn, resBtn, delBtn, findBtn, initBtn;

	ProjectExe pexe = new ProjectExe();
	List<Project> list;

	public ProjectScreen() {
		setTitle("직원 관리화면");
		setLayout(new BorderLayout(10, 10));

		topPanel = new JPanel(new GridLayout(5, 2));
		for (int i = 0; i < labels.length; i++) {
			topPanel.add(new JLabel(labels[i]));
			fields[i] = new JTextField(30);
			topPanel.add(fields[i]);
		}

		String[] headers = { "사원번호", "이름", "나이", "직급", "부서" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);

		table = new JTable(model);
		table.addMouseListener(null);
		centerPanel = new JScrollPane(table);

		rightPanel = new JPanel(new GridLayout(5, 1));
		addBtn = new JButton("추가");
		resBtn = new JButton("수정");
		delBtn = new JButton("삭제");
		findBtn = new JButton("조회");
		initBtn = new JButton("메인메뉴");

		addBtn.addActionListener(this);
		resBtn.addActionListener(this);
		delBtn.addActionListener(this);
		findBtn.addActionListener(this);
		initBtn.addActionListener(this);

		rightPanel.add(addBtn);
		rightPanel.add(resBtn);
		rightPanel.add(delBtn);
		rightPanel.add(findBtn);
		rightPanel.add(initBtn);

		add("North", topPanel);
		add("Center", centerPanel);
		add("East", rightPanel);

		setSize(620, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ProjectScreen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == addBtn) {
			addData();
		} else if (src == delBtn) {

		} else if (src == resBtn) {

		} else if (src == findBtn) {
			searchData();
		} else if (src == initBtn) {

		}

	}

	private void searchData() {
		// TODO Auto-generated method stub
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int allCnt = model.getRowCount();
		for (int i = 0; i < allCnt; i++) {
			model.removeRow(0);
		}

		int eNo = 0;
		int age = 0;
		if (fields[0].getText().equals("")) {
			eNo = 0;

		} else {
			eNo = Integer.parseInt(fields[0].getText());
		}

		if (fields[2].getText().equals("")) {
			age = 0;
		} else {
			age = Integer.parseInt(fields[2].getText());
		}
		String[] record = new String[5];
		
		list = pexe.userList(new Project(eNo, fields[1].getText(), age, fields[3].getText(), fields[4].getText()));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			record[0] = String.valueOf(list.get(i).getUserid());
			record[1] = list.get(i).getName();
			record[2] = String.valueOf(list.get(i).getAge());
			record[3] = list.get(i).getRank();
			record[4] = list.get(i).getJobid();
			model.addRow(record);
		}
	
		
	}

	private char[] valueof(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}

	private void addData() {
		// TODO Auto-generated method stub
		String[] records = new String[5];
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < fields.length; i++) {
			records[i] = fields[i].getText();
		}
		Project pj = new Project(Integer.parseInt(records[0]), records[1], Integer.parseInt(records[2]), records[3],
				records[4]);
		pexe.insert(pj);
		model.addRow(records);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
