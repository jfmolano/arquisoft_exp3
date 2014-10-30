package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import munod.ExceptionValorFactura;
import munod.Factura;
import munod.Mundo;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PPal extends JFrame implements ActionListener, ListSelectionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String QUITAR = "-";
	private static final String AGREGAR = "+";
	private static PPal instancia;
	private JTextField txtBuscar;
	private JList <Factura>list;
	private PnlFact pnlFact;
	private Mundo mundo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSessionDlog dig = new IniciarSessionDlog();
					dig.setVisible(true);
					PPal.get();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void dispose( )
	{
        try
        {
        	System.out.println("Se Guardo la información");
        	ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("./datosTiendaTuMeOp.tume" ) );
            oos.writeObject( mundo );
            oos.close( );
        }
        catch( Exception e )
        {
        	e.printStackTrace();
        }
        
        super.dispose( );
    }
	
	public static PPal get()
	{
		if ( instancia == null)
		{
			System.out.println("Nueva interfaz disponible");
			instancia= new PPal();
		}
		return instancia;
	}

	/**
	 * Create the application.
	 */
	public PPal() {
		try 
    	{
    		ObjectInputStream ois = new ObjectInputStream( new FileInputStream("./datosTiendaTuMeOp.tume") );
            mundo = (Mundo) ois.readObject( );
            ois.close( );
            
    	}
    	catch (Exception e) {
    		mundo = new Mundo();
		}
		
		
		initialize();
		refrescarFacturas(null);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setForeground(new Color(0, 0, 0));
		setContentPane(new JPanel());
		setBounds(100, 100, 663, 311);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{100, 284, 0};
		gbl_panel_2.rowHeights = new int[]{278, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 140, 0));
		panel_1.setForeground(new Color(255, 140, 0));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.insets = new Insets(6, 6, 6, 6);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel_2.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 147, 41, 20, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblFacturas = new JLabel("Facturas");
		GridBagConstraints gbc_lblFacturas = new GridBagConstraints();
		gbc_lblFacturas.gridwidth = 2;
		gbc_lblFacturas.insets = new Insets(0, 0, 5, 5);
		gbc_lblFacturas.gridx = 0;
		gbc_lblFacturas.gridy = 0;
		panel_1.add(lblFacturas, gbc_lblFacturas);
		
		JButton btnAgregar = new JButton(AGREGAR);
		btnAgregar.addActionListener(this);
		btnAgregar.setPreferredSize(new Dimension(40, 20));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 0;
		panel_1.add(btnAgregar, gbc_button);
		
		JButton btnQuitar = new JButton(QUITAR);
		btnQuitar.setPreferredSize(new Dimension(40, 20));
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 0;
		panel_1.add(btnQuitar, gbc_button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		list = new JList<Factura>();
		list.addListSelectionListener(this);
		scrollPane.setViewportView(list);
		
		JLabel lblBuscar = new JLabel("Buscar");
		GridBagConstraints gbc_lblBuscar = new GridBagConstraints();
		gbc_lblBuscar.insets = new Insets(0, 6, 0, 5);
		gbc_lblBuscar.anchor = GridBagConstraints.EAST;
		gbc_lblBuscar.gridx = 0;
		gbc_lblBuscar.gridy = 2;
		panel_1.add(lblBuscar, gbc_lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setText("Buscar");
		GridBagConstraints gbc_txtBuscar = new GridBagConstraints();
		gbc_txtBuscar.gridwidth = 3;
		gbc_txtBuscar.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBuscar.gridx = 1;
		gbc_txtBuscar.gridy = 2;
		panel_1.add(txtBuscar, gbc_txtBuscar);
		txtBuscar.setColumns(10);
		
		pnlFact = new PnlFact();
		seleccionarPrimerFactura();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(6, 6, 6, 6);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_2.add(pnlFact, gbc_panel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(AGREGAR))
		{
			pnlFact.setContent(null);
			pnlFact.setEditable(true);
		}
		
	}

	public void seleccionarPrimerFactura() {
		if (list.getModel().getSize() ==0)
		{
			pnlFact.setContent(null);
		}
		else
		{
			pnlFact.setContent(list.getSelectedValue());
		}
		pnlFact.setEditable(false);
		
	}

	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		pnlFact.setContent(list.getSelectedValue());
		
	}

	public void agregarFactura(Factura newFactura) {
		try {
			mundo.agregarFactura(newFactura, true);
			refrescarFacturas(newFactura);
			pnlFact.setEditable(false);
			mundo.cancelarBono(newFactura.getBono());
		} 
		catch (ExceptionValorFactura e){
			int i = JOptionPane.showConfirmDialog(null, e.getMensaje());
			if (i == JOptionPane.OK_OPTION)
			{
				try {
					mundo.agregarFactura(newFactura, false);
					refrescarFacturas(newFactura);
					pnlFact.setEditable(false);
					mundo.cancelarBono(newFactura.getBono());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No fue posible añadir la factura: " + e.getMessage());
		}
		
	}

	private void refrescarFacturas(Factura newFactura) {
		Factura[] facturasArray = new Factura[mundo.facturas.size()];
		for (int i = 0; i < mundo.facturas.size(); i++) {
			facturasArray[i] = mundo.facturas.get(i);
		}
		list.setListData(facturasArray);
		if ( newFactura == null)
		{
			list.setSelectedIndex(0);
		}
		else
		{
			list.setSelectedValue(newFactura, true);
		}
	}

	public String login(String login, String pass) {
		String resp = "";
//		long promedio = 0;
//		for(int i = 0; i < 100; i++)
//		{
//			long x = System.nanoTime();
			resp = mundo.login (login, pass);
//			long f = System.nanoTime();
//			promedio += (x-f)/1000;
//			System.out.println(x-i);
//		}
//		
//		System.out.println(" Promedio " + promedio);
		return resp;
		 //promedio = 2.61 ms 
	}


}
