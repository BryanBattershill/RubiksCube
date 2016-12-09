
public class RubiksCubeObject {
	private Faces[] _faces = new Faces[6];
	private int[][] _moves = new int[20][2];
	
	public RubiksCubeObject(int[] values){
		for (int counter = 0; counter < 6; counter++){
			this._faces[counter] = new Faces();
			this._faces[counter].setColours(values[counter*4], values[(counter*4)+1], values[(counter*4)+2], values[(counter*4)+3]);
		}
		
		for (int counter = 0; counter < 20; counter++){
			this._moves[counter][0] = -1; 
		}
		
	}
	public void PS(){
		int i = 0;
		int i2 = 0;
		for (int counter1 = 0; counter1 < 24; counter1++){
			System.out.println(this._faces[i]._squares[i2]._colour);
			i2++;
			if (i2 == 4){
				i2 = 0;
				i++;
			}
		}
	}
	private boolean checkCube(){
		for (int counter = 0; counter < 6; counter++){
			if (!this._faces[counter].checkFace()){
				return false;
			}
			else if (counter == 5){
				return true;
			}
		}
		//Needed because program thinks there is a possibility of no return value
		return false;
	}
	
	public int[][] getMoveList(){
		return this._moves;
	}
	
	private void storeMove(int face, int direction){
		for (int counter = 0; counter < 20; counter++)
		if (this._moves[counter][0] == -1){
			this._moves[counter][0] = face;
			this._moves[counter][1] = direction;
			break;
		}
	}
	
