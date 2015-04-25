
public class RedBlack_Tree {
	
	private Node root;
	
	public RedBlack_Tree() {
		root = null;
	}
	
	public void insert(int v)
	{
		if(root ==null)
		{
			root = new Node(v, Color.Black, null);
			return;
		}
		
		Node iterator = root;
		Node newNode = 	insertRec(v, iterator);
		
		traverseColors(newNode);
		
	}
	////////////////////////////////////////////
	
	public void print ()
	{
		printRec(root, 0);
	}
	private void printRec (Node iterator, int level)
	{
		if(iterator == null)
			return;
		
		printRec(iterator.left, level +1 );
		
		System.out.println("level = " + level + "  value = " + iterator.value + " color " + iterator.color);
		
		printRec(iterator.right, level +1 );
		
	}
	////////////////////////////////////////////
	private Node insertRec(int v, Node iterator)
	{
		if(v <= iterator.value)
		{
			if(iterator.left == null)
			{
				iterator.left = new Node(v, Color.Red, iterator);
				return iterator.left;
			}
			return insertRec(v, iterator.left);
		}
		
		else
		{
			if(iterator.right == null)
			{
				iterator.right = new Node(v, Color.Red, iterator);
				return iterator.right;
			}
			return insertRec(v, iterator.right);
		}
		
		
	}
	/////////////////////////////
	private void traverseColors(Node iterator)
	{
		if(iterator == null)
			return;
		// reach root
		if(iterator.parent == null)
		{
			iterator.color = Color.Black;
			return;
		}
		////////////////////////////////////////
		// no problem here
		if(iterator.parent.color == Color.Black)
			return;
		
		
		// parent is red and uncle is red
		if(iterator.color == iterator.getUncle().color)
		{
			//System.out.println("Uncle Red");
			iterator.parent.color = iterator.getUncle().color = Color.Black;
			
			iterator.parent.parent.color = Color.Red;
			
			iterator = iterator.parent.parent;
		}
		// uncle is black
		else
		{
			//System.out.println("Uncle Black");
			
		}
		
		traverseColors(iterator);
	}
	
	
}
