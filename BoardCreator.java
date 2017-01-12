
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class BoardCreator extends JFrame {

	private JTextField[][] allFields = new JTextField[10][10];
	private JPanel contentPane;
	private JTextField robotsX;
	private JTextField robotsY;
	private JTextField numberOfBlocks;
	private JTextField direction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoardCreator frame = new BoardCreator();
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
	public BoardCreator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		robotsX = new JTextField();
		robotsX.setBounds(583, 22, 86, 20);
		contentPane.add(robotsX);
		robotsX.setColumns(10);

		robotsY = new JTextField();
		robotsY.setBounds(583, 53, 86, 20);
		contentPane.add(robotsY);
		robotsY.setColumns(10);

		numberOfBlocks = new JTextField();
		numberOfBlocks.setBounds(583, 165, 86, 20);
		contentPane.add(numberOfBlocks);
		numberOfBlocks.setColumns(10);

		JLabel lblX = new JLabel("Y:");
		lblX.setBounds(555, 56, 49, 14);
		contentPane.add(lblX);

		JLabel label = new JLabel("X:");
		label.setBounds(555, 25, 49, 14);
		contentPane.add(label);

		JLabel lblBlocksOnTruck = new JLabel("Blocks on Truck:");
		lblBlocksOnTruck.setBounds(583, 140, 104, 14);
		contentPane.add(lblBlocksOnTruck);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				allFields[i][j] = new JTextField(Envirement.b.getBoard()[i][j]);
				allFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				allFields[i][j].setBounds(30 + 50 * i, 30 + 50 * j, 40, 40);
				allFields[i][j].setText(Envirement.b.getBoard()[i][j] + "");
				if (i == Envirement.b.getCurrentPoz()[0] && j == Envirement.b.getCurrentPoz()[1]) {
					allFields[i][j].setBackground(Color.GREEN);
				} else {
					allFields[i][j].setBackground(Color.GRAY);
				}
				contentPane.add(allFields[i][j]);
				allFields[i][j].setColumns(10);

			}
		}

		JButton addRobot = new JButton("Add Robot");
		addRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Envirement.b.
			}
		});
		addRobot.setBounds(583, 196, 89, 23);
		contentPane.add(addRobot);

		JButton addBlock = new JButton("Add Block");
		addBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (addBlockPossible()) {
					Envirement.b.addBlock(Integer.parseInt(robotsX.toString()), Integer.parseInt(robotsY.toString()));
				}
			}
		});
		addBlock.setBounds(583, 230, 89, 23);
		contentPane.add(addBlock);

		JLabel lblDirection = new JLabel("Direction:");
		lblDirection.setBounds(582, 84, 70, 14);
		contentPane.add(lblDirection);

		direction = new JTextField();
		direction.setBounds(583, 109, 86, 20);
		contentPane.add(direction);
		direction.setColumns(10);
		
		JButton take = new JButton("Take Block");
		take.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(takeBlockPossible()){
					Envirement.b.takeBlock(Integer.parseInt(robotsX.toString()), Integer.parseInt(robotsY.toString()));
				}
			}
		});
		take.setBounds(583, 264, 89, 23);
		contentPane.add(take);

	}

	private boolean addBlockPossible() {
		try {
			int x = Integer.parseInt(robotsX.toString());
			int y = Integer.parseInt(robotsY.toString());
			if (0 <= x && x < Envirement.b.boardSize() && 0 <= y && y < Envirement.b.boardSize()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean takeBlockPossible() {
		try {
			int x = Integer.parseInt(robotsX.toString());
			int y = Integer.parseInt(robotsY.toString());
			if (0 <= x && x < Envirement.b.boardSize() && 0 <= y && y < Envirement.b.boardSize()) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean addRobotPossible() {
		try {
			int x = Integer.parseInt(robotsX.toString());
			int y = Integer.parseInt(robotsY.toString());
			int b = Integer.parseInt(numberOfBlocks.toString());
			if (0 <= x && x < Envirement.b.boardSize() && 0 <= y && y < Envirement.b.boardSize() && b > 0) {
				if (properDirection()) {
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	private boolean properDirection() {
		try {
			if (direction.toString().length() == 1 && direction.toString().charAt(0) == 'N'
					&& direction.toString().charAt(0) == 'W' && direction.toString().charAt(0) == 'E'
					&& direction.toString().charAt(0) == 'S') {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}
}
