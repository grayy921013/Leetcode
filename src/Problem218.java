import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhehui Zhou on 4/5/16.
 */
public class Problem218 {
    public List<int[]> getSkyline(int[][] buildings) {
        //convert buildings to list
        List<List<int[]>> lines = new ArrayList<>();
        for(int[] building : buildings) {
            List<int[]> line = new ArrayList<>();
            line.add(new int[]{building[0], building[2]});
            line.add(new int[]{building[1], 0});
            lines.add(line);
        }
        int size = lines.size();
        while(size > 1) {
            int count = 0;
            for(int i = 0; i < size; i+=2) {
                if (i < size - 1) lines.set(count++, merge(lines.get(i), lines.get(i + 1))); //merge two
                else lines.set(count++, lines.get(i));
            }
            size = count;
        }
        return lines.get(0);
    }

    private List<int[]> merge(List<int[]> line1, List<int[]> line2) {
        //merge two list;
        List<int[]> line = new ArrayList<>();
        int index1 = 0, index2 = 0;
        int level1 = 0, level2 = 0;
        while(index1 < line1.size() && index2 < line2.size()) {
            int[] point1 = line1.get(index1);
            int[] point2 = line2.get(index2);
            int[] point;
            if (point1[0] < point2[0]) {
                point = point1;
                index1++;
                level1 = point[1];
            } else if (point1[0] > point2[0]){
                point = point2;
                index2++;
                level2 = point[1];
            } else {
                point = point1;
                index1++;
                index2++;
                level1 = point1[1];
                level2 = point2[1];
            }
            int h = Math.max(level1, level2);
            if(line.size() == 0 || line.get(line.size() - 1)[1] != h) {
                line.add(new int[]{point[0], Math.max(level1,level2)});
            }
        }
        while(index1 < line1.size()) {
            line.add(line1.get(index1++));
        }
        while(index2 < line2.size()) {
            line.add(line2.get(index2++));
        }
        return line;
    }
}
