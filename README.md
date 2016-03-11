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