	public void rotateFace(int face, int direction){
		int square1;
		int square2;
		int square3;
		int square4;
		int square5;
		int square6;
		int square7;
		int square8;
		
		//These are with relation to the turning face
		int top;
		int right;
		int bottom;
		int left;
		/*
		 * 0 = front
		 * 1 = back
		 * 2 = left
		 * 3 = right
		 * 4 = top
		 * 5 = bottom
		 */
		if (face == 0){

			top = 4;
			right = 3;
			bottom = 5;
			left = 2;
			
			square1 = this._faces[2]._squares[1]._colour;
			square2 = this._faces[2]._squares[3]._colour;
			square3 = this._faces[4]._squares[2]._colour;
			square4 = this._faces[4]._squares[3]._colour;
			square5 = this._faces[3]._squares[2]._colour;
			square6 = this._faces[3]._squares[0]._colour;
			square7 = this._faces[5]._squares[0]._colour;
			square8 = this._faces[5]._squares[1]._colour;
			
		}
		else if(face == 1){

			top = 5;
			right = 3;
			bottom = 4;
			left = 2;
			
			square1 = this._faces[2]._squares[0]._colour;
			square2 = this._faces[2]._squares[2]._colour;
			square3 = this._faces[5]._squares[2]._colour;
			square4 = this._faces[5]._squares[3]._colour;
			square5 = this._faces[3]._squares[1]._colour;
			square6 = this._faces[3]._squares[3]._colour;
			square7 = this._faces[4]._squares[0]._colour;
			square8 = this._faces[4]._squares[1]._colour;

		}
		else if (face == 2){
			
			top = 4;
			right = 0;
			bottom = 5;
			left = 1;
			
			square1 = this._faces[1]._squares[0]._colour;
			square2 = this._faces[1]._squares[2]._colour;
			square3 = this._faces[4]._squares[0]._colour;
			square4 = this._faces[4]._squares[2]._colour;
			square5 = this._faces[0]._squares[0]._colour;
			square6 = this._faces[0]._squares[2]._colour;
			square7 = this._faces[5]._squares[0]._colour;
			square8 = this._faces[5]._squares[2]._colour;

		}
		else if (face == 3){
			
			top = 4;
			right = 1;
			bottom = 5;
			left = 0;
			
			square1 = this._faces[0]._squares[1]._colour;
			square2 = this._faces[0]._squares[3]._colour;
			square3 = this._faces[4]._squares[1]._colour;
			square4 = this._faces[4]._squares[3]._colour;
			square5 = this._faces[1]._squares[1]._colour;
			square6 = this._faces[1]._squares[3]._colour;
			square7 = this._faces[5]._squares[1]._colour;
			square8 = this._faces[5]._squares[3]._colour;

		}		
		else if (face == 4){
			
			top = 1;
			right = 3;
			bottom = 0;
			left = 2;
			
			square1 = this._faces[2]._squares[0]._colour;
			square2 = this._faces[2]._squares[1]._colour;
			square3 = this._faces[1]._squares[2]._colour;
			square4 = this._faces[1]._squares[3]._colour;
			square5 = this._faces[3]._squares[0]._colour;
			square6 = this._faces[3]._squares[1]._colour;
			square7 = this._faces[0]._squares[0]._colour;
			square8 = this._faces[0]._squares[1]._colour;

		}
		else {
			top = 0;
			right = 3;
			bottom = 1;
			left = 2;
			
			square1 = this._faces[2]._squares[2]._colour;
			square2 = this._faces[2]._squares[3]._colour;
			square3 = this._faces[0]._squares[2]._colour;
			square4 = this._faces[0]._squares[3]._colour;
			square5 = this._faces[3]._squares[2]._colour;
			square6 = this._faces[3]._squares[3]._colour;
			square7 = this._faces[1]._squares[0]._colour;
			square8 = this._faces[1]._squares[1]._colour;
		}
		
		if (direction == 0){
			this._faces[face].setColours(this._faces[face]._squares[2]._colour, 
					this._faces[face]._squares[0]._colour, 
					this._faces[face]._squares[3]._colour, 
					this._faces[face]._squares[1]._colour);
			
			if (face == 0){
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square2, 
						square1);
				
				this._faces[right].setColours(square3, 
						this._faces[right]._squares[1]._colour, 
						square4, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square5, 
						square6, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						square7, 
						this._faces[left]._squares[2]._colour, 
						square8);
			}
			else if (face == 1){
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square1, 
						square2);
				
				this._faces[left].setColours(square8, 
						this._faces[left]._squares[1]._colour, 
						square7, 
						this._faces[left]._squares[3]._colour);
				
				this._faces[bottom].setColours(square5, 
						square6, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						square4, 
						this._faces[right]._squares[2]._colour, 
						square3);
			}
			else if (face == 2){
				this._faces[top].setColours(square1, 
						this._faces[top]._squares[1]._colour, 
						square2, 
						this._faces[top]._squares[3]._colour);
				
				this._faces[right].setColours(square3, 
						this._faces[right]._squares[1]._colour, 
						square4, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square5, 
						this._faces[bottom]._squares[1]._colour, 
						square6, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(square7, 
						this._faces[left]._squares[1]._colour, 
						square8, 
						this._faces[left]._squares[3]._colour);
			}
			else if (face == 3){
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						square1, 
						this._faces[top]._squares[2]._colour, 
						square2);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						square3, 
						this._faces[right]._squares[2]._colour, 
						square4);
				
