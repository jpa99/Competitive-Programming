import java.util.*;
import java.util.Collections.*;
import java.util.Comparator.*;
import java.util.stream.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Toolbox {

	public static void main(String[] args) throws Exception{
		long start=System.nanoTime();
		int x=100;
		
		for(int i=2;i<=x;i++){
			println(i+": "+numDivisors(i));
		}

	}
	
	public static int numDivisors(int n){
		int num=0;
		for(int i=2;i<Math.sqrt(n);i++){
			if(n%i==0)
				num+=2;
		}
		
		if(n%Math.sqrt(n)==0)
			num++;
		return ++num;
	}
	
	
	public static int gcd(int a, int b){
		return (b==0)? a:gcd(b, a%b);
	}
	
	//Tests if input is divisible by 2 (10x faster than standard)
	public static boolean div2(int n){
		return (n & 1) == 0 && n!=0;
	}
	
	//Tests if input is prime
	public static boolean isPrime(int n){
		for(int i=2;i<Math.sqrt(n)+1;i++)
			if(n%i==0)
				return false;
		return n!=0 && n!=1;
	}
	
	public static <T> void print(T t){
	   System.out.print(t);
	}

	public static <T> void println(T t){
		   System.out.println(t);
		}
	// Converting from ArrayList (list) to Array (arr):
			//int[] arr = list.stream().mapToInt(i->i).toArray());
		
			// Converting from Array (arr) to ArrayList(list):
			//List<Integer> list=Arrays.stream(arr).boxed().collect(Collectors.toList());
		
	
}
