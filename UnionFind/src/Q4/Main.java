package Q4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws FileNotFoundException{
		
		int length;
		
		File file = new File("in.txt");
		Scanner input = new Scanner( file );
		
		length = input.nextInt();
		
		int [] arr = new int [length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		int commands = input.nextInt();
		
		UnionFind union = new UnionFind(arr);
		
		PrintWriter out = new PrintWriter("out.txt");
		for (int i = 0; i < commands; i++) {
			String cmd = input.next();
			
			switch (cmd) {
			case "Union":
				int ele1 = input.nextInt();
				int ele2 = input.nextInt();
				union.union(ele1, ele2);
				break;
				
			case "Print":
				out.println(union.print());
				break;
			
			case "Find":
				int element = input.nextInt();
				int classs = union.getClass(element);
				
				out.println(element + " is in S" + (classs+1) +", representative=" + union.getRepresentative(classs));
				
				break;	
			default:
				break;
			}
			
			
		}
		
		out.close();
		
	}
}
