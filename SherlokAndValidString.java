import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*;
// https://www.hackerrank.com/challenges/sherlock-and-valid-string
public class SherlokAndValidString {

	public static void main(String...args){
		try{
	        BufferedReader reader = new BufferedReader(new FileReader(new File("E:\\AA.txt")));
	        HashMap<Character, Integer> list = new HashMap<Character,Integer>();
	        String str=reader.readLine();
	        int l=str.length();
	        char oneChar='0';
	        while(--l>=0){
	        	char c=str.charAt(l);
	        	if(list.containsKey(c))list.put(c, list.get(c)+1);
	        	else list.put(c, 1);
	        	oneChar=c;
	        }
	        int fixed=list.get(oneChar).intValue();
	        int min=Integer.MAX_VALUE;
	        Set<Entry<Character,Integer>> set=list.entrySet();
	        HashMap<Integer, Integer> count=new HashMap<>();
	        boolean isYes=true;
	        for(Entry e:set){
	        	int value=(Integer)e.getValue();
	        	if(min>value) min=value;
	        	if(fixed !=value)isYes=false;
	        	if(count.containsKey(value))count.put(value, count.get(value)+1);
	        	else count.put(value, 1);
	        }
	        if(!isYes){
	        	if(count.containsValue(1)){
	        		if(count.size()<3){
	        			isYes=true;
	        		}else{
	        			Set<Entry<Integer,Integer>> tempSet=count.entrySet();
	        			for(Entry<Integer,Integer> e:tempSet){
	        				if(e.getValue()>2){
	        					isYes=false;
	        					break;
	        				}
	        			}
	        		}
	        	}
	        }
	        if(isYes)System.out.println("YES");
	        else System.out.println("NO");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
