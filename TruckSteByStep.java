import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument.ElementEdit;


public class TruckSteByStep extends JFrame {

	private JPanel contentPane;
	private int i = 0;
	private JLabel[][] fieldsOfBoard = new JLabel[10][10];
	/**
	 * Launch the application.
	 */
	public static void truck() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TruckSteByStep frame = new TruckSteByStep();
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
	public TruckSteByStep() {
		Envirement.hist.uploadHist();
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
		btnHelp.setBounds(648, 460, 126, 23);
		contentPane.add(btnHelp);

		JButton btnClose = new JButton("Close Window");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//s = 
				setVisible(false);
			}
		});
		btnClose.setBounds(648, 528, 126, 23);
		contentPane.add(btnClose);
		
		JButton btnRefreshBoard = new JButton("Refresh Board");
		btnRefreshBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshBoard();
			}
		});
		btnRefreshBoard.setBounds(648, 494, 126, 23);
		contentPane.add(btnRefreshBoard);
		
		JButton ShowCurrentBoard = new JButton("Show Current Board");
		ShowCurrentBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("initial:");
				Envirement.hist.getInitialBoard().showBoard();
				System.out.println("current:");
				Envirement.hist.getCurrentBoard().showBoard();
				System.out.println("final:");
				Envirement.hist.getFinalBoard().showBoard();
				IBoard tmp = Envirement.cp(Envirement.b);
				Envirement.b = Envirement.cp(Envirement.hist.getCurrentBoard());
				refreshBoard();
				Envirement.b = tmp;
			}
		});
		ShowCurrentBoard.setBounds(609, 35, 165, 23);
		contentPane.add(ShowCurrentBoard);
		
		JButton ShowInitialBoard = new JButton("Show Initial Board");
		ShowInitialBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBoard tmp = Envirement.cp(Envirement.b);
				Envirement.b = Envirement.cp(Envirement.hist.getInitialBoard());
				refreshBoard();
				Envirement.b = tmp;
			}
		});
		ShowInitialBoard.setBounds(609, 69, 165, 23);
		contentPane.add(ShowInitialBoard);
		
		JButton ShowFinalBoard = new JButton("Show Final Board");
		ShowFinalBoard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IBoard tmp = Envirement.cp(Envirement.b);
				Envirement.b = Envirement.cp(Envirement.hist.getFinalBoard());
				refreshBoard();
				Envirement.b = tmp;
			}
		});
		ShowFinalBoard.setBounds(609, 106, 165, 23);
		contentPane.add(ShowFinalBoard);
		
		JButton btnNextStep = new JButton("Next Step");
		btnNextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.hist.actionForeward();
				IBoard tmp = Envirement.cp(Envirement.b);
				Envirement.b = Envirement.cp(Envirement.hist.getCurrentBoard());
				refreshBoard();
				Envirement.b = tmp;
			}
		});
		btnNextStep.setBounds(609, 140, 165, 23);
		contentPane.add(btnNextStep);
		
		JButton btnResetProgram = new JButton("Reset Program");
		btnResetProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.hist.restCouner();
				Envirement.hist.setCurrentBoard(Envirement.hist.getInitialBoard());
				IBoard tmp = Envirement.cp(Envirement.b);
				Envirement.b = Envirement.cp(Envirement.hist.getCurrentBoard());
				refreshBoard();
				Envirement.b = tmp;
			}
		});
		btnResetProgram.setBounds(609, 174, 165, 23);
		contentPane.add(btnResetProgram);
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
}
