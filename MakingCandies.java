//https://www.hackerrank.com/challenges/making-candies

//------------------------------------------------------------------Not complete
class MakingCandies{
static long minimumPasses(long m,long w,long p,long n){
    	long current=0;
    	long toReduce=0;
    	long pass=0;
    	long min=Integer.MAX_VALUE;
    	while(current<n){
    		pass++;
    		current+=m*w;
    		long localCurrent=current;
    		long localM=m;
    		long localW=w;
    		//localCurrent=localM*localW;
    		long minLocal=pass+morePassesWithCurrentResources(n-localCurrent, localM*localW);
    		if(min>minLocal) min=minLocal;
    		long count=localCurrent/p;
    		long i=1;
    		while(i<=count){	
    			if(localM<localW) localM++;
    			else localW++;
    			minLocal=pass+morePassesWithCurrentResources(n-localCurrent, localM*localW);
        		if(min>minLocal) {
        			min=minLocal;
        			m=localM;
        			w=localW;
        			current-=i*p;
        		}
        		i++;
    		}
    		
    		
    	}
    	return min;
/*    	System.out.println(current);
    	System.out.println(pass+"----"+min);
*/    
    	}
    
    static long morePassesWithCurrentResources(long finalCount,long factor){
    	long min=0;
    	min=finalCount/factor;
    	if(finalCount%factor>0)min++;
    	return min;
    }
}