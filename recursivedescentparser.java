package spcc_pracs;

import java.util.*;
public class recursivedescentparser
{
static int ptr;
static char str[];

public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the input string");
		String s=sc.nextLine();
		s=s+"$";
		
		str= s.toCharArray();
		if(str.length < 2) {
		System.out.println("The input string is invalid.");
		System.exit(0);
		}
		
		ptr=0;		
		if(E() && (ptr+1 == str.length)) 
			System.out.println("The input string is valid.");
		else 
			System.out.println("The input string is invalid.");
	}	
	
	static boolean E()
	{
		if(T())
		{	
			if(A())
			{	
				return true;
			}
		}	
		return false;	
	}
	
	static boolean A()
	{
		int temp=ptr;
		if(ptr!=str.length) {
		if(str[ptr]=='+')
		{
			ptr++;			
			if(T())			
			{	
				if(A())
				{
					return true;
				}
			}
			
		}
		}
		ptr=temp;
		System.out.println(ptr);
		return true; 
	}
	
	static boolean T()
	{
		if(F())
		{
			if(B())
			{	
				return true;
			}
		}		
		return false;	
	}
	
	static boolean B()
	{
		int temp=ptr;
		
		if(ptr!=str.length) 
		{
		if(str[ptr]=='*')
		{
			ptr++;
			if(F())			
			{
				if(B())
				{
					return true;
				}
			}
			/*else 
				return false;*/
		}
		}
		ptr=temp;
		return true; 
	}
	
	static boolean F()
	{

		int temp=ptr;
		if(ptr!=str.length)
		{
		if(str[ptr]=='(')
		{
			ptr++;
				if(E())
				{	

					if(str[ptr]==')')
					{
						ptr++;
						return true;
					}
				}
				
		}
		else if(str[ptr]=='a')
		{
			ptr++;
			return true;
		}
		}
		ptr=temp;
		return false;
		
	}
}
