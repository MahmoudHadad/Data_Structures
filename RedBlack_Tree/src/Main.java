import RedBlack.RedBlack_Tree;


public class Main {
	
	public static void main (String []args)
	{
		RedBlack_Tree tree = new RedBlack_Tree();
		
		tree.insert(3);
		tree.insert(5);
		tree.insert(7);

		tree.insert(1);
		tree.print();
		System.out.println("_______________________________________");
		
		tree.testRotateLeft();
		tree.print();
		System.out.println("_______________________________________");
		
		
	}
}
