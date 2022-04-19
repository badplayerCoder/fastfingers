package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;

public class ResultDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JLabel lblFeedback;
	private JLabel lblAccuary;
	private JLabel lblCorrect;
	private JLabel lblWrong;
	
	/**
	 * Create the dialog.
	 */
	public ResultDialog(int wpm, double accuracy, int right, int wrong) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lblFeedback = new JLabel("Feedback");
		lblFeedback.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setBounds(6, 6, 438, 32);
		contentPanel.add(lblFeedback);
		lblFeedback.setText(wpm + " WPM");
		
		lblAccuary = new JLabel("Feedback");
		lblAccuary.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAccuary.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccuary.setBounds(6, 39, 438, 22);
		contentPanel.add(lblAccuary);
		lblAccuary.setText("Accuracy: " + accuracy + "%");
		
		lblCorrect = new JLabel("Feedback");
		lblCorrect.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorrect.setBounds(6, 62, 438, 22);
		contentPanel.add(lblCorrect);
		lblCorrect.setText("Correct words: " + right);
			
		lblWrong = new JLabel("Feedback");
		lblWrong.setHorizontalTextPosition(SwingConstants.CENTER);
		lblWrong.setHorizontalAlignment(SwingConstants.CENTER);
		lblWrong.setBounds(6, 87, 438, 22);
		contentPanel.add(lblWrong);
		lblWrong.setText("Wrong words: " + wrong);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						disposeClientByKey(e);
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						disposeClient();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	private void disposeClient() {
		setVisible(false);
		dispose();
	}
	
	private void disposeClientByKey(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
			disposeClient();
		}
	}
}
