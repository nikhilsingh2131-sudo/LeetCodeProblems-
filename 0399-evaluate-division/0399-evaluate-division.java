class Solution {

    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Graph
        Map<String, List<Pair>> graph = new HashMap<>();

        // Build graph
        for (int i = 0; i < equations.size(); i++) {

            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            double value = values[i];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());

            // a / b = value
            graph.get(a).add(new Pair(b, value));

            // b / a = 1 / value
            graph.get(b).add(new Pair(a, 1.0 / value));
        }

        double[] answer = new double[queries.size()];

        // Process queries
        for (int i = 0; i < queries.size(); i++) {

            String start = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            // Variable does not exist
            if (!graph.containsKey(start) ||
                !graph.containsKey(target)) {

                answer[i] = -1.0;
                continue;
            }

            // a / a = 1
            if (start.equals(target)) {
                answer[i] = 1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();

            answer[i] = dfs(
                    start,
                    target,
                    1.0,
                    graph,
                    visited
            );
        }

        return answer;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Pair>> graph,
            Set<String> visited) {

        // Target mil gaya
        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        // Neighbours explore karo
        for (Pair edge : graph.get(current)) {

            String neighbour = edge.node;
            double weight = edge.weight;

            if (!visited.contains(neighbour)) {

                double result = dfs(
                        neighbour,
                        target,
                        product * weight,
                        graph,
                        visited
                );

                // Path mil gaya
                if (result != -1.0) {
                    return result;
                }
            }
        }

        // Target tak path nahi mila
        return -1.0;
    }
}