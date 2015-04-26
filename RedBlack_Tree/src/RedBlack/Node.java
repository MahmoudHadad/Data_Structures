package RedBlack;

public class Node {
	
	public int value;
	public Color color;
	public Node parent;
	public Node left;
	public Node right;
	
	public Node(int value, Color color, Node parent) {
		super();
		this.value = value;
		this.color = color;
		this.parent = parent;
		
		left = null;
		right = null;
		
	}
	
	public Node getUncle()
	{
		if(this.parent == this.parent.parent.left)
		{
			return this.parent.parent.right;
		}
		else 
			return this.parent.parent.left;
			
	}
	
	
}
