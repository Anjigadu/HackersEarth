import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.hackerrank.com/challenges/primsmstsub
public class PrimsSubTree {
	static int ans=0;
	static int cost[];
    static int V,E;
    static int[][] dataArray;
    static boolean[] visited;
    static ArrayList<Integer> reachable=new ArrayList<>();
	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\a.txt")));
	        String[] data=reader.readLine().split(" ");
	        V=Integer.valueOf(data[0]);
	        E=Integer.valueOf(data[1]);
	        dataArray=new int[V][V];
	        visited=new boolean[V];
	        cost=new int[V];
	        Arrays.fill(cost, Integer.MAX_VALUE);
	        int s,d,c;
	        for(int i=0;i<E;i++){
	        	data=reader.readLine().split(" ");
		        s=Integer.valueOf(data[0]);
		        d=Integer.valueOf(data[1]);
		        c=Integer.valueOf(data[2]);
		        dataArray[s-1][d-1]=c;
		        dataArray[d-1][s-1]=c;
	        }
	        int source=Integer.valueOf(reader.readLine());
	        primMST(dataArray);
//	        System.out.println(ans);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	 static int minKey(int key[], Boolean mstSet[])
	    {
	        // Initialize min value
	        int min = Integer.MAX_VALUE, min_index=-1;
	 
	        for (int v = 0; v < V; v++)
	            if (mstSet[v] == false && key[v] < min)
	            {
	                min = key[v];
	                min_index = v;
	            }
	 
	        return min_index;
	    }
	 static void primMST(int graph[][])
	    {
	        // Array to store constructed MST
	        int parent[] = new int[V];
	 
	        // Key values used to pick minimum weight edge in cut
	        int key[] = new int [V];
	 
	        // To represent set of vertices not yet included in MST
	        Boolean mstSet[] = new Boolean[V];
	 
	        // Initialize all keys as INFINITE
	        for (int i = 0; i < V; i++)
	        {
	            key[i] = Integer.MAX_VALUE;
	            mstSet[i] = false;
	        }
	 
	        // Always include first 1st vertex in MST.
	        key[0] = 0;     // Make key 0 so that this vertex is
	                        // picked as first vertex
	        parent[0] = -1; // First node is always root of MST
	 
	        // The MST will have V vertices
	        for (int count = 0; count < V-1; count++)
	        {
	            // Pick thd minimum key vertex from the set of vertices
	            // not yet included in MST
	            int u = minKey(key, mstSet);
	 
	            // Add the picked vertex to the MST Set
	            mstSet[u] = true;
	 
	            // Update key value and parent index of the adjacent
	            // vertices of the picked vertex. Consider only those
	            // vertices which are not yet included in MST
	            for (int v = 0; v < V; v++)
	 
	                // graph[u][v] is non zero only for adjacent vertices of m
	                // mstSet[v] is false for vertices not yet included in MST
	                // Update the key only if graph[u][v] is smaller than key[v]
	                if (graph[u][v]!=0 && mstSet[v] == false &&
	                    graph[u][v] <  key[v])
	                {
	                    parent[v]  = u;
	                    key[v] = graph[u][v];
	                }
	        }
	 
	        // print the constructed MST
	        printMST(parent, V, graph);
	    }
	
	 static void printMST(int parent[], int n, int graph[][])
	    {
//	        System.out.println("Edge   Weight");
	        for (int i = 1; i < V; i++)
	        	ans+=graph[i][parent[i]];
//	            System.out.println(parent[i]+" - "+ i+"    "+                            graph[i][parent[i]]);
	        System.out.println(ans);
	    }	
	
	
}