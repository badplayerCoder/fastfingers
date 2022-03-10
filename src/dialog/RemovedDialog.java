package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import addon.Placeholder;
import gui.WindowManager;
import gui.WordGUI;
import gui.WordGUIIF;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RemovedDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblFeedback;
	
	private WordGUI gui;

	/**
	 * Create the dialog.
	 * @param text	the word sent 
	 */
	public RemovedDialog(String text, WordGUI gui) {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		this.gui = gui;
		
		lblFeedback = new JLabel("Feedback");
		lblFeedback.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setBounds(6, 44, 438, 28);
		contentPanel.add(lblFeedback);
		
		lblFeedback.setText(text.toUpperCase() + " has been removed!");
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						setVisible(false);
						dispose();
						gui.setFeedbackRemove(text);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		
		
	}
}
