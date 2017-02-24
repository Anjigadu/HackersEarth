import java.io.*;
import java.util.*;
/* https://www.hackerrank.com/challenges/coin-change 
  Using solution of previous same problem. Memorizing. Bottomup approach
*/

public class CoinChange{
	static int N=0; 
	static int M=0; 
	static ArrayList<Integer> coins=null;
	public static void main(String[] args){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("E:/AA.txt"));
			String[] data=reader.readLine().split(" ");
			N=Integer.valueOf(data[0]);
			M=Integer.valueOf(data[1]);
			coins=new ArrayList<>(M);
			String[] d=reader.readLine().split(" ");
			for(String s:d){
				coins.add(Integer.valueOf(s));
			}
			System.out.println(solve(M,N));
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	static long solve(int index,int sum){
		 long[] table = new long[sum+1];
		 
	        // Initialize all table values as 0
	        Arrays.fill(table, 0);   //O(n)
	 
	        // Base case (If given value is 0)
	        table[0] = 1;
	 
	        // Pick all coins one by one and update the table[]
	        // values after the index greater than or equal to
	        // the value of the picked coin
	        for (int i=0; i<index; i++)
	            for (int j=coins.get(i); j<=sum; j++){
	                table[j] += table[j-coins.get(i)];
	                System.out.println(j+","+(j-coins.get(i)));
	            }
	 
	        return table[sum];
	}
	
}

