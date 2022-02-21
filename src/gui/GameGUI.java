package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GameController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblFirst;
	private JLabel lblSecond;
	
	
	private WindowManager windowManager;
	private GameController gameController;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGUI frame = new GameGUI();
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
	public GameGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(275, 283, 218, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblFirst = new JLabel("Placeholder first");
		lblFirst.setBounds(275, 251, 218, 23);
		contentPane.add(lblFirst);
		
		lblSecond = new JLabel("Placeholder second");
		lblSecond.setBounds(490, 251, 197, 23);
		contentPane.add(lblSecond);
		
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
		setLocationRelativeTo(null);
		
		init();
	}
	
	
	
	public void setFirst(String lbl) {
		lblFirst.setText(lbl);
	}
	
	private void init() {
		windowManager = new WindowManager();
		gameController = new GameController();
		//gameController.setLabelFirst();
	}
}
