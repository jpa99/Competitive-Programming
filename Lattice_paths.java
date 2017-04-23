import java.util.*;
public class Lattice_paths {

	public static void main(String[] args) {
		int sum=0;
		String[] nums={"1", "0"};
		ArrayList<String> used=new ArrayList<String>();
		String x;
		for(int k=0;k<1000;k++){
			x="";
			for(int i=0;i<2;i++){
				x+=nums[(int)(2*Math.random())];
			}
			if(!used.contains(x)){
				used.add(x);
				sum++;
			}
		}
		System.out.println(sum);

	}

}
