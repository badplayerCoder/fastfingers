package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.WordController;

public class WordGUI extends JFrame {

	private JPanel contentPane;
	private WindowManager windowManager;
	private JTextField wordField;
	private WordController wordController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WordGUI frame = new WordGUI();
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
	public WordGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				windowManager.goMainMenu();
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 75, 23);
		contentPane.add(btnBack);
		
		JLabel lblInfo = new JLabel("Enter here, the word you want to add");
		lblInfo.setBounds(275, 251, 218, 23);
		contentPane.add(lblInfo);
		
		wordField = new JTextField();
		wordField.setBounds(275, 283, 218, 23);
		contentPane.add(wordField);
		wordField.setColumns(10);
		
		JButton btnAdd = new JButton("Add word");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println(wordController.findWord(wordField.getText()));
				String s = wordField.getText();
				System.out.println(s);
				wordController.newWord(s);
			}
		});
		btnAdd.setBounds(322, 317, 116, 23);
		contentPane.add(btnAdd);
		
		init();
	}
	
	private void init() {
		windowManager = new WindowManager();
		wordController = new WordController();
	}
}
