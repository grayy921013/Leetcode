# Leetcode Notes
1. Problem 44 (Wildcard Matching)  
  **Method 1:**  
  Recursion cannot be used in this problem, which will result in TLE. To solve it, I manage to use DP.  
  Let's use m to denote the length of string s, n to denote the length of string p.
  Firstly, I create an array with size (m+1)*(n+1). Entry i,j in the array is true if p[0...j-1] can match s[0...i-1].
  The recursion is:  
  1.  When p.charAt(j - 1) != '*':  
    match[i][j] = (match[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'));
  2.  When p.charAt(j - 1) == '*'
    match[i][j] = match[i - 1][j] || match[i][j - 1];  

  Actually we can use 1-D array to save the memory consumption.  

  **Method 2:**  
  A simpler method, check the code.  

2. Problem 46&47 (Permutation)  
  Given a collection of distinct numbers, return all possible permutations. The problem is not difficult, but I use a tricky method to resolve duplication.  
  The general idea is to insert item recursively.   Given array [2, 3], we insert items one by one in every possible positions. Firstly, we get [2]. When inserting "3", there are two positions to choose, so we simply replicate the list and get [2, 3] and [3, 2].  
  The tricky part is what if the array contains duplicate values. The solution is to only insert value v at the left(right should also work) of existing v entries.  

3. Problem 56 (Merge Intervals)  
  I first came up with a *silly* method, which finally appeared to be faster than most of the *clean* solutions.  
  **My Initial Method:**  
  Insert intervals into the list one by one without sorting. For a new interval, call search() method with both the starting point and the ending point, which binary searches for a certain integer value in the existing list. If the value overlaps with the interval at index i, the function returns 2i + 1; if the value lies between interval i and interval i + 1, the function returns 2i + 2. After searching, construct and insert the new interval after removing overlaps.  
  *This method can be directly used in Problem57 !*

  **Clean Method:**  
  Sort the input array according to the start value, and then insert one by one. Remember the ongoing bound and compare with the next interval.

4. Problem 72 (Edit Distance)  
  I use DP to solve this problem. We only need to consider edit s1 to s2 because all the operations are *symmetric*. Let's use cost[i][j] to denote the edit distance between word1.substr(0, i) and word2.substr(0, j). If word1.charAt(i) == word2.charAt(j), then cost[i+1][j+1] = cost[i][j] as we don't need extra cost. If the two characters are not the same, we have to perform one of the operation, and choose the previous stage with smallest cost. Therefore,
  ```java
  cost[i+1][j+1] = min{cost[i][j], cost[i+1][j], cost[i][j+1]} + 1.
  ```
  For initialization, cost[0][k] = k and cost[k][0] = k, and then we use two for loop and get the answer. I further save the memory space by using only 1-D array.

5. Problem 76 (Minimum Window Substring)  
  Basic idea: use two pointer start and end. First, increase end to make the window contain all the characters needed. Then, increase start to remove unnecessary characters to make the window a local minimum.  
  *Note: use array instead of HashMap to count can save a lot of time, as we only have 256 characters*

6. Problem 84 (Largest Rectangle in Histogram)  
  Use a stack to maintain the bar indexes, and ensure that height of the bar in the stack are in non-descending order so that we can calculate the area easily. When the new "arriving" bar is larger or equal to the peek, we just push is index into the stack; otherwise, we keep popping the stack until we can push the new bar into the stack. Whenever we pop a bar, we calculate the area of rectangle with the height of this bar.  
  ```java
   tp = s.pop();
   area = height[tp] * (s.isEmpty() ? i : i - 1 - s.peek());
  ```
  **Solution for this problem can be reused in the Problem 85**  
  We can apply the algorithm for each row.

7. Problem 87 (Scramble String)  
  Intuition: If s2 is a scrambled string of s1, there must exist two cut points in s1 and s2, which divide s1 into s11 and s12, s2 into s21 and s22, such that s11 is a scrambled string of s21, and s12 is a scrambled string of s22.  
  Basic idea: We loop s1 from head to tail, and cut it into two parts, and for s2, we loop it from head to tail and tail to head at the same time.
  ```java
  for (int i = 1; i < length; i++) {
              String part1 = s1.substring(0, i);
              String part2 = s1.substring(i);
              String part3 = s2.substring(0, i);
              String part4 = s2.substring(i);
              String part5 = s2.substring(length - i);
              String part6 = s2.substring(0, length - i);
  }
  ```
  And then we have to check if (part1, part3) and (part2, part4) are both scrambled pairs (Or (part1, part5) and (part2, part6)), so we do the checking recursively. At this stage, we can prune quite a lot path because s1 cannot be a scrambled string of s2 if they contain different character sets. And here comes three checking method:  
  **Method1** We just sort s1 and s2, and then compare them. (slow but reliable)  

  ***If only alphabets exist in s1 and s2:***  
  **Method2** We can use an array with length of 26 to mark the appearance of all characters. (fast)  
  **Method3** We use 26 prime number to represent each character, and only need to check their product. (very fast, but the product may overflow)

8. Problem 88 (Merge Sorted Array)  
  In order to merge two arrays in place, we can proceed them from tail to head.  

9. Problem 91 (Decode Ways)  
  We can use similar bottom-up method used to solve fibonacci problem. Firstly, we initialize result 0 and result1.  
  ```java
  int result1 = s.charAt(index + 1) == '0' ? 0 : 1;
  int result0 = 1;
  ```
  Then, we loop the string from tail to head, and compute the result based on previous result and the previous of previous result. There exist three conditions:  
  ```java
  while (index >= 0) {
            if (s.charAt(index) == '0') {
                result0 = result1;
                result1 = 0;
            } else if (s.charAt(index) > '0' && s.charAt(index) < '2' || s.charAt(index) == '2' && s.charAt(index + 1) <= '6') {
                result1 = result0 + result1;
                result0 = result1 - result0;
            } else {
                result0 = result1;
            }
            index--;
  }
  ```

10. Problem 95&96 (Unique Binary Search Trees)  
  We can construct the result of n nodes using the result of 1 to n - 1 nodes. If the left subtree has i nodes, then the right subtree with have (n - 1 - i) nodes, and the root node will have value (i + 1). Then, the left subtree actually can be constructed directly by cloning the result of i nodes, while for the right subtree, we have to clone the result of (n - 1 - i) while add each node with value (k + 1) because the smallest value in the right subtree is (k + 2) instead of 1.  
  Then, we can use bottom-up method to solve the problem starting with 0 node to n nodes.  

11. Problem 105&106 (Construct Binary Tree from Preorder/Postorder and Inorder Traversal My Submissions Question
)  
  preoder[0] must be the root node. Then in inorder array, we can find inorder[i] == preorder[0], which implies that inorder[0..i] must be in the left subtree while inorder[i..end] must be in the right subtree. We do this operation recursively and will get the whole tree.  
  For problem 106, the idea is basically the same, but we have to loop postorder from the tail to the end.  

12. Problem 115 (Distinct Subsequences)  
  **DP can always be used to solve this kind of problem, as the solution to the whole problem depends on the solution of subproblems**  
  We can use a matrix `match[][]` to denote the number of subsequences. Use `match[i][j]` denotes the number of subsequences of T[0..i] in S[0..j] and the result will be in `match[t.length()][s.length()]`.  
  Initialization: `match[0][k] = 0` for any k because any T have one and only one empty subsequence.  
  Recurrence: If the current character of t is not the same as the current character of s, then the entry of `match` has the same value with the shorter s. Otherwise, we have got `match[i][j]` more subsequences.  
  ```java
  if(t.charAt(i) == s.charAt(j)) {
      match[i + 1][j + 1] = match[i][j] + match[i + 1][j];
  } else {
      match[i + 1][j + 1] = match[i + 1][j];
  }
  ```  
  As usual, we can optimize the memory space by using 1D array.  

13. Problem 126&127 (Word Ladder)  
  Intuition: The one-character transformation is like an edge, and all the words are vertexes, so we can transform the original problem into a graph problem and use BFS to solve it. However, as we only need to compute the shortest path, we actually do not need to construct a real graph explicitly. We can remember all the vertexes we have already visited and the vertex set which contain all the nodes with minimum distance `i` to the root, then we are able to find all the nodes with minimum distance `i + 1`.  
  Difficulty: I did not find a simpler method to find all one-character distance word of a certain given word, so I used a brute force method: try `a - z` on every position and check if the result is in the wordlist and has not yet been visited. I previously thought this would not work, but it turns out to be acceptable. **So do not give up before really implement it.**    
  Optimization: Actually we can start the search from both ends. We can maintain two sets, `begin` and `end`. For each round, we always start searching from the smaller set.  
  The detail solution for problem126 is not clear nor straightforward. Basic idea is to use a map to remember all shortest paths to a certain word and also mark down visited words.

14. Problem 132 (Palindrome Partitioning II)  
  Basic idea:  
  * If `s[i] = s[j]` and s[i+1..j-1] is a palindrome, then s[i..j] is also a palindrome.
  * If s[i..j] is a palindrome, cut needed for s[0..j] is at most cut used for s[0..i] + 1.  

  For every index i, we try to find the minimum cut for s[0..i]. So we use an inner loop for index j to find out whether s[j..i] is a palindrome and use a 2D array to memorize the result, if yes then we know that s[i] is at most s[j] + 1.  
  ```java  
  boolean[][] pad = new boolean[s.length()][s.length()];
  int[] cut = new int[s.length()];
  for(int i = 0; i < s.length(); i++) {  
    int min = i;
    for(int j = 0; j <= i; j++) {
      if (s.charAt(i) == s.charAt(j) && (j + 1 > i - 1 || pad[j + 1][i - 1])) {
        pad[j][i] = true;
        min = Math.min(j == 0 ? 0 : cut[j - 1] + 1, min);
      }
    }
    cut[i] = min;
  }
  return cut[cut.length - 1];
  ```  
  Alternatives: We can actually save the space for marking down whether s[i..j] is a palindrome by moving left and right simultaneously from a center point(see problem5).  

15. Problem 136&137 (Single Number)  
  Use XOR because `0 ^ a = a` and `a ^ a = 0`.  
  For 137, we maintain two variable ones and twos, which represents whether '1' on corresponding bits have appeared for one time or two times. So if for a certain bit, both ones and twos are equal to 1, then that bit has appear for three times and we set both to 0.  
  ```java
  twos |= (ones & a);
  ones ^= a; // same as problem 136
  int three = ~(ones & twos);
  ones &= three;
  twos &= three;
  ```  
  Finally, just return ones as the result.  

16. Problem 142 (Linked List Cycle II)  
  First, use the *fast slow pointer* to determine if the list contains a cycle. Then we get a meeting point. Assume the distance between the head and the cycle start is d1, the distance between the cycle start and the meeting point is d2, while the length of the cycle is c. We know that slow pointer has run `d1 + d2 + n1 * c`, and the fast pointer has run `d1 + d2 + n2 * c`. Therefore, `d1 + d2 + n2 * c = 2 * (d1 + d2 + n1 * c)`, which leads to `d1 = (n1 - 2 * n2) * c - d2 = (n - 1) * c + c - d2, (n >= 1)`. If we put one small pointer at the head, one at the meeting point, they will finally meet at the cycle start.  

17. Problem 155 (Min Stack)  
  It is trivial to maintain the min value. The main challenge is how to *update* the min value if we pop a item equal to the current min value. The trick is to something more in `push()`: if the item is less or equal to the current min value, we push the current min value into the stack before we push the actual value. What we want to do is actually to maintain the min value of items *under* the latest item. Therefore, when we pop an item that is equal to the current min value, we just pop one more item to update the min value.  
  ```java
  public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if (val == min) min = stack.pop();
        if (stack.isEmpty()) min = Integer.MAX_VALUE;
    }
  ```  

18. Problem 164 (Maximum Gap)  
  In order to achieve *linear time/space* algorithm, you have to try something special, bucket sort. First, I find the `max` and `min` value of the whole array, and use it to divide the array into `length - 1` buckets. As the max gap must be larger than `(max - min) / (length) - 1`, the max gap must happen between two buckets but not with in a single bucket.  
  ```java
  int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));
  ```
  Then we mark the `min` and `max` value of each bucket. At last, we loop through all the buckets to calculate the max gap value.  

19. Problem 174 (Dungeon Game)  
  It is a typical DP problem. The idea is that when the knight reaches a cell, he should have at least 1 health. We use a 2D array `health[][]`.  
  * `health[col-1][row-1] = 1;`
  * `health[i][j] = Math.max(Math.min(health[i][j+1],health[i-1][j]) - dungeon[i][j], 1);`  

20. Problem 218 (The Skyline Problem)  
  Main idea is divide & conquer. The first mission is to write a function that can *combine* two skylines. Then we transform each individual building into a skyline. Finally, we recursively combine two skylines into one. Refer to my code for details.  

21. Problem 222 (Count Complete Tree Nodes)  
  At first, I thought of binary search, which take `log(2^h) = h` steps to find the number of nodes in the last level, but for each level, I have to go down `h` levels to find the node. So the overall time complexity is `O(n^2)`, which is too slow.  
  A better solution is to compare the *height* of the left and right subtree. Here, we calculate the height by always going left from the start node. If the height of the left subtree is equal to the height of the right subtree, then the left subtree is a full tree of height `h - 1`, and the result is `2 ^ h + no. of nodes in the right subtree`. Else, the right subtree is a full tree of heigh `h -  2`, and the result is `2 ^ (h - 1) + no. of nodes in the left subtree`. We do the calculation recursively.
