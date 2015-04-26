import java.util.Scanner;

import RedBlack.RedBlack_Tree;


public class Main {
	
	public static void main (String []args)
	{
		Scanner sc = new Scanner(System.in);
		RedBlack_Tree tree = new RedBlack_Tree();
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			tree.insert(sc.nextInt());
		}
		
		tree.print();
		System.out.println("_______________________________________");
		
	
		
	}
}
