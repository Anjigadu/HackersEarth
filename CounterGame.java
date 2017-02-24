import java.io.*;
import java.math.BigInteger;

public class CounterGame {

	public static void main(String...args){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int n=Integer.valueOf(reader.readLine());
			for(int i=0;i<n;i++){
				BigInteger integer = new BigInteger(reader.readLine());
				whoWin(integer);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static void whoWin(BigInteger n){
		int i=0;
		BigInteger two = new BigInteger("2");
		while(n.longValue()!=1){
			BigInteger j=new BigInteger("1");
			while(true){
//				System.out.println(j.longValue());
				if(n.equals(j) ){
					break;
				}
				else if(n.compareTo(j)>0){
					j=j.multiply(two);
				}
				else {
					j=j.divide(two);
					break;
				}
			}
			if(n.equals(j))n=n.divide(two);
			else n=n.subtract(j);
			if(n.equals(new BigInteger("1"))) break;
//			System.out.println(n);
			i++;
		}
		if(i%2==0)System.out.println("Louise");
		else System.out.println("Richard");
	}
}
