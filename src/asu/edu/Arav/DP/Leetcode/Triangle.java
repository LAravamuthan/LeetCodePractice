package asu.edu.Arav.DP.Leetcode;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }
        int [] triangleRowLevelPathCost  = new int [triangle.get(triangle.size()-1).size()];
        for(int i = triangle.size() -1; i >=0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                triangleRowLevelPathCost[j] = Math.min(triangleRowLevelPathCost[j], triangleRowLevelPathCost[j+1]) + triangle.get(i).get(j);
            }
        }
        return triangleRowLevelPathCost[0];
    }
}
