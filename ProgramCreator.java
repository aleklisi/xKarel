import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class ProgramCreator extends JFrame {

	private JPanel contentPane;
	private JTextField programsName;

	/**
	 * Launch the application.
	 */
	public static void makeProg() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramCreator frame = new ProgramCreator();
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
	public ProgramCreator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel info = new JLabel("");
		info.setBounds(172, 103, 240, 50);
		contentPane.add(info);

		JLabel lblNewLabel = new JLabel("Program creator\n");
		lblNewLabel.setBounds(34, 22, 100, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Write your new program name:");
		lblNewLabel_1.setBounds(34, 60, 200, 14);
		contentPane.add(lblNewLabel_1);

		programsName = new JTextField();
		programsName.setBounds(34, 99, 115, 28);
		contentPane.add(programsName);
		programsName.setColumns(10);

		JButton create = new JButton("Create Program");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (makeNewProgram()) {
					setVisible(false);
				} else {
					info.setText("Can't make program. Rename it and try again.");
				}
			}
		});
		create.setBounds(10, 156, 133, 23);
		contentPane.add(create);
		
		JButton Close = new JButton("Close Window");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Close.setBounds(10, 190, 133, 23);
		contentPane.add(Close);

	}

	private boolean makeNewProgram() {

		try {
			String filename = programsName.getText();
			if (filename.equals("")) {
				return false;
			}
			File dir = new File(filename);
			if (dir.exists()) {
				return false;
			}
			dir.mkdir();
			PrintWriter writer = new PrintWriter(filename + "/main.txt", "UTF-8");
			writer.println("Move");
			writer.close();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
