
public class SolveCube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1 = red
		 * 2 = blue
		 * 3 = green
		 * 4 = white
		 * 5 = orange
		 * 6 = yellow
		 */
		


		for (int counter = 1; counter < 33; counter++){
			//Front 4, back 4, left 4, right 4, top 4, bottom 4
			//int[] input = {1,1,1,1,5,5,5,5,3,3,3,3,2,2,2,2,4,4,4,4,6,6,6,6};
			int[] input =   {5,4,6,3,5,1,6,5,2,3,2,1,1,6,5,4,1,2,6,2,3,4,4,3};

			RubiksCubeObject cube = new RubiksCubeObject(input);
			if (cube.solve(0,0,-1, counter)){
				int [][] moves = cube.getMoveList();
				printMoves(moves);
				break;
			}
		}
		
		System.out.println("DONE");
		
	}
	
	public static void printMoves(int[][] moveList){
		for (int counter = 0; counter < 20; counter++){
			if (moveList[19-counter][0] == -1){
				
			}
			else if (moveList[19-counter][0] == 0 && moveList[19-counter][1] == 0){
				System.out.println("Turn the front face clockwise.");
			}
			else if (moveList[19-counter][0] == 0 && moveList[19-counter][1] == 1){
				System.out.println("Turn the front face counter-clockwise.");
			}
			else if (moveList[19-counter][0] == 1 && moveList[19-counter][1] == 0){
				System.out.println("Turn the back face clockwise.");
			}
			else if (moveList[19-counter][0] == 1 && moveList[19-counter][1] == 1){
				System.out.println("Turn the back face counter-clockwise.");
			}
			else if (moveList[19-counter][0] == 2 && moveList[19-counter][1] == 0){
				System.out.println("Turn the left face clockwise.");
			}
			else if (moveList[19-counter][0] == 2 && moveList[19-counter][1] == 1){
				System.out.println("Turn the left face counter-clockwise.");
			}
			else if (moveList[19-counter][0] == 3 && moveList[19-counter][1] == 0){
				System.out.println("Turn the right face clockwise.");
			}
			else if (moveList[19-counter][0] == 3 && moveList[19-counter][1] == 1){
				System.out.println("Turn the right face counter-clockwise.");
			}
			else if (moveList[19-counter][0] == 4 && moveList[19-counter][1] == 0){
				System.out.println("Turn the top face clockwise.");
			}
			else if (moveList[19-counter][0] == 4 && moveList[19-counter][1] == 1){
				System.out.println("Turn the top face counter-clockwise.");
			}
			else if (moveList[19-counter][0] == 5 && moveList[19-counter][1] == 0){
				System.out.println("Turn the bottom face clockwise.");
			}
			else if (moveList[19-counter][0] == 5 && moveList[19-counter][1] == 1){
				System.out.println("Turn the bottom face counter-clockwise.");
			}
		}
	}
		
}
