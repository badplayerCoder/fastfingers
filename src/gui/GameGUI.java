package gui;

import java.awt.AWTException;
import java.awt.EventQueue;
import java.awt.Robot;
import static java.util.concurrent.TimeUnit.SECONDS;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import addon.Config;
import addon.CreateFile;
import addon.Highscore;
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
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.awt.event.KeyAdapter;
import javax.swing.SwingConstants;

/**
 * 
 * @author lassehas
 */

public class GameGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblFirst;
	private JLabel lblScore;
	private JLabel lblBestWPM;
	private JLabel lblHighscore;

	private Robot robot;

	private WindowManager windowManager;
	private GameController gameController;
	private Config config;
	private WriteToFile writeFile;
	private Timer timer;
	private HighscoreIF highScore;

	// Game variable
	private int startTime = 60; // Default as 60
	private boolean started = false; // Default as false
	private boolean open = false; // Default as false
	private JLabel lblTimer; // Holds the label for timer to be updated

	private ScheduledExecutorService scheduler;

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public GameGUI() throws FileNotFoundException {
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
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					gameTextFieldLogic();
					if (!started) {
						startTimer();
					}
					started = true;
					config.printText("space bar is pressed");
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					exitGameGUI();
				}
			}
		});

		textField.setBounds(226, 216, 218, 32);
		contentPane.add(textField);
		textField.setColumns(10);

		// This is to set focus for textField when GameGUI is opened
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
				exitGameGUI();
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

		lblHighscore = new JLabel("HIGHSCORE");
		lblHighscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblHighscore.setBounds(32, 126, 138, 23);
		contentPane.add(lblHighscore);

		lblBestWPM = new JLabel("");
		lblBestWPM.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestWPM.setBounds(57, 149, 90, 23);
		contentPane.add(lblBestWPM);
		setLocationRelativeTo(null);

		// Init method
		init();
	}

	/**
	 * The whole timer code for game GUI. Uses int startTime & boolean open in 'if
	 * statements'
	 */

	private void startTimer() {
		// TODO Check if the code can be more eff
		if (!started) {
			scheduler = Executors.newScheduledThreadPool(1);
			final Runnable refresh = new Runnable() {
				public void run() {

					double accuracy = gameController.getProcent();
					int right = gameController.getCorrect();
					int wrong = gameController.getWrong();
					int amount = (right + wrong);

					if (startTime == 0) {
						if (!open) {
							open = true;
							writeFile.writeHighScoreToFile(right);
							windowManager.goResultDialog(amount, accuracy, right, wrong);
							combineReset();
							wholeHighscore();
							config.printInt(startTime);
							scheduler.shutdown();
						}
					} else {
						startTime--;
						updateTimer();
						config.printInt(startTime);
					}
				}
			};
			scheduler.scheduleAtFixedRate(refresh, 0, 1, SECONDS);
		} else {
			System.out.println("Something went wrong!");
		}
	}

	/**
	 * Init controllers & managers in the class at startup. Writes status to the log
	 * file
	 * 
	 * @throws FileNotFoundException
	 */

	private void init() throws FileNotFoundException {

		highScore = new Highscore();
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		windowManager = new WindowManager();
		gameController = new GameController();
		config = new Config();
		writeFile = new WriteToFile();
		CreateFile createFile = new CreateFile();
		timer = new Timer();

		updateTimer();
		createFile.createWrongWordFile();
		createFile.createHighScore();

		writeFile.onOpen("Game GUI started");

		setupLabel();
		setupScore();
		setupHighScore();
	}

	/**
	 * Updates the timer on gui when called
	 */

	private void updateTimer() {
		String txt = null;
		txt = timer.updateTimer(startTime);
		lblTimer.setText(txt);
	}

	/**
	 * Updates highscore
	 */

	private void setupHighScore() {
		try {
			highScore.setHighscore();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		updateHighscore();
	}

	private void wholeHighscore() {
		int current = highScore.getTop();
		try {
			highScore.setHighscore();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		checkHighscore(current);
	}

	private void checkHighscore(int current) {

		if (highScore.getTop() > current) {
			lblHighscore.setText("NEW HIGHSCORE!");
			updateHighscore();
			System.out.println("IF");
		} else {
			lblHighscore.setText("HIGHSCORE");
			System.out.println("Else");
		}
	}

	private void updateHighscore() {
		String correct = null;
		correct = highScore.getTop() + " Correct";
		lblBestWPM.setText(correct);
	}

	/**
	 * Exit GameGUI method by setvisible to false & dispose the gui
	 */

	private void exitGameGUI() {
		writeFile.onClosed("Exiting Game GUI");
		windowManager.goMainMenu();
		canShutdown();
		setVisible(false);
		dispose();
	}

	/**
	 * Checks if scheduler can be shutdown or not
	 */

	private void canShutdown() {
		// Checks if scheduler not null, if so it will run shutdown
		if (scheduler != null) {
			scheduler.shutdown();
			dispose();
		}
	}

	/**
	 * Combine all the methods needed to restart game
	 */

	private void combineReset() {
		doReset();
		clearTextField();
		resetScore();
		updateTimer();
	}

	/**
	 * Clears textField! Used when there is needed without checking word
	 */

	private void clearTextField() {
		// Clears textfield
		textField.setText(null);

		// Uses robot to backspace in textfield to start at the beginning everytime
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	/**
	 * Logic behind the textField. Checks if the word in textField is equals to
	 * lblFirst in the gameController
	 */

	private void gameTextFieldLogic() {
		if (gameController.checkTextBox(textField.getText())) {
			// Moves words to new row
			gameController.moveTextToNewRow();

			// Clears textfield
			textField.setText(null);

			// Uses robot to backspace in textfield to start at the beginning everytime
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);

			// Updates labels & score
			updateLabel();
			setupScore();

		} else {
			String text = textField.getText();
			String right = gameController.getFirst();
			writeFile.writeWrongWordToFile(right, text);

			// Moves words to new row
			gameController.moveTextToNewRow();

			// Clears textfield
			textField.setText(null);

			// Uses robot to backspace in textfield to start at the beginning everytime
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);

			// Updates labels & score
			updateLabel();
			setupScore();
		}
	}

	/**
	 * Updates words & what place the words are in the label
	 */

	private void updateLabel() {
		String text = null;
		text = gameController.updateLabel();
		lblFirst.setText(text);
	}

	/**
	 * Setups at startup words in the label place
	 */

	private void setupLabel() {
		String text = null;
		text = gameController.setupLabel();
		lblFirst.setText(text);
	}

	/*
	 * Setups score at startup & also being used to update score Resets score when
	 * called
	 */

	private void setupScore() {
		String text = null;
		text = gameController.setupScore();
		lblScore.setText(text);
	}

	/**
	 * Resets score & updates the display
	 */

	private void resetScore() {
		// Resets score
		gameController.resetScore();
		// Updates score
		setupScore();
	}

	/**
	 * Resets the game variables to default
	 */

	private void doReset() {
		startTime = 60; // Sets startTime to 60 seconds
		started = false; // Sets started to false
		open = false; // Sets open to false
	}
}
