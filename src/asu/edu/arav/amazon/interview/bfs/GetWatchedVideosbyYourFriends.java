package asu.edu.arav.amazon.interview.bfs;

import java.util.*;
import java.util.stream.Collectors;

;

/**
 * @author Aravamuthan Lakshminarayanan
 * @author Bhavana Vakkalagadda
 * @project LeetCodePractice
 * @link https://leetcode.com/problems/get-watched-videos-by-your-friends/
 */
public class GetWatchedVideosbyYourFriends {


    /**
     * @algo - BFS
     * @time-complexity - O(f)
     * @space-complexity - O(f)
     */
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

        List<String> res = new ArrayList<>();
        if (watchedVideos == null || watchedVideos.size() == 0 || friends == null || friends.length == 0) {
            return res;
        }
        if (level == 0) {
            return watchedVideos.get(id);
        }
        Queue<Integer> queue = new ArrayDeque<Integer>();
        Set<Integer> visited = new HashSet<Integer>();
        Map<String, Integer> mov = new HashMap<String, Integer>();
        queue.offer(id);
        visited.add(id);
        int curLevel = 0;
        while (!queue.isEmpty() && curLevel <= level) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int fid = queue.poll();
                if (curLevel == level) {
                    for(String m : watchedVideos.get(fid)){
                        mov.put(m, mov.getOrDefault(m, 0) + 1);
                    }
                }
                for (int j = 0; j < friends[fid].length; j++) {
                    if(!visited.contains(friends[fid][j])){
                        queue.offer(friends[fid][j]);
                        visited.add(friends[fid][j]);
                    }
                }
            }
            curLevel++;
        }
        res.addAll(mov.keySet());
        Collections.sort(res, (a, b) -> mov.get(a) == mov.get(a) ? a.compareToIgnoreCase(b) : mov.get(a) - mov.get(b));
        return res;
    }


}
