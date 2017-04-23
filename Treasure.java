import java.util.*;
import java.io.*;


//Modified Markov Property Solution
public class Treasure {

	public static void main(String[] args) throws FileNotFoundException{
		Scanner scan=new Scanner(new File("treasure.dat"));
		int inputs=scan.nextInt();
		
		for(int i=0;i<inputs;i++){
			int moves=scan.nextInt();
			int[] start=new int[2];			
			int[][] map=new int[scan.nextInt()+2][scan.nextInt()+2];
			
			for(int j=0;j<map.length;j++){
				String[] line=scan.next().split("");
				for(int k=0;k<line.length;k++){
					if(line[k].equals("*")){
						start[0]=j;
						start[1]=k;
						map[j][k]=0;
					}
					else if(line[k].equals("."))
						map[j][k]=0;
					else
						map[j][k]=Integer.parseInt(line[k]);
					
				}
			}
			
			System.out.println(maxTreasure(map, start, moves));
			
		}
	}

	/*max treasure at any location is equal to maxTreasure at 
	if moves==1, best move is equal to maximum(map, start)[2];
	if moves==2, maxTreasure is best move + maxTreasure at the next position
	*/
	
	public static int maxTreasure(int[][] map, int[] start, int moves){
		int[] step=new int[2];
		int[] max=maximum(map, start);
		step[0]=max[0];
		step[1]=max[1];
		int value=max[2];
		map[step[0]][step[1]]=0;
		if(moves==1){
			return value;
		}
		return value+maxTreasure(map, step, moves-1);
	}
	
	//given map and starting point, returns position of best single move and value
	public static int[] maximum(int[][] map, int[] start){
		
		int x=start[0];
		int y=start[1];
		int[] position=new int[4];
		
		try{
			position[0]=map[x+1][y];
		}
		catch(Exception e){
			position[0]=-1;
		}
		
		try{
			position[1]=map[x-1][y];
		}
		catch(Exception e){
			position[1]=-1;
		}
		
		try{
			position[2]=map[x][y+1];
		}
		catch(Exception e){
			position[2]=-1;
		}
		
		try{
			position[3]=map[x][y-1];
		}
		catch(Exception e){
			position[3]=-1;
		}
		int max=position[0];
		int index=0;
		
		for(int i=0;i<position.length;i++){
			if(position[i]>max){
				max=position[i];
				index=i;
			}
		}
		
		int[] maxpos=new int[3];
		maxpos[2]=max;
		
		switch(index){
		case 0: 
			maxpos[0]=x+1;
			maxpos[1]=y;
			break;
		case 1:
			maxpos[0]=x-1;
			maxpos[1]=y;
			break;
		case 2:
			maxpos[0]=x;
			maxpos[1]=y+1;
			break;
		case 3:
			maxpos[0]=x;
			maxpos[1]=y-1;
			break;
		}
		
		return maxpos;
		
	}
}
