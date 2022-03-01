package dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.WordController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExistDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JLabel lblFeedback;
	
	private WordController wordController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ExistDialog dialog = new ExistDialog("Feedback");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ExistDialog(String text) {
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setLocationRelativeTo(null);
		
		lblFeedback = new JLabel("Feedback");
		lblFeedback.setHorizontalTextPosition(SwingConstants.CENTER);
		lblFeedback.setHorizontalAlignment(SwingConstants.CENTER);
		lblFeedback.setBounds(6, 44, 438, 28);
		
		lblFeedback.setText(text.toUpperCase() + " is already added. How do you want to continue?");
		
		contentPanel.add(lblFeedback);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Keep");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Remove");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						wordController.removeWord(text);
						System.out.println(text);
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		init();
	}
	
	private void init() {
		wordController = new WordController();
	}
}
