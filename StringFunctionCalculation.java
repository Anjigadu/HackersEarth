import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

// https://www.hackerrank.com/challenges/string-function-calculation

public class StringFunctionCalculation {

	static int length;
	static int[] index;
	static int[] lcp;
	static String[] strArray;
	static String[] solutionArray;
	static int MAX;
	public static void main(String...args){
    	try{
	    	BufferedReader reader = new BufferedReader(new FileReader("D:/a.txt"));
	    	
	    	String str=reader.readLine();
	    	// Developing suffix array
	    	Suffix[] sa=suffixArray(str);
	    	lcp=new int[length];
	    	//calculating LCP array (Longest common prefix)
	    	for(int i=0;i<length-1;i++){
	    		int j=i+1;
	    		lcp[i]=lcp(sa[i].index,sa[j].index,str);
	    	}
			MAX=checkHistogram(lcp);
	    	if(MAX<length)MAX=length;

	    	System.out.println(MAX);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		
		
	}
	

	public static Suffix[] suffixArray(CharSequence S) {
		length=S.length();
	    Suffix[] suffixArr = new Suffix[length];
	    for(int i=0;i<length;i++)
	    	suffixArr[i]=new Suffix();
	    for(int i=0;i<length;i++){
	    	suffixArr[i].index=i;
	    	suffixArr[i].rank[0]=S.charAt(i)-'a';
	    	suffixArr[i].rank[1]=((i+1)<length)?S.charAt(i+1)-'a':-1;
	    }
	    Arrays.sort(suffixArr);
	    int ind[] = new int[length];
	    for(int k=4;k<2*length;k=k*2){
	    	int rank=0;
	    	suffixArr[0].rank[0]=0;
	    	int prevRank=suffixArr[0].rank[0];
	    	for(int i=1;i<length;i++){
	    		if((suffixArr[i].rank[0]==prevRank) && (suffixArr[i].rank[1]==suffixArr[i-1].rank[1])){
	    			prevRank=suffixArr[i].rank[0];
	    			suffixArr[i].rank[0]=rank;
	    		}
	    		else{
	    			prevRank=suffixArr[i].rank[0];
	    			suffixArr[i].rank[0]=++rank;
	    		}
	    		 ind[suffixArr[i].index] = i;
	    	}
	    	for(int i=0;i<length;i++){
	    		int nextindex = suffixArr[i].index + k/2;
	    		suffixArr[i].rank[1] = (nextindex < length)?
	    				suffixArr[ind[nextindex]].rank[0]: -1;
	             }
	    	Arrays.sort(suffixArr);
	    }
	  /*  for(Suffix s:suffixArr)
	    	System.out.println(s);*/
	    return suffixArr;
	  }
	


	private static int lcp(int first,int second,CharSequence str){
		int val=0;
		try{
			while(first <length && second<length){
				if(str.charAt(first)==str.charAt(second)){
					val++;
					first++;
					second++;
				}
				else break;
			}
		}catch(Exception e){
			System.out.println("some error" +first+","+second);
		}
		return val;
	}
	
	static class Rect {
	    int width = 1;
	    int height;
	    
	    Rect(int height){
	        this.height = height;
	    }
	}
	private static int checkHistogram(int[] height){
		  if(height.length == 0) return 0;
	        
	        height = Arrays.copyOf(height, height.length + 1);
	        height[height.length - 1] = 0;
	        
	        Deque<Rect> stack = new LinkedList<Rect>();
	        
	        stack.push(new Rect(height[0]));
	        
	        int max = 0;
	        
	        next:
	        for(int i = 1; i < height.length; i++){
	            int h = height[i];
	            
	            Rect r = new Rect(h);
	            
	            int sl = 0;
	            while(true){
	                
	                if(stack.isEmpty() || h > stack.peek().height){
	                    stack.push(r);
	                    continue next;
	                }
	                
	                
	                Rect left = stack.pop();
	                
	                sl += left.width;
	                max = Math.max(max, left.height * (sl + 1));
	                
	                r.width = 1 + sl ; // merge left into new
	            }

	        }
	        
		return max;
		
	}
	
	
	
	// This solution is KMP algorithm based. Though it's working solution but for very large strings it's taking time. Therefore not efficient solution.
	private static void solution(String str){
		String pat=null;
		String[] strArr=str.split("");
		int MAX=Integer.MIN_VALUE;
		
		for(int m=1;m<=strArr.length;m++){
			pat=str.substring(0,m);
			int[] lps=buildLPS(pat);
			String[] patArr=pat.split("");
			int i=0,j=0;
			int lenP=patArr.length;
			int lenS=strArr.length;
			int countOfPattern=0;
			int startIndex=0;
			System.out.println(m);
			while(i<lenS){
				if(j==0 && strArr[i].equals(patArr[j])){
					startIndex=i;
				}
				if(strArr[i].equals(patArr[j])){
					i++;
					j++;
				}else if(j==0){
					i++;
				}
				else {
					j=lps[j-1];
				}
				if(j==lenP){
					countOfPattern++;
					j=0;
					i=startIndex+1;
				}
			}
			if(MAX<pat.length()*countOfPattern)MAX=pat.length()*countOfPattern;
		}
		System.out.println(MAX);
	}
	
	private static int[] buildLPS(String pat){
		int[] lps=new int[pat.length()];
		String[] patArr=pat.split("");
		lps[0]=0;
		int j=0;
		int i=1;
		while(i<pat.length()){
			if(patArr[i].equals(patArr[j]))
			{
				lps[i]=j+1;
				i++;
				j++;
			}
			else{
				if(j==0){
					lps[i]=0;
					i++;
				}else
					j=lps[j-1];
			}
		}
		
		
		return lps;
	}
	
}

class Suffix implements Comparable<Suffix>{

	int index;
	int[] rank;
	Suffix(){
		index=0;
		rank=new int[2];
	}
	@Override
	public int compareTo(Suffix o) {
		int i=(this.rank[0]==o.rank[0])?((this.rank[1]==o.rank[1])?0:(this.rank[1]<o.rank[1])?-1:1):((this.rank[0]<o.rank[0])?-1:1);
		return i;
	}
	
	@Override
	public String toString(){
		return index+"^"+rank[0]+"^"+rank[1];
	}
	
}