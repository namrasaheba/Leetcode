/**
* Problem: https://leetcode.com/problems/n-th-tribonacci-number/
* Name: Nth Tribonacci Number
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
* It is similar to Fibonacci number.
* First we have solved the problem using recursion
* and then added memoization to reduce the time complexity.
*
*/
class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    public int tribonacci(int n) {
        if (memo.containsKey(n))
            return memo.get(n);
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;
        memo.put(n, tribonacci(n-3) + tribonacci(n-2) + tribonacci(n-1));
        return memo.get(n);
    }
}
