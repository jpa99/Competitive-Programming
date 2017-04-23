import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;
 
public class Dish_Life {
 
	public static void main(String[] args) throws Exception{
		long start=System.nanoTime();
		Scanner scan=new Scanner(new File("input.txt"));
		int numinputs=scan.nextInt();
		int[] index;
		for(int cases=1;cases<=numinputs;cases++){
			ArrayList<Integer> el=new ArrayList<Integer>();
			Set<Integer> set=new HashSet<Integer>();
			int isl=scan.nextInt();
			int ing=scan.nextInt();
			
			for(int y=1;y<=ing;y++){
				set.add(y);
			}
			
			index=new int[isl+1];
			int sum=0;
			index[0]=0;
			for(int i=0;i<isl;i++){
				int len=scan.nextInt();
				sum+=len;
				index[i+1]=sum;
				for(int j=0;j<len;j++){
					int x=scan.nextInt();
					el.add(x);
					if(set.contains(x))
						set.remove(x);
				}
			}
			
			if(!set.isEmpty()){
				System.out.println("sad");
				continue;
			}

			String x="all";/*
			for(int i=0;i<isl;i++){
				@SuppressWarnings("unchecked")
				ArrayList<Integer> el2=(ArrayList<Integer>) el.clone();
				el2.subList(index[i], index[i+1]).clear();
				Set<Integer> s=new HashSet<Integer>();
				s.addAll(el2);
				if(s.size()==ing){
					x="some";
					break;
				}
			}
			*/
			
			System.out.println(x);
			
		}
		System.out.println(1e-9*(System.nanoTime()-start)+" sec");
	}
 
}