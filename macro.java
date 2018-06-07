package spcc_pracs;

import java.io.*;
import java.util.*;

public class macro {
	public static void main(String args[]) throws IOException
	{
		Scanner sc =new Scanner(System.in);
		 String mnt[][]=new String[5][3]; //assuming 5 macros in 1 program
		 String ala[][]=new String[10][2]; //assuming 2 arguments in each macro
		 String mdt[][]=new String[20][1];  
		int mntc=0,mdtc=0,alac=0,i,j,index=0,index1,alap=0,mdtp,flag=0;
		
		BufferedReader  f = null;
		try {
			f = new BufferedReader(new FileReader("C:\\Users\\Govind Kalena\\Desktop\\inputm.txt"));
			} 
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		
		FileWriter outFile = new FileWriter("C:\\Users\\Govind Kalena\\Desktop\\outputm.txt");
	    PrintWriter riter = new PrintWriter(outFile);
		
		String s,s1,pr="",substring,temp;
		
		 while((s=f.readLine())!=null)
	        { 
	        	if(s.equals("MACRO"))
	        	{
	        		pr=s;
	        		for(;!(s=f.readLine()).equalsIgnoreCase("MEND");mdtc++,pr=s)
	        		{
	        			if(pr.equals("MACRO"))
	        			{
	        				 StringTokenizer st=new StringTokenizer(s);
	        				 String str[]=new String[st.countTokens()];
	        				 
	        				 for(i=0;i<str.length;i++) {
	        					 str[i]=st.nextToken();
	        					 }
	        					 mnt[mntc][0]=(mntc+1)+""; //mnt formation
	        					 mnt[mntc][1]=str[0];
	        					 mnt[mntc++][2]=(++mdtc)+"";
	        				 st=new StringTokenizer(str[1],","); //tokenizing the arguments

	        				 String string[]=new String[st.countTokens()];

	        				 for(i=0;i<string.length;i++)
	        				 {
	        				 string[i]=st.nextToken();
	        				 ala[alac][0]=alac+""; //ala table formation
	        				 index=string[i].indexOf("=");
	        				 if(index!=-1)
	        				 ala[alac++][1]=string[i].substring(0,index);
	        				 else
	        				 ala[alac++][1]=string[i];
	        				 }
	        				 
	        			}
	        			{ //mdt formation
	        				 index=s.indexOf("&");
	        				 substring=s.substring(index);
	        				 for(i=0;i<alac;i++)
	        				 if(ala[i][1].equals(substring))
	        				 s=s.replaceAll(substring,"#"+ala[i][0]);
	        			}
	        			mdt[mdtc-1][0]=s;
	        		}
	        		mdt[mdtc-1][0]=s;
	        	}
	        	else
	        	{
	        		riter.println(s);
	        	}
	        }
			riter.close();
			System.out.println("\nMacro Table(MNT)");
			 display(mnt,mntc,3);
			 System.out.println("\n\nArgument Array(ALA) for Pass1");
			 display(ala,alac,2);
			 System.out.println("\n\nMaro Definition Table(MDT)");
			 display(mdt,mdtc,1);
			 System.out.println("\n\n\n");
			 
			 
			 BufferedReader  f1 = null;
			try {
				 f1 = new BufferedReader(new FileReader("C:\\Users\\Govind Kalena\\Desktop\\outputm.txt"));
				 } 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();}
			 
			 FileWriter outFile1 = new FileWriter("macroop2.txt");
			 PrintWriter writer = new PrintWriter(outFile1);
			 
			 for(;(s1=f1.readLine())!=null;flag=0)
			 {System.out.println(s1);
				 StringTokenizer st1=new StringTokenizer(s1);
				 String str[]=new String[st1.countTokens()];
				 //System.out.println(str.length);
				 for(i=0;i<str.length;i++) 
					 str[i]=st1.nextToken();
					 //System.out.println(str[i]);
				 
				 for(j=0;j<mntc;j++)
				 {
				 if(str[0].equals(mnt[j][1]))
				 {
				 mdtp=Integer.parseInt(mnt[j][2]);
				 st1=new StringTokenizer(str[1],",");
				 String arg[]=new String[st1.countTokens()];
				 for(i=0;i<arg.length;i++)
				 {
				 arg[i]=st1.nextToken();
				 System.out.println(arg[i]);
				 ala[alap++][1]=arg[i];
				 }
				 for(i=mdtp;!(mdt[i][0].equalsIgnoreCase("MEND"));i++) //expand till MEND
				 {
				 index1=mdt[i][0].indexOf("#");
				 temp=mdt[i][0].substring(0,index1);
				 temp+=ala[Integer.parseInt(""+mdt[i][0].charAt(index1+1))][1]; //converting char->string->integer & appending it
				 writer.println(temp);
				 }
				 flag=1;
				 }
				 }
				 if(flag==0) //when it is not a macro
				 {
				 writer.println(s1);
				 }
			 }
			 writer.close();
			 
			 System.out.println("Argument Array(ALA) for Pass2");
			 display(ala,alac,2);
			 
			 
			 
	}
			 static void display(String a[][],int n,int m)
			 {
				 //System.out.println(n+" "+m);
			 int i,j;
			 for(i=0;i<n;i++)
			 {
			 for(j=0;j<m;j++)
			 System.out.print(a[i][j]+" ");
			 System.out.println();
			 }
			 }        		
	        			
	
}
