import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;

public class UsersGUI extends JFrame {

	private JPanel contentPane;
	private File currentProgram;
	private int i = 0;
	private DefaultListModel listModel = new DefaultListModel();
	private JLabel[][] fieldsOfBoard = new JLabel[10][10];

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
		setBounds(100, 100, 800, 600);
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
		btnHelp.setBounds(498, 243, 126, 23);
		contentPane.add(btnHelp);

		JButton btnNewButton = new JButton("Create New Program");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProgramCreator p = new ProgramCreator();
				p.makeProg();
			}
		});
		btnNewButton.setBounds(76, 11, 153, 23);
		contentPane.add(btnNewButton);

		JButton newProc = new JButton("Add & Create Procedure");
		newProc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcedureCreator p = new ProcedureCreator();
				p.procEdit();
			}
		});
		newProc.setBounds(261, 11, 180, 23);
		contentPane.add(newProc);

		JButton runAndCompile = new JButton("Compile and Run");
		runAndCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Compile c = new Compile();
				c.compileAndRun();
			}
		});
		runAndCompile.setBounds(462, 11, 162, 23);
		contentPane.add(runAndCompile);

		JList list = new JList(listModel);
		list.setBounds(634, 11, 140, 430);
		contentPane.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JButton btnClose = new JButton("Close Program");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				//setVisible(false);
			}
		});
		btnClose.setBounds(498, 528, 118, 23);
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

		JButton btnCompile = new JButton("Compile");
		btnCompile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				if (currentProgram != null) {
					clearOutput();
					if (compile(currentProgram.getName())) {
						answear();
						btnCompile.setBackground(Color.GREEN);
					} else {
						btnCompile.setBackground(Color.RED);
					}
				}
			}
		});
		btnCompile.setBounds(634, 486, 140, 23);
		contentPane.add(btnCompile);

		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currentProgram != null) {
					clearOutput();
					run(currentProgram.getName());
					refreshBoard();
					// output.setText(answear());
				}
			}
		});
		btnRun.setBounds(634, 528, 140, 23);
		contentPane.add(btnRun);

		JButton refresh = new JButton("Refresh List");
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listModel.clear();
				for (File prog : getProgrames())
					listModel.addElement(prog);
			}
		});
		refresh.setBounds(634, 452, 140, 23);
		contentPane.add(refresh);

		JButton setBlocks = new JButton("Blocks Editor");
		setBlocks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetBlocks.setBlocks();
			}
		});
		setBlocks.setBounds(498, 39, 126, 23);
		contentPane.add(setBlocks);
		
		JButton btnPut = new JButton("Put");
		btnPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Put");
				refreshBoard();
			}
		});
		btnPut.setBounds(498, 73, 126, 23);
		contentPane.add(btnPut);
		
		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Move");
				refreshBoard();
			}
		});
		btnMove.setBounds(498, 107, 126, 23);
		contentPane.add(btnMove);
		
		JButton btnTake = new JButton("Take");
		btnTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Take");
				refreshBoard();
			}
		});
		btnTake.setBounds(498, 141, 126, 23);
		contentPane.add(btnTake);
		
		JButton btnTurnleft = new JButton("Turnleft");
		btnTurnleft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.action("Turnleft");
				refreshBoard();
			}
		});
		btnTurnleft.setBounds(498, 175, 126, 23);
		contentPane.add(btnTurnleft);
		
		JButton btnRefreshBoard = new JButton("Refresh Board");
		btnRefreshBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshBoard();
			}
		});
		btnRefreshBoard.setBounds(498, 209, 126, 23);
		contentPane.add(btnRefreshBoard);
		
		JButton btnSetRobot = new JButton("Set Robot");
		btnSetRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setRobot.resetRobot();
			}
		});
		btnSetRobot.setBounds(498, 277, 126, 23);
		contentPane.add(btnSetRobot);
		
		JButton saveBoard = new JButton("Save Board");
		saveBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.hist.saveCurrentBoard(Envirement.b);
			}
		});
		saveBoard.setBounds(498, 311, 126, 23);
		contentPane.add(saveBoard);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Envirement.b.showBoard();
				Envirement.hist.actionForeward().showBoard();
			}
		});
		btnShow.setBounds(498, 402, 89, 23);
		contentPane.add(btnShow);
		
		JButton stepByStep = new JButton("See Prog Step \r\nBy Step");
		stepByStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.hist.setTmpBoarc(Envirement.b);
			}
		});
		stepByStep.setBounds(498, 345, 126, 23);
		contentPane.add(stepByStep);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JLabel f1 = new JLabel();
				f1.setText(Envirement.b.getBoard()[i][j] + "");
				f1.setBounds(50 * i, 50 * j + 60, 40, 40);
				f1.setOpaque(true);
				f1.setHorizontalAlignment(SwingConstants.CENTER);
				f1.setVerticalAlignment(SwingConstants.CENTER);
				contentPane.add(f1);
				fieldsOfBoard[i][j] = f1;
				
			}
		}
		refreshBoard();

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

	void refreshBoard() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				fieldsOfBoard[i][j].setText(Envirement.b.getBoard()[i][j] + "");
				if(i == Envirement.b.getCurrentPoz()[0] && j == Envirement.b.getCurrentPoz()[1]){
					fieldsOfBoard[i][j].setBackground(Color.GRAY);
				}else{
					fieldsOfBoard[i][j].setBackground(Color.GREEN);
				}
			}
		}

	}

	private boolean compile(String programName) {
		IProgram p = new Program(programName);
		return p.compileProg();
	}

	private void run(String programName) {
		IProgram p = new Program(programName);
		if (p.compileProg()) {
			p.runProg();
		}
	}

	private void clearOutput() {
		Envirement.consoleOutput = "";
	}

	private String answear() {
		return Envirement.consoleOutput;
	}
}
