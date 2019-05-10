import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Test3 {

	public static int findBestPath(int n, int m, int max_t, List<Integer> beauty, List<Integer> u, List<Integer> v,
			List<Integer> t) {
		// Write your code here

		HashMap<Integer, HashMap<Integer, Integer>> cityMap = new HashMap<>();

		for (int i = 0; i < u.size(); i++) {

			int s = u.get(i);
			int t1 = v.get(i);
			if (cityMap.containsKey(s)) {
				cityMap.get(s).put(t1, t.get(i));
			} else {
				HashMap<Integer, Integer> edges = new HashMap<>();
				edges.put(t1, t.get(i));
				cityMap.put(s, edges);
			}
		}
		// bfs search for best path w r t to cost
		return BFS_Distance(0, cityMap, n, beauty, max_t, t);
	}

	public static int BFS_Distance(int root, HashMap<Integer, HashMap<Integer, Integer>> graph, int N,
			List<Integer> beauty, int max_t, List<Integer> t) {
		int[] distances = new int[N];
		int maxbeauty = 0;

		HashSet<Integer> notVisited = new HashSet<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 1; i <= N; i++)
			notVisited.add(i);

		Queue<Integer> queue = new LinkedList<>();
		HashMap<Integer, Integer> siteCostMap = new HashMap<>();
		siteCostMap.put(root, 0);
		HashMap<Integer, Integer> siteTillBeautyMap = new HashMap<>();
		siteTillBeautyMap.put(root, beauty.get(root));
		queue.offer(root);
		notVisited.remove(root);
		distances[0] = 0;
		if (beauty.get(root) > maxbeauty) {
			maxbeauty = beauty.get(root);
		}

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int currCost = siteCostMap.get(curr);
			int currBeauty = siteTillBeautyMap.get(curr);
			HashMap<Integer, Integer> neighborsMap = graph.get(curr);

			Set<Integer> sitSet = neighborsMap.keySet();
			if(notVisited != null || notVisited.size() != 0) {
				for (int s : notVisited) {
					if (sitSet.contains(s)) {
						visited.add(s);
						int beautySite = currBeauty + beauty.get(s);
						if (currCost + neighborsMap.get(s) <= (max_t / 2)) {
							if (beautySite > maxbeauty)
								maxbeauty = beautySite;
							siteTillBeautyMap.put(s, beautySite);
							siteCostMap.put(s, currCost + neighborsMap.get(s));
							queue.offer(s);
						}
					}
				}
				notVisited.removeAll(visited);
				visited = new HashSet<>();
			}
			
		}
		return maxbeauty;
	}

}
