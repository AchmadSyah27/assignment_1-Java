package jakartalabs.assignment1;

import java.util.HashMap;

public class Hashmap_Based_On_Keys {

	public static void main(String args[]) {

		HashMap<Integer, String> studentMap = new HashMap<>();

		studentMap.put(4, "chandan");
		studentMap.put(1, "Marco");
		studentMap.put(11, "ririn");
		studentMap.put(2, "adi");

		for (Integer key : studentMap.keySet()) {
			System.out.println("Key is: " + key + "Value is: " + studentMap.get(key));
		}
	}
}
