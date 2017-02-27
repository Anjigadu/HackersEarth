import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;

//https://www.hackerrank.com/challenges/kruskalmstrsub

//To detect cycle, using union find algorithm http://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/


public class KruskalReallySpecialSubTree {
	static Graph graph[]=null;
	static int N=0;
	static int E=0;
	static int MAX=0;
	static int[] parent;
	static int rank[];
	public static class Graph implements Comparable<Graph>{
		int src=0;int dst=0;int weight=0;

		public Graph(int src, int dst, int weight) {
			super();
			this.src = src;
			this.dst = dst;
			this.weight = weight;
		}

		@Override
		public int compareTo(Graph o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}


		@Override
		public boolean equals(Object obj) {
			Graph local=(Graph)obj;
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			if (dst != local.dst)
				return false;
			if (src != local.src)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Graph [src=" + src + ", dst=" + dst + ", weight=" + weight + "]";
		}

		
	}
	
	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\AA.txt")));
	        String[] strArr=reader.readLine().split(" ");
	        N=Integer.parseInt(strArr[0]);
	        E=Integer.parseInt(strArr[1]);
	        graph=new Graph[E];
	        parent = new int[N+1];
	        rank=new int[N+1];
	        for(int i=0;i<E;i++){
	        	strArr=reader.readLine().split(" ");
	        	int a=Integer.parseInt(strArr[0]);
	        	int b=Integer.parseInt(strArr[1]);
	        	int w=Integer.parseInt(strArr[2]);
	        	graph[i]=new Graph(a, b, w);
	        }
	        for(int i=0;i<=N;i++)parent[i]=i;
	        solve();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static void solve(){
		LinkedList<Graph> mst=new LinkedList<Graph>();
		LinkedList<Integer> included = new LinkedList<>();
		Arrays.sort(graph);
		for(Graph edge:graph){
			int v = find(edge.src);
            int u = find(edge.dst);
            if (v != u) {
                union(edge.src, edge.dst);
                MAX += edge.weight;
            }
		}
			System.out.println(MAX);
	}
	 private static int find(int v) {
	        if (v == parent[v])
	            return v;
	        return parent[v] = find(parent[v]);
	    }
	 private static void union(int a, int b) {
	        a = find(a);
	        b = find(b);
	        if (a != b) {
	            if (rank[a] < rank[b]) {
	                int k = a;
	                a = b;
	                b = k;
	            }
	            parent[b] = a;
	            if (rank[a] == rank[b]) {
	                ++rank[a];
	            }
	        }
	    }
	
}
