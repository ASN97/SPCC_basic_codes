package spcc_pracs;

import java.util.Scanner;

public class codegeneration{

	static char register[]=new char[50];
	static int c;
	public static void main(String args[])
	{
		int n;
		String ip[];
		String op="";
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter no. of lines:");
		n=sc.nextInt();
		ip=new String[n];
		System.out.println("Enter code:");
		for(int i=0;i<n;i++)
		ip[i]=sc.next();
		op=op+"\n";	
		for(int i=0;i<n;i++)
		{
			char temporary[]=ip[i].toCharArray();
			int k=search(temporary[2]);
			int j=search(temporary[4]);
			if(k==-1)
			{
				op=op+"MOV  "+"R"+c+","+temporary[2]+"\n";
				register[c]=temporary[2];
			}	
			String s=searchOperator(temporary[3]);
			op=op+s;
			if(j==-1)
			{
				op=op+"R"+c+","+temporary[4]+"\n";
				register[c++]=temporary[0];
			}
			else if(k==-1)
			{
				op=op+"R"+c+",R"+j+"\n";
				register[c++]=temporary[0];
			}
			else if(j!=-1&&k!=-1)
			{
				op=op+"R"+k+",R"+j+"\n";
				register[k]=temporary[0];
			}
			if(i==ip.length-1)
			{
				int h=search(temporary[0]);
				op=op+"MOV  "+temporary[0]+",R"+h+"\n";
			}
			op=op+"\n";
		}
		System.out.println(op);
	}
	static int search(char c)
	{
		for(int i=0;i<register.length;i++)
		{
			if(register[i]==c)
			return i;	
		}
		return -1;
	}
	static String searchOperator(char c)
	{
		switch(c)
		{
			case '+':
			return "ADD  ";
			case '-':
			return "SUB  ";
			case '*':
			return "MUL  ";
			case '/':
			return "DIV  ";
		}
		return "";
	}
}
