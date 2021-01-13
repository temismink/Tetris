import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Tetris extends JComponent implements ActionListener, KeyListener{
	
	//Globals
	ArrayList<Block> blocks = new ArrayList<Block>();
	Grid gr; //Holds Grid Commands
	Block currBlock; //Holds Block on Screen & Mobile
	//Block block = new Block(50,0);
	int x,y;
	int testX, testY;
	int[][] temp;
	
	public Tetris() {
		Timer t = new Timer(1000,this);
		t.start();
		currBlock = new Block(0,0);
		testX = currBlock.getX();
		testY = currBlock.getY();
		temp = currBlock.getPiece();
		
		setFocusable(true);
		requestFocus();
	}

	public void paintComponent(Graphics g) {
		//draws grid (20x25)
		 for (int i = 0; i < 420; i += 20)
		    {
		      g.drawLine(i, 0, i, 500);
		    }
		 for (int i = 0; i < 490; i += 20)
     {
       g.drawLine(0, i, 400, i);
     }
		
		//draws the piece
		for(int i = 0; i < temp.length; i++) {
			testX = 0;
			for(int j = 0; j < temp[0].length; j++) {
				if(temp[i][j] == 1) {
				testX += 20;
					g.setColor(Color.RED);
					g.fillRect(testX, testY, 20, 20);
				}
			}
			testY += 20;
		}
		
		//saves grid and colors in the previous block's spots
		
		/*if(gr.reachedBottom(currBlock)) {
		for(int i = 0;i < gr.getEmptySquares().length;i++) {
			  for(int j = 0;j < gr.getEmptySquares().length;j++) {
				  if(gr.getEmptySquares()[i][j]==1) {
					  g.setColor(Color.RED);
					  g.fillRect(i*20, j*20, 20, 20);
				  }
			  }
			}
		}*/
		//g.fillRect(x, y, 20, 20);
		
		
	}

	//BUGS
	//BUGs
	public void actionPerformed(ActionEvent e) {

		//testY += 20;
//		currBlock = blocks.get(0); //First Block on Testing
//		if(gr.reachedBottom(currBlock)) {
//			//currBlock.disable() -> Update table 
//			// toSee(generateBlock());
			
//		}
		moveDown();
		
		repaint();
	}

	
	private void moveDown() {
		// TODO Auto-generated method stub
		temp = currBlock.getPiece();
	}


	//
	// Key Listener Functions
	//
	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT) {
			testX -= 20;
		}
		if(keyCode == KeyEvent.VK_RIGHT) {
			testX+=20;
		}
		if(keyCode == KeyEvent.VK_UP) {
			
		}
		if(keyCode == KeyEvent.VK_DOWN) {
			testY += 20;
		}
		
	}

	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
