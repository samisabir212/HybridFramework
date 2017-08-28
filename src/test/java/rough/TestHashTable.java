package rough;

import java.util.Hashtable;

public class TestHashTable {

	public static void main(String[] args) {


		Hashtable<String,String> table = new Hashtable<String,String>();
		
		
		table.put("Iteration", "1");
		table.put("TestData", "Login1");
		
		System.out.println(table.get("TestData"));

	}

}
