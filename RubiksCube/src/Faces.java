
public class Faces {
	public Squares[] _squares = new Squares[4];
	
	public Faces(){
		for (int counter = 0; counter < 4; counter++){
			this._squares[counter] = new Squares();
		}
	}
	
	public void setColours(int valA, int valB, int valC, int valD){
		this._squares[0]._colour = valA;
		this._squares[1]._colour = valB;
		this._squares[2]._colour = valC;
		this._squares[3]._colour = valD;
	}
	
	public boolean checkFace(){
		if (this._squares[0]._colour == this._squares[1]._colour && 
				this._squares[1]._colour == this._squares[2]._colour && 
				this._squares[2]._colour == this._squares[3]._colour){
			return true;
		}
		else{
			return false;
		}
	}
}
