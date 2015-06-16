package Q4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



public class UnionFind {
	private int []Ids;
	private int []rank;
	private int []representativ;
	
	private  Map<Integer, Integer>map;
	
	public UnionFind(int []elements) {
		map = new HashMap<Integer, Integer>();
		
		representativ = elements;
		rank = new int [elements.length];
		Ids = new int [elements.length];
		for (int i = 0; i < elements.length; i++) {
			map.put(elements[i], i);
			Ids[i] = i;
			rank[i] = 1;
		}
	}
	
	
	
	public int getClass(int element)
	{
		int indx = map.get(element);
		
		int class_ = 0;
		ArrayList<Integer>path = new ArrayList<Integer>();
		while(Ids[indx] != indx)
		{
			path.add(indx);
			indx = Ids[indx];
		}
		class_ = Ids[indx];
		for (int i = 0; i < path.size(); i++) {
			Ids[path.get(i)] = class_;
		}
		return class_;
	}
	
	public int union(int element1, int element2)
	{
		int class1 = getClass(element1);
		int class2 = getClass(element2);
		
		if(rank[class1] > rank[class2])
		{
			Ids[class2] = Ids[class1];
			return class1;
		}
		else if(rank[class1] == rank[class2])
		{
			Ids[class2] = Ids[class1];
			rank[class1]++;
			return class1;
		}
		
		Ids[class1] = Ids[class2];
		return class2;
	}
	
	public int getRepresentative(int class_)
	{
		return representativ[class_];
	}
	
	public Map<Integer, ArrayList<Integer> > getElementsAndClasses(){
		Map<Integer, ArrayList<Integer> > classes = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i < representativ.length; i++) {
			ArrayList<Integer>arr;
			int classs = getClass(representativ[i]);
			
			if(classes.get(classs) == null)
			{
				arr = new ArrayList<Integer>();
				arr.add(representativ[i]);
				classes.put(classs, arr);
			}
			else 
			{
				arr = classes.get(classs);
				arr.add(representativ[i]);
			}
				
		}
		
		return classes;
	}
	
	public String print() {
		String s = "";
		Map<Integer, ArrayList<Integer> > classes = getElementsAndClasses();
		int i=1;
		for (Integer key: classes.keySet()) {
			ArrayList<Integer>arr = classes.get(key);
			
			s+= "S" + (i) + ": " ;
			for (int j = 0; j < arr.size(); j++) {
				s+=arr.get(j) + " ";
			}
			s+="\n";
			i++;
		}
		s = s.substring(0, s.length()-1);
		
		return s;
	}
}
