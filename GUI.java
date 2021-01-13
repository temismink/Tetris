import javax.swing.JFrame;

public class GUI extends JFrame{
	
	JFrame fr = new JFrame();
	GUI(){
		super("Tetris V1");
		
		fr.setSize(423,555);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Tetris Class
		fr.add(new Tetris());
		fr.setVisible(true);
	}
	
	public static void main(String[] args)
	{
	  new GUI();
	}
}