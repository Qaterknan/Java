import javax.swing.JFrame;

public class Hlavni extends JFrame  {
	
	protected Eventhandler eventhandler = new Eventhandler(this);
	
	public Hlavni (){
		super("Eventhandler");
		setSize(300,300);
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main (String args[]){
		new Hlavni();
		eventhandler.keyboardControls.add(new KeyboardControl(83){
			public void down (){
				System.out.println("First action initiated by evenhandler!");
			}
		});
	}
}