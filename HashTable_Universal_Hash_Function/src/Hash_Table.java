import java.util.*;


public class Hash_Table {
	// n
	private int capacity;
	
	private int a1;
	private int a2;
	private int a3;
	private int a4;
	// array list to make a chain
	private Keys[] keys;
	private Values[] values;
	
	
	public Hash_Table(int capacity) {
		super();
		this.capacity = capacity;
		
		keys = new Keys[capacity];
		values = new Values[capacity];
		Random r = new Random();
		
		a1 = r.nextInt(capacity);
		a2 = r.nextInt(capacity);
		a3 = r.nextInt(capacity);
		a4 = r.nextInt(capacity);
		
	}
	
	
	public Hash_Table() {
		this(1000);
	}


	public Integer get (Integer key)
	{
		
		int hashKey = calcHashFunction(key);
		// key not found
		if(keys[hashKey] == null)
			return null;
		// search in chain
		int indx = keys[hashKey].indexOf(key);
		if(indx != -1)
			return values[hashKey].get(indx);
		
		// it was a collegion
		return null;
	}
	//////////////////////
	
	public void put (Integer key, Integer value)
	{
		// key not found before 
		int hashKey = calcHashFunction(key);
		if(keys[hashKey] == null)
		{
			keys[hashKey] = new Keys();
			values[hashKey] = new Values();
			
			keys[hashKey].add(key);
			values[hashKey].add(value);
			
		}
		// it exists before 1-same key 2-collegion
		else
		{
			int indx = keys[hashKey].indexOf(key);
			// key exists
			if(indx != -1)
				values[hashKey].set(indx, value);
			// new key and it is a collegion
			else
			{
				System.out.println("Collegion happend");
				keys[hashKey].add(value);
				values[hashKey].add(value);
			}
		}
		
	}
	
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	private int calcHashFunction(Integer key)
	{
		int x1, x2, x3, x4 =0;
		
		x1 = (key >> 0) & 0xff;
		x2 = (key >> 8) & 0xff;
		x3 = (key >> 16) & 0xff;
		x4 = (key >> 24) & 0xff;
		
		return (x1*a1 + x2*a2 + x3*a3 + x4*a4 ) % capacity;  
	}
	
}


class Keys extends ArrayList<Integer>{}
class Values extends ArrayList<Integer>{}
