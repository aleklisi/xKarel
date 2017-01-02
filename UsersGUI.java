import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.List;
import javax.swing.JLabel;
import java.awt.Checkbox;

public class UsersGUI extends JFrame {

	private JPanel contentPane;
	private JTextField consoleIn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersGUI frame = new UsersGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public UsersGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		consoleIn = new JTextField();
		consoleIn.setBounds(20, 500, 500, 50);
		contentPane.add(consoleIn);
		consoleIn.setColumns(10);
		
		
		
		JTextArea consoleOut = new JTextArea();
		consoleOut.setBounds(20, 50, 500, 400);
		JScrollPane scrollPane = new JScrollPane(consoleOut,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollPane.setVisible(true);
		/*contentPane.add(scrollPane);
		contentPane.add(consoleOut);
		//contentPane.add(scrollPane);*/
		consoleOut.setText("begin");
		consoleOut.setColumns(20);
		//consoleOut.setFont(new java.awt.Font("Tahoma", 0, 12));
		//consoleOut.setForeground(new java.awt.Color(0, 0, 255));
		consoleOut.setLineWrap(true);
		consoleOut.setWrapStyleWord(true);
		consoleOut.setRows(5);
		consoleOut.setEditable(false);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(consoleOut);
		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 20, 500, 450);
		
		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Move");
				consoleOut.setText(Envirement.consoleOutput);
			}
		});
		btnMove.setBounds(555, 427, 100, 23);
		contentPane.add(btnMove);
		
		JButton btnPut = new JButton("Put");
		btnPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Put");
				consoleOut.setText(Envirement.consoleOutput);
			}
		});
		btnPut.setBounds(555, 389, 100, 23);
		contentPane.add(btnPut);
		
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = consoleIn.getText();
				if(!s.equals("")){
					Envirement.action(s);
					consoleOut.setText(Envirement.consoleOutput);
				}
			}
		});
		Enter.setBounds(600, 500, 150, 50);
		contentPane.add(Enter);
		
		JButton btnTake = new JButton("Take");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Take");
				consoleOut.setText(Envirement.consoleOutput);
			}
		});
		btnTake.setBounds(661, 389, 100, 23);
		contentPane.add(btnTake);
		
		JButton btnTurnleft = new JButton("Turnleft");
		btnTurnleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Turnleft");
				consoleOut.setText(Envirement.consoleOutput);
			}
		});
		btnTurnleft.setBounds(661, 427, 100, 23);
		contentPane.add(btnTurnleft);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWindow h = new HelpWindow();
				h.openHelpWindow();
			}
		});
		btnHelp.setBounds(555, 349, 100, 23);
		contentPane.add(btnHelp);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(661, 349, 100, 23);
		contentPane.add(btnSave);
		
		JButton btnNewButton = new JButton("New program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramCreator p = new ProgramCreator();
				p.makeProg();
						
			}
		});
		btnNewButton.setBounds(555, 170, 206, 30);
		contentPane.add(btnNewButton);
		
		JButton newProc = new JButton("Porcedure Editor");
		newProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcedureCreator p = new ProcedureCreator();
				p.procEdit();
			}
		});
		newProc.setBounds(555, 210, 206, 30);
		contentPane.add(newProc);
		
		JButton runAndCompile = new JButton("Run and Compile ");
		runAndCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compile c = new Compile();
				c.compileAndRun();
			}
		});
		runAndCompile.setBounds(555, 250, 206, 30);
		contentPane.add(runAndCompile);
	}
	
}
