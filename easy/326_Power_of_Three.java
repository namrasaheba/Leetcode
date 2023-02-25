/**
*
* Problem: https://leetcode.com/problems/power-of-three/
* Name: 326. Power of Three
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
    public boolean isPowerOfThree(int n) {        
        if (n == 3 || n == 1)
            return true;
        if ( n == 0 || n%3 != 0)
            return false;
        
        return isPowerOfThree(n/3);
    }
}
