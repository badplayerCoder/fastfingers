package gui;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Robot;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import controller.WordController;
import addon.Config;
import addon.WriteToFile;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WordGUI extends JFrame {

	private JPanel contentPane;
	private WindowManager windowManager;
	private Config config;
	private Robot robot;
	
	private JTextField wordField;
	private JLabel lblFeedback;
	private WordController wordController;
	private JLabel lblDisclaimer;
	private JLabel lblInfo;
	
	private WriteToFile writeFile;

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
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				writeFile.onClosed("Exiting Word GUI");
				windowManager.goMainMenu();
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 75, 23);
		contentPane.add(btnBack);
		
		lblInfo = new JLabel("Enter here, the word you want to add or remove");
		lblInfo.setBounds(229, 120, 272, 23);
		contentPane.add(lblInfo);
		
		wordField = new JTextField();
		wordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
					addNewWord();
					clearTextField();
				}
			}
		});
		wordField.setBounds(239, 155, 218, 23);
		contentPane.add(wordField);
		wordField.setColumns(10);
		
		//This is to set focus for wordField when WordGUI is opened
		addWindowListener(new WindowAdapter() {
		     public void windowOpened(WindowEvent e) {
		    	 wordField.requestFocus();
		     }
		});
		
		JButton btnAdd = new JButton("Add word");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				addNewWord();
				clearTextField();
			}
		});
		btnAdd.setBounds(291, 190, 116, 23);
		contentPane.add(btnAdd);
		
		lblFeedback = new JLabel("");
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeedback.setBounds(95, 225, 515, 23);
		contentPane.add(lblFeedback);
		
		lblDisclaimer = new JLabel("<html>Disclaimer: when adding words manually with this. The words are only temporarily in the system while the program is opened, when program is closed the added words will be removed again!");
		lblDisclaimer.setBounds(10, 322, 684, 44);
		contentPane.add(lblDisclaimer);
		
		init();
	}
	
	/*
	 * 	Goes through wordController to check & add new word given in wordField. This is being used by the button & wordField ENTER key
	 */
	
	private void addNewWord() {
		String s = wordField.getText();
		if(wordController.newWord(s)) {
			writeFile.writeWordToFile(s + " has been added");
			lblFeedback.setText("The word " + s.toUpperCase() + " has been added");
		}else {
			windowManager.goExistDialog(s);
			//lblFeedback.setText("The word " + s.toUpperCase() + " is already added");
		}
	}
	
	/*
	 * 	Clear the wordField when using keyboard to add words by pressing ENTER key
	 */
	
	private void clearTextField() {
//		Clears textfield
		wordField.setText(null);
		
		//	Uses robot to backspace in textfield to start at the beginning everytime
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	
	/*
	 * 	Does all the startup things to make it all work
	 */
	
	private void init() {
		config = new Config();
		config.printText("Init word gui called");
		windowManager = new WindowManager();
		wordController = new WordController();
		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writeFile = new WriteToFile();
		
		writeFile.onOpen("Word GUI started");
	}
}
