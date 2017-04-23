import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Turn_Distance {
	static String input="input.txt", out="output.txt";
	static Scan scan;
	//don't forget to change input to STDIN before submitting
	public static void main(String[] args) throws Exception{
		Scan scan=new Scan();
		int r=scan.nextInt();
		int c=scan.nextInt();
		int[] source=new int[2];
		int[] sink=new int[2];
		char[][] grid=new char[r][c];
		for(int i=0;i<r;i++){
			grid[i]=scan.nextLine().toCharArray();
			for(int j=0;j<c;j++){
				if(grid[i][j]=='S'){
					source[0]=i; source[1]=j;
				}
				else if(grid[i][j]=='T'){
					sink[0]=i; sink[1]=j;
				}
			}
		}
		int s0=source[0]; int s1=source[1];
		char[] r1=grid[source[0]];
		int fdr=c-1, fdl=0, fdu=0, fdd=r-1;
		boolean rmax=false, lmax=false;
		//s branch hor
		int right=s1; int left=s1;
		while(right<c || left >=0){
			if(right < c && grid[s0][right]!='*'){
				grid[s0][right]='#';
			}else if(!rmax){
				fdr=right-1;
				right=c;
				rmax=true;
			}
			
			if(left >=0 && grid[s0][left]!='*'){
				grid[s0][left]='#';
			}else if(!lmax){
				fdr=left+1;
				left=-1;
				lmax=true;
			}
			right++; left--;
		}
		
		
		//rigt branch ver
		int up=s0; int down=s0;
		while(up>=0 || down < r){
			if(up >=0 && grid[up][fdr]!='*'){
				grid[up][fdr]='#';
			}else{
				up=-1;
			}
			
			if(down < r && grid[down][fdr]!='*'){
				grid[down][fdr]='#';
			}else{
				down=r;
			}
			
			up--; down++;
		}
		
		
		//s branch ver
		boolean umax=false, dmax=false;
		up=s0; down =s0;
 		while(up>=0 || down < r){
			if(up >=0 && grid[up][s1]!='*'){
				grid[up][s1]='#';
			}else if(!umax){
				fdu=up+1;
				up=-1;
				umax=true;
			}
			
			if(down < r && grid[down][s1]!='*'){
				grid[down][s1]='#';
			}else if(!dmax){
				fdd=down-1;
				down=r;
				dmax=true;
			}
			
			up--; down++;
		}
		
		
		//left branch ver
		up=s0; down=s0;
		while(up>=0 || down < r){
			if(up >=0 && grid[up][fdl]!='*'){
				grid[up][fdl]='#';
			}else{
				up=-1;
			}
			
			if(down < r && grid[down][fdl]!='*'){
				grid[down][fdl]='#';
			}else{
				down=r;
			}
			
			up--; down++;
		}
		
		//------------------
		//top branch hor
		right=s1; left=s1;
		while(right<c || left >=0){
			if(right < c && grid[fdu][right]!='*'){
				grid[fdu][right]='#';
			}else{
				right=c;
			}
			
			if(left >=0 && grid[fdu][left]!='*'){
				grid[fdu][left]='#';
			}else{
				left=-1;
			}
			right++; left--;
		}
		
		//botton branch hor
		right=s1; left=s1;
		while(right<c || left >=0){
			if(right < c && grid[fdd][right]!='*'){
				grid[fdd][right]='#';
			}else{
				right=c;
			}
			
			if(left >=0 && grid[fdd][left]!='*'){
				grid[fdd][left]='#';
			}else{
				left=-1;
			}
			right++; left--;
		}
		
		boolean possible=false;
		//sink
		int sr=sink[0], sc=sink[1];
		right=sc; left=sc;
		while((right<c || left >=0) && !possible){
			if(right < c && grid[sr][right]!='*'){
				if(grid[sr][right]=='#'){
					possible=true;
				}
			}else{
				right=c;
			}
			
			if(left >=0 && grid[sr][left]!='*'){
				if(grid[sr][left]=='#'){
					possible=true;
				}
			}else{
				left=-1;
			}
			right++; left--;
		}
		
		up=sr; down =sr;
 		while((up>=0 || down < r) && (!possible)){
			if(up >=0 && grid[up][sc]!='*'){
				if(grid[up][sc]=='#'){
					possible=true;
					break;
				}
			}else{
				up=-1;
			}
			
			if(down < r && grid[down][sc]!='*'){
				if(grid[down][sc]=='#'){
					possible=true;
					break;
				}
			}else{
				down=r;
			}
			
			up--; down++;
		}
		/*
		for(char[] f: grid){
			System.out.println(Arrays.toString(f));
		}*/
		if(possible)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
		
		
		
		
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
