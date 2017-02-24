import java.io.*;
import java.util.*;
import java.util.Map.Entry;
/*
https://www.hackerrank.com/challenges/longest-increasing-subsequent
http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
https://en.wikipedia.org/wiki/Patience_sorting
*/
public class LIS_in_logN{
	static int N=0; 
	static int M=0;
	static int[] array=null;
	static int[] tailTable;
	public static void main(String[] args){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("C:\\a.txt"));
			N=Integer.valueOf(reader.readLine());
			tailTable=new int[N];
			array=new int[N];
			for(int i=0;i<N;i++)
				array[i]=Integer.parseInt(reader.readLine());
			System.out.println(LIS());
			}catch(Exception e){
			e.printStackTrace();
		}
	}
	static int LIS(){
		int element=0;
		int MAX=0;
		tailTable[0]=array[0];
		int len=1;
		for(int i=1;i<N;i++){
			element=array[i];
			//System.out.println(len);
			if(element<tailTable[0])tailTable[0]=element;
			else if(element>tailTable[len-1])tailTable[len++]=element;
			else tailTable[CeilIndex(-1,len-1,element)]=element;
			//System.out.println(len);
		}
		return len;
	}
	 static int CeilIndex(int l, int r, int key)
	    {
	        while (r - l > 1)
	        {
	            int m = l + (r - l)/2;
	            if (tailTable[m]>=key)
	                r = m;
	            else
	                l = m;
	        }
	 
	        return r;
	    }
	
}
