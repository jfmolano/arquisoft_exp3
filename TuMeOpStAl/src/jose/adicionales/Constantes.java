package jose.adicionales;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public final class Constantes 
{
	public final static KeyListener SOLO_NATURALES = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '-'))
			{
				e.consume();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	};
	public final static KeyListener SOLO_ENTEROS = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			if (!Character.isDigit(e.getKeyChar()) && !(e.getKeyChar() == '-'))
			{
				e.consume();
			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	};

	public final static KeyListener CONVERT_TO_MAYUSCULAS = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			if (Character.isLowerCase((e.getKeyChar())))
			{
				e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
			}		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}; 

	public final static KeyListener CONVERT_TO_CAPITAL = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
			try {
				JTextField textF = ((JTextField)e.getComponent());
				byte[] chara = textF.getText().getBytes();
				if ( textF.getText().isEmpty() || chara[chara.length-1] == 32)
				{
					
					e.setKeyChar(Character.toUpperCase(e.getKeyChar()));
				}
				else
				{
					e.setKeyChar(Character.toLowerCase(e.getKeyChar()));
				}
			}
			catch (Exception ev) {
				System.out.println(ev.getMessage());
			}		
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}; 
	 
	
	public final static FocusListener GREEN_WHEN_NOT_NULL = new FocusListener() {
		
		@Override
		public void focusLost(FocusEvent e) 
		{
			try 
			{
				JTextField textF = (JTextField)e.getComponent();
				if ( !textF.getText().isEmpty() )
				{
					e.getComponent().setBackground(new Color(60, 181, 83));
				}	
				else
				{
					e.getComponent().setBackground(new Color(255, 186, 0));	
				}
			}
			catch (Exception ev) {
				System.out.println(ev.getMessage());
			}
				
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			try 
			{
					e.getComponent().setBackground(new Color(216, 186, 0));	
			}
			catch (Exception ev) {
				System.out.println(ev.getMessage());
			}
			
		}
	};

}
