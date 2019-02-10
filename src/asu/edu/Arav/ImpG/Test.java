package asu.edu.Arav.ImpG;

import java.util.Collections;
import java.util.Set;

import java.util.List;

public class Test {
	
	public void findOptimalWeights(int numPallets, double maxCapacity, List<Double> wtPallets)
			{
			// WRITE YOUR CODE HERE
				Collections.sort(wtPallets);
				int diff = Integer.MAX_VALUE;
				
				Double val1, val2;
				
				
				int i = 0;
				int j = wtPallets.size()-1;
				
				
				while(i < j) {
					if(wtPallets.get(i) + wtPallets.get(j) > maxCapacity) {
						j--;
					}
					else if (wtPallets.get(i) + wtPallets.get(j) < maxCapacity) {
						if(maxCapacity - (wtPallets.get(i) + wtPallets.get(j)) < diff) {
							val1 = wtPallets.get(i);
							val2 = wtPallets.get(j);
						}
						i--;
					}
				}

}

}
