import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

// https://www.hackerrank.com/challenges/morgan-and-a-string
// Testcase #7 is failing
public class MorganAndString {

	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\a.txt")));
	        int testCases= Integer.valueOf(reader.readLine());
	        for(int i=0;i<testCases;i++){
	        	String str1=reader.readLine();
	        	String str2=reader.readLine();
	        	check(str1,str2);
	        }

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static void check(String str1,String str2){
		int idx1=0;
		int idx2=0;
		int length1=str1.length();
		int length2=str2.length();
		StringBuffer sb=new StringBuffer(length1+length2);
		int i=0;
		while(idx1<length1 && idx2<length2){
			char c1=str1.charAt(idx1);
			char c2=str2.charAt(idx2);
			if(c1<c2)
				sb.append(str1.charAt(idx1++));
			else if(c2<c1)
				sb.append(str2.charAt(idx2++));
			else{
				int m=idx1;
				int n=idx2;
				int p=m;
				int q=n;
				while(true){
					while( m<length1 && n <length2 && (str1.charAt(m)==str2.charAt(n))){
						m++;
						n++;
					}
					if(m==length1 && n==length2 && idx1<length1){
						sb.append(str1.charAt(idx1++));
					}else{
						if(m<length1 && str1.charAt(m)<str2.charAt(n)){
							sb.append(str1.charAt(idx1++));
						}else if(n <length2){
							sb.append(str2.charAt(idx2++));
						}
					}
				if(idx1>=length1 || idx2>=length2) break;	
				if(idx1<length1 && idx2<length2 && str1.charAt(idx1)!=str2.charAt(idx2))break;
				}
			}
		}
		if(idx1<length1)sb.append(str1.substring(idx1,length1));
		if(idx2<length2)sb.append(str2.substring(idx2,length2));
		System.out.print(sb.toString());
		System.out.print("\n");
	}
}
