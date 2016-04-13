import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Zhehui Zhou on 4/13/16.
 */
public class Problem284 {
    static class PeekingIterator implements Iterator<Integer> {
        Iterator<Integer> iterator;
        Integer peek = null;
        public PeekingIterator(Iterator<Integer> iterator) {

            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext()) peek = iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return peek;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int temp = peek;
            if (iterator.hasNext()) peek = iterator.next();
            else peek = null;
            return temp;
        }

        @Override
        public boolean hasNext() {
            return peek != null;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        PeekingIterator iterator = new PeekingIterator(list.iterator());
        System.out.println(iterator.next());
        System.out.println(iterator.peek());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
