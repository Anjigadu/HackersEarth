//https://www.hackerrank.com/challenges/new-year-chaos
//This is working solution but getting timed out. Few customizations are required.

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NewYearChaos {

	public static void main(String...args){
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int testCases=Integer.valueOf(reader.readLine());
			List<String> list=new LinkedList<>();
			for(int i=0;i<testCases;i++){
				int size=Integer.valueOf(reader.readLine());
				list.add(reader.readLine());
			}
			checkMinBribe(list);
			} catch (Exception e) {
			e.printStackTrace();
			}
		
	}
	
	static void checkMinBribe(List<String> list){
		for(String s:list){
				String[] arr=s.split(" ");
				int size=arr.length;
				ArrayList<Integer> actualArr=new ArrayList<>(size);
				for(int i=0;i<size;i++){
					actualArr.add(Integer.valueOf(arr[i]));
				}
			int minBribe=0;
			boolean isChaotic=false;
			int ppp=0;
			for(int i=0;i<size;i++){
				ppp++;
				if(ppp!=actualArr.get(i)){
					if((actualArr.get(i)-ppp)>2){
						isChaotic=true;
						break;
					}
				}
			}
			ppp=0;
				for(int i=0;i<size && !isChaotic;i++){
				ppp++;
				if(ppp!=actualArr.get(i)){
					int index=actualArr.indexOf(ppp);
					int diff=index-i;
					while(diff>0){
						minBribe++;
						int m=actualArr.get(index);
						actualArr.set(index, actualArr.get(index-1));
						index--;
						actualArr.set(index, m);
						diff--;
					}
				}
			}
			
			if(isChaotic)
				System.out.println("Too chaotic");
			else System.out.println(minBribe);
		}
	}
	
}
