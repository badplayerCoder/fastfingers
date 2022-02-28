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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblFirst;
	private JLabel lblScore;
	
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
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_SPACE) {
					
					gameTextFieldLogic();
					config.printText("space bar is pressed");
				}
			}
		});
		
		textField.setBounds(226, 216, 218, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//	This is to set focus for textField when GameGUI is opened
		addWindowListener(new WindowAdapter() {
		     public void windowOpened(WindowEvent e) {
		    	 textField.requestFocus();
		     }
		});
		
		lblFirst = new JLabel("Placeholder first");
		lblFirst.setBounds(230, 188, 220, 30);
		contentPane.add(lblFirst);
		
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
		
		lblScore = new JLabel("Placeholder Score");
		lblScore.setBounds(509, 18, 241, 67);
		contentPane.add(lblScore);
		setLocationRelativeTo(null);
		
		//Init method
		init();
	}
	
	/*
	 * 	Init controllers & managers in the class at startup
	 */
	
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
		scoreSetup();
	}
	
	/*
	 * 	Method to hold game logic with the textfield
	 */
	
	private void gameTextFieldLogic() {
		if(gameController.checkTextBox(textField.getText())) {
			
			//	Clears textfield
			textField.setText(null);
			
			//	Uses robot to backspace in textfield to start at the beginning everytime
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		    
			//	Updates labels & score
			updateLabel();
			scoreSetup();
			
			
		}else {
			//	Clears textfield
			textField.setText(null);
			
			//	Uses robot to backspace in textfield to start at the beginning everytime
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			
			//	Updates labels & score
			updateLabel();
			scoreSetup();
		}
	}
	
	/*
	 * 	Updates words & what place the words are in the label
	 */
	
	private void updateLabel() {
		String text = "<html>" + gameController.getFirst() + " " + gameController.getSecond() + " " + gameController.getThird() + " " + gameController.getFourth();
		lblFirst.setText(text);
	}
	
	/*
	 * 	Setups at startup words in the label place
	 */
	
	private void setup() {
		String text = "<html>" + gameController.setLabelFirst() + " " + gameController.setLabelSecond() + " " + gameController.setLabelThird() + " " + gameController.setLabelFourth();
		lblFirst.setText(text);
	}
	
	/*
	 * 	Setups score at startup & also being used to update score 
	 */
	
	private void scoreSetup() {
		String procent = Double.toString(Math.floor(gameController.getProcent()));
		String text = "<html>Correct: " + gameController.getCorrect() + "<br>Wrong: " + gameController.getWrong() + "<br>Accuracy: " + procent + "%";
		
		lblScore.setText(text);
	}
}
