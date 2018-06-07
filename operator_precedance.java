package spcc_pracs;

import java.util.*;


public class operator_precedance {
/*e is error, gi goal*/
	static char mat[][] = { 
			{ 'e', '(', ')', '^', '*', '/', '+', '-','i','$' },
    		  { '(', '<','=', '<', '<', '<', '<', '<', '<', 'e' },
    		   {')', 'e', '>', '>', '>', '>', '>', '>', 'e', '>'},
    		  { '^', '<', '>', '<', '>', '>', '>', '>', '<', '>'},
    		  { '*', '<', '>', '<', '<', '>', '>', '>', '<', '>'},
    		  { '/', '<', '>', '<', '>', '<', '>', '>', '<', '>'},
    		  { '+', '<', '>', '<', '<', '<', '>', '>', '<', '>'},
    		  { '-', '<', '>', '<', '<', '<', '>', '>', '<', '>'},
    		  { 'i', 'e', '>', '>', '>', '>', '>', '>', 'e', '>'},
    		  { '$', '<','e', '<', '<', '<', '<', '<', '<', '>' }       //change in $,$ value        		
    	  };
	static String E[]={")E(","E+E","E-E","E*E","E/E","E^E","i"};
    static Stack<Character> st=new Stack<Character>();
    
	public static void main(String args[])
	{
		
		int i;
		
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter the input string");		
		String input=sc.next();
		input=input+"$";
		char ch[]=input.toCharArray();
		
		st.push('$');
		i=0;
		
		while(i<input.length())
		{
			char temp=retrieve(st.peek(),ch[i]);
			
			if(temp=='<')
				st.push('<');

			if(temp=='>')
			{
				st.push('>');
				if(st.contains('<'))
				{
					char t=' ';
					String dummy="";
					st.pop();
					while(st.peek()!='<')
					{//pop till first '<' in stack
						 t=st.pop();
						 dummy=dummy+t;
					}
					st.pop();//'<' is also popped out
					for(int j=0;j<E.length;j++) 
						if(dummy.equals(E[j])){				
							st.push('E');
							System.out.println("Reduced E->"+dummy);
							break;
						}
				}
				while(reduce()) {
					
				}
			}
			else if(temp=='e'){
				System.out.println("String Not Accepted");
				System.exit(0);
			}
			display();
			st.push(ch[i]);
			display();
			i++;
			
		}
		
		if(st.toString().equals("[$, E, $]"))
		{
			System.out.println("String Accepted");
		}
		else
		{
			System.out.println("String Not Accepted");
		}
			
	}
	static char retrieve(char a,char b)
	{
		int i,j;
		char ans=' ';

		for(i=0;i<10;i++)
			for(j=0;j<10;j++)
			{
				if(a==mat[i][0] && b==mat[0][j]) //check in 1st row and column
				{
					ans=mat[i][j];
				}
			}
		
		return ans;
	}
	
	static void display()
	{
		System.out.println(st.toString());		
	}

	static boolean reduce()
	{
		int flag=0,i,j=0,top=0;
		String t="";
		for( i=0;i<E.length;i++) 
		{

			int len=E[i].length();	
			top=st.lastIndexOf(st.peek());
			//System.out.println("top: "+top);
			if(st.peek()==E[i].charAt(0) && top+1>len) 
			{
				flag=1;
				for(j=0;j<len;j++) 
				{		
					if(st.get(top-j)!=E[i].charAt(j) ) {				
						flag=0;
						break;
					}								
				}
				if(flag==1) //check for each element of string array
				{
					
					while(j!=0)
					{
						t=t+st.peek();
						st.pop();					
						j--;
					}
					st.push('E');
					System.out.println("Reducedd E->"+t);
					return true;
				}
			}
		}
		return false;
	}
}


