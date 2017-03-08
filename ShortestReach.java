import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

// https://www.hackerrank.com/challenges/bfsshortreach
//BFS: Shortest reach
public class ShortestReach {

	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\a.txt")));
	        int testCases=Integer.valueOf(reader.readLine());
	        for(int i=0;i<testCases;i++){
	        	String[] str=reader.readLine().split(" ");
	        	int nodes=Integer.valueOf(str[0]);
	        	int edges=Integer.valueOf(str[1]);
	        	int[][] dataArray = new int[nodes][nodes];
	        	for(int j=0;j<edges;j++){
	        		str=reader.readLine().split(" ");
	        		int x=Integer.valueOf(str[0])-1;
	        		int y=Integer.valueOf(str[1])-1;
	        		dataArray[x][y]=6;
	        		dataArray[y][x]=6;
	        	}
		        int stIdx=Integer.valueOf(reader.readLine())-1;
	        	solve(dataArray,nodes,stIdx);
	        }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void solve(int dataArray[][],int nodes,int stIdx){
		boolean[] sol=new boolean[nodes];
		int[] dist=new int[nodes];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[stIdx]=0;
		for(int i=0;i<nodes;i++){
			int u=minimum(dist,sol,nodes);
			if(u==-1){
				
			}else{
				sol[u]=true;
				for(int j=0;j<nodes;j++){
					if(!sol[j] && dataArray[u][j]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+dataArray[u][j]<dist[j])
						dist[j]=dist[u]+dataArray[u][j];
				}
			}
		}
		for(int i=1;i<nodes;i++){
			if(dist[i]==Integer.MAX_VALUE || dist[i]==0)
				System.out.print("-1 ");
			else
				System.out.print(dist[i]+" ");
		}
		System.out.println();
	}
	public static int minimum(int[] dist,boolean[] sol,int nodes){
		int u=-1;
		int min=Integer.MAX_VALUE;
		for(int i=0;i<nodes;i++){
			if(!sol[i] && dist[i]<min){
				min=dist[i];
				u=i;		
			}
		}
		return u;
	}
}
