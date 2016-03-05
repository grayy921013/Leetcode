#Leetcode Notes
1. Problem 44 (Wildcard Matching)  
  ###Method 1:
  Recursion cannot be used in this problem, which will result in TLE. To solve it, I manage to use DP.  
  Let's use m to denote the length of string s, n to denote the length of string p.
  Firstly, I create an array with size (m+1)*(n+1). Entry i,j in the array is true if p[0...j-1] can match s[0...i-1].
  The recursion is:  
  1.  When p.charAt(j - 1) != '*':  
    match[i][j] = (match[i - 1][j - 1] && (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?'));
  2.  When p.charAt(j - 1) == '*'
    match[i][j] = match[i - 1][j] || match[i][j - 1];  

  Actually we can use 1-D array to save the memory comsumption.  
  
  ###Method 2:
  A simpler method, check the code.
