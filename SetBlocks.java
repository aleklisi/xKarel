import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SetBlocks extends JFrame {

	private JPanel contentPane;
	private JTextField textX;
	private JTextField textY;
	private JTextField textB;

	/**
	 * Launch the application.
	 */
	public static void setBlocks() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetBlocks frame = new SetBlocks();
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
	public SetBlocks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 250, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblX = new JLabel("X:");
		lblX.setBounds(10, 11, 96, 19);
		contentPane.add(lblX);

		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(10, 41, 96, 14);
		contentPane.add(lblY);

		JLabel lblNumberOfBlocks = new JLabel("Number of Blocks:");
		lblNumberOfBlocks.setBounds(10, 66, 106, 19);
		contentPane.add(lblNumberOfBlocks);

		textX = new JTextField();
		textX.setBounds(116, 10, 86, 20);
		contentPane.add(textX);
		textX.setColumns(10);

		textY = new JTextField();
		textY.setBounds(116, 38, 86, 20);
		contentPane.add(textY);
		textY.setColumns(10);

		textB = new JTextField();
		textB.setBounds(116, 65, 86, 20);
		contentPane.add(textB);
		textB.setColumns(10);

		JButton Close = new JButton("Close Window");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		Close.setBounds(10, 128, 192, 23);
		contentPane.add(Close);

		JButton btnAdd = new JButton("Set Number of Block(s)");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (properInputData()) {
					Envirement.b.setNumberOfBlocks(Integer.parseInt(textX.getText()),
							Integer.parseInt(textY.getText()), Integer.parseInt(textB.getText()));
					System.out.println("block added");	
					
				}
			}
		});
		btnAdd.setBounds(10, 96, 192, 23);
		contentPane.add(btnAdd);
	}

	boolean properInputData() {
		try {
			//System.out.println(textX.getText() + "" + textY.getText() + "" + textB.getText());
			Integer.parseInt(textX.getText());
			Integer.parseInt(textY.getText());
			Integer.parseInt(textB.getText());
			System.out.println(textX.getText() + "" + textY.getText() + "" + textB.getText());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
