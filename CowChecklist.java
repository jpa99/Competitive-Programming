import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class CowChecklist {
	static String name="10";
	static ArrayList<int[]> h;
	static ArrayList<int[]> g;
	static double[][][] dp = new double[2][1001][1001];
	
	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(name+".out")));
		Scan scan=new Scan(name+".in");
		int numH=scan.nextInt();
		int numG=scan.nextInt();
		//LinkedList<int[]> h=new LinkedList<int[]>();
		//LinkedList<int[]> g=new LinkedList<int[]>();
		h=new ArrayList<int[]>();
		g=new ArrayList<int[]>();
		for(int cases=0;cases<numH;cases++){
			int[] x={scan.nextInt(), scan.nextInt()};
			if(!h.contains(x))
				h.add(x);
		}
		for(int cases=0;cases<numG;cases++){
			int[] x={scan.nextInt(), scan.nextInt()};
			if(!g.contains(x))
				g.add(x);
		}
		//int[] start=h.poll();
		int[] a={198, 891};
		System.out.println(g.contains(a));
		//h: h1, h2, h3...
		//g: g1, g2, g3...
		//if start @ h1, h1-h2 OR 
		//if start @ g1, g1-g2 OR g1-h1
		//minenergy(Hlist, Glist, start[]) = MIN(dsq(start, Hlist[0]) , dsq(start, Glist[0]))
		
		int ans=(int) minenergy2(1, 1, 0);
		System.out.println(ans);
		writer.println(ans);
		writer.close();
	}
	
	public static double minenergy(LinkedList<int[]> h, LinkedList<int[]> g, int[] start){
		if(h.isEmpty() && g.isEmpty()){
			return 0;
		}
		if(h.isEmpty()){
			int[] d=g.poll();
			System.out.println(Arrays.toString(d));
			return dsq(start, d)+minenergy(h, g, d);
		}
		if(g.isEmpty()){
			int[] d=h.poll();
			return dsq(start, d)+minenergy(h, g, d);
		}
		LinkedList<int[]> hnew = (LinkedList<int[]>) h.clone();
		LinkedList<int[]> gnew = (LinkedList<int[]>) g.clone();
		int[] hstart = hnew.poll(), gstart = gnew.poll();
		return Math.min(dsq(start, hstart)+minenergy(hnew, g, hstart), dsq(start, gstart)+minenergy(h, gnew, gstart));
	}
	//minenergy(true, 0, 1, 0);
	
	//if which==1, start=hindex-1; else gindex-1
	public static double minenergy2(int which, int hindex, int gindex){
		int[] start;
		if(which==1)
			start=h.get(hindex-1);
		else
			start=g.get(gindex-1);

		if(dp[which][hindex][gindex] !=0){
			return dp[which][hindex][gindex];
		}
		if(hindex == h.size()-1 && gindex == g.size()){
			return dsq(start, h.get(h.size()-1));
		}
		if(hindex == h.size()-1){
			double val = dsq(start, g.get(gindex))+minenergy2(0, hindex, gindex+1);
			dp[which][hindex][gindex] = val;
			return val;
		}
		if(gindex == g.size()){
			double val =  dsq(start, h.get(hindex))+minenergy2(1, hindex+1, gindex);
			dp[which][hindex][gindex] = val;
			return val;
		}
		double val = Math.min(dsq(start, h.get(hindex))+minenergy2(1, hindex+1, gindex), dsq(start, g.get(gindex))+minenergy2(0, hindex, gindex+1));
		dp[which][hindex][gindex] = val;
		return val;
	}
	
	//1 + f(h[1])    9 + f(g[1])
	//
	
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
