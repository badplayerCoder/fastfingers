package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import addon.Tester;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private WindowManager windowManager;
	private Tester tester;

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
		
		init();
		runTest();
	}
	
	
	//	Init on startup
	private void init() {
		windowManager = new WindowManager();
	}
	
	private void runTest() {
		tester = new Tester();
	}
	
}
