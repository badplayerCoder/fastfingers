package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import addon.Commands;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CommandDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblCommands;
	private Commands cmds;

	/**
	 * Create the dialog.
	 */
	public CommandDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		lblCommands = new JLabel("");
		lblCommands.setHorizontalAlignment(SwingConstants.CENTER);
		lblCommands.setBounds(6, 6, 438, 221);
		contentPanel.add(lblCommands);
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
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}

		lblCommands.setText(postCommands());
	}
	
	private String postCommands() {
		String cmdTxt = "<html>";
		cmdTxt += "clearhighscore <br>";
		cmdTxt += "clearlog <br>";
		cmdTxt += "clearwrong <br>";
		cmdTxt += "debugtrue <br>";
		cmdTxt += "openfolder <br>";
		cmdTxt += "openhighscore <br>";
		cmdTxt += "openlog <br>";
		cmdTxt += "openwrong <br>";
		
		return cmdTxt;
	}
}
