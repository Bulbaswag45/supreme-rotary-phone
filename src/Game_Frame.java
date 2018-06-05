import java.awt.Frame;
import javax.swing.*;
import javax.swing.JFrame;

public class Game_Frame extends JFrame{
	public static void main(String[] args) {
	}
	
	Game_Frame() {
		super("");
		setSize(400,700);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		final Map applet = new Map();
		getContentPane().add(applet);
		//add(applet);
		pack();
		setVisible(true);
		
	}
	
}
