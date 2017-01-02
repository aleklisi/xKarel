import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Compile extends JFrame {

	private JPanel contentPane;
	private File currentProgram;
	private int i = 0;

	/**
	 * Launch the application.
	 */
	public static void compileAndRun() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Compile frame = new Compile();
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
	public Compile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea output = new JTextArea();
		output.setBounds(20, 50, 500, 400);
		JScrollPane scrollPane = new JScrollPane(output, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVisible(true);
		/*
		 * contentPane.add(scrollPane); contentPane.add(consoleOut);
		 * //contentPane.add(scrollPane);
		 */
		output.setColumns(20);
		// consoleOut.setFont(new java.awt.Font("Tahoma", 0, 12));
		// consoleOut.setForeground(new java.awt.Color(0, 0, 255));
		output.setLineWrap(true);
		output.setWrapStyleWord(true);
		output.setRows(5);
		output.setEditable(true);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(output);
		contentPane.add(scrollPane);
		scrollPane.setBounds(20, 20, 500, 450);

		JButton btnCompile = new JButton("Compile");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				if (currentProgram != null) {
					clearOutput();
					if (compile(currentProgram.getName())) {
						answear();
						output.setText(i + answear() + "Compilation succeded!");
					} else {
						output.setText(i + answear() + "Compilation failed!");
					}
				}
			}
		});
		btnCompile.setBounds(634, 494, 140, 23);
		contentPane.add(btnCompile);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentProgram != null) {
					clearOutput();
					run(currentProgram.getName());
					output.setText(answear());
				}
			}
		});
		btnRun.setBounds(634, 528, 140, 23);
		contentPane.add(btnRun);

		/*
		 * JList list = new JList(); list.setBounds(634, 11, 140, 472);
		 * contentPane.add(list);
		 */

		JList list = new JList(getProgrames());
		list.setBounds(634, 11, 140, 430);
		contentPane.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JCheckBox stepByStep = new JCheckBox("Folow step by step");
		stepByStep.setBounds(634, 464, 133, 23);
		contentPane.add(stepByStep);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnClose.setBounds(505, 528, 111, 23);
		contentPane.add(btnClose);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					final List<File> selectedValuesList = list.getSelectedValuesList();
					currentProgram = selectedValuesList.get(0);
					// System.out.println(selectedValuesList.get(0).getName());
				}
			}
		});

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

	boolean compile(String programName) {
		Program p = new Program(programName);
		return p.compileProg();
	}

	void run(String programName) {
		Program p = new Program(programName);
		if (p.compileProg()) {
			p.runProg();
		}
	}
	private void clearOutput(){
		Envirement.consoleOutput = "";
	}
	private String answear(){
		return Envirement.consoleOutput;
	}
}
