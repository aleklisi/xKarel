import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.tools.Tool;
import javax.swing.ListSelectionModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class ProcedureCreator extends JFrame {
	private JPanel contentPane;
	private JTextField procName;
	private File currentFile;
	private File currentProgram;
	/**
	 * Launch the application.
	 */
	public static void procEdit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProcedureCreator frame = new ProcedureCreator();
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
	public ProcedureCreator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel programName = new JLabel("no program chosen");
		programName.setBounds(557, 304, 177, 14);
		contentPane.add(programName);

		JTextArea consoleOut = new JTextArea();
		consoleOut.setBounds(20, 50, 500, 400);
		JScrollPane scrollPane = new JScrollPane(consoleOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVisible(true);
		/*
		 * contentPane.add(scrollPane); contentPane.add(consoleOut);
		 * //contentPane.add(scrollPane);
		 */
		consoleOut.setColumns(20);
		// consoleOut.setFont(new java.awt.Font("Tahoma", 0, 12));
		// consoleOut.setForeground(new java.awt.Color(0, 0, 255));
		consoleOut.setLineWrap(true);
		consoleOut.setWrapStyleWord(true);
		consoleOut.setRows(5);
		consoleOut.setEditable(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(consoleOut);
		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 20, 500, 450);

		JList list = new JList(getProgrames());
		list.setBounds(557, 46, 199, 207);
		contentPane.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					final List<File> selectedValuesList = list.getSelectedValuesList();
					programName.setText(selectedValuesList.get(0).getName());
					currentProgram = selectedValuesList.get(0).getParentFile();
					// System.out.println(selectedValuesList.get(0).getName());

				}
			}
		});

		JLabel lblAviablePrograms = new JLabel("Aviable programs:");
		lblAviablePrograms.setBounds(557, 21, 199, 24);
		contentPane.add(lblAviablePrograms);

		procName = new JTextField();
		procName.setBounds(557, 376, 199, 33);
		contentPane.add(procName);
		procName.setColumns(10);

		JLabel lblNameYourProcedure = new JLabel("Name Your procedure:");
		lblNameYourProcedure.setBounds(557, 344, 199, 21);
		contentPane.add(lblNameYourProcedure);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(557, 463, 89, 23);
		contentPane.add(btnClose);

		JLabel lblYouAreCurrently = new JLabel("You are currently in program:");
		lblYouAreCurrently.setBounds(557, 281, 199, 14);
		contentPane.add(lblYouAreCurrently);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!programName.equals("no program chosen")) {
					if (!procName.getText().equals("")) {

						File toOpen = new File(
								list.getSelectedValuesList().get(0).toString() + "/" + procName.getText() + ".txt");
						currentFile = toOpen;
						if (!toOpen.exists()) {
							// System.out.println("file dosent exist");
							makeFile();
						}
						consoleOut.setText(readFile(toOpen));
					}
				}
			}
		});
		btnOpen.setBounds(557, 429, 89, 23);
		contentPane.add(btnOpen);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveFile(consoleOut.getText());
			}
		});
		btnSave.setBounds(656, 429, 89, 23);
		contentPane.add(btnSave);

		JButton Help = new JButton("Help");
		Help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWindow h = new HelpWindow();
				h.openHelpWindow();
			}
		});
		Help.setBounds(656, 463, 89, 23);
		contentPane.add(Help);
	}

	private Vector<File> getProgrames() {
		Vector<File> directories = new Vector<File>();

		File[] dirs = new File(".").listFiles(File::isDirectory);
		for (File f : dirs) {
			File g = new File(f.getName() + "/main.txt");
			if (g.exists()) {
				directories.add(f);
			}
		}
		return directories;
	}

	private String readFile(File file) {
		try {
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

	private Vector<File> getProcedures(File f) {
		Vector<File> procedures = new Vector<File>();

		File[] procs = f.listFiles();
		for (File proc : procs) {
			if (proc.getName().endsWith(".txt") && !proc.isDirectory()) {
				procedures.add(f);
			}
		}
		return procedures;
	}

	private void makeFile() {
		try {
			PrintWriter writer = new PrintWriter(currentFile.getPath(), "UTF-8");
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	private void saveFile(String newContent) {
		try {
			// System.out.println(newContent);
			PrintWriter writer = new PrintWriter(currentFile.getPath(), "UTF-8");
			writer.print(newContent);
			writer.close();
		} catch (IOException e) {
			// do something
		}
	}

	private boolean compile() {
		Proced p = new Proced(currentFile, null);
		if(p.compileProc() == -1){
			return true;
		}
		
		return false;
	}

}
