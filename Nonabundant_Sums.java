import java.util.Arrays;

public class Nonabundant_Sums {
	public static void main(String[] args) {
		int[] abundant=new int[28123];
		int[] nums=new int[50000];
		int count=0;
		for(int i=2;i<28123;i++){
			int sum=1;
			for(int j=2;j<(int)(i/2)+1;j++){
				if(i%j==0){
					sum+=j;
				}
			}
			if(sum>i){
				abundant[i]=1;
				count++;
			}
		}
		
		int[] abundants=new int[count];
		
		int j=0;
		for(int n=0;n<abundant.length;n++){
			if(abundant[n]==1){
				abundants[j]=n;
				j++;
				
			}
		}
		for(int b:abundants){
			for(int a:abundants){
				try{
					nums[a+b]=1;
				} catch (Exception e){
					
				}
			}	
		}
		//1 means that it can be expressed as sum of abundants, 0 means nonabundant sum
		int summs=0;
		for(int i=0;i<nums.length;i++){
			if(i!=1){
				summs+=i;
			}
		}
		//System.out.println(Arrays.toString(nums));
		
		for(int asdf=28123;asdf<nums.length;asdf++){
			if(nums[asdf]!=1){
				System.out.println(asdf);
			}
		}
		
	}

}
