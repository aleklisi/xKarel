import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class setRobot extends JFrame {

	private JPanel contentPane;
	private JTextField textX;
	private JTextField textY;
	private JTextField textB;
	private JTextField textD;

	/**
	 * Launch the application.
	 */
	public static void resetRobot() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setRobot frame = new setRobot();
					frame.setResizable(false);
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
	public setRobot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X:");
		lblX.setBounds(10, 11, 108, 14);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(10, 36, 108, 14);
		contentPane.add(lblY);

		JLabel lblBlocksOnTruck = new JLabel("Blocks on Truck:");
		lblBlocksOnTruck.setBounds(10, 61, 108, 14);
		contentPane.add(lblBlocksOnTruck);

		JLabel lblDirectionFacing = new JLabel("Direction facing:");
		lblDirectionFacing.setBounds(10, 90, 108, 14);
		contentPane.add(lblDirectionFacing);

		textX = new JTextField();
		textX.setBounds(128, 8, 86, 20);
		contentPane.add(textX);
		textX.setColumns(10);

		textY = new JTextField();
		textY.setBounds(128, 33, 86, 20);
		contentPane.add(textY);
		textY.setColumns(10);

		textB = new JTextField();
		textB.setBounds(128, 58, 86, 20);
		contentPane.add(textB);
		textB.setColumns(10);

		textD = new JTextField();
		textD.setBounds(128, 87, 86, 20);
		contentPane.add(textD);
		textD.setColumns(10);

		JButton btnNewButton = new JButton("Replace Robot");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(properInputData()){
					Envirement.b.setRobot(Integer.parseInt(textX.getText()), Integer.parseInt(textY.getText()), Integer.parseInt(textB.getText()), textD.getText().toString().charAt(0));
					System.out.println("robot replaced");
				}
			}
		});
		btnNewButton.setBounds(10, 133, 204, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Close Window");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(10, 167, 204, 23);
		contentPane.add(btnNewButton_1);
	}

	private boolean properInputData() {
		try {
			int x = Integer.parseInt(textX.getText());
			int y = Integer.parseInt(textY.getText());
			int b = Integer.parseInt(textB.getText());
			char d = textD.getText().toString().toUpperCase().charAt(0);
			if( 0 <= x && 0 <= y && x < 10 && y < 10 && b >= 0 && (d == 'N'|| d == 'E' ||  d == 'S' ||  d == 'W' ))
			return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
