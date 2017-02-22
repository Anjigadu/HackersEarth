import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;


/* https://www.hackerrank.com/challenges/vertical-sticks 

http://cs.stackexchange.com/questions/1076/how-to-approach-vertical-sticks-challenge/1114#1114
Imagine a different problem: if you had to place kk sticks of equal heights in nn slots then the expected distance between sticks (and the expected distance between the first stick and a notional slot 00, and the expected distance between the last stick and a notional slot n+1n+1) is n+1k+1n+1k+1 since there are k+1k+1 gaps to fit in a length n+1n+1.

Returning to this problem, a particular stick is interested in how many sticks (including itself) are as high or higher. If this number is kk, then the expected gap to its left is also n+1k+1n+1k+1.

So the algorithm is simply to find this value for each stick and add up the expectation. For example, starting with heights of [3,2,5,3,3,4,1,2][3,2,5,3,3,4,1,2], the number of sticks with a greater or equal height is [5,7,1,5,5,2,8,7][5,7,1,5,5,2,8,7] so the expectation is 96+98+92+96+96+93+99+98=15.2596+98+92+96+96+93+99+98=15.25.
*/
public class VerticalSticks {
    public static void main(String[] args){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int testCases=Integer.valueOf(reader.readLine());
			for(int i=0;i<testCases;i++){
				int n=Integer.valueOf(reader.readLine());
				String[] d=reader.readLine().split(" ");
				float[] dataArray=new float[n];
				int m=0;
				for(String s:d){
					dataArray[m++]=Integer.valueOf(s);
				}
				verticalSticks(dataArray,n);
			}
			
			} catch (Exception e) {
			e.printStackTrace();
			}

    }
    static void verticalSticks(float[] dataArray,int n){
    	DecimalFormat df = new DecimalFormat("#.00");
    	
    	float solution=0;
    	float temp=0;
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			if(dataArray[i]<=dataArray[j])temp++;
    		}
    		solution+=((n+1)/(temp+1));
    		temp=0;
    	}
    	System.out.println(df.format(solution));
   }
}
