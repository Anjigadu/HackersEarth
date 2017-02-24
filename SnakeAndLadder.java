
// https://www.hackerrank.com/challenges/the-quickest-way-up
//Hacker Rank 

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Temp
{
    public static void main(String [] args) 
    {
    	try{
	    	BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int testCases=Integer.valueOf(reader.readLine());
			
			for(int i=0;i<testCases;i++){
	    		HashMap<Integer, Integer> ladder=new HashMap<>();
				int ladders=Integer.valueOf(reader.readLine());
				HashMap<Integer,Integer> testLadder=new HashMap<>();
				HashMap<Integer,Integer> testSnakes=new HashMap<>();
				while((ladders--)>0){
					String[] line= reader.readLine().split(" ");
					int start=Integer.valueOf(line[0])-1;
					int end=Integer.valueOf(line[1])-1;
					ladder.put(start, end);
					testLadder.put(start, end);
				}
				int snakes=Integer.valueOf(reader.readLine());
				while((snakes--)>0){
					String[] line= reader.readLine().split(" ");
					int start=Integer.valueOf(line[0])-1;
					int end=Integer.valueOf(line[1])-1;
					ladder.put(start,end);
					testSnakes.put(start, end);
				}
				
				boolean isValid=checkValidity(testLadder,testSnakes);
				if(isValid)
					solution(ladder);
				else System.out.println("-1");
			}
			
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
    
    
    public static void solution(HashMap<Integer,Integer> ladder){
    	final int MAX=100;
    	final int DESTINATION=99;
    	int[] dest = new int[MAX];
    	int[] board=new int[MAX];
    	BitSet visited=new BitSet();
    	for(int i=0;i<MAX;i++)
    		board[i]=i;
    	Set<Entry<Integer,Integer>> entrySet=ladder.entrySet();
    	for(Entry<Integer,Integer> e:entrySet)
    		board[e.getKey()]=e.getValue();
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(board[0]);
    	int m=0;
    	while(!queue.isEmpty()){
//    		System.out.println(m++);
    		int number=queue.poll();
    		if(number==DESTINATION) break;
    		int distance=dest[number];
    		for(int j=number;j<=(number+6) && j<=DESTINATION;j++){
    			if(!visited.get(j))
    				dest[board[j]]=distance+1;
    			if(board[j]!=j)visited.set(j);
				visited.set(board[j]);
				if(!queue.contains(board[j]))
					queue.add(board[j]);
    		}
    	}
    	System.out.println(dest[99]);
    	
    }
    
    static boolean checkValidity(HashMap<Integer,Integer> ladder,HashMap<Integer,Integer> snakes){
    	boolean isValid=true;
    	
    	boolean hasLeaderToLast6Blocks=false;
    	Set<Entry<Integer,Integer>> entrySet=ladder.entrySet();
    	for(Entry<Integer,Integer> e:entrySet){
    		if(e.getValue()>94){
    			hasLeaderToLast6Blocks=true;
    			return true;
    		}
    	}
    	Set<Integer> snakeSet=snakes.keySet();
    	TreeSet<Integer> treeSet = new TreeSet<>(snakeSet);
    	List<Integer> startPositionofContiniousSix=new ArrayList<>();
    	if(treeSet.size()>=6){
    		while(!treeSet.isEmpty() && treeSet.size()>=6){
	    		int six=5;
	    		int previous=-1;
	    		previous=treeSet.first();
	    		treeSet.remove(previous);
	    		for(int i=0;i<5;i++){
	    			if(previous+1==treeSet.first()){
	    				previous=treeSet.first();
	    				treeSet.remove(previous);
	    				six--;
	    			}
	    			else {
	    				treeSet.remove(treeSet.first());
	    				break;
	    			}
	    		}
	    		
	    		if(six==0){
	    			startPositionofContiniousSix.add(previous-5);
	    		}
    		}
    	}
    	
    	
    	
/*    	Set<Integer> firstCheck=new HashSet<>();
    	Set<Integer> secondCheck=new HashSet<>();
    	for(int i=94;i<=99;i++)
    		firstCheck.add(i);
    	for(int i=88;i<=93;i++)
    		secondCheck.add(i);
    	if(snakeSet.containsAll(firstCheck) || snakeSet.containsAll(secondCheck))
    		isValid=false;
*/  
    	Set<Integer> ladderKeys=ladder.keySet();
    	for(int index:startPositionofContiniousSix){
    		isValid=false;
    		for(int lKey:ladderKeys){
    			if(lKey>index){
    				isValid=true;
    				break;
    			}
    		}
    	}
    	
    	return isValid;
    }
}
