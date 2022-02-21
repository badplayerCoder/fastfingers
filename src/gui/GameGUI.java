package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import addon.Config;
import controller.GameController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblFirst;
	private JLabel lblSecond;
	
	private Robot robot;
	
	
	private WindowManager windowManager;
	private GameController gameController;
	private Config config;
	

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
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					if(gameController.checkTextBox(textField.getText())) {
						
						textField.setText(null);
						robot.keyPress(KeyEvent.VK_BACK_SPACE);
						robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					    
						updateLabel();
						//textField.setText(null);
						//String text = textField.getText().trim().strip();
						//textField.setText(text);
						
						
					}
					config.printText("space bar is pressed");
				}
			}
		});
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
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		windowManager = new WindowManager();
		gameController = new GameController();
		config = new Config();
		
		setup();
	}
	
	private void updateLabel() {
		lblFirst.setText(gameController.getFirst());
		lblSecond.setText(gameController.getSecond());
	}
	
	private void setup() {
		lblFirst.setText(gameController.setLabelFirst());
		lblSecond.setText(gameController.setLabelSecond());
	}
	
}
