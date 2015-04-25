import java.util.Random;


public class Main {

	
	public static void main(String[] args) {
		
		
		Hash_Table table = new Hash_Table(2000);
		
		for (int i = 0; i < 500; i++) {
			table.put(i, i);
		}
		
		
	}

}
