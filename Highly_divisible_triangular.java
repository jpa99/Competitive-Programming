import java.util.ArrayList;

public class Highly_divisible_triangular {

	public static void main(String[] args) {
		int index=1;
		int max_divisors=0;
		int i=1;
		while(max_divisors<=500){
			max_divisors=Math.max(max_divisors, num_divisors(i));
			index++;
			i+=index;
		}
		System.out.println("The "+index+"th triangle number, "+i+", has "+max_divisors+" divisors");
		
	}
	
	public static int num_divisors(int input){
	    int sum=2;
	    if(input==1)
	    	sum=1;
	    for(int i = 2; i <= (int)Math.sqrt(input); i++)
	    {
	        if(input % i == 0)
	        {
	           sum ++;
	           int d = input/i;
	           if(d!=i){
	              sum++;
	           }
	        }
	    }
	    return sum;

	}

}
