/**
* Problem: https://leetcode.com/problems/countingbits/
* Name: Counting Bits
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
* It is a classic DP problem.
* First we have solved the problem using recursion
* and then added memoization to reduce the time complexity.
*
*/

class Solution {
    public int[] countBits(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] answer = new int[n+1];
        for (int i = 0; i <= n; i++) {
            answer[i] = countBits(i, memo);
        }
        return answer;
    }

    private int countBits(int n, Map<Integer, Integer> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        int totalBits = 0;
        if (n % 2 == 0) {
            // n is odd
            totalBits = countBits(n/2, memo);
        } else {
            // n is even
            totalBits = countBits(n/2, memo) + countBits(n%2, memo);
        }
        memo.put(n, totalBits);
        return memo.get(n);
    }
}
