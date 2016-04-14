/**
 * Created by Zhehui Zhou on 4/14/16.
 */
public class Problem299 {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int[] count1 = new int[10];
        int[] count2 = new int[10];
        for(int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) bull++;
            else {
                count1[secret.charAt(i) - '0']++;
                count2[guess.charAt(i) - '0']++;
            }
        }
        for(int i = 0; i < 10; i++) {
            cow += Math.min(count1[i], count2[i]);
        }
        return bull + "A" + cow + "B";
    }
}
