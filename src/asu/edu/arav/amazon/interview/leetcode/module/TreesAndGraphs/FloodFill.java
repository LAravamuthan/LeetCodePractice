package asu.edu.arav.amazon.interview.leetcode.module.TreesAndGraphs;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/flood-fill/
 */
public class FloodFill {

    int n, m, newColor1;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        // start from given root
        n = image.length;
        m = image[0].length;
        newColor1 = newColor;
        boolean[][] visitied = new boolean[n][m];
        dfsStyleColorFill(image, sr, sc, visitied);
        return image;
    }


    public void dfsStyleColorFill(int[][] image, int i, int j,
                                         boolean[][] visitied) {

        if(visitied[i][j]){
            return;
        }
        // you fucker always forget to check whether child or not parent chutiya
        // here not only you have check whether its parent or not but its visited or not i tjink
        // lets see
        // funcker not parent but visited check also required
        // think about it though dfs in 2d array how it is done

        // dont change the color before doing dfs to its childs
        int curColor = image[i][j];
        visitied[i][j] = true;
        // go the the indexes which are inside the image grid
        // and match the color of parent
        if (i + 1 < n && image[i + 1][j] == curColor) {
            dfsStyleColorFill(image, i + 1, j, visitied);
        }
        if (i - 1 >= 0 && image[i - 1][j] == curColor) {
            dfsStyleColorFill(image, i - 1, j, visitied);
        }
        if (j + 1 < m && image[i][j + 1] == curColor) {
            dfsStyleColorFill(image, i, j + 1, visitied);
        }
        if (j - 1 >= 0 && image[i][j - 1] == curColor) {
            dfsStyleColorFill(image, i, j - 1, visitied);
        }
        image[i][j] = newColor1;
    }

    public static void main(String[] args) {

        int[][] i = new int[3][3];
        i[0] = new int[]{1, 1, 1};
        i[1] = new int[]{1, 1, 0};
        i[2] = new int[]{1, 0, 1};
        //floodFill(i, 1, 1, 2);
    }

}
