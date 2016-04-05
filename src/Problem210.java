import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/4/16.
 */
public class Problem210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //first check if cycle exists
        List<Integer>[] adj = new List[numCourses];
        Stack<Integer> stack = new Stack<>();
        for(int[] pre : prerequisites) {
            int v = pre[0];
            int u = pre[1];
            if (adj[u] == null) adj[u] = new LinkedList<>();
            adj[u].add(v);
        }
        //dfs
        boolean[] mark = new boolean[numCourses];
        boolean[] post = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (!mark[i]) {
                //not visited
                if (!dfs(i, mark, adj, post, stack)) return new int[0];
            }
        }
        int[] result = new int[numCourses];
        int i = 0;
        while(!stack.isEmpty()) result[i++] = stack.pop();
        return result;
    }
    private boolean dfs(int start, boolean[] mark, List<Integer>[] adj, boolean[] post, Stack<Integer> stack) {
        mark[start] = true;
        if (adj[start] == null) {
            post[start] = true;
            stack.push(start);
            return true;
        }
        for(int v : adj[start]) {
            if (!mark[v]) {
                if(!dfs(v, mark, adj, post, stack)) return false;
            } else if (!post[v]) return false;
        }
        post[start] = true;
        stack.push(start);
        return true;
    }
}
