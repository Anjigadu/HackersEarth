
//https://www.hackerrank.com/challenges/candies


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Candies {

	public static void main(String...args){
    	try{
	    	BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int testCases=Integer.valueOf(reader.readLine());
			int n=testCases;
			long temp;
			int[] arr=new int[testCases];
			for(int i=0;i<testCases;i++)
				arr[i]=Integer.valueOf(reader.readLine());
			int[] brr=new int[testCases];
			for(int i=0;i<testCases;i++)
				brr[i]=1;
			int sum=0;
			for(int i=0;i<(n-1);i++)
			{
				if(arr[i+1]>arr[i])
				{
					temp=brr[i+1];
					brr[i+1]=brr[i] + 1;
				}
			}
			for(int i=n-1;i>0;i--)
			{
				if(arr[i-1]>arr[i] && brr[i-1]<=brr[i])
				{
					temp=brr[i-1];
					brr[i-1]= brr[i]+1;
				}
			}
			for(int i=0;i<n;i++) sum+=brr[i];
			System.out.println(sum);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
}
class MyComparator implements Comparator<Integer>{
	HashMap<Integer, Integer> map;
	public MyComparator(HashMap<Integer, Integer> map) {
		this.map=map;
	}
	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		return map.get(o1).compareTo(map.get(o2));
	}
	
}
