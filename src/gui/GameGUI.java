package gui;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Robot;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import addon.Config;
import addon.CreateFile;
import addon.Timer;
import addon.WriteToFile;
import controller.GameController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.event.KeyAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblFirst;
	private JLabel lblScore;
	
	private Robot robot;
	
	private WindowManager windowManager;
	private GameController gameController;
	private Config config;
	private WriteToFile writeFile;
	private CreateFile createFile;
	private Timer timer;
	
	//	Game variable
	private int startTime = 60; //Default as 60
	private boolean started = false; //Default as false
	private boolean open = false; //Default as false 
	private JLabel lblTimer;
	
	private ScheduledExecutorService scheduler;

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
					if(started) {
						//Do nothing
					}else {
						startTimer();
					}
					started = true;
					config.printText("space bar is pressed");
				}
			}
		});
		
		textField.setBounds(226, 216, 218, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		//	This is to set focus for textField when GameGUI is opened
		addWindowListener(new WindowAdapter() {
		     @Override
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
				writeFile.onClosed("Exiting Game GUI");
				windowManager.goMainMenu();
				canShutdown();
				setVisible(false);
			}
		});
		btnBack.setBounds(10, 11, 75, 23);
		contentPane.add(btnBack);
		
		lblScore = new JLabel("Placeholder Score");
		lblScore.setBounds(509, 18, 241, 67);
		contentPane.add(lblScore);
		
		lblTimer = new JLabel("1:00");
		lblTimer.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setBounds(445, 224, 61, 16);
		contentPane.add(lblTimer);
		setLocationRelativeTo(null);
		
		//Init method
		init();
	}
	
	
	/*
	 * 	Timer
	 */
	
	private void startTimer() {
		if(!started) {
			scheduler = Executors.newScheduledThreadPool(1);
		    final Runnable refresh = new Runnable() {
		            public void run() {
		                int amount = (gameController.getCorrect() + gameController.getWrong());
		                double accuracy = gameController.getProcent();
		                int right = gameController.getCorrect();
		                int wrong = gameController.getWrong();
		            	if(startTime == 0) {
		                	if(!open) {
		                		open = true;
		                		scheduler.shutdown();
		                		combineReset();
		                		windowManager.goResultDialog(amount, accuracy, right, wrong);
			                	System.out.println(startTime);
		                	}
		                }else {
		                	startTime--;
		                	updateTimer();
		                	System.out.println(startTime);
		                }
		            }
		};
		   scheduler.scheduleAtFixedRate(refresh, 0, 1,SECONDS);
		}else {
			System.out.println("Something went wrong!");
		}
	}
	
	/*
	 * 	Init controllers & managers in the class at startup
	 */
	
	private void init() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		windowManager = new WindowManager();
		gameController = new GameController();
		config = new Config();
		writeFile = new WriteToFile();
		createFile = new CreateFile();
		timer = new Timer();
		updateTimer();
		createFile.createWrongWordFile();
		
		writeFile.onOpen("Game GUI started");
		
		setup();
		scoreSetup();
	}
	
	private void updateTimer() {
		String txt = null;
		txt = timer.updateTimer(startTime);
		lblTimer.setText(txt);
	}
	
	/*
	 * 	Checks if scheduler can be shutdown or not
	 */
	
	private void canShutdown() {
		if(scheduler != null) {
			scheduler.shutdown();
		}
	}
	
	/*
	 * 	Combine methods to restart game
	 */
	
	private void combineReset() {
		doReset();
		clearTextField();
		resetScore();
		updateTimer();
	}
	
	/*
	 * 	Clears textField! Used when there is needed without checking word
	 */
	
	private void clearTextField() {
		//	Clears textfield
		textField.setText(null);
		
		//	Uses robot to backspace in textfield to start at the beginning everytime
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
	
	/*
	 * 	Method to hold game logic with the textfield
	 */
	
	private void gameTextFieldLogic() {
		if(gameController.checkTextBox(textField.getText())) {
			//	Moves words to new row
			gameController.moveTextToNewRow();
			
			//	Clears textfield
			textField.setText(null);
			
			//	Uses robot to backspace in textfield to start at the beginning everytime
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		    
			//	Updates labels & score
			updateLabel();
			scoreSetup();
			
			
		}else {
			String text = textField.getText();
			String right = gameController.getFirst();
			writeFile.writeWrongWordToFile(right,text);
			
			//	Moves words to new row
			gameController.moveTextToNewRow();
			
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
	 * 	Resets score when called
	 */
	
	private void scoreSetup() {
		String text = "<html>Correct: " + gameController.getCorrect() + "<br>Wrong: " + gameController.getWrong() + "<br>Accuracy: " + gameController.getProcent() + "%";
		
		lblScore.setText(text);
	}
	
	private void resetScore() {
		//Resets correct words
		gameController.setCorrect(0);
		//Resets wrong words
		gameController.setWrong(0);
		//Updates score
		scoreSetup();
	}
	
	/*
	 * 	Setters for game variables
	 */
	
	private void doReset() {
		startTime = 60; //Sets startTime to 60 seconds
		started = false; //Sets started to false
		open = false; //Sets open to false
	}
	
}
