/**
* Problem: https://leetcode.com/problems/climbing-stairs/
* Name: Climbing Stairs
*
* Difficulty: Easy
*
* Time complexity: O(n)
* Space complexity: O(n)
*
* @author: Namra A. Saheba
*
*/

/**
* Logic:
* 
* First we figure out the base-cases: 0 step, 1 step, 2 steps.
* Based on the base-cases, we figure out a recursive solution.
* Then we add memoization to reduce the time complexity of recursive solution.
* 
*/

class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int climbStairs(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return memo.get(n);        
    }
}
