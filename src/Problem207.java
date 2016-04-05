import java.util.LinkedList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/4/16.
 */
public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //use dfs to detect cycle, first process prerequisites
        List<Integer>[] adj = new List[numCourses];
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
                if (!dfs(i, mark, adj, post)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int start, boolean[] mark, List<Integer>[] adj, boolean[] post) {
        mark[start] = true;
        if (adj[start] == null) {
            post[start] = true;
            return true;
        }
        for(int v : adj[start]) {
            if (!mark[v]) {
                if(!dfs(v, mark, adj, post)) return false;
            } else if (!post[v]) return false;
        }
        post[start] = true;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Problem207().canFinish(3, new int[][]{{0,1},{0,2},{1,2}}));
    }
}
