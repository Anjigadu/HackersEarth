import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/* https://www.hackerrank.com/challenges/maxsubarray */
public class MaximumSubarray {
    public static void main(String[] args){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int testCases=Integer.valueOf(reader.readLine());
			for(int i=0;i<testCases;i++){
				int n=Integer.valueOf(reader.readLine());
				String[] d=reader.readLine().split(" ");
				int[] dataArray=new int[n];
				int m=0;
				for(String s:d){
					dataArray[m++]=Integer.valueOf(s);
				}
				maxSubArray(dataArray,n);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			}

    }
    static void maxSubArray(int[] dataArray,int n){
    	int maxC=0;
    	int maxN=0;
    	int local=0;
    	for(int i=0;i<n;i++){
    		local+=dataArray[i];
    		if(local>0){
    			if(maxC<local)maxC=local;
    		}else local=0;
    		if(dataArray[i]>0)maxN+=dataArray[i];
    	}
    	if(maxC==0){
    		maxC=Integer.MIN_VALUE;
    		for(int i=0;i<n;i++){
    			if(maxC<dataArray[i])maxC=dataArray[i];
    		}
    		maxN=maxC;
    	}
    	System.out.println(maxC+" "+maxN);
    }
}
