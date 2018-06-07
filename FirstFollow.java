package spcc_pracs;
import java.util.*;
public class FirstFollow {
	Scanner sc=new Scanner(System.in);
	public static HashMap<Character , String[]> grammar=new HashMap<>();
	
	
	public static void printfirst(String s)
	{
		List<Character> out=new ArrayList<>();
		char[] o=s.toCharArray();
		for(char q: o)
		{ 
				if(!out.contains(q))
				out.add(q);
		}
		System.out.println("\nfinal: "+out);
	}
	
	
	public static void printfollow(String s)
	{
		List<Character> out=new ArrayList<>();
		char[] o=s.toCharArray();
		for(char q: o)
		{
			if(q=='#')
			{
				continue;
			}
			else 
				if(!out.contains(q))
				out.add(q);
		}
		System.out.println("\nfinal: "+out);
	}
	//HashMap<String,Integer> valmap = new HashMap<>();
//ystem.out.println("Enter the grammar to find first and follow.....");

public static HashMap<Character , String> first=new HashMap<>();
	public static HashMap<Character , String> follow=new HashMap<>();
	public static List<Character>terminals= Arrays.asList('a','b','d','g','h','#');
	public static List<Character>nonterminals= Arrays.asList('S','A','B','C');
	
	public static String first1(char F)
	{
		String ff="";
		System.out.print(" first("+F+") = ");
		for(String s : grammar.get(F))
		{			
			if(nonterminals.contains(s.charAt(0)))
			{
				
				ff=ff.concat(first1(s.charAt(0)));
			}
			else 
			{
				System.out.print(s.charAt(0)+" ");
				ff=ff.concat(Character.toString(s.charAt(0)));
			}
			
		}
		return ff;
	}
	
	
	public static String Follow1(char L)
	{
		
		String fl="";
		String rhs[];
		int m=0;
		
		
		for(char k : grammar.keySet())
		{
rhs=grammar.get(k);
			//System.out.println("\n\n : " +grammar.get(k) +"\n\n");
			if(k=='S')
			{
				fl=fl+"$";
			
			}
			for(String ss: rhs)
			{
				//System.out.println("\n\n : " +ss +"\n\n");
				//System.out.println("ss.length"+ ss.length());

				
				if((m=ss.indexOf(L))!=-1 && m<ss.length()-1)
					
				{
					//System.out.println("m 2: "+m);
					char a=ss.charAt(++m);
					if(nonterminals.contains(a))
					{
						String l=first1(a)	;
						fl=fl+l;
						if(l.indexOf("#")!=-1)
						{
							//System.out.println("++m: "+m+ " ss.length: "+ss.length());
							if(m+1<ss.length())
							{
								if(nonterminals.contains(ss.charAt(m+1)))
								{
									fl=fl+first1(ss.charAt(m+1));
								}
								else
									fl=fl+ss.charAt(m+1);
							}
							if(m+1==ss.length())
							{
								System.out.print(" follow("+k+") = ");
								fl=fl+Follow1(k);
								
							}

}
					
					}
					
					if(terminals.contains(a))
					{
						fl=fl+a;
						System.out.print(a);
					}
						
					
				}
				m=ss.indexOf(L);
				//System.out.println("m "+m);
			
				if(m==ss.length()-1 && nonterminals.contains(L))
				{   
					
					System.out.print(" follow("+k+") = ");	
					fl=fl+Follow1(k);
				}
				
			}
			
		
		}
	return fl;
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		grammar.put(new Character('S'),new String[]{"ACB","CbB","Ba"});
		grammar.put(new Character('A'),new String[]{"da","BC"});
		grammar.put(new Character('B'),new String[]{"g","#"});
		grammar.put(new Character('C'),new String[]{"h","#"});

System.out.println("The considered grammar is as follows: ");
		for(char t: grammar.keySet())
		{
			
			System.out.print(t+"->");
			for(String s: grammar.get(t))
			{
				System.out.print(s+" | ");
			}
			System.out.println();
		}
		System.out.println("Firsts of nonterminals....");
		for(char t: grammar.keySet())
		{
			
			System.out.print("first: "+t);
			printfirst(first1(t));
			System.out.println("------------------------------------");
		}
		System.out.println("/////////////////////////////////////////////////////////////////////////////");
		System.out.println("Follows of nonterminals....");
		for(char t: grammar.keySet())
		{
			System.out.println("follow: "+t);
			printfollow(Follow1(t));
			System.out.println("------------------------------------");
		}
		
		
	}

}


