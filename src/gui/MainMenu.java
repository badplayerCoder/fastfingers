package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import addon.Tester;
import database.DBWord;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private WindowManager windowManager;
	private DBWord dbWord;
	private Robot robot;
	
	private JTextField textField;
	private JLabel lblLang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnWord = new JButton("Word Menu");
		btnWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				windowManager.goWordMenu();
				setVisible(false);
			}
		});
		btnWord.setBounds(212, 210, 120, 100);
		contentPane.add(btnWord);
		
		JButton btnGame = new JButton("Game Menu");
		btnGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				windowManager.goGameMenu();
				setVisible(false);
			}
		});
		btnGame.setBounds(416, 210, 120, 100);
		contentPane.add(btnGame);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					String stext = textField.getText();
					
					if(dbWord.pickLang(stext).equals(stext)) {
						//	Clears textfield
						textField.setText(null);
						
						//	Uses robot to backspace in textfield to start at the beginning everytime
						robot.keyPress(KeyEvent.VK_BACK_SPACE);
						robot.keyRelease(KeyEvent.VK_BACK_SPACE);
					}
				}
			}
		});
		textField.setBounds(307, 46, 146, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblLang = new JLabel("Supported lang: danish & english");
		lblLang.setBounds(268, 19, 228, 23);
		contentPane.add(lblLang);
		
		init();
	}
	
	
	//	Init on startup
	private void init() {
		windowManager = new WindowManager();
		dbWord = new DBWord();
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
