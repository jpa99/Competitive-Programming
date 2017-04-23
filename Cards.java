import java.io.*;
import java.util.*;

public class Cards {

	public static void main(String[] args) throws Exception {
		Scanner scan=new Scanner(new File("base3.dat"));
		
		while(scan.hasNextLine()){
			String[] s=scan.nextLine().split(" ");
			Card[] hand=new Card[6];
			for(int i=0;i<hand.length;i++){
				hand[i]=new Card(s[i], 1);
			}
			for(int i=0;i<hand.length;i++){
				hand[i].changeNum(numel(hand, hand[i]));
			}
			Arrays.sort(hand);
			System.out.println(Arrays.toString(hand));
			for(int i=5;i<s.length;i++){
				hand[0]=new Card(s[i], 1);
				for(int a=0;a<hand.length;a++){
					hand[a].changeNum(numel(hand, hand[a]));
				}
				Arrays.sort(hand);
			}
			
			for(int z=1;z<hand.length;z++){
				System.out.print(hand[z].value+" ");
				
			}
			System.out.println();
		}
		

	}
	
	public static int numel(Card[] hand, Card c){
		int num=0;
		for(int i=0;i<hand.length;i++){
			if(hand[i].value.equals(c.value)){
				num++;
			}
		}
		return num;
	}

}

class Card implements Comparable{

	public String value;
	public int num;
	public int compareTo(Card b) {
		if(b.num < num){
			return 1;
		}
		else if(num < b.num){
			return -1;
		}
		else{
			int v, v2;
			if(value.equals("J")){
				v=11;
			}
			else if(value.equals("Q")){
				v=12;
			}
			else if(value.equals("K")){
				v=13;
			}
			else if(value.equals("A")){
				v=14;
			}
			else{
				v=Integer.parseInt(value);
			}
			
			if(b.value.equals("J")){
				v2=11;
			}
			else if(b.value.equals("Q")){
				v2=12;
			}
			else if(b.value.equals("K")){
				v2=13;
			}
			else if(b.value.equals("A")){
				v2=14;
			}
			else{
				v2=Integer.parseInt(b.value);
			}
			
			if(v<v2){
				return -1;
			}
			else{
				return 1;
			}
		}
	}
	
	public Card(String value, int num){
		this.value=value;
		this.num=num;
	}
	
	
	public void changeNum(int num){
		this.num=num;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public String toString(){
		return value;
	}
}
