package asu.edu.arav.impgoogle;

import java.util.HashMap;
import java.util.Map;

public class FindingAnagramMapping {

	public static int[] anagramMappings(int[] a, int[] b) {
		
		int [] result = new int[a.length];
		Map<Integer, Integer> valueToIndexMap = new HashMap<Integer, Integer>();
		
		
		for(int i =0; i < b.length; i ++) {
			valueToIndexMap.put(b[i], i);
		}
		
		for(int i = 0; i < a.length; i++) {
			result[i]= valueToIndexMap.get(a[i]);
		}

		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
