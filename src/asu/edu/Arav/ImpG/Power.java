package asu.edu.Arav.ImpG;

public class Power {

	public double myPow(double x, int n) {
		long _n = n;
		if(_n<0) {
			x =1/x;
			_n = -_n;
		}
		double ans = 1;
		double product = x;
		for(long i = _n; i > 0; i = i/2) {
			if(i%2==1) {
				ans= ans * product;
			}
			product = product * product;
		}
		return ans;
	}
}
