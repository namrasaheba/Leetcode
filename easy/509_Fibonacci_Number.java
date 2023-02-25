/**
* Problem: https://leetcode.com/problems/fibonacci-number/
* Name: Fibonacci Number
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
*
* Logic:
*
* First we have solved the problem using recursion
* and then added memoization to reduce the time complexity.
*
*/
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int fib(int n) {
        
        if (memo.containsKey(n))
            return memo.get(n);
        if (n == 0) 
            return 0;
        if (n <= 2) 
            return 1;
            
        memo.put(n, fib(n-1) + fib(n-2));
        return memo.get(n);
    }
}
