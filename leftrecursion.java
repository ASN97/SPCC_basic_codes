package spcc_pracs;

import java.util.*;
import java.io.*;

public class leftrecursion{
	
	public static void main(String arhs[])
	{
		int n,i,j,x,c=0,ch=0,chh=0,k;
		String str,extra,neww = null;
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter no.");
		n=scanner.nextInt();
		String[] s= new String[n];
		String[] l= new String[100];
		String[] r= new String[100];
		int[] isrec =  new int[n];
		String[] newr= new String[100];
		String[] newrr= new String[100];
		String[] newrrr= new String[100];
		String[] recextra= new String[n];
		String[] arrOfStr = new String[100];
		String[] split1 = new String[100];
		String[] split0 = new String[100];



System.out.println("enter the input grammer: ");
		for(i=0; i<n; i++){
			s[i]=scanner.next();
			int index = s[i].indexOf("-");
			l[i]=s[i].substring(0,index);
			r[i]=s[i].substring(index+1);	
		}
		
		if(l[0].charAt(0)==r[1].charAt(0)) {
			if(r[0].charAt(0)==l[1].charAt(0)) {
				System.out.println("indir at: " +l[1]);
				split0 = r[0].split("/", 5);
				split1 = r[1].split("/", 5);
				for (String a : split0)
				{newrr[ch] = a;
	            System.out.println("\nSplit0  "+ newrr[ch]);
				ch++;}
				for (String a : split1)
				{newrrr[chh] = a;
				System.out.println("\nSplit1  "+ newrrr[chh]);
				chh++;}
				
				newrrr[0] = newrrr[0].substring(1);
				//System.out.println(newrrr[0]);
				r[1]="";
				for(k=0; k<ch; k++) {
					r[1]= r[1]+newrr[k] + newrrr[0]+ "/";
					System.out.println("r1: "+r[1]);

				}
				System.out.println("r11: "+r[1]);
				
				for(i=1; i<chh; i++) {
				r[1]+=newrrr[i];
				System.out.println(r[1]);
			}}
		}



/*
		 * s-aa/x
a-ss/y
		 */
			
		for(i=0; i<n; i++){
		System.out.println("\nLeft is: "+ l[i]);
		System.out.println("Right is: "+ r[i]);
		
		if(l[i].charAt(0)==r[i].charAt(0)){
			System.out.println("Left recursion at: " +l[i]);
			isrec[i]=1;
			
			x= r[i].indexOf("/");
			recextra[i]=r[i].substring(1,x);
			System.out.println("Extra of rec: "+recextra[i]);
			
			r[i]= r[i].substring(x+1);
			arrOfStr = r[i].split("/", 5);
			for (String a : arrOfStr)
			{newr[c] = a;
            System.out.println("\nSplit rec and non rec "+ newr[c]);
			c++;}
			System.out.println("\nEnter a new var");
			neww=scanner.next();
			recextra[i] +=neww+"/ epsilon";
			System.out.print(l[i]+" - ");
			for(k=0;k<c; k++) {
				
			System.out.print(newr[k] + neww + "/");}
			c=0;
			System.out.println("\n"+neww + " - " + recextra[i]);
		}
		else 
			isrec[i]=0;}
	
		
		System.out.println();
		for(i=0; i<n; i++) {
			if(isrec[i]==0)
				System.out.println(l[i] + " - " + r[i]);		
			}
		
		
	/*
	 * e-e+t/b/c
a-q/ss/bs
b-re/bb
d-d/tt
*/	
		
	}

}