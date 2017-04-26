import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Moocast {
	static String name="moocast";

	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(name+".out")));
		Scan scan=new Scan(name+".in");
		int numinputs=scan.nextInt();
		//scan.nextLine(); //only use with Scanner, not w/ custom scan class
		ArrayList<int[]> list=new ArrayList<int[]>();
		ArrayList<int[]> mst=new ArrayList<int[]>();
		for(int cases=0;cases<numinputs;cases++){
			int[] x={scan.nextInt(), scan.nextInt()};
			list.add(x);
		}
		double max=0;
		mst.add(list.remove(0));
		while(!list.isEmpty()){
			//find node in list that's closest to mst (minimum dsq) and store dsq
			//max=Math.max(max, dsq);
			//add it to mst
			double min=Double.MAX_VALUE;
			int node=0;
			for(int[] vis:mst){
				for(int[] unvis:list){
					double dsq=dsq(vis, unvis);
					if(dsq < min){
						min=dsq;
						node=list.indexOf(unvis);
					}
				}
			}
			mst.add(list.remove(node));
			max=Math.max(max, min);
		}
	
	
		
		int ans=(int)Math.ceil(max);
		System.out.println(ans);
		writer.println(ans);
		writer.close();
	}
	
	public static double dsq(int[] a, int[] b){
		return Math.pow((b[1]-a[1]), 2)+Math.pow((b[0]-a[0]), 2);
	}
	
	//Optimized Scanner Class, includes next String, int, Long, double, line
	static class Scan{
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public Scan(String file) throws IOException{
	            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
	            
	        }
	 
	        public Scan() throws IOException{
	            br = new BufferedReader(new InputStreamReader(System.in));
	        }
	        
	        String next(){
	            while (st == null || !st.hasMoreElements()){
	                try{
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException  e){
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	 
	        int nextInt(){
	            return Integer.parseInt(next());
	        }
	 
	        long nextLong(){
	            return Long.parseLong(next());
	        }
	 
	        double nextDouble(){
	            return Double.parseDouble(next());
	        }
	 
	        String nextLine(){
	            String str = "";
            try{
                str = br.readLine();
            }
            catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }

}
