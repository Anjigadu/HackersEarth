import java.io.BufferedReader;
import java.io.FileReader;

/*
https://www.hackerrank.com/challenges/jeanies-route

Let's solve another problem where Jeanie has to return to the city she started from. If Jeanie passes any edge, then she will have to pass the same edge in backward direction.
Thus, the answer is:

Jeanie also has to pass an edge if and only if there is at least one delivery destination in both directions.

In this way, Jeanie has to travel a further distance than she had to travel in the real problem. It's easy to understand the difference in distance between her starting and ending points.

Thus, the real answer is:

Calculating maximum distance is an easy dfs problem. For any node , find any furthest node , and from node find any furthest node . The answer is the distance between and (it's also possible with easy dp on a tree).
*/



public class JeaniesRoute {

	static int V;
	static int T;
	static int[] cost;
	static int[][] dataArray;
	static boolean[] visited;
	static boolean[] terminal;
	static int MAX=1000000;
	static int startNode=-1;
	public static void main(String...args){
		try{
			
			BufferedReader br = new BufferedReader(new FileReader("C:\\a.txt"));
			String[] arr=br.readLine().split(" ");
			V=Integer.parseInt(arr[0]);
			T=Integer.parseInt(arr[1]);
			terminal=new boolean[V];
			visited=new boolean[V];
			cost=new int[V];
			dataArray=new int[V][V];
			for(int i=0;i<V;i++){
				cost[i]=MAX;
			}
			
			arr=br.readLine().split(" ");
			for(String s:arr){
				terminal[Integer.valueOf(s)-1]=true;
				if(startNode==-1)
					startNode=Integer.valueOf(s)-1;
			}
			for(int i=0;i<(V-1);i++){
				arr=br.readLine().split(" ");
				int start=Integer.parseInt(arr[0])-1;
				int end=Integer.parseInt(arr[1])-1;
				int cost=Integer.parseInt(arr[2]);
				dataArray[start][end]=cost;
				dataArray[end][start]=cost;
			}
			solve();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static void solve(){
		cost[startNode]=0;
		//first update cost of each reachable vertex from start vertex(0) 
		updateReachableCostofEachVertexfromGivenVetrex(startNode,startNode);
		//get farthest vertex from start vertex(0)
		int farthestIndex=getFarthestVertex();
		//now we have to calculate cost of each vertex from this vertex. Before that reset the visit and cost array;
		visited=new boolean[V];
		for(int i=0;i<V;i++){
			cost[i]=MAX;
		}
		cost[farthestIndex]=0;
		updateReachableCostofEachVertexfromGivenVetrex(farthestIndex,farthestIndex);
		farthestIndex=getFarthestVertex();
		int maximumToBeDeducted=cost[farthestIndex];
		System.out.println(maximumToBeDeducted);
		visited=new boolean[V];
		int sum=2*getSumOfEachReachable(farthestIndex);
		System.out.println(sum-maximumToBeDeducted);
	}
	static void updateReachableCostofEachVertexfromGivenVetrex(int from,int v){
		visited[v]=true;
		for(int i=0;i<V;i++){
			if(dataArray[v][i]!=0 && !visited[i]){
				if(cost[i]>cost[v]+dataArray[v][i])
					cost[i]=cost[v]+dataArray[v][i];
				updateReachableCostofEachVertexfromGivenVetrex(from,i);
			}
		}
	}
	static int getFarthestVertex(){
		int max=0;
		int index=-1;
		for(int i=0;i<V;i++){
			if(max<cost[i] && terminal[i]){
				max=cost[i];
				index=i;
			}
		}
		return index;
	}
	static int getSumOfEachReachable(int v){
		visited[v]=true;
		int res=0;
		for(int i=0;i<V;i++){
			if(dataArray[v][i]!=0 && !visited[i]){
				int a=getSumOfEachReachable(i);
				if(terminal[i] || a>0) res+=dataArray[v][i]+a;
			}
		}
		return res;
	}
}
