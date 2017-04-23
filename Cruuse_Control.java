import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Cruuse_Control {
	static String input="input.txt", out="output.txt";

	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scanner scan=new Scanner(new File(input));
		int numinputs=scan.nextInt();

		for(int cases=1;cases<=numinputs;cases++){
			double d=scan.nextDouble();
			double n=scan.nextDouble();
			ArrayList<double[]> list=new ArrayList<double[]>();
			for(int i=0;i<n;i++){
				double[] x={scan.nextDouble(), scan.nextDouble()};
				list.add(x);
			}
			Comparator<double[]> comparator = new Comparator<double[]>(){

			    public int compare(double[] o1, double[] o2){
			        return Double.valueOf(o2[0]).compareTo(Double.valueOf(o1[0]));
			    }
			};
			
			Collections.sort(list, comparator);
			
			for(int i=0;i<list.size()-1;i++){
				if(list.get(i+1)[0] >= list.get(i)[0])
					System.out.println("FALSE");
			}
			
			double pos=list.get(0)[0];
			double maxtime=(d-pos)/(list.get(0)[1]);
			for(double[] arr:list){
				double time=(d-arr[0])/(arr[1]);
				if(time > maxtime){
					maxtime=time;
					pos=arr[0];
				}
			}
			
			double speed=d/maxtime;
			
			String output="Case #"+cases+": "+speed;
			System.out.printf("Case #%s: %.7f\n", cases, speed);
			writer.printf("Case #%s: %.7f\n", cases, speed);
		}
		
		writer.close();
	}
}
