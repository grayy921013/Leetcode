import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by Zhehui Zhou on 4/29/16.
 */
public class Problem341 implements Iterator<Integer> {
    private Stack<Iterator<NestedInteger>> stack = new Stack<>();
    private Integer next = null;
    public Problem341(List<NestedInteger> nestedList) {
        stack.push(nestedList.iterator());
        getNext();
    }
    private void getNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> iterator = stack.peek();
            NestedInteger integer;
            if (iterator.hasNext()) integer = iterator.next();
            else {
                stack.pop();
                continue;
            }
            if(!iterator.hasNext()) stack.pop();
            if (integer.isInteger()) {
                next = integer.getInteger();
                return;
            }
            else stack.push(integer.getList().iterator());
        }
        next = null;
    }
    @Override
    public Integer next() {
        Integer temp = next;
        getNext();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
