package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IniciarSessionDlog extends JDialog {

	private static final String LOGIN = "Login";
	private final JPanel contentPanel = new JPanel();
	private JTextField txtLogin;
	private JTextField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IniciarSessionDlog dialog = new IniciarSessionDlog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IniciarSessionDlog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 328, 136);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{78, 27, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBackground(new Color(255, 250, 205));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{136, 39, 0};
		gbl_contentPanel.rowHeights = new int[]{28, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblLogin = new JLabel("Login:");
			GridBagConstraints gbc_lblLogin = new GridBagConstraints();
			gbc_lblLogin.anchor = GridBagConstraints.EAST;
			gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
			gbc_lblLogin.gridx = 0;
			gbc_lblLogin.gridy = 0;
			contentPanel.add(lblLogin, gbc_lblLogin);
		}
		{
			txtLogin = new JTextField();
			txtLogin.setText("login");
			GridBagConstraints gbc_txtLogin = new GridBagConstraints();
			gbc_txtLogin.insets = new Insets(0, 0, 5, 0);
			gbc_txtLogin.anchor = GridBagConstraints.NORTHWEST;
			gbc_txtLogin.gridx = 1;
			gbc_txtLogin.gridy = 0;
			contentPanel.add(txtLogin, gbc_txtLogin);
			txtLogin.setColumns(10);
		}
		{
			JLabel lblPasword = new JLabel("Password");
			GridBagConstraints gbc_lblPasword = new GridBagConstraints();
			gbc_lblPasword.anchor = GridBagConstraints.EAST;
			gbc_lblPasword.insets = new Insets(0, 0, 0, 5);
			gbc_lblPasword.gridx = 0;
			gbc_lblPasword.gridy = 1;
			contentPanel.add(lblPasword, gbc_lblPasword);
		}
		{
			txtPass = new JTextField();
			txtPass.setText("pass");
			GridBagConstraints gbc_txtPass = new GridBagConstraints();
			gbc_txtPass.anchor = GridBagConstraints.WEST;
			gbc_txtPass.gridx = 1;
			gbc_txtPass.gridy = 1;
			contentPanel.add(txtPass, gbc_txtPass);
			txtPass.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(255, 165, 0));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.fill = GridBagConstraints.BOTH;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton(LOGIN);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String login = txtLogin.getText();
						String pass = txtPass.getText();
						if (login != null && !login.equals("") && pass != null && !pass.equals("") )
						{
							String respuestaServer = PPal.get().login ( login, pass);
							if (respuestaServer.equals("true") )
							{
								PPal.get().setVisible(true);
								dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(null, respuestaServer);
							}
							
						}
						
					}
				});
				okButton.setActionCommand(LOGIN);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

}
