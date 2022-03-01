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
import java.time.format.DateTimeFormatter;

import addon.Config;
import addon.CreateFile;
import addon.Tester;
import addon.WriteToFile;
import controller.WordController;
import database.DBWord;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	
	private WindowManager windowManager;
	private DBWord dbWord;
	private Robot robot;
	private Config config;
	private WordController wordController;
	
	private JTextField textField;
	private JLabel lblLang;
	private JLabel lblDisclaim;
	
	private CreateFile createFile;
	private WriteToFile writeFile;

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
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnWord = new JButton("Word Menu");
		btnWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				writeFile.onClosed("Exiting main menu");
				windowManager.goWordMenu();
				setVisible(false);
			}
		});
		btnWord.setBounds(170, 150, 120, 100);
		contentPane.add(btnWord);
		
		JButton btnGame = new JButton("Game Menu");
		btnGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(wordController.getAmountWords() == 0) {
					windowManager.goMainMenuDialog();
				}else {
					writeFile.onClosed("Exiting main menu");
					windowManager.goGameMenu();
					setVisible(false);
				}
			}
		});
		btnGame.setBounds(410, 150, 120, 100);
		contentPane.add(btnGame);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					
					textFieldLogic();
					
				}
			}
		});
		textField.setBounds(278, 66, 146, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblLang = new JLabel("Supported languages: danish & english");
		lblLang.setHorizontalAlignment(SwingConstants.CENTER);
		lblLang.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLang.setBounds(170, 41, 360, 23);
		contentPane.add(lblLang);
		
		lblDisclaim = new JLabel("Made by Lasse Haslund");
		lblDisclaim.setBounds(6, 350, 418, 16);
		contentPane.add(lblDisclaim);
		
		init();
	}
	
	private void textFieldLogic() {
		String stext = textField.getText();
		
		if(dbWord.pickLang(stext).equals(stext)) {
			if(dbWord.pickLang(stext).equals("help") || dbWord.pickLang(stext).equals("info")) {
				
				//	Clears textfield
				textField.setText(null);
				
				//	Uses robot to backspace in textfield to start at the beginning everytime
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
				lblLang.setText("Supported languages: danish & english");
				
			}else {
				//	Clears textfield
				textField.setText(null);
				
				//	Uses robot to backspace in textfield to start at the beginning everytime
				robot.keyPress(KeyEvent.VK_BACK_SPACE);
				robot.keyRelease(KeyEvent.VK_BACK_SPACE);
				
				lblLang.setText(stext + " has been activated with " + wordController.getAmountWords() + " different words");
			}
		}else{
			
			lblLang.setText(stext + " is not supported");
			
		}
	}
	
	//	Init on startup
	private void init() {
		windowManager = new WindowManager();
		wordController = new WordController();
		dbWord = new DBWord();
		config = new Config();
		createFile = new CreateFile();
		writeFile = new WriteToFile();
		try {
			robot = new Robot();
			createFile.createLogFile();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addDisclaim();
		writeFile.onOpen("Main menu started");
		writeFile.onOpen(addDisclaim());
	}
	
	private String addDisclaim() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
        String formatDateTime = config.now.format(format);  
		String ph = "Made by " + config.author + " - Version: " + config.version + " - " + formatDateTime;
		lblDisclaim.setText(ph);
		return formatDateTime;
	}
}
