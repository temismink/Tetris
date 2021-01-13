import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Grid
{
  
  private int[][] emptySquares = new int[20][25];
  
  //Basic Constructor
  public Grid() {
	  
  }
  
  //checks if block has reached its lowest point
  public boolean reachedBottom(Block b)
  {
    if(b.getY()+b.getHeight() == minHeight(b.getX()))
    {
      emptySquares[b.getX()][b.getY()] = 1;
      if(b.getShape().equals("square")) {
    	  emptySquares[b.getX()+1][b.getY()] = 1;
    	  emptySquares[b.getX()][b.getY()+1] = 1;
    	  emptySquares[b.getX()+1][b.getY()+1] = 1;
      }
      else if(b.getShape().equals("line")) {
    	  emptySquares[b.getX()][b.getY()+1] = 1;
    	  emptySquares[b.getX()][b.getY()+2] = 1;
    	  emptySquares[b.getX()][b.getY()+3] = 1;
      }
      else if(b.getShape().equals("z")) {
    	  emptySquares[b.getX()+1][b.getY()] = 1;
    	  emptySquares[b.getX()-1][b.getY()+1] = 1;
    	  emptySquares[b.getX()][b.getY()+1] = 1;
      }
      else if(b.getShape().equals("l")) {
    	  emptySquares[b.getX()][b.getY()+1] = 1;
    	  emptySquares[b.getX()][b.getY()+2] = 1;
    	  emptySquares[b.getX()+1][b.getY()+2] = 1;
      }
      else {
    	  emptySquares[b.getX()-1][b.getY()+1] = 1;
    	  emptySquares[b.getX()][b.getY()+1] = 1;
    	  emptySquares[b.getX()+1][b.getY()+1] = 1;
      }
      return true;
     // emptySquares.update();
    }
    return false;
  }
  
  //sees if there is no more space to add blocks, GAME OVER
  public void gameOver() {
	  
  }
  
  //if a horizontal line is completed across the grid, the line is deleted and the top of the grid shifts down
  public void score() {
	  int count = 0;
	  for(int i = 0;i < emptySquares.length;i++) {
		  for(int j = 0;j < emptySquares[j].length;j++) {
			  if(emptySquares[i][j] == 1) {
				  count++;
				  if(count == emptySquares.length) {
					  
				  }
			  }
		  }
		  count = 0;
	  }
  }
  
  //returns the grid in the form of a 2-D array
  public int[][] getEmptySquares() {
	  return emptySquares;
  }
  
  //views the lowest space within a specific column that is not filled (not marked with a 1)
  public int minHeight(int column)
  {
    for(int i = 0; i < emptySquares[0].length; i++)
    {
      if(emptySquares[i + 1][column] == 1)
        return i;
    }
    return 25;
  }

  
}