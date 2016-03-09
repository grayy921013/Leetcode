/**
 * Created by Zhehui Zhou on 3/9/16.
 */
public class Problem66 {
    public int[] plusOne(int[] digits) {
        int rem = 1;
        for(int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + rem;
            digits[i] = sum % 10;
            rem = sum / 10;
        }
        if (rem > 0) {
            //need to add one digit
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = rem;
            for(int i = 0; i < digits.length; i++) newDigits[i + 1] = digits[i];
            return newDigits;
        } else return digits;
    }
}
