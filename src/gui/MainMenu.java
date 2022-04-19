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
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;

import addon.Config;
import addon.CreateFile;
import addon.WriteToFile;
import controller.TerminalController;
import controller.TerminalControllerIF;
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
	private JLabel lblTerminalFeedback;

	private CreateFile createFile;
	private WriteToFile writeFile;
	private JTextField terminalBox;

	private TerminalControllerIF terminalController;

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
		setResizable(false);

		
		
		JButton btnWord = new JButton("Word Menu");
		btnWord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				writeFile.onClosed("Exiting main menu");
				windowManager.goWordMenu();
				setVisible(false);
				dispose();
			}
		});
		btnWord.setBounds(170, 150, 120, 100);
		contentPane.add(btnWord);

		JButton btnGame = new JButton("Start Game");
		btnGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (wordController.getAmountWords() == 0) {
					windowManager.goMainMenuDialog();
				} else {
					writeFile.onClosed("Exiting main menu");
					try {
						windowManager.goGameMenu();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					setVisible(false);
					dispose();
				}
			}
		});
		btnGame.setBounds(410, 150, 120, 100);
		contentPane.add(btnGame);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

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

		JLabel lblTerminal = new JLabel("Terminal");
		lblTerminal.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTerminal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminal.setBounds(547, 321, 147, 16);
		contentPane.add(lblTerminal);

		terminalBox = new JTextField();
		terminalBox.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String txt = null;
					txt = terminalBox.getText().toLowerCase();
					terminalController.terminalExecute(txt);
				}
			}
		});
		terminalBox.setColumns(10);
		terminalBox.setBounds(548, 335, 146, 31);
		contentPane.add(terminalBox);

		lblTerminalFeedback = new JLabel("");
		lblTerminalFeedback.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTerminalFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblTerminalFeedback.setBounds(547, 293, 147, 16);
		contentPane.add(lblTerminalFeedback);

		init();
	}

	/**
	 * textFieldLogic check if the given data in the textField input is equals to
	 * some keyword in the system
	 */

	private void textFieldLogic() {
		String stext = textField.getText();

		if (dbWord.pickLang(stext).equals(stext)) {
			if (dbWord.pickLang(stext).equals("help") || dbWord.pickLang(stext).equals("info")) {

				clearBoxAndChangeLabel("Supported languages: danish & english");

			} else if (dbWord.pickLang(stext).equals("empty") || dbWord.pickLang(stext).equals("drop")) {
				clearBoxAndChangeLabel("The word database is now " + stext);
			} else {
				if (stext.equals("")) {
					lblLang.setText("Textfield is empty! Do 'help' or 'info'!");
				} else {
					clearBoxAndChangeLabel(
							stext + " has been activated with " + wordController.getAmountWords() + " different words");
				}
			}
		} else {

			lblLang.setText(stext + " is not supported");

		}
	}

	// Init on startup
	private void init() {
		windowManager = new WindowManager();
		wordController = new WordController();
		dbWord = new DBWord();
		config = new Config();
		createFile = new CreateFile();
		writeFile = new WriteToFile();
		terminalController = new TerminalController(this);
		try {
			robot = new Robot();
			createFile.createLogFile();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		addDisclaim();
		writeFile.onOpen("Main menu started");
		writeFile.onOpen(addDisclaim());
	}

	public void clearTerminal() {
		// Clears textfield
		terminalBox.setText(null);

		// Uses robot to backspace in textfield to start at the beginning everytime
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	private void clearBoxAndChangeLabel(String text) {
		// Clears textfield
		textField.setText(null);

		// Uses robot to backspace in textfield to start at the beginning everytime
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);

		String txt = null;
		txt = "<html>" + text;

		lblLang.setText(txt);
	}

	public void changeTerminalFeedback(String text) {
		lblTerminalFeedback.setText(text);
	}

	/**
	 * Adds disclaim to the main menu at startup
	 * 
	 * @return formatDateTime as string to display the time when program is opened
	 */

	private String addDisclaim() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String formatDateTime = config.now.format(format);
		String ph = "Made by " + config.author + " - Version: " + config.version + " - " + formatDateTime;
		lblDisclaim.setText(ph);
		return formatDateTime;
	}
}
