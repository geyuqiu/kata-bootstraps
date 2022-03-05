package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetAncestors {
  // return ancestors (of ancestors) sorted in a DAG
  List<List<Integer>> getAncestors(int n, int[][] edges) {
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    for (int i=0; i<n; i++) {
      graph.put(i, new HashSet<>());
    }
    for (int i = 0; i < edges.length; i++) {
      int[] edge = edges[i];
      graph.get(edge[1]).add(edge[0]);
    }
    System.out.println(graph);

    return new ArrayList<>();
  }
}
