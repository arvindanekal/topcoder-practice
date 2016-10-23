// Solution for https://community.topcoder.com/stat?c=problem_statement&pm=1889&rd=4709
import java.util.*;

public class AvoidRoads {

	public static void main(String args[]){
		System.out.println(
				new AvoidRoads().numWays(
						2,
						2,
		new String[]{"0 0 1 0", "1 2 2 2", "1 1 2 1"}));
	}

	public long numWays(int width, int height, String[] bad){
		width++; height++;
		long[][] matrix = new long[height][width];
		for(int i = 0;i<height;i++)
			for(int j = 0;j<width;j++)
				matrix[i][j] = 0;

		matrix[0][0] = 1;
		for(int i = 1;i<height;i++){
			if(!checkBad(i, 0, i-1, 0, bad))
				matrix[i][0] = matrix[i-1][0];
		}

		for(int j = 1;j<width;j++){
			if(!checkBad(0, j, 0, j-1, bad))
				matrix[0][j] = matrix[0][j-1];
		}

		for(int i = 1;i<height;i++){
			for(int j = 1;j<width;j++){
				if(!checkBad(i, j, i-1, j, bad))
					matrix[i][j] += matrix[i-1][j];
				if(!checkBad(i, j, i, j-1, bad))
					matrix[i][j] += matrix[i][j-1];
			}
		}
		return matrix[height-1][width-1];
	}

	public boolean checkBad(int x1, int y1, int x2, int y2, String[] bad){
		for(String str : bad) {
			String[] arr = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			int d = Integer.parseInt(arr[3]);

			if(x1 == a && y1 == b && x2 == c && y2 == d) return true;
			if(x1 == c && y1 == d && x2 == a && y2 == b) return true;
		}
		return false;
	}
}
