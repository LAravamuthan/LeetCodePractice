package asu.edu.arav.ImpG;

public class TrapRainWater {
	public int trap(int[] height) {
		int ans = 0;
		if(height.length ==0) {
			return 0;
		}
		int[] lA = new int[height.length];
		int[] rA = new int[height.length];
		lA[0] = height[0];
		rA[height.length-1] = height[height.length-1];
		for(int i =1; i < height.length; i++) {
			lA[i] = Math.max(lA[i-1], height[i-1]);
		}
		for(int i = height.length-2; i >= 0; i--) {
			rA[i] = Math.max(rA[i+1], height[i+1]);
		}
		for(int i =1; i < height.length-1; i++) {
			ans+= Math.min(lA[i], rA[i]) - height[i];
		}
		
		return ans;
	}
}
