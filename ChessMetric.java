// Solution for https://community.topcoder.com/stat?c=problem_statement&pm=1592&rd=4482
import java.util.ArrayList;
import java.util.List;

public class ChessMetric {

	public static void main(String args[]){
		System.out.println(
				new ChessMetric().howMany(100,
		new int[]{0,0},
		new int[]{0,99},
		50


		));
	}

	public 	long howMany(int size, int[] start, int[] end, int numMoves){
		long[][][] matrix = new long[size][size][numMoves+1];
		matrix[start[0]][start[1]][0] = 1;

		for(int k = 1;k<=numMoves;k++){
			for(int i = 0;i<size;i++)
				for(int j = 0;j<size;j++){
						int x = i;
						int y = j;
						checkValid(x, y, x+1, y, size, matrix, k);
						checkValid(x, y, x-1, y, size, matrix, k);
						checkValid(x, y, x, y+1, size, matrix, k);
						checkValid(x, y, x+1, y+1, size, matrix, k);
						checkValid(x, y, x-1, y+1, size, matrix, k);
						checkValid(x, y, x, y-1, size, matrix, k);
						checkValid(x, y, x+1, y-1, size, matrix, k);
						checkValid(x, y, x-1, y-1, size, matrix, k);

						// knight moves
						checkValid(x, y, x+1, y+2, size, matrix, k);
						checkValid(x, y, x+2, y+1, size, matrix, k);
						checkValid(x, y, x+2, y-1, size, matrix, k);
						checkValid(x, y, x+1, y-2, size, matrix, k);
						checkValid(x, y, x-1, y-2, size, matrix, k);
						checkValid(x, y, x-2, y-1, size, matrix, k);
						checkValid(x, y, x-2, y+1, size, matrix, k);
						checkValid(x, y, x-1, y+2, size, matrix, k);
					}
				}
		return matrix[end[0]][end[1]][numMoves];
	}

	public boolean checkValid(int i, int j, int x, int y, int size, long[][][] matrix, int level){
		if(x < 0 || y < 0 || x >= size || y >= size) return false;
		matrix[x][y][level] += matrix[i][j][level-1];
		return true;
	}
}
