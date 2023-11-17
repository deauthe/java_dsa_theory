import java.util.*;

class graphPt4 {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        int answer[] = new int[numCourses];
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[numCourses];
        if (numCourses <= 1) {
            return answer;
        }
        ArrayList<Integer>[] graph = createAdj(prerequisites, numCourses);

        for (int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                Util(graph, i, vis, s);
            }
        }
        if (s.size() < numCourses) {
            return answer;
        }
        for (int i = 0; i < s.size(); i++) {
            answer[i] = s.pop();
        }
        return answer;
    }

    public static void Util(ArrayList<Integer>[] graph, int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (Integer i = 0; i < graph[curr].size(); i++) {
            Integer neigh = graph[curr].get(i);
            if (!vis[neigh]) {
                Util(graph, neigh, vis, s);
            }
        }
        s.push(curr);
    }

    public static ArrayList<Integer>[] createAdj(int[][] prerequisites, int numCourses) {

        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        return graph;
    }

    public static void main(String args[]) {
        int[][] prerequisites = {{1, 0}};
        int[] order = findOrder(2, prerequisites);
        System.out.println(Arrays.toString(order));
    }
}
