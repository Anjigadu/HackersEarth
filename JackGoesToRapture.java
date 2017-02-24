import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//https://www.hackerrank.com/challenges/jack-goes-to-rapture

public class JackGoesToRapture {
	static int MAX;
	static int ROWS=0;
	static boolean[] included;
	static int[] distance;

	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\a.txt")));
	        String[] strArr=reader.readLine().split(" ");
	        MAX=Integer.parseInt(strArr[0]);
	        ROWS=Integer.parseInt(strArr[1]);
	        int[][] dataArray=new int[MAX][MAX];
	        for(int i=0;i<ROWS;i++){
	        	strArr=reader.readLine().split(" ");
	        	int f=Integer.parseInt(strArr[0]);
	        	int s=Integer.parseInt(strArr[1]);
	        	int c=Integer.parseInt(strArr[2]);
	        	dataArray[f-1][s-1]=c;
	        	dataArray[s-1][f-1]=c;
	        }
	        distance=new int[MAX];
	        included=new boolean[MAX];
	        for(int i=0;i<MAX;i++){
	    		distance[i]=Integer.MAX_VALUE;
	    		included[i]=false;
	    	}
	        djikstra(dataArray);
	        for(int i:distance)
	        	System.out.println(i);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    static void djikstra(int[][] dataArray){
    	distance[0]=0;
    	for(int i=0;i<MAX;i++){
    		int u=minDistance();
    		included[u]=true;
    		for(int j=0;j<MAX;j++){
    			if(!included[j] && dataArray[u][j] !=0 && distance[u] != Integer.MAX_VALUE ){
/*    					if(dataArray[u][j]-distance[u]<0)
    						distance[j]=distance[u];
    					else
    						distance[j]=dataArray[u][j];
*/
    				distance[j]=Integer.min(distance[j], Integer.max(distance[u], dataArray[u][j]));
    			}
    		}
    	}
    }
    static int minDistance(){
    	int min=Integer.MAX_VALUE;
    	int minIndex=-1;
    	for(int i=0;i<MAX;i++){
    		if(!included[i] && distance[i]<=min){
    			min=distance[i];
    			minIndex=i;
    		}
    	}
    	return minIndex;
    }
	
	
}
