import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BoardVisualization extends JFrame {
	private JTextField[][] allFields  = new JTextField [10][10];
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void seeHist() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardVisualization frame = new BoardVisualization();
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
	public BoardVisualization() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Next Action");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Envirement.b.showBoard();
			//	if(!Envirement.hist.IsEmpty()){
			//		Envirement.b = Envirement.hist.actionForeward();
				//}
				repaint();
				Envirement.b.showBoard();
			}
		});
		
		btnNewButton.setBounds(123, 528, 103, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("Help");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HelpWindow.openHelpWindow();
			}
		});
		button.setBounds(20, 528, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Previous Action");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Envirement.b.showBoard();
			//	if(!Envirement.hist.IsEmpty()){
			//		Envirement.b = Envirement.hist.actionBackward();
			//	}
				repaint();
				Envirement.b.showBoard();
			}
		});
		button_1.setBounds(236, 528, 107, 23);
		contentPane.add(button_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});
		btnClose.setBounds(361, 528, 118, 23);
		contentPane.add(btnClose);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				allFields[i][j] =  new JTextField(Envirement.b.getBoard()[i][j]);
				allFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				allFields[i][j].setBounds(30 + 50 * i, 30 + 50 * j, 40, 40);
				allFields[i][j].setText(Envirement.b.getBoard()[i][j] + "");
				if(i == Envirement.b.getCurrentPoz()[0] && j == Envirement.b.getCurrentPoz()[1]){
					allFields[i][j].setBackground(Color.GREEN);
				}else{
					allFields[i][j].setBackground(Color.GRAY);
				}
				contentPane.add(allFields[i][j]);
				allFields[i][j].setColumns(10);
				
			}
		}
	}
	private void rewrite(){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				/*allFields[i][j] = new JTextField(Envirement.b.getBoard()[i][j]);
				allFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				allFields[i][j].setBounds(30 + 50 * i, 30 + 50 * j, 40, 40);*/
				allFields[i][j].setText(Envirement.b.getBoard()[i][j] + "");
				if(i == Envirement.b.getCurrentPoz()[0] && j == Envirement.b.getCurrentPoz()[1]){
					allFields[i][j].setBackground(Color.GREEN);
				}else{
					allFields[i][j].setBackground(Color.GRAY);
				}
				contentPane.add(allFields[i][j]);				
			}
		}
	}
	
}

