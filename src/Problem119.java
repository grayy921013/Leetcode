import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 3/21/16.
 */
public class Problem119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (rowIndex == 0) return list;
        List<Integer> last = list;
        for(int i = 0; i < rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            for(int j = 0; j < i - 1; j++) {
                list.add(last.get(j) + last.get(j + 1));
            }
            list.add(1);
            last = list;
        }
        return list;
    }
}
