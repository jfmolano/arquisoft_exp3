package munod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyPair;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import cifrado.CipherKeyPair;
import cifrado.GenaerateDigsetHex;

public class Mundo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String HOST = "172.24.98.137";
	public ArrayList<Factura> facturas;
	public KeyPair kp;

	public Mundo() {
		facturas = new ArrayList<>();
	}

	public void agregarFactura(Factura fact, boolean comprobar) throws Exception 
	{
		if (comprobar)
			comprobarFactura(fact);

		facturas.add(fact);
	}

	private void comprobarFactura(Factura fact) throws Exception 
	{

		darValorBono(fact);

		if (fact.getValorBono() == 0)
		{
			throw new Exception("El bono no ha sido registrado, por lo que no se puede realizar la compra.\n Cambie el código o dejelo en blanco");
		}
		else if (fact.getValorBono() < 0)
		{
			throw new Exception("El bono ya fue utilizado en una compra anterior");
		}
		else if (fact.getValorBono() < fact.getValorDECompra() )
		{
			throw new ExceptionValorFactura("El bono no cubre el valor total de la compra. Por favor pague: " + ( fact.getValorDECompra()-fact.getValorBono()) );
		}



	}

	private void darValorBono(Factura fact) throws Exception {
		URL url;
		try {
			url = new URL("http://"+ HOST +":8080/TuMeOp.web/webresources/Bono/validar/" + GenaerateDigsetHex.firmar(fact.getBono()));
			URLConnection connection = url.openConnection();

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
			JSONObject json = new JSONObject(builder.toString());

			Object valor = json.get("valor");
			fact.setValorBono(Integer.parseInt(valor.toString()));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new Exception("No hay conexión con el servidor");
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("Se produjo un error mientras se realizaba la conexión, intentelo de nuevo");
		} catch (JSONException e) {
			e.printStackTrace();
			throw new Exception("No se recibió el formato esperada de respuesta");
		}
	}

	public void cancelarBono(String bono) {
		URL url;
		try {
			url = new URL("http://"+ HOST +":8080/TuMeOp.web/webresources/Bono/cancelar/" +  GenaerateDigsetHex.firmar(bono));
			URLConnection connection = url.openConnection();

			String line;
			StringBuilder builder = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
			JSONObject json = new JSONObject(builder.toString());

			System.out.println(json.get("valor"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		

	}

	public String login(String login, String pass) {
		URL url;
		try {
			String rp = "http://"+ HOST +":8080/TuMeOp.web/webresources/Tienda/login/" + CipherKeyPair.cifrarRSA(login + "#" + pass);
			url = new URL(rp);
			System.out.println(rp);
			URLConnection connection = url.openConnection();

			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			line = CipherKeyPair.descifrarRSA(reader.readLine());
			return line;
			
			
			//JSONObject json = new JSONObject(builder.toString());

			//System.out.println(json.get("valor"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Errores pasaron"; 
		
	}

}

