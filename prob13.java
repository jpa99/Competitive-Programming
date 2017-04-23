import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class prob13 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner (new File("prob13.txt"));
		String name, decdegrees, classification;
		int RAhours, a;
		double RAminutes, mag, d, RA, dec, r, theta, phi, x, y, z, decminutes;
		int num=Integer.parseInt(scan.nextLine());
		for(int i=0;i<num;i++){
			name=scan.next();
			RAhours=scan.nextInt();
			RAminutes=scan.nextDouble();
			decdegrees=scan.next();
			a=scan.nextInt();
			classification=scan.next();
			mag=scan.nextDouble();
			d=scan.nextDouble();
			
			RA=15*RAhours+RAminutes/4;
			
			decminutes=Double.valueOf(a);
			if(decdegrees.substring(0,1).equals("+")){
				dec=Double.parseDouble(decdegrees)+(decminutes/60);
			}
			else{
				dec=Double.parseDouble(decdegrees)-(decminutes/60);
			}
			
			theta=(90-dec)*Math.PI/180;
			phi=RA*Math.PI/180;
			
			x=d*Math.sin(theta)*Math.cos(phi);
			y=d*Math.sin(theta)*Math.sin(phi);
			z=d*Math.cos(theta);
			
			System.out.println(name+" x="+x+", y="+y+", z="+z);
			
			
			
		}
		
	}

}
