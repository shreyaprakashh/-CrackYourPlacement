// You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
// Each Ai or Bi is a string that represents a single variable.
// You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
// Return the answers to all queries. If a single answer cannot be determined, return -1.0.

class Solution {
    public class Node {
        String dest;
        double val;
        public Node(String d, double v){
            dest = d;
            val = v;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String, List<Node>> graph = buildGraph(equations, values);
        
        double[] ans = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++){
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return ans;
    }

    private double dfs(String src, String dest, HashSet<String> visited, Map<String, List<Node>> graph){
        if(!graph.containsKey(src) || !graph.containsKey(dest)) return -1.0;
        if(src.equals(dest)) return 1.0;
        visited.add(src);
        for(Node node : graph.get(src)){
            if(!visited.contains(node.dest)){
                double ans = dfs(node.dest, dest, visited, graph);
                if(ans != -1.0) return ans * node.val;
            }
        }
        return -1.0;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values){
        Map<String, List<Node>> graph = new HashMap<>();
        System.out.println(values.length);
        for(int i = 0; i < values.length; i++){
            
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList());
            graph.putIfAbsent(dest, new ArrayList());
            graph.get(src).add(new Node(dest, values[i]));
            graph.get(dest).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }
}
