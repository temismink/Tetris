import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

public class Block{
	int[][] temp;
	int x1, y1;
	int xPos, yPos, height;
	Graphics g;
	int [][] piece;
	ArrayList<int[][]> pieces;
	
	public Block(int x, int y) {
		x1 = x;
		y1 = y;
		pieces = new ArrayList<int[][]>();
		
		//Add Template Pieces
		pieces.add(L);
		pieces.add(Z);
		pieces.add(LINE);
		pieces.add(SQUARE);
		pieces.add(T);
		
		//toSee(piece);
	}
	//all possible Tetrominoes
		int [][] L = {
				{1,0},
				{1,0},
				{1,1}
		};
	
		int [][] Z = {
				{0,0,0,0},
				{0,0,0,0},
				{0,1,1,0},
				{1,1,0,0}
		};
	
		int [][] LINE = {
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0},
				{1,0,0,0}
		};
	
		int [][] SQUARE = {
				{0,0,0,0},
				{0,0,0,0},
				{1,1,0,0},
				{1,1,0,0}
		};
	
		int [][] T = {
				{0,0,0,0},
				{0,0,0,0},
				{0,1,0,0},
				{1,1,1,0}
		};
	
	
	/*public static Block generateBlock() {
		Block product = new Block(50,10);
		
		
		return product;
	}*/
	
	//
	//  Getters and Setters
	//

	//returns the piece and sets the height
	public int[][] getPiece(){
		x1 = 0;
		y1 = 0;
		int[][] dog = pieces.get((int)(Math.random() * pieces.size()));
		if (equate(dog,L)){
			height = 2;
		}
		if (equate(dog,T)){
			height = 1;
		}
		if (equate(dog,Z)){
			height = 1;
		}
		if (equate(dog,LINE)){
			height = 3;
		}
		if (equate(dog,SQUARE)){
			height = 1;
		}
		return dog;
		
	}

	//returns a String to see which shape was generated
	public String getShape() {
		
		int[][] temp = getPiece();
		
		if(equate(temp,L)) {
			return "l";
		}
		else if(equate(temp,Z)) {
			return "z";
		}
		else if(equate(temp,LINE)) {
			return "line";
		}
		else if(equate(temp,SQUARE)) {
			return "square";
		}
			return "t";
	}
	
	//checks if two arrays are equal
	private boolean equate(int[][] T, int[][] K) {
		for(int row = 0; row < T.length; row++) {
			for(int col = 0; col < K[0].length; col++) {
				if(T[row][col] != K[row][col]) {
					return false;
				}
			}	
		}
		return true;
	}
	
	public int getX()
	{
		return x1;
	}
	
	public int getY() {
		return y1;
	}
	public int getHeight() {
		return height;
	}
	public void increment() {
		y1 += 20;
	}
}
