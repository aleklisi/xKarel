import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelpWindow extends JFrame {

	private JPanel contentPane;
	private JButton close;

	/**
	 * Launch the application.
	 */
	public static void openHelpWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpWindow frame = new HelpWindow();
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
	public HelpWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea consoleOut = new JTextArea();
		consoleOut.setBounds(20, 50, 500, 400);
		JScrollPane scrollPane = new JScrollPane(consoleOut,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollPane.setVisible(true);
		/*contentPane.add(scrollPane);
		contentPane.add(consoleOut);
		//contentPane.add(scrollPane);*/
		consoleOut.setText(help());
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
		scrollPane.setBounds(20, 20, 740, 500);
		
		close = new JButton("Close");
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		close.setBounds(30, 528, 89, 23);
		contentPane.add(close);
	}
	private String help(){
		try {
			File file = new File("help.txt");
			StringBuilder fileContents = new StringBuilder((int) file.length());
			Scanner scanner = new Scanner(file);
			String lineSeparator = System.getProperty("line.separator");
			while (scanner.hasNextLine()) {
				fileContents.append(scanner.nextLine() + lineSeparator);
			}
			scanner.close();
			return fileContents.toString();
		} catch (Exception e) {
			return "";
		}
	}
}
