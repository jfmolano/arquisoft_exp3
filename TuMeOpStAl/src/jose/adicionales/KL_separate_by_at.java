package jose.adicionales;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JTextField;

public class KL_separate_by_at implements KeyListener{

	private String by;
	private ArrayList<Integer> at;
	private ArrayList<String> byList;

	public KL_separate_by_at(String by, ArrayList<Integer> at) {
		this.by = by;
		this.at = at;
	}
//	public KL_separate_by_at(ArrayList<String> by, ArrayList<Integer> at) {
//		this.byList = by;
//		this.at = at;
//	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {

		JTextField textF = ((JTextField)e.getComponent());
		String text = textF.getText().replace(by, "");
		String textoAnteor = text;
		text = "";
		for (int i = 0; i < textoAnteor.length(); i++) {

			if ( partirEn (i))
			{
				text += by+ textoAnteor.charAt(i);
			}
			else
			{
				text +=textoAnteor.charAt(i);
			}

		}
		textF.setText(text);


	}
	private boolean partirEn(int i) {
		for (int j = 0; j < at.size(); j++) {
			if ( at.get(j) == i)
			{
				return true;
			}
		}
		return false;
	}


}
