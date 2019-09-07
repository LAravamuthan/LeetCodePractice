package asu.edu.aravl.utility;

import java.util.HashMap;

public class Counter extends HashMap<Integer, Integer> {

	// this method returns the value of the key, if the key is not present it
	// returns 0;
	public int get(int key) {
		return containsKey(key) ? super.get(key) : 0;
	}

	/*
	 * This method probably the most value added method in the need to practise
	 * programming this adds the value to already present key value
	 */

	public void add(int key, int value) {
		put(key, get(key) + value);
	}

}
