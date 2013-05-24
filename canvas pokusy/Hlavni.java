import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JFrame;

public class Hlavni extends JFrame {
	
	Renderer canvas = new Renderer();
	
	public Hlavni(String title) throws Exception {
		super(title);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int) screen.getWidth(),(int) screen.getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		Container con = this.getContentPane();
		con.setBackground(Color.WHITE);
		canvas.setSize(this.getSize());
		con.add(canvas);
		canvas.run();
	}
	
	public static void main(String args[]) throws Exception {
		new Hlavni("Okno s canvasem");
	}
}