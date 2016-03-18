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
