package asu.edu.arav.DP.leetcode;

/**
 * @author Aravamuthan Lakshminarayanan
 * @project LeetCodePractice
 */
public class FillingBookCaseShelves {
    public static int minHeightShelves(int[][] books, int shelf_width) {
        if(books == null || books.length == 0){
            return 0;
        }
        if(books.length == 1){
            return books[0][1];
        }


        int [] dp = new int[books.length+1];
        dp[0] = 0;
        dp[1] = books[0][1];

        for(int i = 1; i < books.length; i++){
            int width = books[i][0];
            int height = books[i][1];
            dp[i+1] = dp[i] + height;
            int j = i-1;
            while(j >=0 && width + books[j][0] <= shelf_width){
                width += books[j][0];
                height = Math.max(height, books[j][1]);
                dp[i+1] = Math.min(dp[i+1], dp[j] + height);
                j--;
            }
        }
        return dp[books.length];
    }

    public static void main(String [] args){
        int [][] in = {{7,3},{8,7},{2,7},{2,5}};
        System.out.println(minHeightShelves(in, 10));
    }
}