				this._faces[bottom].setColours(this._faces[bottom]._squares[0]._colour, 
						square5, 
						this._faces[bottom]._squares[2]._colour, 
						square6);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						square7, 
						this._faces[left]._squares[2]._colour, 
						square8);
			}
			else if (face == 4){
				
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square2, 
						square1);
				
				this._faces[right].setColours(square4, 
						square3, 
						this._faces[right]._squares[2]._colour, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square5, 
						square6, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(square7, 
						square8, 
						this._faces[left]._squares[2]._colour, 
						this._faces[left]._squares[3]._colour);
			}
			else{
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square1, 
						square2);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						this._faces[right]._squares[1]._colour, 
						square3, 
						square4);
				
				this._faces[bottom].setColours(square6, 
						square5, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						this._faces[left]._squares[1]._colour, 
						square8, 
						square7);
			}
		}
		else {
			
			this._faces[face].setColours(this._faces[face]._squares[1]._colour, 
					this._faces[face]._squares[3]._colour, 
					this._faces[face]._squares[0]._colour, 
					this._faces[face]._squares[2]._colour);
			
			if (face == 0){
						
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square6, 
						square5);
				
				this._faces[right].setColours(square8, 
						this._faces[right]._squares[1]._colour, 
						square7, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square1, 
						square2, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						square4, 
						this._faces[left]._squares[2]._colour, 
						square3);
			}
			else if (face == 1){
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square6, 
						square5);
				
				this._faces[left].setColours(square3, 
						this._faces[left]._squares[1]._colour, 
						square4, 
						this._faces[left]._squares[3]._colour);
				
				this._faces[bottom].setColours(square2, 
						square1, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						square7, 
						this._faces[right]._squares[2]._colour, 
						square8);
			}
			else if (face == 2){
				this._faces[top].setColours(square5, 
						this._faces[top]._squares[1]._colour, 
						square6, 
						this._faces[top]._squares[3]._colour);
				
				this._faces[right].setColours(square7, 
						this._faces[right]._squares[1]._colour, 
						square8, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square1, 
						this._faces[bottom]._squares[1]._colour, 
						square2, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(square3, 
						this._faces[left]._squares[1]._colour, 
						square4, 
						this._faces[left]._squares[3]._colour);
			}
			else if (face == 3){
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						square5, 
						this._faces[top]._squares[2]._colour, 
						square6);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						square7, 
						this._faces[right]._squares[2]._colour, 
						square8);
				
				this._faces[bottom].setColours(this._faces[bottom]._squares[0]._colour, 
						square1, 
						this._faces[bottom]._squares[2]._colour, 
						square2);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						square3, 
						this._faces[left]._squares[2]._colour, 
						square4);
			}
			else if (face == 4){
				
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square6, 
						square5);
				
				this._faces[right].setColours(square7, 
						square8, 
						this._faces[right]._squares[2]._colour, 
						this._faces[right]._squares[3]._colour);
				
				this._faces[bottom].setColours(square1, 
						square2, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(square4, 
						square3, 
						this._faces[left]._squares[2]._colour, 
						this._faces[left]._squares[3]._colour);
			}
			else{
				this._faces[top].setColours(this._faces[top]._squares[0]._colour, 
						this._faces[top]._squares[1]._colour, 
						square5, 
						square6);
				
				this._faces[right].setColours(this._faces[right]._squares[0]._colour, 
						this._faces[right]._squares[1]._colour, 
						square8, 
						square7);
				
				this._faces[bottom].setColours(square2, 
						square1, 
						this._faces[bottom]._squares[2]._colour, 
						this._faces[bottom]._squares[3]._colour);
				
				this._faces[left].setColours(this._faces[left]._squares[0]._colour, 
						this._faces[left]._squares[1]._colour, 
						square3, 
						square4);
			}
		}
	}
	
	
	public boolean solve(int movesDone, int consecutiveMoves, int prevCounter, int movesToMake){
		int face = 0;
		int direction = 0;
		int consecutiveMovesTemp = consecutiveMoves;
		
		for (int counter = 0; counter < 6; counter++){
			
			if (counter > 5){
				face = counter - 6;
				direction = 1;
			}
			else{
				face = counter;
				direction = 0;
			}
			
			rotateFace(face, direction);
			
			if (checkCube()){
				storeMove(face, direction);
				return true;
			}
			else {
					rotateFace(face, 1-direction);
			}
		}
		
		for (int counter = 0; counter < 3; counter++){
			
			if (checkCube()){
				return true;
			}
			else if (movesDone == movesToMake){
				//System.out.println("Moves done = " + movesDone);

				return false;
			}
			/*
			if (counter > 5){
				face = counter - 6;
				direction = 1;
			}
			else{
				face = counter;
				direction = 0;
			}
			*/
			direction = 0;
			if (counter == 0){
				face = 0;
			}
			else if (counter == 1){
				face = 2;
			}
			else if (counter == 2){
				face = 4;
			}
			if (counter == prevCounter){
				consecutiveMovesTemp++;
			}
			else{
				consecutiveMovesTemp = 1;
			}
			if (consecutiveMoves == 3){
				//System.out.println("Consecutive moves = " + consecutiveMoves);
				return false;
			} 
			//System.out.println(face + " " + direction + " " + movesDone);
			//if (face == 0 && direction == 0 && movesDone == 1){
				//PS();
			//}
			
			rotateFace(face, direction);
			
			if (solve(movesDone+1, consecutiveMovesTemp, counter, movesToMake)){
				storeMove(face, direction);
				return true;
			}
			else{
				
					rotateFace(face, 1-direction);			
			}
		}
		//System.out.println("All moves done.");
		return false;
	}
}
