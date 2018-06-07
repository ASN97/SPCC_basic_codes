package spcc_pracs;
import java.io.*;
import java.util.*;
public class lexical {


@SuppressWarnings("resource")
public static void main(String args[])throws IOException
 {
 	String[] keyword = {"void","do","include","continue","else","if","for","return","void","double","int","float","char"};
	String[] functions = {"main","printf","scanf"};
 	String[] operators = {"+","-","*","/","%","=","<",">"};
	String[] spcl = {",", ";", "}", "{", "(", ")", "#"};
    String[] header = {"stdio.h","conio.h"};
    String constants[]=new String[10];
	String variables[]=new String[10];
	
	String lex[] = new String[100]; 
	String var[] = new String[100];
	BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Govind Kalena\\Desktop\\input.txt"));
	//Writer riter = new FileWriter("opt.txt");
	
	FileWriter outFile = new FileWriter("C:\\Users\\Govind Kalena\\Desktop\\output.txt");
    PrintWriter riter = new PrintWriter(outFile);
	
	String s;
	int i,j=0, count=0, count1=0,k=0;
  
	StringTokenizer st;
	while ((s=br.readLine()) != null)
   	{ 
   	 
   	  st= new StringTokenizer(s," \n,;(){}+-=#<>",true);
   	  String temp;
   	  
   	  while(st.hasMoreTokens())	
   	  {
   		  
   		  int flag = 0;
   	  	  temp = st.nextToken();
   	  
   	  	   	  	  
   	  	  if(temp.equals(" ") )
   	  	  {
   	  		  temp = st.nextToken();
   	  		  }
   	 
   	  
   	  	  for (i=0;i<keyword.length;i++)
   	  		  if(temp.equals(keyword[i]))
   	  		  {
   	  			  lex[j++] = "keyword";
   	  			  riter.println(temp  +"   "+ lex[j-1]);
   	  			  System.out.println(temp  +"   "+ lex[j-1]);
   	  			  
   	  			
   	  			for(j=9;j<keyword.length;j++)
				{
					if(temp.equals(keyword[j]))
					{
						String temp1 = st.nextToken();
		   	  			temp1 = st.nextToken();
		   	  			char varch[]= temp1.toCharArray();
		   	  			if(!Character.isDigit(varch[0])) {
						lex[j++] = "variable";
						var[k]=temp1;
						k++;
						riter.println(temp1  +"   "+ lex[j-1]);
						System.out.println(temp1  +"   "+ lex[j-1]);}
		   	  									
					}
				}
  	  			  flag = 1;
   	  			  break;
   	  		  }
   	  	  
   	   for (i=0;i<header.length;i++)
	  		  if(temp.equals(header[i]))
	  		  {
	  			  lex[j++] = "header";
	  			  riter.println(temp  +"   "+ lex[j-1]);
	  			  System.out.println(temp  +"   "+ lex[j-1]);
	  			  flag = 1;
	  			  break;
	  		  }
   	  	  
   	      	  	
   	  	  for (i=0;i<functions.length;i++)
   	  		  if(temp.equals(functions[i]))
   	  		  {
   	  			  lex[j++] = "function";
   	  			  riter.println(temp  +"   "+  lex[j-1]);
   	  			  System.out.println(temp  +"   "+  lex[j-1]);
   	  			  flag = 1;
   	  			  break;
   	  		  }
   	  	
   	  	  for (i=0;i<spcl.length;i++)
   	  		  if(temp.equals(spcl[i]))
   	  		  {
   	  			  lex[j++] = "special char";
   	  			  riter.println(temp  +"   "+ lex[j-1]);
   	  			System.out.println(temp  +"   "+ lex[j-1]);
   	  			  flag = 1;
   	  			  break;
   	  		  }
   	  	
   	  	  for (i=0;i<operators.length;i++)  	  	  
   	  		  if(temp.equals(operators[i]))
   	  		  {
   	  			  lex[j++] = "operators";
   	  			  riter.println(temp  +"   "+ lex[j-1]);
   	  			  System.out.println(temp  +"   "+ lex[j-1]);
   	  			  flag = 1;
   	  			  break;
   	  		  }
		
		
   	  	  char[] ch=temp.toCharArray();
   	  	  if (Character.isDigit(ch[0]) && flag!= 1)
   	  	  {
   	  		  	lex[j++]="constant";
   	  		  	constants[count] = temp;
   	  		  	count++;
   	  		  	riter.println(temp  +"   "+ lex[j-1]);
   	  		System.out.println(temp  +"   "+ lex[j-1]);
   	  		  	flag = 1;  	  		
   	  	  }
   	  	  if (!Character.isDigit(ch[0]) && flag!= 1)
   	  	  {    
   	  		  for(i=0;i<k;i++)
   	  		  {
   	  			  if(temp.equals(var[i]))
   	  			  {
   	  				  lex[j++]="variablee";
   	  				  flag=1; 	  	
   	  				  riter.println(temp  +"   "+ lex[j-1]);
   	  				  System.out.println(temp  +"   "+ lex[j-1]);

   	  			  }
   	  		  }
   	  		  if(flag!=1)
   	  		  {
   	  			  lex[j++]="identifier";
   	  			  variables[count1] = temp;
   	  			  count1++;
   	  			  riter.println(temp  +"   "+ lex[j-1]);
   	  			System.out.println(temp  +"   "+ lex[j-1]);
   	  	
   	  		  }
   	  	  }  	 
   	  }
	}
	riter.close();
	
 }   	  	
}