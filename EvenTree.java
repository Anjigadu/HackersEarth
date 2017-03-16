import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

// https://www.hackerrank.com/challenges/even-tree
// Not completed
public class EvenTree {
	static int ans=0;
    static int V,E;
    static int[][] dataArray;
    static boolean[] visited;
	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\a.txt")));
	        String[] data=reader.readLine().split(" ");
	        V=Integer.valueOf(data[0]);
	        E=Integer.valueOf(data[1]);
	        dataArray=new int[V][V];
	        visited=new boolean[V];
	        int s,d;
	        for(int i=0;i<E;i++){
	        	data=reader.readLine().split(" ");
		        s=Integer.valueOf(data[0]);
		        d=Integer.valueOf(data[1]);
		        dataArray[s-1][d-1]=1;
		        dataArray[d-1][s-1]=1;
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static int solution(int startNode){
		visited[startNode]=true;
		int numbers=0;
		for(int i=0;i<dataArray[startNode].length;i++){
//			if(dataArray[startNode][i]==1 && !visited[])
		}
		return numbers;
	}
}
