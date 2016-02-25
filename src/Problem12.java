/**
 * Created by admin on 2/25/16.
 */
public class Problem12 {
    public String intToRoman(int num) {
        int[] indexs = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] values = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        StringBuilder builder = new StringBuilder();
//        while (num > 0) {
//            int index = binarySearch(indexs, num);
//            builder.append(values[index]);
//            num -= indexs[index];
//        }
        //another method
        for(int i = indexs.length - 1; i >= 0; i--) {
            while(num >= indexs[i]) {
                builder.append(values[i]);
                num -= indexs[i];
            }
        }
        return builder.toString();
    }

    private int binarySearch(int[] array, int value) {
        //return the largest index of entry that is smaller or equal to VALUE
        return binarySearch(array, 0, array.length - 1, value);
    }

    private int binarySearch(int[] array, int start, int end, int value) {
        int mid = (start + end) / 2;
        if (start == end) return start;
        if (array[mid] <= value && array[mid + 1] > value) return mid;
        else if (array[mid] < value) return binarySearch(array, mid + 1, end, value);
        else return binarySearch(array, start, mid, value);
    }

    public static void main(String[] args) {
        Problem12 problem12 = new Problem12();
        System.out.println(problem12.intToRoman(1996));
    }
}
