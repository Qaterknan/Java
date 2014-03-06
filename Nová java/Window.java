import javax.swing.JFrame;
public class Window extends JFrame{
	
	private static final long serialVersionUID = 1L; // Vyžaduje eclipse, pøepisuji JFrame

	public Window (String title, Vector2 position, Vector2 dimension){
		super(title);
		setSize(dimension.ix(), dimension.iy());
		setLocation(position.ix(),position.iy());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
