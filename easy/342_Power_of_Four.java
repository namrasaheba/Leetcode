/**
*
* Problem: https://leetcode.com/problems/power-of-four/
* Name: 342. Power of Four
*
* Difficulty: Easy
*
* Time complexity: O(n)
* Space complexity: O(n)
*
* @author Namra A. Saheba
*
*/

class Solution {
    public boolean isPowerOfFour(int n) {
        if (n == 4 || n == 1)
            return true;
        if ( n == 0 || n%4 != 0)
            return false;
        
        return isPowerOfFour(n/4);
    }
}
