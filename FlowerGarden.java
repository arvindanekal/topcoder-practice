/*
Solution for the problem: https://community.topcoder.com/stat?c=problem_statement&pm=1918&rd=5006
*/
import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class FlowerGarden {

	public static void main(String args[]){
		System.out.println(Arrays.toString(
				new FlowerGarden().getOrdering(

				new int[]
						{3,2,5,4},
		new int[]{1,2,11,10},
		new int[]{4,3,12,13}




		)));
	}

	public int[] getOrdering(int[] height, int[] bloom, int[] wilt){
		HashSet<Integer> visited = new HashSet<>();
		List<List<Integer>> collection = new ArrayList<>();
		int[] ordering = new int[height.length];
		int k = 0;
		while(true){
			if(visited.size() == height.length) break;
			List<Integer> vertices = new ArrayList<>();
			int min = -1, max = -1;
			for(int i = 0;i<height.length;i++){
				if(visited.contains(i)) continue;
				if(min == -1){
					min = bloom[i];
					max = wilt[i];
					vertices.add(height[i]);
					visited.add(i);
				}else{
					if((min<=bloom[i] && bloom[i]<= max)
					|| (min>=bloom[i] && min <= wilt[i])){
						min = Math.min(min, bloom[i]);
						max = Math.max(max, wilt[i]);
						visited.add(i);
						vertices.add(height[i]);
					}
				}
			}
			Collections.sort(vertices);
			collection.add(vertices);
		}
		while(collection.size()>0){
			int max = 0;
			int size = collection.get(0).get(0);
			for(int i = 0;i<collection.size();i++){
				if(size < collection.get(i).get(0)){
					max = i;
				}
			}
			List<Integer> list = collection.remove(max);
			for(int i = 0;i<list.size();i++)
				ordering[k++] = list.get(i);
		}
		return ordering;
	}
}
