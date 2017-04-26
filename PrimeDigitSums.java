import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/prime-digit-sums
public class PrimeDigitSums {

	public static void main(String...args){
		try{
			BufferedReader reader = new BufferedReader(new FileReader("C:/a.txt"));
			int n=Integer.valueOf(reader.readLine());
			for(int i=0;i<n;i++){
				int integer = Integer.valueOf(reader.readLine());
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static void checkPrimeDigitsSum(int n){
		int count=0;
		
		double number = Math.pow(10, n-1);
		double limit=Math.pow(10, n);
		while(number<limit){
			
		}
		
		System.out.println(count);
	}
	private static boolean checkRule(double number){
		boolean isTrue=false;
		
		return isTrue;
	}
	
}
