package asu.edu.arav.ImpG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Test2 {
	
	
	public static void main(String [] args) {
		
		ArrayList<ProductReviewScore> set = new ArrayList<ProductReviewScore>();
		
		
		ProductReviewScore pr = new ProductReviewScore(2, 4.5);
		set.add(pr);
		pr = new ProductReviewScore(2, 5.25);
		set.add(pr);
		pr = new ProductReviewScore(2, 7.25);
		set.add(pr);
		pr = new ProductReviewScore(2, 7.25);
		set.add(pr);
		pr = new ProductReviewScore(2, 9.75);
		set.add(pr);
		pr = new ProductReviewScore(2, 11.5);
		set.add(pr);		
		System.out.println(calculateHighestFive(0, set));
	}
	
	public static Map<Integer, Double> calculateHighestFive(int scoreCount, ArrayList<ProductReviewScore> reviewScoresOfProduct){
		
		
		Map<Integer, ArrayList<Double>> productTopReview  = new HashMap<Integer, ArrayList<Double>>();
		
		Map<Integer, Double> ans  = new HashMap<Integer, Double>();
		
		for(ProductReviewScore prs : reviewScoresOfProduct) {
			if(productTopReview.get(prs.productId)==null) {
				ArrayList<Double>scores = new ArrayList<Double>();
				scores.add(prs.reviewScore);
				productTopReview.put(prs.productId, scores);
			}else {
				ArrayList<Double>scores = productTopReview.get(prs.productId);
				if(scores.size() < 5) {
					scores.add(prs.reviewScore);
					Collections.sort(scores, Collections.reverseOrder());
				}else {
					if(scores.get(4) > prs.reviewScore) {
						continue;
					}else {
						scores.add(prs.reviewScore);
						Collections.sort(scores, Collections.reverseOrder());
						scores.remove(5);
					}
				}
				productTopReview.put(prs.productId, scores);
			}
		}
		
		for (Integer key : productTopReview.keySet()) {
			double sum = 0; 
			for(double val : productTopReview.get(key)) {
				sum += val;
			} 
			ans.put(key, sum/5);
		}
		return ans;
	}

}
