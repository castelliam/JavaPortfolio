import java.awt.List;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RegExp {
	
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> resWord = new ArrayList<String>();
		ArrayList<String> symbol = new ArrayList<String>();
		ArrayList<String> id = new ArrayList<String>();
		ArrayList num = new ArrayList();
		ArrayList lexError = new ArrayList();
		
		
		ArrayList<String> resWordCheck = new ArrayList<String>();
		resWordCheck.add("program");
		resWordCheck.add("is");
		resWordCheck.add("begin");
		resWordCheck.add("end");
		resWordCheck.add("var");
		resWordCheck.add("integer");
		resWordCheck.add("boolean");
		resWordCheck.add("skip");
		resWordCheck.add("read");
		resWordCheck.add("write");
		resWordCheck.add("while");
		resWordCheck.add("do");
		resWordCheck.add("if");
		resWordCheck.add("then");
		resWordCheck.add("else");
		resWordCheck.add("not");
		resWordCheck.add("true");
		resWordCheck.add("false");
		resWordCheck.add("and");
		resWordCheck.add("or");
		
		ArrayList<String> resSymCheck = new ArrayList<String>();
		resSymCheck.add(":");
		resSymCheck.add(";");
		resSymCheck.add(":=");
		resSymCheck.add("<=");
		resSymCheck.add(">=");
		resSymCheck.add("<>");
		resSymCheck.add("<");
		resSymCheck.add(">");
		resSymCheck.add("=");
		resSymCheck.add("+");
		resSymCheck.add("-");
		resSymCheck.add("/");
		resSymCheck.add("*");
		resSymCheck.add("(");
		resSymCheck.add(")");
		resSymCheck.add("");
		
		
		ArrayList a = new ArrayList();
		BufferedReader r = new BufferedReader(new FileReader("TestFile.txt"));
		
		String line;
		while((line = r.readLine()) != null)
		{
			String[] current = line.split(" ");;
			
			for(int i = 0; i < current.length; i++)
			{
				a.add(current[i]);
			}
		}
		
		for(int i = 0; i < a.size(); i++)
		{
			Object x = a.get(i);
			Character firstLetter = new Character(x.toString().charAt(0));
			//System.out.println("FirstLetter: " + firstLetter + " Value: " + firstLetter.hashCode());
			
			if(resWordCheck.contains(x)) //is it a reserved word?
			{
				resWord.add(x.toString());
			}
			else if(resSymCheck.contains(x)) //is it a symbol?
			{
				symbol.add(x.toString());
			}
			else if(x.toString().contains(".")) //is it a decimal digit?
			{
				
				Boolean containsNumber = false;
				
				String s = x.toString();
				for(int y = 0; y < s.length(); y++)
				{
					Character c = new Character(s.charAt(y));
					
					if(c.hashCode() >= 48 && c.hashCode() <= 57)
					{
						containsNumber = true;
					}
				}
				if(containsNumber == true) num.add(s);
				else lexError.add(s);
			}
			else if(firstLetter.hashCode() >= 97 && firstLetter.hashCode() <= 192) //is it a user-defined ID
			{
				Boolean containsNumber = false;
				
				String s = x.toString();
				for(int y = 0; y < s.length(); y++)
				{
					Character c = new Character(s.charAt(y));
					
					if(c.hashCode() >= 48 && c.hashCode() <= 57)
					{
						containsNumber = true;
					}
				}
				if(containsNumber == true) id.add(s);
				else lexError.add(s);
				
			}
			else // it is a lexical error
			{
				lexError.add(x);
			}
		}
		
		//print words
		System.out.println("Reserved word results: ");
		for(int i = 0; i < resWord.size(); i++)
		{
			System.out.println(resWord.get(i));
		}
		System.out.println();
		
		//print symbols
		System.out.println("Symbol results: ");
		for(int i = 0; i < symbol.size(); i++)
		{
			System.out.println(symbol.get(i));
		}
		System.out.println();
		
		//print userDefinedID
		System.out.println("User Defined ID results: ");
		for(int i = 0; i < id.size(); i++)
		{
			System.out.println(id.get(i));
		}
		System.out.println();
		
		//print numeral
		System.out.println("Numeral results: ");
		for(int i = 0; i < num.size(); i++)
		{
			System.out.println(num.get(i));
		}
		System.out.println();
		
		//print lexical error
		System.out.println("Lexical error results: ");
		for(int i = 0; i < lexError.size(); i++)
		{
			System.out.println(lexError.get(i));
		}
		System.out.println();
		
	}
	
	
	
	
	
}
