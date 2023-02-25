/**
*
* Problem: https://leetcode.com/problems/power-of-two/
* Name: 231. Power of Two
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
    public boolean isPowerOfTwo(int n) {        
        if (n == 2 || n == 1)
            return true;
        if ( n%2 != 0 || n == 0)
            return false;
        
        return isPowerOfTwo(n/2);
    }
}
