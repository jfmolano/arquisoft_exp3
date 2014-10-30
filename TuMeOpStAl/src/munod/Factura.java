package munod;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;


public class Factura implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Calendar fecha;
	private String bono;
	private int valorDECompra;
	private int valorBono;
	public Factura(Calendar fecha, String bono, int valorDECompra, int valorBono) {
		
		this.fecha = fecha;
		this.bono = bono;
		this.valorDECompra = valorDECompra;
		this.valorBono = valorBono;
	}
	public Calendar getFecha() {
		return fecha;
	}
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	public String getBono() {
		return bono;
	}
	public void setBono(String bono) {
		this.bono = bono;
	}
	public int getValorDECompra() {
		return valorDECompra;
	}
	public void setValorDECompra(int valorDECompra) {
		this.valorDECompra = valorDECompra;
	}
	public int getValorBono() {
		return valorBono;
	}
	public void setValorBono(int valorBono) {
		this.valorBono = valorBono;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return fecha.get(Calendar.DAY_OF_MONTH)+ " " + fecha.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH)+ " " + fecha.get(Calendar.YEAR);
	}
}
