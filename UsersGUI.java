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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsersGUI frame = new UsersGUI();
					frame.setVisible(true);
					frame.setResizable(false);
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
		setBounds(100, 100, 253, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWindow h = new HelpWindow();
				h.openHelpWindow();
			}
		});
		btnHelp.setBounds(10, 250, 206, 30);
		contentPane.add(btnHelp);
		
		JButton btnNewButton = new JButton("New program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramCreator p = new ProgramCreator();
				p.makeProg();						
			}
		});
		btnNewButton.setBounds(10, 40, 206, 30);
		contentPane.add(btnNewButton);
		
		JButton newProc = new JButton("Porcedure Editor");
		newProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcedureCreator p = new ProcedureCreator();
				p.procEdit();
			}
		});
		newProc.setBounds(10, 100, 206, 30);
		contentPane.add(newProc);
		
		JButton runAndCompile = new JButton("Run and Compile ");
		runAndCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compile c = new Compile();
				c.compileAndRun();
			}
		});
		runAndCompile.setBounds(10, 150, 206, 30);
		contentPane.add(runAndCompile);
		
		JButton btnNewButton_1 = new JButton("Program Step By Step");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardVisualization.seeHist();
			}
		});
		btnNewButton_1.setBounds(10, 200, 206, 30);
		contentPane.add(btnNewButton_1);
	}
	
}
