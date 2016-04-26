import java.util.*;

/**
 * Created by Zhehui Zhou on 4/26/16.
 */
public class Problem332 {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> out = new HashMap<>();
        for(String[] ticket : tickets) {
            PriorityQueue<String> queue = out.get(ticket[0]);
            if (queue == null) {
                queue = new PriorityQueue<>();
                out.put(ticket[0], queue);
            }
            queue.offer(ticket[1]);
        }
        Stack<String> stack = new Stack<>();
        List<String> route = new LinkedList<>();
        stack.push("JFK");
        while (!stack.empty()) {
            while (out.containsKey(stack.peek()) && !out.get(stack.peek()).isEmpty())
                stack.push(out.get(stack.peek()).poll());
            route.add(0, stack.pop());
        }
        return route;
    }
}
