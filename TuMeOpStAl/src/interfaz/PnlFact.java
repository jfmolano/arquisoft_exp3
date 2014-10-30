package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import jose.adicionales.Constantes;
import munod.Factura;
import munod.ManagerQR;

import com.google.zxing.NotFoundException;

public class PnlFact extends JPanel implements ActionListener {

	private static final String CARGAR = "Cargar";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONFIRMAR = "Confirmar";
	private static final String CANCELAR = "cancelar";
	private JTextField txtFecha;
	private JTextField txtValor;
	private JTextField txtBono;
	private JTextField txtValorbono;
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private Component verticalStrut;
	private JLabel lblHora;
	private JTextField txtHora;
	private Calendar fecha;
	private JButton btnCargar;

	/**
	 * Create the panel.
	 */
	public PnlFact() {
		GridBagConstraints gbc_panel = new GridBagConstraints();


		this.setBackground(new Color(255, 165, 0));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		this.setLayout(gbl_panel);

		JLabel lblFechaDeCompra = new JLabel("Fecha de compra:");
		GridBagConstraints gbc_lblFechaDeCompra = new GridBagConstraints();
		gbc_lblFechaDeCompra.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeCompra.insets = new Insets(0, 6, 5, 5);
		gbc_lblFechaDeCompra.gridx = 0;
		gbc_lblFechaDeCompra.gridy = 1;
		this.add(lblFechaDeCompra, gbc_lblFechaDeCompra);

		txtFecha = new JTextField();
		txtFecha.setText("FEcha");
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.gridwidth = 2;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 6);
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.gridx = 1;
		gbc_txtFecha.gridy = 1;
		this.add(txtFecha, gbc_txtFecha);
		txtFecha.setColumns(10);

		lblHora = new JLabel("Hora:");
		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.anchor = GridBagConstraints.EAST;
		gbc_lblHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblHora.gridx = 0;
		gbc_lblHora.gridy = 2;
		add(lblHora, gbc_lblHora);

		txtHora = new JTextField();
		txtHora.setText("Hora");
		GridBagConstraints gbc_txtHora = new GridBagConstraints();
		gbc_txtHora.gridwidth = 2;
		gbc_txtHora.insets = new Insets(0, 0, 5, 6);
		gbc_txtHora.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHora.gridx = 1;
		gbc_txtHora.gridy = 2;
		add(txtHora, gbc_txtHora);
		txtHora.setColumns(10);

		JLabel lblValorDeCompra = new JLabel("Valor de compra:");
		GridBagConstraints gbc_lblValorDeCompra = new GridBagConstraints();
		gbc_lblValorDeCompra.anchor = GridBagConstraints.EAST;
		gbc_lblValorDeCompra.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorDeCompra.gridx = 0;
		gbc_lblValorDeCompra.gridy = 3;
		this.add(lblValorDeCompra, gbc_lblValorDeCompra);

		txtValor = new JTextField();
		txtValor.setText("Valor");
		txtValor.addKeyListener(Constantes.SOLO_NATURALES);
		GridBagConstraints gbc_txtValor = new GridBagConstraints();
		gbc_txtValor.gridwidth = 2;
		gbc_txtValor.insets = new Insets(0, 0, 5, 6);
		gbc_txtValor.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValor.gridx = 1;
		gbc_txtValor.gridy = 3;
		this.add(txtValor, gbc_txtValor);
		txtValor.setColumns(10);

		JLabel lblBono = new JLabel("Bono:");
		GridBagConstraints gbc_lblBono = new GridBagConstraints();
		gbc_lblBono.insets = new Insets(0, 0, 5, 5);
		gbc_lblBono.anchor = GridBagConstraints.EAST;
		gbc_lblBono.gridx = 0;
		gbc_lblBono.gridy = 4;
		this.add(lblBono, gbc_lblBono);

		txtBono = new JTextField();
		txtBono.setText("Bono");
		GridBagConstraints gbc_txtBono = new GridBagConstraints();
		gbc_txtBono.insets = new Insets(0, 0, 5, 6);
		gbc_txtBono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBono.gridx = 1;
		gbc_txtBono.gridy = 4;
		this.add(txtBono, gbc_txtBono);
		txtBono.setColumns(10);

		btnCargar = new JButton(CARGAR);
		btnCargar.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		add(btnCargar, gbc_btnNewButton);

		JLabel lblValorBono = new JLabel("Valor Bono:\n");
		GridBagConstraints gbc_lblValorBono = new GridBagConstraints();
		gbc_lblValorBono.anchor = GridBagConstraints.EAST;
		gbc_lblValorBono.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorBono.gridx = 0;
		gbc_lblValorBono.gridy = 5;
		this.add(lblValorBono, gbc_lblValorBono);

		txtValorbono = new JTextField();
		txtValorbono.setText("ValorBono");
		GridBagConstraints gbc_txtValorbono = new GridBagConstraints();
		gbc_txtValorbono.gridwidth = 2;
		gbc_txtValorbono.insets = new Insets(0, 0, 5, 6);
		gbc_txtValorbono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtValorbono.gridx = 1;
		gbc_txtValorbono.gridy = 5;
		this.add(txtValorbono, gbc_txtValorbono);
		txtValorbono.setColumns(10);

		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 0;
		gbc_verticalStrut.gridy = 7;
		add(verticalStrut, gbc_verticalStrut);

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(255, 165, 0));
		gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(6, 6, 6, 6);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		add(panel, gbc_panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		btnCancelar = new JButton(CANCELAR);
		btnCancelar.addActionListener(this);
		panel.add(btnCancelar);

		btnConfirmar = new JButton(CONFIRMAR);
		btnConfirmar.addActionListener(this);
		panel.add(btnConfirmar);

		setEditable(false);
	}

	public void setEditable(boolean b) {


		txtBono.setEditable(b);
		txtFecha.setEditable(false);
		txtHora.setEditable(false);
		txtValor.setEditable(b);
		txtValorbono.setEditable(false);

		txtHora.transferFocus();
		btnCancelar.setVisible(b);
		btnConfirmar.setVisible(b);
		btnCargar.setEnabled(b);
		if (b)
			setBackground(new Color(255, 255, 240));
		else
			setBackground(new Color(255, 165, 0));

	}
	public void setContent( Factura fact)
	{	
		fecha = Calendar.getInstance();

		if ( fact == null)
		{

			txtBono.setText("");
			txtValor.setText("");
			txtValorbono.setText("");
		}
		else
		{
			fecha = fact.getFecha();
			txtBono.setText(fact.getBono());
			txtValor.setText(""+fact.getValorDECompra());
			txtValorbono.setText(""+fact.getValorBono());
		}
		txtFecha.setText(fecha.get(Calendar.DAY_OF_MONTH)+ " " + fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + fecha.get(Calendar.YEAR));
		txtHora.setText(fecha.get(Calendar.HOUR) +":"+fecha.get(Calendar.MINUTE));

	}
	private Factura getNewFactura() {
		return new Factura(fecha, txtBono.getText(), Integer.parseInt((txtValor.getText().equals(""))?"0":txtValor.getText()), 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(CANCELAR))
		{
			PPal.get().seleccionarPrimerFactura();
		}
		else if (e.getActionCommand().equals(CONFIRMAR))
		{
			PPal.get().agregarFactura(getNewFactura());
		}
		else if (e.getActionCommand().equals(CARGAR))
		{
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				try {
					 txtBono.setText(ManagerQR.readQRCode(chooser.getSelectedFile()));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

	



}
