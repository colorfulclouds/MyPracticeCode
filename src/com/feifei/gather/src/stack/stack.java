package stack;
import java.util.*;
import java.io.*;
//Õ»
public class stack {

	public static void main(String[] args) {

		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		char ch;
		Stack<Character> stack = new Stack<Character>();
		
		fin = new FileInputStream(FileDescriptor.in);
		System.out.println("Ò»ÐÐ×Ö·û:");
		
		try {
			
			while((ch = (char)fin.read())!='\r')
				stack.push(ch);
			
			fin.close();
			
			fout = new FileOutputStream(FileDescriptor.out);
			
			while(!stack.empty())
				fout.write((char)stack.pop());
			
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

}
