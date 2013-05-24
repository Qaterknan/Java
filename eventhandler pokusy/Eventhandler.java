import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;
import java.util.ArrayList;

public class Eventhandler implements KeyListener, MouseInputListener {
	
	public ArrayList<KeyboardControl> keyboardControls = new ArrayList<KeyboardControl>();
	
	public Eventhandler (Hlavni game){
		game.addKeyListener(this);
		game.addMouseListener(this);
		game.addMouseMotionListener(this);
	}
	
	public void keyTyped(KeyEvent e){
		//~ System.out.println("Key typed: "+e.getKeyChar());
	}
	
	public void keyPressed(KeyEvent e){
		keyHandle(e, "down");
	}
	
	public void keyReleased(KeyEvent e){
		keyHandle(e, "up");
	}
	
	public void mouseClicked(MouseEvent e){
		mouseReport(e,"clicked (pressed and released)");
	}
	
	public void mousePressed(MouseEvent e){
		mouseReport(e,"pressed");
	}
	
	public void mouseReleased(MouseEvent e){
		mouseReport(e, "released");
	}
	
	public void mouseDragged(MouseEvent e){
		mouseReport(e,"dragged");
	}
	
	public void mouseMoved(MouseEvent e){
		mouseReport(e,"moved");
	}
	
	public void mouseEntered(MouseEvent e){
		return;
	}
	
	public void mouseExited(MouseEvent e){
		return;
	}
	
	public void mouseReport(MouseEvent e,String state){
		System.out.println("Button "+state+": "+e.getButton());
		System.out.println("Number of clicks: "+e.getClickCount());
		System.out.println("X coordinate: "+e.getX());
		System.out.println("Y coordinate: "+e.getY());
	}
	
	public void keyHandle(KeyEvent e,String id){
		for(KeyboardControl kc : keyboardControls){
			if(id == "down"){
				if(e.getKeyCode() == kc.id){
					kc.down();
				}
			}
		}
	}
}