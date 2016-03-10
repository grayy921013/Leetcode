import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 3/10/16.
 */
public class Problem71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for(int i = 0; i < dirs.length; i++) {
            String dir = dirs[i];
            if (dir.length() > 0 && !dir.equals(".")) {
                if (dir.equals("..")) {
                    if(!stack.isEmpty()) stack.pop();
                } else {
                    stack.push(dir);
                }
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append('/');
            builder.append(s);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Problem71().simplifyPath("/abc/../cd"));
    }
}
